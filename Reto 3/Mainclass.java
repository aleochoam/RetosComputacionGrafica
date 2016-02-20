import Maths.*;

public class Mainclass {
    public static void main(String[] args) {
        EcParSR2D ec1 = new EcParSR2D(5, 15, 8, 20);
        EcParSR2D ec2 = new EcParSR2D(-12, -14, -8, -7);

        EcParSR2D.hallarInter(ec1, ec2);

    }
}