package dispatch;

public class HomeOffice implements Locacion{

	
	public double compara(Locacion otracaract) {
		return otracaract.comparaHomeOffice();
	}
	public double comparaHomeOffice() {
			return 1;
	}
	public double comparaPresencial() {
		return -1;
	}	
	public double comparaIndistinto() {
		return 1;
	}
}