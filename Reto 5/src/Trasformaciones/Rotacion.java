package Trasformaciones;

import Maths.Matriz3D;
import Maths.PuntoH3D;

public abstract class Rotacion extends Matriz3D {

	public Rotacion(double grado) {
		super();
		double[][] m = {{0, 0, 0,0},
						{0 ,0, 0,0},
						{0 ,0 ,0,0},
						{0 ,0 ,0 ,1}};
		
		matriz = m;
	}
	
	public PuntoH3D rotar(PuntoH3D p){
		double[][] temp = new double[4][1];
		temp[0][0] = p.getPunto()[0];
		temp[1][0] = p.getPunto()[1];
		temp[2][0] = p.getPunto()[2];
		temp[3][0] = p.getPunto()[3];
		double[][] nuevoPunto = multiplicar(matriz, temp);
		return new PuntoH3D(nuevoPunto[0][0],nuevoPunto[1][0],nuevoPunto[2][0],1);
	}

}
