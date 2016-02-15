package Maths;

public class Punto3D {

    private double[] coordenadas = new double[3];

    public Punto3D(double x, double y, double z){
        coordenadas[0] = x;
        coordenadas[1] = y;
        coordenadas[2] = z;
    }

    public double[] getCoord(){
        return coordenadas;
    }

    public String toString(){
        return "(" + coordenadas[0] + ", " + coordenadas[1] + ", " + coordenadas[2] + ")";
    }
}