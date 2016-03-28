package Trasformaciones;

import Maths.Matriz3D;
import Maths.PuntoH3D;

public class Traslacion extends Matriz3D {

	public Traslacion(double dx, double dy, double dz) {
		super();
		double[][] m = {{1, 0, 0, dx},
						{0, 1, 0, dy},
						{0, 0, 1, dz},
						{0, 0, 0, 1}};
		
		matriz = m;
	}
}
