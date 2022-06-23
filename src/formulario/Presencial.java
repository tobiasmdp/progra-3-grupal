package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase Presencial es parte del patron Double Dispatch para la categoria del formulario Locacion
 */
=======

>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
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
	@Override
	public String toString() {
<<<<<<< HEAD
		return "Presencial ";
=======
		return "Presencial";
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
	}
	
}
