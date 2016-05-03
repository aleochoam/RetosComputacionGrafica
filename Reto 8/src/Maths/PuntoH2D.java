package Maths;

public class PuntoH2D{

	private double[] punto= new double[3];

	public PuntoH2D(double x, double y, double w){
		punto[0] = x;
		punto[1] = y;
		punto[2] = w;
	}
	
	public double[] getPunto(){
		return punto;
	}
	public String toString() {
		return "(" + punto[0] + ", " + punto[1] + ", " + punto[2] + ")";
	}
}