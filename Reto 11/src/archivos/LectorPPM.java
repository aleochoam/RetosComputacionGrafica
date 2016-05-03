/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import imagen.Color;

/**
 *
 * @author htrefftz
 */
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author htrefftz
 */
public class LectorPPM {
    private Color[][] imagen;
    private int numFilas;
    private int numColumnas;
    private int maxValor;
    private String nombreArchivo;
    private boolean DEBUG = true;

    public LectorPPM(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        leerArchivoPPM(nombreArchivo);
    }

    private void leerArchivoPPM(String nombre) {
        try{
            FileInputStream fstream = new FileInputStream(nombre);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(in));
            String strLine;
            // Número mágico
            strLine = br.readLine();
            if(DEBUG) System.out.println(strLine);
            // Comentario
            strLine = br.readLine();
            if(DEBUG) System.out.println(strLine);
            // Si la linea anterior es un comentario,
            while(strLine.charAt(0) == '#') {
                // NumColumnas, NumFilas
                strLine = br.readLine();
                if(DEBUG) System.out.println(strLine);
            }
            Scanner sc = new Scanner(strLine);
            numColumnas = sc.nextInt();
            numFilas = sc.nextInt();
            imagen = new Color[numFilas][numColumnas];
            // máxima profundidad
            strLine = br.readLine();
            if(DEBUG) System.out.println(strLine);
            sc = new Scanner(strLine);
            maxValor = sc.nextInt();
            strLine = br.readLine();
            int fila = 0;
            int columna = 0;
            while(strLine != null) {
                sc = new Scanner(strLine);
                while(sc.hasNextInt()) {
                    int r = sc.nextInt();
                    int g = sc.nextInt();
                    int b = sc.nextInt();
                    Color color = new Color(r/(double)maxValor,
                            g/(double)maxValor, b/(double)maxValor);
                    imagen[fila][columna] = color;
                    columna++;
                    if (columna == numColumnas) {
                        columna = 0;
                        fila++;
                    }
                }
                // leer siguiente linea
                strLine = br.readLine();
            }
            in.close();
        } catch (Exception e){
            System.err.println("Error al leer la escena: " + e.getMessage());
        }
        if(DEBUG) System.out.println("Termine de leer la textura");
    }

    public Color getColor(double s, double t) {
        int fila = (int)(s * (numColumnas - 1));
        int columna = (int)(t * (numFilas - 1));
        return imagen[fila][columna];
    }

    public Color[][] getImagen() {
        return imagen;
    }

    public int getMaxValor() {
        return maxValor;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public int getNumFilas() {
        return numFilas;
    }

    @Override
    public String toString() {
        return "Textura{" + "textura=" + imagen + "numFilas=" + numFilas + "numColumnas=" + numColumnas + "maxValor=" + maxValor + "nombreArchivo=" + nombreArchivo + '}';
    }



    public static void main(String [] args) {
        LectorPPM lector = new LectorPPM("earthmap1k.ppm");
        //Textura imagen = new Textura("ensayo.ppm");
        System.out.println(lector);
    }


}
