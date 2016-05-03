import Maths.Matriz3D;
import Maths.PuntoH3D;

public class Camara {
    
    private double distance;

	public Camara(double d) {
		distance = d;
	}
	
	public double getDistance(){
	    return distance;
	}

	public void transformar(Matriz3D m ){
	    //distance = m.transformar(new PuntoH3D(x, y, z, w))
	}
}
