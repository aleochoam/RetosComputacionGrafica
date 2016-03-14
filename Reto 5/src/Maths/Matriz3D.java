package Maths;

public class Matriz3D {

    protected double[][] matriz;

    public double[][] getMatriz(){
        return matriz;
    }
    
    public Matriz3D(){
    	matriz = new double [4][4];
        for(int i = 0; i < 4; i++) {
            matriz[i][i] = 1d;
        }
    	
    }
    
    public Matriz3D(double[][] m){
    	matriz = m;
    }
    
    public static double[][] multiplicar(double[][] m1, double[][] m2){
    	int fil1 = m1.length;
        int col1 = m1[0].length;
        int fil2 = m2.length;
        int col2 = m2[0].length;
        double [][] result = new double[fil1][col2];
        if(col1 != fil2){
          throw new RuntimeException("No se pueden multiplicar las matrices");
        }else{
            for(int i = 0;i < fil1;i++){
                for(int j = 0; j <col2;j++){
                    for(int k = 0; k < col1;k++){
                        result[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
//            double w = result[3][0];
//            if(w != 1) {
//                for(int i = 0; i < 4; i++) {
//                	result[i][0] = result[i][0]/w;
//                }
//            }
        }
        
        return result;
    }
    
    public static PuntoH3D multiplicar(double[][] matrix, PuntoH3D punto) {
        PuntoH3D nuevoPunto = new PuntoH3D(0, 0, 0, 0);
        for(int i = 0; i < 4; i++) {
            double acum = 0;
            for(int j = 0; j < 4; j++) {
                acum += matrix[i][j] * punto.getPunto()[j];
            }
            nuevoPunto.getPunto()[i] = acum;
        }
        double w = nuevoPunto.getPunto()[3];
        if(w != 1) {
            for(int i = 0; i < 4; i++) {
                nuevoPunto.getPunto()[i] = nuevoPunto.getPunto()[i]/w;
            }
        }
        return nuevoPunto;
    }

    public PuntoH3D transformar(PuntoH3D p){
    	return multiplicar(matriz, p);
    }
    
    
}