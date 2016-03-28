import Trasformaciones.*;
import Maths.PuntoH3D;

import java.io.FileNotFoundException;

public class Choco3D {
	private PuntoH3D[] puntosH3D = new PuntoH3D[9];
	/*public static final int[][] aristas = {{0,1},
								           {1,2},
								           {2,3},
								           {3,0},
								           {4,7},
								           {5,6},
								           {8,9},
								           {9,10},
								           {10,11},
								           {11,8},
								           {12,15},
								           {13,14},
								           {0,8},
								           {1,9},
								           {2,10},
								           {3,11}};
	*/
	public static final int[][] aristas = {{0,1},
									           {1,2},
									           {2,3},
									           {3,0},
									           {4,5},
									           {5,6},
									           {6,7},
									           {7,4},
									           {0,4},
									           {1,5},
									           {2,6},
									           {3,7},
									           {1,8},
									           {5,8},
									           {6,8},
									           {2,8}};
		
	public Choco3D(String archivo){
		initMatrix(archivo);
	}

	public Choco3D(PuntoH3D[] p){
		puntosH3D = p;
	}

	public void initMatrix(String archivo){
		int[][] puntos = new int[9][3];
		try {
			//puntos = LectorArchivo.getPuntos(archivo);
			puntos = LectorArchivo.getPuntosEjemplo(archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for(int i = 0; i < puntos.length; i++) {
			puntosH3D[i] = new PuntoH3D(puntos[i][0], puntos[i][1], 
					puntos[i][2], 1);
		}
	}
	
	public void movArriba(double d){
		Traslacion m = new Traslacion(0, d, 0);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;
	}
	
	public void movAbajo(double d){
		Traslacion m = new Traslacion(0, -d, 0);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;
	}
	
	public void movIzq(double d){
		Traslacion m = new Traslacion(-d, 0, 0);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;

	}
	
	public void movDer(double d){
		Traslacion m = new Traslacion(d, 0, 0);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;

	}
	
	public void movAdelante(double d){
		Traslacion m = new Traslacion(0, 0, d);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;

	}
	
	public void movAtras(double d){
		Traslacion m = new Traslacion(0, 0, -d);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;

	}
	
	public void movRotX(double d){
		RotX m = new RotX(d);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;

	}
	
	public void movRotMX(double d){
		RotX m = new RotX(-d);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;
		
	}
	
	public void movRotY(double d){
		RotY m = new RotY(d);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;

	}
	
	public void movRotMY(double d){
		RotY m = new RotY(-d);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;

	}
	
	public void movRotZ(double d){
		RotZ m = new RotZ(d);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;

	}
	
	public void movRotMZ(double d){
		RotZ m = new RotZ(-d);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;

	}
	
	public void escG(double d){
		Escalamiento m = new Escalamiento(d, d, d);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;

	}
	
	public void escP(double d){
		Escalamiento m = new Escalamiento(1/d, 1/d, 1/d);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		this.puntosH3D = nuevosPuntos;

	}
	
	public Choco3D tomarPerspectiva(double d){
		Perspectiva m = new Perspectiva(d);
		PuntoH3D[] puntos = this.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];

		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.transformar(puntos[i]);
		}
		return new Choco3D(nuevosPuntos);
		
	}
	
	public PuntoH3D[] getPuntos() {
		return puntosH3D;
	}

}
