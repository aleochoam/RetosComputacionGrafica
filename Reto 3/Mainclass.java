import Maths.*;

public class Mainclass {
    public static void main(String[] args) {
        double[][] m1 = {{1,2,-3},
                         {4,0,-2}};

        double[][] m2 = {{3,1},
                         {2,4},
                         {-1,5}};

        Matriz2D res = new Matriz2D(Matriz2D.multiplicar(m1,m2));

        System.out.print(res);

    }
}