package guia604;
import java.util.Arrays;

public class ConjuntoNumeros implements Cloneable{//IMPORTANTE IMPLEMENTAR CLONEABLE
	private int[] celda;
	private int largo;
	private String nombre;
	
	public ConjuntoNumeros(int largo, String nombre) {
		super();
		this.largo = largo;
		this.nombre = nombre;
		this.celda=new int[8];
	}

	//CLON
	public Object clone() {
		try {
			ConjuntoNumeros auxclon=(ConjuntoNumeros)super.clone();//clono la variable asi nomas sin problemas
			auxclon.celda=(int[])celda.clone();//clono los objetos que tiene dentro para nuevas referencias
			return auxclon;	//MIRAR ARRIBA QUE IMPLEMENTE CLONEABLE 
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
		
		
	}
	
	
	
	//
	public int[] getCelda() {
		return celda;
	}

	public int getLargo() {
		return largo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setCelda(int i,int valor){
		this.celda[i]=valor;
	}
	@Override
	public String toString() {
		return "ConjuntoNumeros [celda=" + Arrays.toString(celda) + ", largo=" + largo + ", nombre=" + nombre + "]";
	}
	
	
}
