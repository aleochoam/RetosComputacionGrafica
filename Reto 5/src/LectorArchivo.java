import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectorArchivo {
	public static int[][] getPuntos(String archivo)throws FileNotFoundException{
		int [][] puntos = new int[16][3];
		Scanner sc = new Scanner(new File(archivo));
		for (int i = 0; i < puntos.length; i++) {
			puntos[i][0] = sc.nextInt();
			puntos[i][1] = sc.nextInt();
			puntos[i][2] = sc.nextInt();
		}

		sc.close();
		return puntos;
	}
	
	public static int[][] getPuntosEjemplo(String archivo) throws FileNotFoundException{
		int[][] puntos = new int[9][3];
		Scanner sc = new Scanner(new File(archivo));
		for (int i = 0; i < puntos.length; i++) {
			puntos[i][0] = sc.nextInt();
			puntos[i][1] = sc.nextInt();
			puntos[i][2] = sc.nextInt();
			//System.out.println(puntos[i][0]+", "+puntos[i][1]+", "+puntos[i][2]);
		}

		sc.close();
		return puntos;		
	}
}
