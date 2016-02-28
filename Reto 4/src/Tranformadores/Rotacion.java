package Tranformadores;

import Maths.Matriz2D;
import Maths.PuntoH2D;

public class Rotacion extends Matriz2D {

	public Rotacion(double grado) {
		super();
		double rads = Math.toRadians(grado);
		double[][] m = {{Math.cos(rads), -Math.sin(rads),0},
				        {Math.sin(rads),Math.cos(rads),0},
				        {0,0,1}};
	
		matriz = m;
	}
	
	public PuntoH2D rotar(PuntoH2D p){
		double[][] temp = new double[2][1];
		temp[0][0] = p.getPunto()[0];
		temp[1][0] = p.getPunto()[1];
		temp[2][0] = p.getPunto()[2];
		double[][] nuevoPunto = multiplicar(temp, matriz);
		return new PuntoH2D(nuevoPunto[0][0], nuevoPunto[1][0], 1);
	}

}
