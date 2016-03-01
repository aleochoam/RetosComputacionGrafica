package Maths;

public class Punto2D {

    private double[] coordenadas = new double[2];

    public Punto2D(double x, double y){
        coordenadas[0] = x;
        coordenadas[1] = y;
    }

    public double[] getCoord(){
        return coordenadas;
    }


    public static Punto2D suma(Punto2D p1, Punto2D p2){
        double rx = p2.getCoord()[0] + p1.getCoord()[0];
        double ry = p2.getCoord()[1] + p1.getCoord()[1];

        return new Punto2D(rx, ry);
    }

    public static Punto2D resta(Punto2D p1, Punto2D p2){
        double rx = p2.getCoord()[0] - p1.getCoord()[0];
        double ry = p2.getCoord()[1] - p1.getCoord()[1];

        return new Punto2D(rx, ry);
    }

    public String toString(){
        return "(" + coordenadas[0] + ", " + coordenadas[1] + ")";
    }
}