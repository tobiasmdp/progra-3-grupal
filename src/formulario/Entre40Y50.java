package formulario;

<<<<<<< HEAD
/**
 *<br>
 *La clase Entre40y50 es parte del patron Double Dispatch para la categoria del formulario RangoEtario
 */
=======
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
public class Entre40Y50 implements RangoEtario{
    
	public double compara(RangoEtario otracaract) {
		return otracaract.comparaEntre40y50();
	}
	
	public double comparaMenor40() {
		return -0.5;
	}
	
	public double comparaEntre40y50() {
		return 1;
	}
	
	public double comparaMasde50() {
		return 0.5;
}

	@Override
	public String toString() {
		return "Entre 40 y 50 a�os";
	}

}
