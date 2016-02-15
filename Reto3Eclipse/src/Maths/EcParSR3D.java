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

    public String toString(){
        return ("x = " + x0 + " + t(" + dX + ")\n") +
               ("y = " + y0 + " + t(" +dY + ")\n" ) +
               ("z = " + z0 + " + t(" +dZ + ")\n" );
    }
}