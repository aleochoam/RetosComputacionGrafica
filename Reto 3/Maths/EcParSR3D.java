package Maths;

/**
 * x = x0 + t(dX)
 * y = y0 + t(dY)
 * z = z0 + t(dZ)
 */
public class EcParSR3D {

    private double x0, y0, z0;
    private double dX, dY, dZ;

    public EcParSR3D(double x0, double y0, double z0, double x1, double y1,
    		double z1){
        this.x0 = x0;
        this.y0 = y0;
        this.z0 = z0;
        dX = x1-x0;
        dY = y1-y0;
        dZ = z1-z0;
    }

    public static double evalX(EcParSR3D ecuacion,double t){
    	return ecuacion.x0 + t * ecuacion.dX;
    }

	public static double evalY(EcParSR3D ecuacion, double t){
	    return ecuacion.y0 + t * ecuacion.dY;
	}

	public static double evalZ(EcParSR3D ecuacion, double t){
		return ecuacion.z0 + t * ecuacion.dZ;
	}

    public static void hallarInter(EcParSR3D ec1, EcParSR3D ec2){
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
        double z = evalZ(ec1, t);

        System.out.println("x = " + x + " y = " + y + " z = " + z);
    }

    public String toString(){
        return ("x = " + x0 + " + t(" + dX + ")\n") +
               ("y = " + y0 + " + t(" +dY + ")\n" ) +
               ("z = " + z0 + " + t(" +dZ + ")\n" );
    }
}