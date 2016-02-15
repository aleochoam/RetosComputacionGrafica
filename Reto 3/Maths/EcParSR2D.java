package Maths;
/**
 * x = x0 + t(dX)
 * y = y0 + t(dY)
 */
public class EcParSR2D {

    double x0, y0;
    double dX, dY;

    public EcParSR2D(double x0, double y0, double x1, double y1){
        this.x0 = x0;
        this.y0 = y0;
        dX = x1-x0;
        dY = y1-y0;
    }

    public String toString(){
        return ("x = " + x0 + " + t(" + dX + ")\n") + ("y = " + y0 + " + t(" + dY + ")");
    }
}