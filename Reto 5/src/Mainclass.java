import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Maths.Matriz3D;
import Maths.PuntoH3D;

public class Mainclass extends JPanel{
	
	private Choco3D choco;
	
	private Graphics2D g2d;
	Dimension size;
	private int w;
	private int h;

	public static void main(String[] args) {
		Mainclass vent = new Mainclass();
		JFrame frame = new JFrame("Chocolatina");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(vent);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	public Mainclass(){
		choco = new Choco3D("test/test1.txt");
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g2d = (Graphics2D) g;	
		size = getSize();
		java.awt.Insets insets = getInsets();
       
		w =  size.width - insets.left - insets.right;
		h =  size.height - insets.top - insets.bottom;
	

	    g2d.setColor(Color.RED);
	    g2d.drawLine(w/2, h, w/2, 0);
	    g2d.drawLine(0, h/2, w, h/2);
	    g2d.setColor(Color.BLUE);
	    
	    pintarChocolate();
	}
	
	/**
	 * Realizado por htrefftz
	 */
	public void drawOneLine(int x1, int y1, int x2, int y2) {

        x1 = x1 + size.width / 2;
        x2 = x2 + size.width / 2;

        y1 = size.height / 2 - y1;
        y2 = size.height / 2 - y2;

        g2d.drawLine(x1, y1, x2, y2);
    }
	
	public void transform(Matriz3D m){
		PuntoH3D[] puntos = choco.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];
		
		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.tranformar(puntos[i]);
		}
		choco = new Choco3D(nuevosPuntos);
	}
	
	public void pintarChocolate(){
		PuntoH3D[] puntos = choco.getPuntos();
		int[][] aristas = Choco3D.aristas;
		
		for (int i = 0; i < aristas.length; i++) {
			PuntoH3D p1 = puntos[aristas[i][0]];
			PuntoH3D p2 = puntos[aristas[i][1]];
			
			drawOneLine((int)p1.getPunto()[0],(int)p1.getPunto()[1], 
					(int)p2.getPunto()[0],(int)p2.getPunto()[1]);
			
		}
	}
	
	
}
