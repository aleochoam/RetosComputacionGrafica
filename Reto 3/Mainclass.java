import Maths.*;

public class Mainclass {
    public static void main(String[] args) {
        EcParSR3D ec1 = new EcParSR3D(5, 15, 16, 8, 20, 23);
        EcParSR3D ec2 = new EcParSR3D(-12, -14, -25, -8, -7, -15);

        EcParSR3D.hallarInter(ec1, ec2);
/*
        double[][] m = {{3, -4}, {5,7}};
        System.out.print(Matriz2D.determinante(m));
    */}
}