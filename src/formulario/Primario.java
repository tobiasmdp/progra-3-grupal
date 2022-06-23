package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase Primario es parte del patron Double Dispatch para la categoria del formulario EstudiosCursados
 */
=======

>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
public class Primario implements EstudiosCursados{

	public double compara(EstudiosCursados otracaract) {
		return otracaract.comparaPrimario();
	}

	public double comparaPrimario() {
		return 1;
	}

	public double comparaSecundario() {
		return -0.5;
	}

	public double comparaTerciario() {
		return -2;
	}

	@Override
	public String toString() {
		return "Primario ";
	}
	
}
