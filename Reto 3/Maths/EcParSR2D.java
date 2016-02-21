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

    public static void hallarInter(EcParSR2D ec1, EcParSR2D ec2){
        double[][] A = new double[2][2];
        double[]   B = new double[2];

        A[0][0] = ec1.dX;
        A[1][0] = ec1.dY;
        A[0][1] = (-1)*ec2.dX;
        A[1][1] = (-1)*ec2.dY;

        B[0] = ec2.x0 + (-1)*ec1.x0;
        B[1] = ec2.y0 + (-1)*ec1.y0;


        double[][] xM = new double[A.length][A.length];
        xM[0][1] = A[0][1];
        xM[1][1] = A[1][1];

        for (int i = 0; i<A.length; i++) {
            xM[i][0] = B[i];
        }

        double[][] yM = new double[A.length][A.length];
        yM[0][0] = A[0][0];
        yM[1][0] = A[1][0];


        for (int i = 0; i<A.length; i++) {
            yM[i][1] = B[i];
        }

        double detA = Matriz2D.determinante(A);
        double detX = Matriz2D.determinante(xM);
        double detY = Matriz2D.determinante(yM);


        double t = detX/detA;
        double u = detY/detA;

        double x = evalX(ec1, t);
        double y = evalY(ec1, t);

        System.out.println("x = " + x + " y = " + y);
    }
}