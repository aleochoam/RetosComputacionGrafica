package Tranformadores;

import Maths.Matriz2D;
import Maths.PuntoH2D;

public class Escalacion extends Matriz2D {
	
	public Escalacion(double sx, double sy){
		super();
		
		double[][] m = {{sx, 0 , 0},
				        {0 , sy,0},
				        {0 , 0 ,1}};
	
		matriz = m;
	}
	
	public PuntoH2D escalar(PuntoH2D p){
		double[][] temp = new double[3][1];
		temp[0][0] = p.getPunto()[0];
		temp[1][0] = p.getPunto()[1];
		temp[2][0] = p.getPunto()[2];
		double[][] nuevoPunto = multiplicar(matriz, temp);
		return new PuntoH2D(nuevoPunto[0][0], nuevoPunto[1][0], 1);
	}
}
