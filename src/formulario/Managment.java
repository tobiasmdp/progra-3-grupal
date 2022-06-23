package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase Managment es parte del patron Double Dispatch para la categoria del formulario TipodePuesto
 */
=======

>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
public class Managment implements TipodePuesto{
	
	public double compara(TipodePuesto otracaract) {
		return otracaract.comparaManagment();
	}
	
	public double comparaJunior() {
		return 0;
	}

	public double comparaSenior() {
		return 0.5;
	}

	public double comparaManagment() {
		return 1;
	}

	@Override
	public String toString() {
		return "Managment";
	}
	
<<<<<<< HEAD
	@Override
	public double calculaComision() {
		return 1;
	}
=======
	
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
}
