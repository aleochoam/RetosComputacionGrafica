package Trasformaciones;

import Maths.Matriz3D;
import Maths.Punto3D;
import Maths.VectH3D;

public class MatrizUVN extends Matriz3D {

    public MatrizUVN(VectH3D camPos, VectH3D lookingTo, VectH3D V){
        super();
        
        Punto3D cabeza = new Punto3D(lookingTo.getX(), lookingTo.getY(), lookingTo.getZ());
        Punto3D cola = new Punto3D(camPos.getX(), camPos.getY(), camPos.getZ());
        
        VectH3D N = new VectH3D(cabeza, cola);
        N.normalize();
        
        VectH3D n = N;
        VectH3D U = VectH3D.productoCruz(V, N);
        U.normalize();
        VectH3D u = U;
        VectH3D v = VectH3D.productoCruz(n, u);
        
        matriz[0][0] = u.getX();
        matriz[0][1] = u.getY();
        matriz[0][2] = u.getZ();
        matriz[1][0] = v.getX();
        matriz[1][1] = v.getY();
        matriz[1][2] = v.getZ();
        matriz[2][0] = n.getX();
        matriz[2][1] = n.getY();
        matriz[2][2] = n.getZ();
        matriz[3][0] = 0;
        matriz[3][1] = 0;
        matriz[3][2] = 0;
        
        double dx = VectH3D.productoPunto(u, camPos);
        double dy = VectH3D.productoPunto(v, camPos);
        double dz = VectH3D.productoPunto(v, camPos);
        
        matriz[0][3] = dx;
        matriz[1][3] = dy;
        matriz[2][3] = dz;
        
        System.out.println("u: " + u); //System.out.println(u.magnitude());
        System.out.println("v: " + v); //System.out.println(v.magnitude());
        System.out.println("n: " + n);
    }
    
    public static void main(String[] args) {
        VectH3D camPos = new VectH3D(200, 100, -200);
        VectH3D lookingTo = new VectH3D(0, 0, 0);
        VectH3D V = new VectH3D(100, 100, -20);
        MatrizUVN uvn = new MatrizUVN(camPos, lookingTo, V);
        
    }
    
}
