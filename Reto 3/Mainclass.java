import Maths.*;

/**
 * Clase main para realizar test del paquete grafico
 */

public class Mainclass {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1(){
        System.out.println("Intercepto entre dos rectas en R3");
        EcParSR3D ec1 = new EcParSR3D(5, 15, 16, 8, 20, 23);
        EcParSR3D ec2 = new EcParSR3D(-12, -14, -25, -8, -7, -15);

        EcParSR3D.hallarInter(ec1, ec2);
    }

    public static void test2(){
        System.out.println("Multiplicacion de matrices");

        double m1[][] = {{1,2,-3},
                          {4,0,-2}};

        double m2[][] = {{3,1},
                         {2,4},
                         {-1,5}};

         System.out.println(new Matriz2D(Matriz2D.multiplicar(m1, m2)));
    }

    public static void test3(){
        System.out.println("Suma de vectores");

        Vect2D v1 = new Vect2D(0, 5);
        Vect2D v2 = new Vect2D(6,0);

        Vect2D v = Vect2D.suma(v1, v2);

        System.out.println(v);
        System.out.println("De magnitud " + Vect2D.getMagnitud(v));
    }

    public static void test4(){
        System.out.println("Producto cruz");


        Vect3D v1 = new Vect3D(-3, -2, 5);
        Vect3D v2 = new Vect3D(6, -10, -1);

        System.out.println(Vect3D.productoCruz(v1,v2));

    }

}