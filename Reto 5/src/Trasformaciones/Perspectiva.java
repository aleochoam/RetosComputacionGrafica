package Trasformaciones;

import Maths.Matriz3D;

public class Perspectiva extends Matriz3D {

	public Perspectiva(double d) {
		super();
		matriz[3][2] = 1/d;
		matriz[3][3] = 0;
	}

}
