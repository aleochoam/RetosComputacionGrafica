import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.util.Random;

public class Reto extends JPanel{
    @Override
    public void paintComponent(Graphics g) {
       super.paintComponent(g);

       Graphics2D g2d = (Graphics2D) g;

       g2d.setColor(Color.BLUE);

       // size es el tamaño de la ventana.
       Dimension size = getSize();
       // Insets son los bordes y los títulos de la ventana.
       Insets insets = getInsets();
       int w =  500;
       int h =  500;
    }

    public static void main(String[] args) {
        // Crear un nuevo Frame
        JFrame frame = new JFrame("Clipping");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Points (esta clase)
        frame.add(new Reto());
        // Asignarle tamaño
        frame.setSize(500, 500);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);
    }
}