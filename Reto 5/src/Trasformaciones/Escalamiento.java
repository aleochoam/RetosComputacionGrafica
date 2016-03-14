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
}
