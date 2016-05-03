import Graphics.Color;

public class ZBuffer {
    
    private float deepBuffer[][] = new float[800][600];
    private Color colorBuffer[][] = new Color[800][600];
    
    public double interpolar(double x1, double y1, double x2, double y2, double x3) {
        double y3 = (x3 - x2)/(x1 - x2) * y1 + (x1 - x3)/(x1 - x2) * y2; 
        return y3; 
    }

}
