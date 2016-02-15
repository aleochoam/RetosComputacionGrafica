import Maths.*;

public class Mainclass {
    public static void main(String[] args) {
    	Vect3D v1 = new Vect3D(-3, -2, 5);
    	Vect3D v2 = new Vect3D(6, -10, -1);
    	
    	Vect3D vR = Vect3D.productoCruz(v1, v2);
    	System.out.println(vR);
    }
}