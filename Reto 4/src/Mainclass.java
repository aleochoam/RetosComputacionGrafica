import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Maths.PuntoH2D;

public class Mainclass extends JPanel{
	
	private Graphics2D g2d;
	private int w, h;
	private static Chocolatina chocolatina;

	public static void main(String[] args) {
		if(args.length <1){
			System.out.println("Por favor ingrese un archivo de puntos como "
					+ "parametro del programa");
			System.exit(-1);
		}else{
			chocolatina = new Chocolatina(args[0]);
			JFrame frame = new JFrame("Chocolatina");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.add(new Mainclass());
	        frame.setSize(500, 500);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
		}
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
}
