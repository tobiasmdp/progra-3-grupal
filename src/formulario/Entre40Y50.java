package formulario;

/**
 *<br>
 *La clase Entre40y50 es parte del patron Double Dispatch para la categoria del formulario RangoEtario
 */
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
		return "Entre 40 y 50 años";
	}

}
