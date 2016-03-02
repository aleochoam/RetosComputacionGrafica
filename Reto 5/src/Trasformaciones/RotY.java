package Trasformaciones;

import Maths.PuntoH3D;

public class RotY extends Rotacion {

	public RotY(double grado) {
		super(grado);
		double rads = Math.toRadians(grado);
		matriz[0][0] = Math.cos(rads);
		matriz[0][2] = Math.sin(rads);
		matriz[1][1] = 1;
		matriz[2][0] = -Math.sin(rads);
		matriz[2][2] = Math.cos(rads);
	}

	@Override
	public PuntoH3D rotar(PuntoH3D p) {
		// TODO Auto-generated method stub
		return null;
	}

}
