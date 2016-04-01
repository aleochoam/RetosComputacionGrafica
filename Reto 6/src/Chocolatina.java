import Maths.Matriz3D;
import Maths.PuntoH3D;
import Trasformaciones.MatrizUVN;
import Trasformaciones.Perspectiva;

public class Chocolatina {
	
	private PuntoH3D[] puntos;
	private int[][] aristas;

	public Chocolatina(PuntoH3D[] puntos, int[][] aristas) {
		this.puntos = puntos;
		this.aristas = aristas;
	}
	
	public PuntoH3D[] getPuntos(){
		return puntos;
	}
	
	public int[][] getAristas(){
		return aristas;
	}
	
	public void transformar(Matriz3D m){
	    PuntoH3D[] puntos = getPuntos();
	    PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];
	    
	    for (int i = 0; i < puntos.length; i++) {
            nuevosPuntos[i] = m.transformar(puntos[i]);
        }
	    this.puntos = nuevosPuntos;
	}
	
	public Chocolatina tomarPerspectiva(MatrizUVN m){
	    //Perspectiva m = new Perspectiva(d);
	    PuntoH3D[] puntos = getPuntos();
        PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];
        
        for (int i = 0; i < puntos.length; i++) {
            nuevosPuntos[i] = m.transformar(puntos[i]);
        }
        return new Chocolatina(nuevosPuntos, aristas);
	}
	
	public Chocolatina tomarPerspectiva(double d){
        Perspectiva m = new Perspectiva(d);
        PuntoH3D[] puntos = getPuntos();
        PuntoH3D[] nuevosPuntos = new PuntoH3D[puntos.length];
        
        for (int i = 0; i < puntos.length; i++) {
            nuevosPuntos[i] = m.transformar(puntos[i]);
        }
        return new Chocolatina(nuevosPuntos, aristas);
    }

}
