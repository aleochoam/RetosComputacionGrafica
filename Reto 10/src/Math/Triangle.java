package Math;

import Scene.Colour;
import Scene.Material;
import Scene.Shader;

public class Triangle implements Figure{
	Point p1;
	Point p2;
	Point p3;
	Vector4 normal;
	
	Material material;
	
	public Triangle(Point p1,Point p2,Point p3, Material material){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.material = material;
		//normal = computeNormal(null);
	}
	
	public static Solutions intersect(Triangle triangle, Ray ray){
		double[][] coefficients = {{(ray.getU().getX()), -(triangle.p2.x-triangle.p1.x), -(triangle.p3.x-triangle.p1.x)},
								   {(ray.getU().getY()), -(triangle.p2.y-triangle.p1.y), -(triangle.p3.y-triangle.p1.y)},
								   {(ray.getU().getZ()), -(triangle.p2.z-triangle.p1.z), -(triangle.p3.z-triangle.p1.z)}};
		double[] constants = {-ray.p0.x + triangle.p1.x, - ray.p0.y + triangle.p1.y, - ray.p0.z + triangle.p1.z};
		
		ThreeByThreeSystem solutions = new ThreeByThreeSystem(coefficients, constants);
		double[] result = solutions.computeSystem();
		
		double s     = result[0];
		double beta  = result[1];
		double gamma = result[2];
		double alpha = 1 - gamma - beta;
		
		if (alpha >= 0 &&
	        alpha <= 1 &&
	        beta  >= 0 &&
	        beta  <= 1 &&
	        gamma >= 0 &&
	        alpha <= 1 ) {
            return new Solutions(1, s, 0);
        }
		else{
		    return new Solutions(0, 0, 0);
		}
	}
	
	public Vector4 computeNormal(Point p){
        Vector4 ab = new Vector4(p1, p2);
        Vector4 ac = new Vector4(p1, p3);
        Vector4 normal = Vector4.crossProduct(ab, ac);
        normal.normalize();
        return normal;
	}
	
	public Colour callShader(Ray ray, double minT) {
        Point point = ray.evaluate(minT);
        Vector4 ab = new Vector4(p1, p2);
        Vector4 ac = new Vector4(p1, p3);
        Vector4 normal = Vector4.crossProduct(ab, ac);
        normal.normalize();
        return Shader.computeColor(point, normal, material);
    }
	
	
	public Material getMaterial() {
        return material;
    }    
    
    @Override
    public String toString() {
        return "Triangle{" + "p1=" + p1+ ", p2=" + p2+ ", p3=" + p2+'}';
    }
}
