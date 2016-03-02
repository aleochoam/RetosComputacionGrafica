package Trasformaciones;

import Maths.PuntoH3D;

public class RotX extends Rotacion {

	public RotX(double grado) {
		super(grado);
		double rads = Math.toRadians(grado);
		matriz[0][0] = 1;
		matriz[1][1] = Math.cos(rads);
		matriz[1][2] = -Math.sin(rads);
		matriz[2][1] = Math.sin(rads);
		matriz[2][2] = Math.cos(rads);
	}

	@Override
	public PuntoH3D rotar(PuntoH3D p) {
		// TODO Auto-generated method stub
		return null;
	}

}
