
package Math;

/**
 * Solves (if possible) a 3x3 linear system
 * @author htrefftz
 */
public class ThreeByThreeSystem {
   
    double [][] coefficients;
    double [] constants;
    double determinant;
    
    /**
     * Receives the coefficients of equations and the contants
     * @param coefficients coefficients of equations
     * @param constants constants
     */
    public ThreeByThreeSystem(double [][] coefficients, double [] constants) {
        this.coefficients = coefficients;
        this.constants = constants;
        this.determinant = computeDeterminant(this.coefficients);
    }
    
    /**
     * Constructor of a very simple case
     */
    public ThreeByThreeSystem() {
        double [][] mat = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        coefficients = mat;
        double [] vec = {1, 1, 1};
        constants = vec;
        determinant = 1d;
    }

    /**
     * Returns the value of the determinant of the 3x3 system
     * @return value of the determinant
     */
    public double getDeterminant() {
        return determinant;
    }
    
    /**
     * Replace column i with the constants vector
     * @param i position of the column to be replaced
     * @return a new matrix in which column "i" replaced by constants
     */
    private double [][] replaceColumn(int i) {
        int numRows = coefficients.length;
        int numCols = coefficients[0].length;
        double [][] newMat = new double[numRows][numCols];
        
        for(int col = 0; col < numCols; col++) {
            for(int row = 0; row < numRows; row++) {
                if(col == i) {
                    newMat[row][col] = constants[row];
                } else {
                    newMat[row][col] = coefficients[row][col];
                }
            }
        }
        return newMat;
    }
    
    /**
     * Compute the result of the 3x3 system
     * @return a vector with the results 
     */
    public double [] computeSystem() {
        double [] results = new double[constants.length];
        if(this.determinant == 0) {
            System.out.println("No solutions!!!");
        }
        for(int pos = 0; pos < constants.length; pos++) {
            results[pos] = computeDeterminant(replaceColumn(pos))
                    /this.determinant;
        }
        return results;
    }
    
    /**
     * Computes the determinant of a 3x3 matrix
     * @param mat matrix with the coefficients
     * @return determinant
     */
    public final double computeDeterminant(double [][] mat) {
        double ret;
        ret = mat[0][0] * (mat[1][1] * mat[2][2] - mat[1][2] * mat[2][1]);
        ret -= mat[0][1] * (mat[1][0] * mat[2][2] - mat[1][2] * mat[2][0]);
        ret += mat[0][2] * (mat[1][0] * mat[2][1] - mat[1][1] * mat[2][0]);
        return ret;
    }
}
