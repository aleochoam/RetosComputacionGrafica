package Maths;

public class Vect3D {

    protected double[] componentes = new double[3];

    public Vect3D(double x, double y, double z){
        this.componentes[0] = x;
        this.componentes[1] = y;
        this.componentes[2] = z;
    }

    public Vect3D(Punto3D cabeza, Punto3D cola){
        componentes[0] = cabeza.getCoord()[0] - cola.getCoord()[0];
        componentes[1] = cabeza.getCoord()[1] - cola.getCoord()[1];
        componentes[2] = cabeza.getCoord()[2] - cola.getCoord()[2];
    }

    public double[] getComp(){
        return componentes;
    }

    public static double getMagnitud(Vect3D v){
        return Math.sqrt(Math.pow(v.componentes[0], 2) +
                         Math.pow(v.componentes[1], 2) +
                         Math.pow(v.componentes[1], 2));
    }

    public static Vect3D suma(Vect3D v1, Vect3D v2){
        double cX = v1.getComp()[0] + v2.getComp()[0];
        double cY = v2.getComp()[1] + v2.getComp()[1];
        double cZ = v2.getComp()[2] + v2.getComp()[2];
        return new Vect3D(cX, cY, cZ);
    }

    public static Vect3D resta(Vect3D v1, Vect3D v2){
        double cX = v1.getComp()[0] - v2.getComp()[0];
        double cY = v2.getComp()[1] - v2.getComp()[1];
        double cZ = v2.getComp()[2] - v2.getComp()[2];
        return new Vect3D(cX, cY, cZ);
    }

    public static Vect3D productoEscalar(Vect3D v, double u){
        double[] comp = v.getComp();
        return new Vect3D(comp[0] * u, comp[1] * u, comp[2] * u);
    }

    public static double productoPunto(Vect3D v1,Vect3D v2){
        double cX = v1.getComp()[0] * v2.getComp()[0];
        double cY = v1.getComp()[1] * v2.getComp()[1];
        double cZ = v1.getComp()[2] * v2.getComp()[2];
        double result = cX + cY + cZ;
        return result;
    }

    public static Vect3D productoCruz(Vect3D v1, Vect3D v2){
    	double x = (v1.getComp()[1] * v2.getComp()[2]) -
    			(v1.getComp()[2] * v2.getComp()[1]);
    	double y = -((v1.getComp()[0] * v2.getComp()[2]) -
		        (v1.getComp()[2] * v2.getComp()[0]));
    	double z = (v1.getComp()[0] * v2.getComp()[1]) -
    			(v1.getComp()[1] * v2.getComp()[0]);
    	return new Vect3D(x,y,z);
    }
    
    public double magnitude() {
        return Math.sqrt(componentes[0]*componentes[0] + componentes[1]*componentes[1] + componentes[2]*componentes[2]);
    }
    
    public void normalize() {
        double mag = this.magnitude();
        componentes[0] /= mag;
        componentes[1] /= mag;
        componentes[2] /= mag;
    }

    public String toString() {
    	return "(" + componentes[0] + ", " + componentes[1] + ", " +
            componentes[2] + ")";
    }
}
