package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase Menosde40 es parte del patron Double Dispatch para la categoria del formulario RangoEtario
 */
=======

>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
public class Menosde40 implements RangoEtario{
	       
	public double compara(RangoEtario otracaract) {
		return otracaract.comparaMenor40();
	}
	
	public double comparaMenor40() {
		return 1;
	}

	public double comparaEntre40y50() {
		return -0.5;
	}

	public double comparaMasde50() {
		return -1;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Menos de 40 años  ";
=======
		return "Menos de 40 años";
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
	}
	
}
