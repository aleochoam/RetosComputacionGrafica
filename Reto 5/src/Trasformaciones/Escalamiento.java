package Trasformaciones;

import Maths.Matriz3D;
import Maths.PuntoH3D;

public class Escalamiento extends Matriz3D {

	public Escalamiento(double sx, double sy, double sz) {
		super();
		double[][] m = {{sx, 0, 0,0},
						{0 ,sy, 0,0},
						{0 ,0 ,sz,0},
						{0 ,0 ,0 ,1}};
		
		matriz = m;
	}
	
	public PuntoH3D escalar(PuntoH3D p){
		double[][] temp = new double[4][1];
		temp[0][0] = p.getPunto()[0];
		temp[1][0] = p.getPunto()[1];
		temp[2][0] = p.getPunto()[2];
		temp[3][0] = p.getPunto()[3];
		double[][] nuevoPunto = multiplicar(matriz, temp);
		return new PuntoH3D(nuevoPunto[0][0],nuevoPunto[1][0],nuevoPunto[2][0],1);
	}

}
