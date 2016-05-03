/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imagen;

/**
 *
 * @author htrefftz
 */
public class Color {
    double r;
    double g;
    double b;

    public Color(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public double getB() {
        return b;
    }

    public double getG() {
        return g;
    }

    public double getR() {
        return r;
    }

    public Color clonar() {
        Color nuevo = new Color(r, g, b);
        return nuevo;
    }

    @Override
    public String toString() {
        return "Color{" + "r=" + r + "g=" + g + "b=" + b + '}';
    }

}
