package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase Masde50 es parte del patron Double Dispatch para la categoria del formulario RangoEtario
 */
=======

>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
public class Masde50 implements RangoEtario{
    
	public double compara(RangoEtario otracaract) {
		return otracaract.comparaMasde50();
	}
	
	public double comparaMenor40() {
		return -1;
	}
	
	public double comparaEntre40y50() {
		return -0.5;
	}
	
	public double comparaMasde50() {
		return 1;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Mas de 50 años    ";
=======
		return "Mas de 50 años";
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
	}
	
	
}

