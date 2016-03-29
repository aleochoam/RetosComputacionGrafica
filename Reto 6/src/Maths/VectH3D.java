package Maths;

public class VectH3D extends Vect3D {
    
    private double w;

    public VectH3D(double x, double y, double z) {
        super(x, y, z);
        w = 1;
    }
    
    public VectH3D(double x, double y, double z, double w){
        super(x,y,z);
        this.w = w;
    }

    public VectH3D(Punto3D cabeza, Punto3D cola) {
        super(cabeza, cola);
        this.w = 1;
    }
    
    public double getX(){
        return componentes[0];
    }
    
    public double getY(){
        return componentes[1];
    }
    
    public double getZ(){
        return componentes[2];
    }
    
    public double getW(){
        return w;
    }
    
    public static VectH3D productoCruz(Vect3D v1, Vect3D v2){
        double x = (v1.getComp()[1] * v2.getComp()[2]) -
                (v1.getComp()[2] * v2.getComp()[1]);
        double y = -((v1.getComp()[0] * v2.getComp()[2]) -
                (v1.getComp()[2] * v2.getComp()[0]));
        double z = (v1.getComp()[0] * v2.getComp()[1]) -
                (v1.getComp()[1] * v2.getComp()[0]);
        return new VectH3D(x,y,z);
    }
    
    public void normalizeW() {
        if (componentes[3] == 0) {
            return;
        }
        for(int i = 0; i < 4; i++) {
            componentes[i] /= componentes[3];
        }
    }
    
    public String toString(){
        return super.toString() + " w = " + w;
    }

}
