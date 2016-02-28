import java.io.FileNotFoundException;

import Maths.PuntoH2D;

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
	
	public void initMatrix(String archivo){
		int[][] puntos = new int[8][2];
		try {
			puntos = LectorArchivo.getPuntos(archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < puntos.length; i++) {
			puntosH2D[i] = new PuntoH2D(puntos[i][0], puntos[i][1], 1);
			//System.out.println(puntos[i][0] + ", " +puntos[i][1]);
		}
	}
	
	public PuntoH2D[] getPuntos(){
		return puntosH2D;
	}
}