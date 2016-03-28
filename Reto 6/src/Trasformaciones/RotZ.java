package Trasformaciones;

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
}
