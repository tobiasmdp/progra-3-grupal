package formulario;
/**
 *<br>
 *La clase Terciario es parte del patron Double Dispatch para la categoria del formulario EstudiosCursados
 */
public class Terciario implements EstudiosCursados{

	public double compara(EstudiosCursados otracaract) {
		return otracaract.comparaTerciario();
	}

	public double comparaPrimario() {
		return 2;
	}

	public double comparaSecundario() {
		return 1.5;
	}

	public double comparaTerciario() {
		return 1;
	}

	@Override
	public String toString() {
		return "Terciario ";
	}
	
}
