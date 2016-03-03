package Trasformaciones;

import Maths.Matriz3D;

public class Perspectiva extends Matriz3D {

	public Perspectiva(double d) {
		super();
		matriz[0][0] = 1;
		matriz[1][1] = 1;
		matriz[2][2] = 1;
		matriz[2][3] = 1/d;
		
	}

}
