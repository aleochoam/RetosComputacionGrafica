package Tranformadores;

import Maths.Matriz2D;
import Maths.PuntoH2D;

public class Traslacion extends Matriz2D {

	public Traslacion(double dx, double dy) {
		super();
		double[][] m = {{1,0,dx},
				        {0,1,dy},
				        {0,0,1}};
	
		matriz = m;
	}
	
	public PuntoH2D trasladar(PuntoH2D p){
		double[][] temp = new double[3][1];
		temp[0][0] = p.getPunto()[0];
		temp[1][0] = p.getPunto()[1];
		temp[2][0] = p.getPunto()[2];
		double[][] nuevoPunto = multiplicar(matriz, temp);
		return new PuntoH2D(nuevoPunto[0][0], nuevoPunto[1][0], 1);
	}

}
