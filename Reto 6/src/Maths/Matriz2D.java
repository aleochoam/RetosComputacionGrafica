package Maths;

public class Matriz2D {
    protected double[][] matriz = new double[3][3];


    public Matriz2D(){
    	
    }
    public Matriz2D(double[][] m){
        matriz = m;
    }

    public double[][] getMatriz(){
        return matriz;
    }

    public static double[][] multiplicar(double[][] m1, double[][] m2 ){
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

    /**
     * Sacado de http://professorjava.weebly.com/matrix-determinant.html
     * @param  m la matriz
     * @return   el determinante de la matriz
     */
    public static double determinante(double[][] m){
        int sum = 0;
        int s;
        if (m.length == 1) {
            return m[0][0];
        }

        for (int i = 0; i<m.length; i++) {
            double[][] smaller = new double[m.length-1][m[0].length];
            for (int a = 1; a<m.length; a++) {
                for (int b = 0;b<m.length; b++) {
                    if (b<i) {
                        smaller[a-1][b] = m[a][b];
                    }else if (b>i) {
                        smaller[a-1][b-1] = m[a][b];
                    }
                }
            }
            if (i%2 == 0) {
                s = 1;
            }else{
                s = -1;
            }
            sum += s*m[0][i]*determinante(smaller);
        }
        return sum;
    }

    public String toString(){
        String res = "";
        for (int i = 0; i<matriz.length; i++) {
            for (int j = 0; j<matriz[i].length; j++) {
                res = res + matriz[i][j] + ", ";
            }
            res = res + "\n";
        }

        return res;
    }


}





