/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imagen;

/**
 *
 * @author htrefftz
 */
public class Kernel3x3 {
    public double [][] kernel;

    public Kernel3x3() {
        kernel = new double[3][3];
    }

    public Kernel3x3(double [][] kernel) {
        this.kernel = kernel;
    }

}
