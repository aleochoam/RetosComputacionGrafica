package Maths;
/**
 * x = x0 + t(dX)
 * y = y0 + t(dY)
 *
 * https://mx.answers.yahoo.com/question/index?qid=20100211150225AAmgM4V
 * http://www.intmath.com/matrices-determinants/1-determinants.php
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

    public static double evalX(EcParSR2D ecuacion,double t){
    	return ecuacion.x0 + t * ecuacion.dX;
    }

	public static double evalY(EcParSR2D ecuacion, double t){
	    return ecuacion.y0 + t * ecuacion.dY;
	}

    public String toString(){
        return ("x = " + x0 + " + t(" + dX + ")\n") +
        	   ("y = " + y0 + " + t(" + dY + ")");
    }

    public static void hallarInter(){
        //mirar link
    }
}