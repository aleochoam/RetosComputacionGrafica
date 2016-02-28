import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Maths.PuntoH2D;

/**
 * Clase que maneja la ventana y dibuja la chocolatina
 * no se sabe como borrar la chocolatina y crear una nueva
 * @author Alejandro
 *
 */
public class Ventana extends JPanel{
	
	private Graphics2D g2d;
	private int w;
	private int h;
	private Chocolatina chocolatina;
	
	private ArrayList<Chocolatina> listaChocolatinas = new ArrayList<>();

	public static void main(String[] args) {
		if(args.length <1){
			System.out.println("Por favor ingrese un archivo de puntos como "
					+ "parametro del programa");
			System.exit(-1);
		}else{
			Ventana vent = new Ventana(args[0]);
			JFrame frame = new JFrame("Chocolatina");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.add(vent);
	        frame.setSize(500, 500);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);        
	        
	        vent.getKeys();

		}
	}
	
	public Ventana(String archivo) {
		chocolatina = new Chocolatina(archivo);
	}

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	
		Dimension size = getSize();
		java.awt.Insets insets = getInsets();
       
		w =  size.width - insets.left - insets.right;
		h =  size.height - insets.top - insets.bottom;
	
		g2d = (Graphics2D) g;
	    g2d.setColor(Color.BLUE);
	    g2d.drawLine(w/2, h, w/2, 0);
	    g2d.drawLine(0, h/2, w, h/2);
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
	public void getKeys(){
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()){
			System.out.println("Ingrese una tecla");
			char c = sc.nextLine().charAt(0);
			
			switch (c) {
			case 'w':
				listaChocolatinas.add(chocolatina);
				chocolatina = chocolatina.escGrande(chocolatina);
				paintComponent(g2d);
				break;
			case 'a':
				break;
			case 's':
				break;
			case 'd':
				break;
			case 'q':
				break;
			case 'e':
				break;
			case '+':
				break;
			case '-':
				break;
			}
		}
		sc.close();
		
	}
	
}