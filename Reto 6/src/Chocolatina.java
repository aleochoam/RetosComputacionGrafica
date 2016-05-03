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
	
	public PuntoH3D getCentro(){
	    double x0 = Math.abs(puntos[0].getPunto()[0]);
	    double x1 = Math.abs(puntos[1].getPunto()[0]);
	    double y1 = Math.abs(puntos[1].getPunto()[1]);
	    double y2 = Math.abs(puntos[2].getPunto()[1]);
	    double z0 = Math.abs(puntos[0].getPunto()[2]);
	    double z1 = Math.abs(puntos[8].getPunto()[2]);
	    System.out.println(puntos[0] + ", " + puntos[8]);
	    return new PuntoH3D((x1-x0)/2, (y2-y1)/2, (z1-z0)/2, 1);
	}

}
