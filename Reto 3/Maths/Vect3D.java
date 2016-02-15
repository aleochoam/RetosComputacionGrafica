package Maths;

public class Vect3D {

    private double[] componentes = new double[2];

    public Vect3D(double x, double y, double z){
        this.componentes[0] = x;
        this.componentes[1] = y;
        this.componentes[2] = z;
    }

    public Vect3D(Punto3D cabeza, Punto3D cola){
        componentes[0] = cabeza.getCoord()[0] - cola.getCoord()[0];
        componentes[1] = cabeza.getCoord()[1] - cola.getCoord()[1];
        componentes[2] = cabeza.getCoord()[1] - cola.getCoord()[1];
    }

    public double[] getComp(){
        return componentes;
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
}