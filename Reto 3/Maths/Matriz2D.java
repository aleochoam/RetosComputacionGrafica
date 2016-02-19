package Maths;

public class Matriz2D {
    private double[][] matriz = new double[3][3];

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
        if(fil1 != col2){
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

    public static double determinant(double[][] matrix){ //method sig. takes a matrix (two dimensional array), returns determinant.
        double sum=0; 
        double s;
        if(matrix.length==1){  //bottom case of recursion. size 1 matrix determinant is itself.
            return(matrix[0][0]);
        }
        for(int i=0;i<matrix.length;i++){ //finds determinant using row-by-row expansion
            double[][]smaller= new double[matrix.length-1][matrix.length-1]; //creates smaller matrix- values not in same row, column
            for(int a=1;a<matrix.length;a++){
                for(int b=0;b<matrix.length;b++){
                    if(b<i){
                        smaller[a-1][b]=matrix[a][b];
                    }
                    else if(b>i){
                        smaller[a-1][b-1]=matrix[a][b];
                    }
                }
            }
            if(i%2==0){ //sign changes based on i
                s=1;
            }
            else{
                s=-1;
            }
            sum+=s*matrix[0][i]*(determinant(smaller)); //recursive step: determinant of larger determined by smaller.
        }
        return(sum); //returns determinant value. once stack is finished, returns final determinant.
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





