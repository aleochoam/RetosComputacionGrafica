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
	
	public double[][] Escalar(PuntoH2D p){
		double[][] temp = new double[2][1];
		temp[0][0] = p.getPunto()[0];
		temp[1][0] = p.getPunto()[1];
		return multiplicar(super.matriz, temp);
	
	}

}
