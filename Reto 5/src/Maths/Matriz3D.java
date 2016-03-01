package Maths;

public class Matriz3D {

    protected double[][] matriz = new double[4][4];

    public double[][] getMatriz(){
        return matriz;
    }
    
    public Matriz3D(){
    	
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
        }
        return result;
    }
}