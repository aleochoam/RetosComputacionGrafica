import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Maths.PuntoH3D;

public class LectorArchivo {
	
	public static Chocolatina leerArchivo(String archivo){
		try{
    		Scanner sc = new Scanner(new File(archivo));
    		int n = sc.nextInt();
    		PuntoH3D[] puntos = new PuntoH3D[n];
    		for (int i = 0; i < puntos.length; i++) {
    			int x = sc.nextInt();
    			int y = sc.nextInt();
    			int z = sc.nextInt();
    			puntos[i] = new PuntoH3D(x, y, z, 1);
    		}
    		int m = sc.nextInt();
    		int[][] aristas = new int[m][2];
    		for (int i = 0; i < m; i++) {
    			aristas[i][0] = sc.nextInt();
    			aristas[i][1] = sc.nextInt();
    		}
    		Mainclass.d = sc.nextInt();
    		sc.close();
    		
    		Chocolatina choco = new Chocolatina(puntos, aristas);
    		return choco;
		}catch(FileNotFoundException e){
		    e.printStackTrace();
		}
		return null;
	}
}
