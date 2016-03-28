import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Maths.Matriz3D;
import Maths.PuntoH3D;
import Trasformaciones.Escalamiento;
import Trasformaciones.Perspectiva;
import Trasformaciones.RotX;
import Trasformaciones.RotY;
import Trasformaciones.RotZ;
import Trasformaciones.Traslacion;

/**
 * Chocolatina de tamaño 60cm * 20cm
 * Vista desde 50 cm
 * @author Alejandro
 *
 */
public class Mainclass extends JPanel{
	
	private Camara camara;
	private Chocolatina choco;
	private Chocolatina chocoMod;
	
	public static int d;

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
		choco = LectorArchivo.leerArchivo("test/objeto3D.txt");
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g2d = (Graphics2D) g;	
		size = getSize();
		Insets insets = getInsets();
		
		g2d.setColor(Color.WHITE);
		Rectangle2D r = new Rectangle2D.Double(0,0,w,h);
		g2d.fill(r);
		
       
		w =  size.width - insets.left - insets.right;
		h =  size.height - insets.top - insets.bottom;
	

	    g2d.setColor(Color.RED);
	    g2d.drawLine(w/2, h, w/2, 0);
	    g2d.drawLine(0, h/2, w, h/2);
	    g2d.setColor(Color.BLUE);
	    
	    chocoMod = choco.tomarPerspectiva(d);
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
	
	public void pintarChocolate(){
		PuntoH3D[] puntos = chocoMod.getPuntos();
		int[][] aristas = choco.getAristas();
		
		for (int i = 0; i < aristas.length; i++) {
			
			PuntoH3D p1 = puntos[aristas[i][0]];
			PuntoH3D p2 = puntos[aristas[i][1]];
			System.out.println(p1 + "\n" + p2 + "\n");
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
	    Matriz3D m = new Matriz3D();
	    int x = 10;
		switch (c) {
			case 'w':
			    m = new Traslacion(0, x, 0);
				break;
			case 's':
			    m = new Traslacion(0, -x, 0);
			    break;
			case 'a':
			    m = new Traslacion(x, 0, 0);
				break;
			case 'd':
			    m = new Traslacion(-x, 0, 0);
			    break;
			case 'q':
				m = new RotZ(x);
				break;
			case 'e':
				m = new RotZ(-x);
				break;
			case '-':
				m = new Escalamiento(1/x, 1/x, 1/x);
				break;
			case '+':
				m = new Escalamiento(x, x, x);
				break;
			case '1':
				m = new RotX(-x);
				break;
			case '4':
				m = new RotX(x);
				break;
			case '2':
				m = new RotY(-x);
				break;
			case '3':
				m = new RotY(x);
				break;
			case 'z':
				m = new Traslacion(0, 0, x);
				break;
			case 'x':
				m = new Traslacion(0, 0, -x);
				break;
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
			default:
				System.out.println(c + " no es una tecla permitida");
				break;
			}
		choco.transformar(m);
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
