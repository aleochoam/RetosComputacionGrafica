package Trasformaciones;

import Maths.PuntoH3D;

public class RotZ extends Rotacion {

	public RotZ(double grado) {
		super(grado);
		double rads = Math.toRadians(grado);
		matriz[0][0] = Math.cos(rads);
		matriz[0][1] = -Math.sin(rads);
		matriz[1][0] = Math.sin(rads);
		matriz[1][1] = Math.cos(rads);
		matriz[2][2] = 1;
	}

	@Override
	public PuntoH3D rotar(PuntoH3D p) {
		// TODO Auto-generated method stub
		return null;
	}

}
