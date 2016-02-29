import java.io.FileNotFoundException;

import Maths.PuntoH2D;
import Tranformadores.Escalacion;
import Tranformadores.Rotacion;
import Tranformadores.Traslacion;

public class Chocolatina{

	private PuntoH2D[] puntosH2D = new PuntoH2D[8];
	public static final int[][] aristas = {{0,1},
								           {1,2},
								           {2,3},
								           {3,0},
								           {4,7},
								           {5,6}};

	public Chocolatina(String archivo){
		initMatrix(archivo);
	}

	public Chocolatina(PuntoH2D[] p){
		puntosH2D = p;
	}

	public void initMatrix(String archivo){
		int[][] puntos = new int[8][2];
		try {
			puntos = LectorArchivo.getPuntos(archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for(int i = 0; i < puntos.length; i++) {
			puntosH2D[i] = new PuntoH2D(puntos[i][0], puntos[i][1], 1);
		}
	}

	public PuntoH2D[] getPuntos(){
		return puntosH2D;
	}

	public Chocolatina escGrande(Chocolatina c1){
		Escalacion esc = new Escalacion(10, 10);
		PuntoH2D[] puntos = c1.getPuntos();
		PuntoH2D[] nuevosPuntos = new PuntoH2D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = esc.escalar(puntos[i]);
		}

		return new Chocolatina(nuevosPuntos);
	}

	public Chocolatina escPeque(Chocolatina c1){
		Escalacion esc = new Escalacion(-10, -10);
		PuntoH2D[] puntos = c1.getPuntos();
		PuntoH2D[] nuevosPuntos = new PuntoH2D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = esc.escalar(puntos[i]);
		}

		return new Chocolatina(nuevosPuntos);
	}

	public Chocolatina derecha(Chocolatina c1){
		Traslacion tras = new Traslacion(10, 0);
		PuntoH2D[] puntos = c1.getPuntos();
		PuntoH2D[] nuevosPuntos = new PuntoH2D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = tras.trasladar(puntos[i]);
		}

		return new Chocolatina(nuevosPuntos);
	}

	public Chocolatina izquierda(Chocolatina c1){
		Traslacion tras = new Traslacion(-10, 0);
		PuntoH2D[] puntos = c1.getPuntos();
		PuntoH2D[] nuevosPuntos = new PuntoH2D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = tras.trasladar(puntos[i]);
		}

		return new Chocolatina(nuevosPuntos);
	}

	public Chocolatina subir(Chocolatina c1){
		Traslacion tras = new Traslacion(0, 10);
		PuntoH2D[] puntos = c1.getPuntos();
		PuntoH2D[] nuevosPuntos = new PuntoH2D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = tras.trasladar(puntos[i]);
		}

		return new Chocolatina(nuevosPuntos);
	}

	public Chocolatina bajar(Chocolatina c1){
		Traslacion tras = new Traslacion(0, -10);
		PuntoH2D[] puntos = c1.getPuntos();
		PuntoH2D[] nuevosPuntos = new PuntoH2D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = tras.trasladar(puntos[i]);
		}

		return new Chocolatina(nuevosPuntos);
	}

	public Chocolatina rotarReloj(Chocolatina c1){
		Rotacion rot = new Rotacion(10);
		PuntoH2D[] puntos = c1.getPuntos();
		PuntoH2D[] nuevosPuntos = new PuntoH2D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = rot.rotar(puntos[i]);
		}

		return new Chocolatina(nuevosPuntos);
	}

	public Chocolatina rotarAntiReloj(Chocolatina c1){
		Rotacion rot = new Rotacion(-10);
		PuntoH2D[] puntos = c1.getPuntos();
		PuntoH2D[] nuevosPuntos = new PuntoH2D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = rot.rotar(puntos[i]);
		}

		return new Chocolatina(nuevosPuntos);
	}
}