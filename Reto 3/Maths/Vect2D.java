package Maths;

public class Vect2D {

    private double[] componentes = new double[2];

    public Vect2D(double x, double y){
        this.componentes[0] = x;
        this.componentes[1] = y;
    }

    public Vect2D(Punto2D cabeza, Punto2D cola){
        componentes[0] = cabeza.getCoord()[0] - cola.getCoord()[0];
        componentes[1] = cabeza.getCoord()[1] - cola.getCoord()[1];
    }

    public double[] getComp(){
        return componentes;
    }

    public static Vect2D suma(Vect2D v1, Vect2D v2){
        double cX = v1.getComp()[0] + v2.getComp()[0];
        double cY = v2.getComp()[1] + v2.getComp()[1];
        return new Vect2D(cX, cY);
    }

    public static Vect2D resta(Vect2D v1, Vect2D v2){
        double cX = v1.getComp()[0] - v2.getComp()[0];
        double cY = v2.getComp()[1] - v2.getComp()[1];
        return new Vect2D(cX, cY);
    }

    public static Vect2D productoEscalar(Vect2D v, double u){
        double[] comp = v.getComp();
        return new Vect2D(comp[0] * u, comp[1] * u);
    }

    public double productoPunto(Vect2D v1,Vect2D v2){
        double cX = v1.getComp()[0] * v2.getComp()[0];
        double cY = v1.getComp()[1] * v2.getComp()[1];
        double result = cX + cY;
        return result;
    }

}
