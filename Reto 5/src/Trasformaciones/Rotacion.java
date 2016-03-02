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
	
	public abstract PuntoH3D rotar(PuntoH3D p);

}
