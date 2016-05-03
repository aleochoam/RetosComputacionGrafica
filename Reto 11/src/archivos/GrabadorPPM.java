/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import imagen.Imagen;
import java.io.*;

/**
 *
 * @author htrefftz
 */
public class GrabadorPPM {
    PrintStream printStream = null;
    Imagen imagen = null;

    public GrabadorPPM(Imagen imagen, String nombreArchivo) {
        this.imagen = imagen;
        abrirArchivo(nombreArchivo);
        escribirArchivo(imagen);
    }

    private void abrirArchivo(String nombreArchivo) {
        try {
            printStream = new PrintStream(new File(nombreArchivo));
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + e.getMessage());
        }
    }

    private void escribirArchivo(Imagen imagen) {
        System.out.println("Escribiendo la imagen");
        printStream.println("P3");
        printStream.println("# creado por GrabadorPPM");
        printStream.println(imagen.getNumColumnas() + " " + imagen.getNumFilas());
        printStream.println(imagen.getMaxValor());
        for(int fila = 0; fila < imagen.getNumFilas(); fila++) {
            for (int col = 0; col < imagen.getNumColumnas(); col++) {
                int r = (int)(imagen.getPixel(fila, col).getR() * imagen.getMaxValor() + 0.5) ;
                int g = (int)(imagen.getPixel(fila, col).getG() * imagen.getMaxValor() + 0.5) ;
                int b = (int)(imagen.getPixel(fila, col).getB() * imagen.getMaxValor() + 0.5) ;
                printStream.print(r + " ");
                printStream.print(g + " ");
                printStream.print(b + " ");
            }
            printStream.println();
        }
    }

}
