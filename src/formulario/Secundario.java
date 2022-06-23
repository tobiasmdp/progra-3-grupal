package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase Secundario es parte del patron Double Dispatch para la categoria del formulario EstudiosCursados
 */
=======

>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
public class Secundario implements EstudiosCursados{

	public double compara(EstudiosCursados otracaract) {
		return otracaract.comparaSecundario();
	}

	public double comparaPrimario() {
		return 1.5;
	}

	public double comparaSecundario() {
		return 1;
	}

	public double comparaTerciario() {
		return -1.5;
	}

	@Override
	public String toString() {
		return "Secundario ";
	}
	
}
