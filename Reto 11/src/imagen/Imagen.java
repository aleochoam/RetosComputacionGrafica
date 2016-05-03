/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imagen;

import archivos.LectorPPM;
import archivos.GrabadorPPM;

/**
 *
 * @author htrefftz
 */
public class Imagen {
    private Color[][] imagen;
    private int numFilas;
    private int numColumnas;
    private int maxValor;

    public Imagen(String nombreArchivo) {
        LectorPPM lector = new LectorPPM(nombreArchivo);
        numFilas = lector.getNumFilas();
        numColumnas = lector.getNumColumnas();
        maxValor = lector.getMaxValor();
        imagen = lector.getImagen();
    }

    public Imagen(int numFilas, int numColumnas, int maxValor) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.maxValor = maxValor;
        imagen = new Color[numFilas][numColumnas];
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

    public Color getPixel(int fila, int col) {
        return imagen[fila][col];
    }
    
    public void setPixel(int fila, int col, Color color) {
        imagen[fila][col] = color.clonar();
    }

    public Imagen aplicarKernel(Kernel3x3 kernel) {
        Imagen nueva = clonar();
        for (int fila = 1; fila <= numFilas - 2; fila++) {
            for (int col = 1; col < numColumnas - 2; col++) {
                double r =
                        imagen[fila - 1][col -1].getR() * kernel.kernel[0][0] + imagen[fila - 1][col].getR() * kernel.kernel[0][1] + imagen[fila - 1][col + 1].getR() * kernel.kernel[0][2] +
                        imagen[fila][col - 1].getR() * kernel.kernel[1][0] + imagen[fila][col].getR() * kernel.kernel[1][1] + imagen[fila][col + 1].getR() * kernel.kernel[1][2] +
                        imagen[fila + 1][col - 1].getR() * kernel.kernel[2][0] + imagen[fila + 1][col].getR() * kernel.kernel[2][1] + imagen[fila + 1][col + 1].getR() * kernel.kernel[2][2];
                double g =
                        imagen[fila - 1][col -1].getG() * kernel.kernel[0][0] + imagen[fila - 1][col].getG() * kernel.kernel[0][1] + imagen[fila - 1][col + 1].getG() * kernel.kernel[0][2] +
                        imagen[fila][col - 1].getG() * kernel.kernel[1][0] + imagen[fila][col].getG() * kernel.kernel[1][1] + imagen[fila][col + 1].getG() * kernel.kernel[1][2] +
                        imagen[fila + 1][col - 1].getG() * kernel.kernel[2][0] + imagen[fila + 1][col].getG() * kernel.kernel[2][1] + imagen[fila + 1][col + 1].getG() * kernel.kernel[2][2];
                double b =
                        imagen[fila - 1][col -1].getB() * kernel.kernel[0][0] + imagen[fila - 1][col].getB() * kernel.kernel[0][1] + imagen[fila - 1][col + 1].getB() * kernel.kernel[0][2] +
                        imagen[fila][col - 1].getB() * kernel.kernel[1][0] + imagen[fila][col].getB() * kernel.kernel[1][1] + imagen[fila][col + 1].getB() * kernel.kernel[1][2] +
                        imagen[fila + 1][col - 1].getB() * kernel.kernel[2][0] + imagen[fila + 1][col].getB() * kernel.kernel[2][1] + imagen[fila + 1][col + 1].getB() * kernel.kernel[2][2];
                if (r > 1d) r = 1d; if (r < 0) r = 0d;
                if (g > 1d) g = 1d; if (g < 0) g = 0d;
                if (b > 1d) b = 1d; if (b < 0) b = 0d;
                nueva.setPixel(fila, col, new Color(r, g, b));
            }
        }
        return nueva;
    }

    public Imagen volverBlancoYNegro() {
        Imagen nueva = clonar();
        for (int fila = 0; fila < numFilas; fila++) {
            for (int col = 0; col < numColumnas; col++) {
                Color color = nueva.getPixel(fila, col);
                double promedio = (color.getR() + color.getG() + color.getB())/3d;
                nueva.setPixel(fila, col, new Color(promedio, promedio, promedio));
            }
        }
        return nueva;
    }

    public Imagen clonar() {
        Imagen nueva = new Imagen(numFilas, numColumnas, maxValor);
        for (int fila = 0; fila < numFilas; fila++) {
            for (int col = 0; col < numColumnas; col++) {
                nueva.setPixel(fila, col, imagen[fila][col].clonar());
            }
        }
        return nueva;
    }

    public static void main(String [] args) {
        Imagen i = new Imagen("FotoPerro.ppm");
        //Imagen i = new Imagen("ositoOscuro.ppm");
        double [][] matrizBlurr = {
            {1d/9d, 1d/9d, 1d/9d},
            {1d/9d, 1d/9d, 1d/9d},
            {1d/9d, 1d/9d, 1d/9d}
        };
        double [][] matrizSharp = {
            {0d, -1d, 0d},
            {-1d, 5d, -1d},
            {0d, -1d, 0d}
        };
        //Kernel3x3 kernel = new Kernel3x3(matrizSharp);
        //Kernel3x3 kernel = new Kernel3x3(matrizSharp);
        KernelPasaBaja kernel = new KernelPasaBaja();
        //Imagen cambiada = i.aplicarKernel(kpb);
        //Imagen cambiada = i.volverBlancoYNegro();
        Imagen cambiada = i.aplicarKernel(kernel);
        GrabadorPPM grabador = new GrabadorPPM(cambiada, "FotoPerroPasaBaja.ppm");
    }
}
