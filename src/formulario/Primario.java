package formulario;
/**
 *<br>
 *La clase Primario es parte del patron Double Dispatch para la categoria del formulario EstudiosCursados
 */
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
		return "Primario";
	}
	
}
