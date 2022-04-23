package dispatch;

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
	
}
