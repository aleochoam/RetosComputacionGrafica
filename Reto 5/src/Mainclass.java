import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Maths.Matriz3D;
import Maths.PuntoH3D;
import Trasformaciones.Perspectiva;
import Trasformaciones.Traslacion;

/**
 * Chocolatina de tamaño 60cm * 20cm
 * Vista desde 50 cm
 * @author Alejandro
 *
 */
public class Mainclass extends JPanel{
	
	private Choco3D choco;
	private int d = 10;

	private Graphics2D g2d;
	private Dimension size;
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
		addKeyListener(new MyKeyListener());
		setFocusable(true);
		choco = new Choco3D("test/test1.txt");
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g2d = (Graphics2D) g;	
		size = getSize();
		java.awt.Insets insets = getInsets();
		
		g2d.setColor(Color.WHITE);
		Rectangle2D r = new Rectangle2D.Double(0,0,w,h);
		g2d.fill(r);
		
       
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
	
	public void tomarPerspectiva(double d){
		Matriz3D m = new Perspectiva(d);
		transform(m);
		//repaint();
	}
	
	public void rotar(){
		Matriz3D m = new Traslacion(100,100,0);
		transform(m);
		
	}
	
	public void transform(Matriz3D m){
		PuntoH3D[] puntos = choco.getPuntos();
		PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];
		
		for (int i = 0; i < puntos.length; i++) {
			nuevosPuntos[i] = m.tranformar(puntos[i]);
		}
		choco = new Choco3D(nuevosPuntos);
		pintarChocolate();
	}
	
	public void pintarChocolate(){
		PuntoH3D[] puntos = choco.getPuntos();
		for (int i = 0; i < puntos.length; i++) {
			puntos[i].normalizeW();
		}
		int[][] aristas = Choco3D.aristas;
		
		for (int i = 0; i < aristas.length; i++) {
			PuntoH3D p1 = puntos[aristas[i][0]];
			PuntoH3D p2 = puntos[aristas[i][1]];
			
			drawOneLine((int)p1.getPunto()[0],(int)p1.getPunto()[1], 
					(int)p2.getPunto()[0],(int)p2.getPunto()[1]);
			
		}
	}
	
	/**
	 * Metodo que decodifica las teclas que se introduce
	 * w: subir la chocolatina
	 * a: mover a izq
	 * s: bajar
	 * d: mover a der
	 * z: alejar de pantalla
	 * x: acercar a pantalla
	 * q: rotar clockwize
	 * e: rotar counter-cloclwize
	 * 1: rotar izq
	 * 4: rotar red
	 * 2: rotar hacia adelante
	 * 3: rotar hacia atras
	 * @param c
	 */
	public void doMov(char c){
		switch (c) {
			case 'w':
				choco.movArriba(10);
				//System.out.println(c);
				break;
			case 'a':
				choco.movIzq(10);
				//System.out.println(c);
				break;
			case 's':
				choco.movAbajo(10);
				//System.out.println(c);
				break;
			case 'd':
				choco.movDer(10);
				//System.out.println(c);
				break;
			case 'q':
				choco.movRotZ(10);
				//System.out.println(c);
				break;
			case 'e':
				choco.movRotMZ(10);
				//System.out.println(c);
				break;
			case '+':
				choco.escG(1.5);
				//System.out.println(c);
				break;
			case '-':
				choco.escP(1.5);
				//System.out.println(c);
				break;
			case '1':
				choco.movRotMX(10);
				break;
			case '4':
				choco.movRotX(10);
				break;
			case '2':
				choco.movRotMY(10);
				break;
			case '3':
				choco.movRotY(10);
				break;
			case 'z':
				choco.movAdelante(10);
				break;
			case 'x':
				choco.movAtras(10);
				break;
			default:
				System.out.println(c + " no es una tecla permitida");
				break;
			}
		repaint();
	}
	
	class MyKeyListener implements KeyListener{
		private double d = 0;
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
