/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imagen;

/**
 *
 * @author htrefftz
 */
public class KernelPasaBaja extends Kernel3x3 {

    public KernelPasaBaja() {
        super();
        double [][] matrizBlurr = {
            {1d/9d, 1d/9d, 1d/9d},
            {1d/9d, 1d/9d, 1d/9d},
            {1d/9d, 1d/9d, 1d/9d}
        };
        kernel = matrizBlurr;
    }
}
