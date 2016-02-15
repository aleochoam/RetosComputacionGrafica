import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.util.Random;

public class Reto2 extends JPanel{
    private static final int INSIDE = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int BOTTOM = 4;
    private static final int TOP = 8;

    private static  int yMax = 125;
    private static  int yMin = -125;
    private static  int xMax = 125;
    private static  int xMin = -125;

    private int h, w;
    private Graphics2D g2d;

    private double tI = 0.0, tF = 1.0;

    @Override
    public void paintComponent(Graphics g) {
       super.paintComponent(g);

       g2d = (Graphics2D) g;

       g2d.setColor(Color.BLUE);

       // size es el tamaño de la ventana.
       Dimension size = getSize();
       // Insets son los bordes y los títulos de la ventana.
       Insets insets = getInsets();
       w =  500;
       h =  500;
       drawLines();

    }

    public void drawLines(){
        Random r = new Random();

        long tiempoInicial = System.currentTimeMillis();
        for (int i = 0; i<10000; i++) {

            int xp0 = (int) (Math.random() * w - w/2);
            int yp0 = (int) (Math.random() * h - h/2);

            int xp1 = (int) (Math.random() * w - w/2);
            int yp1 = (int) (Math.random() * h - h/2);

            CHAlgol(xp0,yp0, xp1,yp1);
            //barskyAl(xp0,yp0, xp1,yp1);
        }

        System.out.println("Cohen–Sutherland algorithm: " + (System.currentTimeMillis() - tiempoInicial) + " milisegundos");

        long tiempoInicial2 = System.currentTimeMillis();

        for (int i = 0; i<10000; i++) {

            int xp0 = (int) (Math.random() * w - w/2);
            int yp0 = (int) (Math.random() * h - h/2);

            int xp1 = (int) (Math.random() * w - w/2);
            int yp1 = (int) (Math.random() * h - h/2);

            //CHAlgol(xp0,yp0, xp1,yp1);
            barskyAl(xp0,yp0, xp1,yp1);
        }
        System.out.println("Liang–Barsky algorithm: " + (System.currentTimeMillis() - tiempoInicial2) + " milisegundos");

    }

    /*
     *Tomado de https://en.wikipedia.org/wiki/Cohen%E2%80%93Sutherland_algorithm
     */

    public int computeOutCode(int x, int y){
        int code = INSIDE;
        if (x < xMin)
            code |= LEFT;
        else if (x > xMax)
            code |= RIGHT;
        if (y < yMin)
            code |= BOTTOM;
        else if (y > yMax)
            code |= TOP;

        return code;
    }

    public void CHAlgol(int x0, int y0, int x1, int y1){
        int outCode0 = computeOutCode(x0, y0);
        int outCode1 = computeOutCode(x1, y1);

        while(true){
            if((outCode0 | outCode1) == 0){
                g2d.setColor(Color.BLUE);
                g2d.drawLine(x0 + w/2,h/2 - y0,x1 + w/2,h/2 - y1);
                break;
            }else if ((outCode0 & outCode1) != 0 ) {
                g2d.setColor(Color.RED);
                g2d.drawLine(x0 + w/2,h/2 - y0,x1 + w/2,h/2 - y1);
                break;
            }else{
                int  x = 0, y = 0;
                int outCodeOut = outCode0 !=0 ? outCode0 : outCode1;

                if ((outCodeOut & TOP) != 0) {
                    x = x0 + (x1-x0) * (yMax-y0) / (y1-y0);
                    y = yMax;
                } else if ((outCodeOut & BOTTOM) != 0) { // point is below the clip rectangle
                    x = x0 + (x1 - x0) * (yMin - y0) / (y1 - y0);
                    y = yMin;
                } else if ((outCodeOut & RIGHT) != 0) {  // point is to the right of clip rectangle
                    y = y0 + (y1 - y0) * (xMax - x0) / (x1 - x0);
                    x = xMax;
                } else if ((outCodeOut & LEFT) != 0) {   // point is to the left of clip rectangle
                    y = y0 + (y1 - y0) * (xMin - x0) / (x1 - x0);
                    x = xMin;
                }

                if (outCodeOut == outCode0) {
                    g2d.setColor(Color.RED);
                    g2d.drawLine(x0 + w/2,h/2 - y0,x + w/2,h/2 - y);
                    x0 = x;
                    y0 = y;
                    outCode0 = computeOutCode(x0, y0);
                } else {
                    g2d.setColor(Color.RED);
                    g2d.drawLine(x1 + w/2,h/2 - y1,x + w/2,h/2 - y);
                    x1 = x;
                    y1 = y;
                    outCode1 = computeOutCode (x1, y1);
                }
            }
        }

    }

    public boolean isInside(int x, int y){
        return (x>xMin && x < xMax && y < yMax && y > yMin);
    }

    public void barskyAl(int x0, int y0, int x1, int y1){
        int dx, dy;


        dx = x1-x0;
        dy = y1-y0;

        if (dx == 0 && dy == 0 && isInside(x0, y0)) {
            //esta adentro
            g2d.setColor(Color.BLUE);
            g2d.drawLine(x0 + w/2, h/2 -y0, x1 + w/2, h/2 -y1);
            return;
        }

        tI = 0;
        tF = 1;

        if (calcularT(- x0 + xMin, dx) &&
            calcularT(x0 - xMax, -dx)  &&
            calcularT(- y0 + yMin, dy) &&
            calcularT(y0 - yMax, -dy)) {

            if (tF < 1) {
                x1 = x0 + (int)tF * dx;
                y1 = y0 + (int)tF * dy;
            }

            if (tI > 0) {
                x0 += tI * dx;
                y0 += tI * dy;
            }
        }
    }

    /**
     * calcula si el segmento intercepta o no
     * @param  num   numerador
     * @param  denom denominador
     * @return       si intercepta con algun lado del cuadro
     * true si esta adentro del todo, falso si no
     */
    public boolean calcularT(int num, int denom){
        double t;
        if (denom == 0) {
            return num <= 0;
        }

        t = num/denom;

        if (denom > 0) {
            if (t > tF) return false;
            if (t > tI) tI = t;
        } else {
            if (t < tI) return false;
            if (t < tF) tF = t;
        }

        return true;
    }

    public static void main(String[] args) {
        // Crear un nuevo Frame
        JFrame frame = new JFrame("Clipping");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Points (esta clase)
        frame.add(new Reto2());
        // Asignarle tamaño
        frame.setSize(500, 500);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);
    }
}