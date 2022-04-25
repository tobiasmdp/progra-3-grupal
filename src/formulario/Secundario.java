package formulario;

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
	
}
