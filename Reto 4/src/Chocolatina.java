import java.io.FileNotFoundException;


import Maths.PuntoH2D;

public class Chocolatina {
	
	
	
	public static void main(String[] args) {
		int[][] puntos = {{}};
		try {
			puntos = LectorArchivo.getPuntos(args[0]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < puntos.length; i++) {
			System.out.println(puntos[i][0] + ", " + puntos[i][1]);
		}
	}
	
}
