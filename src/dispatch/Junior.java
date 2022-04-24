package dispatch;

public class Junior implements TipodePuesto{
	
	public double compara(TipodePuesto otracaract) {
		return otracaract.comparaJunior();
	}
	
	public double comparaJunior() {
		return 1;
	}

	public double comparaSenior() {
		return -0.5;
	}

	public double comparaManagment() {
		return -1;
	}

	
}
 