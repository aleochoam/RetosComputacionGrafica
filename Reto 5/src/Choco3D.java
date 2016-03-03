import Maths.PuntoH3D;

import java.io.FileNotFoundException;

public class Choco3D {
	private PuntoH3D[] puntosH3D = new PuntoH3D[16];
	public static final int[][] aristas = {{0,1},
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
	public Choco3D(String archivo){
		initMatrix(archivo);
	}

	public Choco3D(PuntoH3D[] p){
		puntosH3D = p;
	}

	public void initMatrix(String archivo){
		int[][] puntos = new int[16][3];
		try {
			puntos = LectorArchivo.getPuntos(archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for(int i = 0; i < puntos.length; i++) {
			puntosH3D[i] = new PuntoH3D(puntos[i][0], puntos[i][1], 
					puntos[i][2], 1);
		}
	}
	
	public PuntoH3D[] getPuntos() {
		return puntosH3D;
	}

}
