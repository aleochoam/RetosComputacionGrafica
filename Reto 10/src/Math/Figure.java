package Math;

import Scene.Colour;
import Scene.Material;

public interface Figure {
	
	public Vector4 computeNormal(Point p);
	public Colour callShader(Ray ray, double minT);
	public Material getMaterial();

}
