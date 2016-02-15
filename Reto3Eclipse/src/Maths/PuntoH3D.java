package Maths;

public class PuntoH3D{
	
	private double[] punto= new double[4];
	
	public PuntoH3D(double x, double y, double z, double w){
		punto[0] = x;
		punto[1] = y;
		punto[2] = z;
		punto[3] = w;
	}
	public String toString() {
		return "(" + punto[0] + ", " + punto[1] + ", " + punto[2] + ", "
	            + punto[3] + ")"  ;
	}
}