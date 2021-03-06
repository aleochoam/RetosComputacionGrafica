import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Maths.Matriz2D;
import Maths.PuntoH2D;


public class Ventana extends JPanel{
	
	private Graphics2D g2d;
	private int w;
	private int h;
	private Chocolatina chocolatina;
	
	private ArrayList<Chocolatina> listaChocolatinas = new ArrayList<>();

	public static void main(String[] args) {
		Ventana vent = new Ventana();
		JFrame frame = new JFrame("Chocolatina");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(vent);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	public Ventana() {
		KeyListener kl = new MyKeyListener();
		addKeyListener(kl);
		setFocusable(true);
		chocolatina = new Chocolatina("test/test1.txt");
	}

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g2d = (Graphics2D) g;	
		g2d.setColor(Color.WHITE);
		Rectangle2D r = new Rectangle2D.Double(0,0,w,h);
		g2d.fill(r);
		Dimension size = getSize();
		java.awt.Insets insets = getInsets();
       
		w =  size.width - insets.left - insets.right;
		h =  size.height - insets.top - insets.bottom;
	

	    g2d.setColor(Color.RED);
	    g2d.drawLine(w/2, h, w/2, 0);
	    g2d.drawLine(0, h/2, w, h/2);
	    g2d.setColor(Color.BLUE);
	    dibujarChocolate();
	}	
	
	public void dibujarChocolate(){
		
		
		
		PuntoH2D[] puntos = chocolatina.getPuntos();
		int[][] aristas = Chocolatina.aristas;
		
		for (int i = 0; i < aristas.length; i++) {
			PuntoH2D p1 = puntos[aristas[i][0]];
			PuntoH2D p2 = puntos[aristas[i][1]];
			
			g2d.drawLine((int)p1.getPunto()[0] + w/2,h/2 -(int)p1.getPunto()[1], 
					(int)p2.getPunto()[0] + w/2, h/2 -(int)p2.getPunto()[1]);
			
		}
	}
	
	/**
	 * metodo clave que debe leer el teclado y modificar la chocolatina
	 */
	public void doMov(char c){
		switch (c) {
			case 'w':
				listaChocolatinas.add(chocolatina);
				chocolatina = chocolatina.subir(chocolatina);
				//System.out.println(c);
				break;
			case 'a':
				listaChocolatinas.add(chocolatina);
				chocolatina = chocolatina.izquierda(chocolatina);
				//System.out.println(c);
				break;
			case 's':
				listaChocolatinas.add(chocolatina);
				chocolatina = chocolatina.bajar(chocolatina);
				//System.out.println(c);
				break;
			case 'd':
				listaChocolatinas.add(chocolatina);
				chocolatina = chocolatina.derecha(chocolatina);
				//System.out.println(c);
				break;
			case 'q':
				listaChocolatinas.add(chocolatina);
				chocolatina = chocolatina.rotarAntiReloj(chocolatina);
				//System.out.println(c);
				break;
			case 'e':
				listaChocolatinas.add(chocolatina);
				chocolatina = chocolatina.rotarReloj(chocolatina);
				//System.out.println(c);
				break;
			case '+':
				listaChocolatinas.add(chocolatina);
				//Chocolatina aux = chocolatina.
				chocolatina = chocolatina.escGrande(chocolatina);
				//System.out.println(c);
				break;
			case '-':
				listaChocolatinas.add(chocolatina);
				chocolatina = chocolatina.escPeque(chocolatina);
				//System.out.println(c);
				break;
			default:
				System.out.println("Tecla no reconocida");
				break;
			}
		repaint();
	}
	
	class MyKeyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {}

		@Override
		public void keyTyped(KeyEvent e) {
			doMov(e.getKeyChar());
			//System.out.println(e.getKeyChar());
		}
	}
}
