package guia604;

public class main {

	public static void main(String[] args) {
		ConjuntoNumeros c1= new ConjuntoNumeros(2,"Nahuel");
		c1.setCelda(0,20);
		c1.setCelda(1, 3);
		ConjuntoNumeros c2=(ConjuntoNumeros)c1.clone();
		c1.setCelda(0,8);
		c1.setCelda(1, 7);
	}

}
