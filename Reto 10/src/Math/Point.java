/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

/**
 *
 * @author htrefftz
 */
public class Point {
    double x;
    double y;
    double z;

    /**
     * Constructor
     * @param x x coordinate
     * @param y y coordinate
     * @param z z coordinate
     */
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public static Point add(Point p1, Point p2){
    	double x = p1.x + p2.x;
    	double y = p1.y + p2.y;
    	double z = p1.z + p2.z;
    	return new Point(x,y,z);
    }
    
    public static Point multiply(Point p1, double d){
    	double x = p1.x * d;
    	double y = p1.y * d;
    	double z = p1.z * d;
    	return new Point(x,y,z);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
    
    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}
