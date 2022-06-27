package formulario;
/**
 *<br>
 *La clase Secundario es parte del patron Double Dispatch para la categoria del formulario EstudiosCursados
 */
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
		return "Secundario";
	}
	
}
