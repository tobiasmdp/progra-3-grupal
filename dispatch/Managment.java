package dispatch;

public class Managment implements TipodePuesto{
	
	public double compara(TipodePuesto otracaract) {
		return otracaract.comparaManagment();
	}
	
	public double comparaJunior() {
		return -1;
	}

	public double comparaSenior() {
		return -0.5;
	}

	public double comparaManagment() {
		return -0.5;
	}
	
}
