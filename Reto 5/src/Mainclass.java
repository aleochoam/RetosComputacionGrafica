import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mainclass extends JPanel{
	
	private Graphics2D g2d;
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
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g2d = (Graphics2D) g;	
		Dimension size = getSize();
		java.awt.Insets insets = getInsets();
       
		w =  size.width - insets.left - insets.right;
		h =  size.height - insets.top - insets.bottom;
	

	    g2d.setColor(Color.RED);
	    g2d.drawLine(w/2, h, w/2, 0);
	    g2d.drawLine(0, h/2, w, h/2);
	    g2d.setColor(Color.BLUE);
	}	
	
	
}
