package formulario;
/**
 *<br>
 *La clase HomeOffice es parte del patron Double Dispatch para la categoria del formulario Locacion
 */
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
	
	@Override
	public String toString() {
		return "Home Office";
	}
	
}
