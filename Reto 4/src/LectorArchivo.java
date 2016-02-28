import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LectorArchivo {
	public static int[][] getPuntos(String archivo)throws FileNotFoundException{
		int [][] puntos = new int[8][2];
		Scanner sc = new Scanner(new File(archivo));
		for (int i = 0; i < puntos.length; i++) {
			puntos[i][0] = sc.nextInt();
			puntos[i][1] = sc.nextInt();
		}

		sc.close();
		return puntos;
	}
}
