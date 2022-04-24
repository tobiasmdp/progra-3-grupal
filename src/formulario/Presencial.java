package formulario;

public class Presencial implements Locacion{
	public double compara(Locacion otracaract) {
		return otracaract.comparaPresencial();
	}
	public double comparaHomeOffice() {
		return -1;
	}
	public double comparaPresencial() {
		return 1;
	}	
	public double comparaIndistinto() {
		return -1;
	}
}
