package formulario;

public class Indistinto implements Locacion{
	public double compara(Locacion otracaract) {
		return otracaract.comparaIndistinto();
	}
	public double comparaHomeOffice() {
		return 1;
	}
	public double comparaPresencial() {
		return 1;
	}	
	public double comparaIndistinto() {
		return 1;
	}
}
