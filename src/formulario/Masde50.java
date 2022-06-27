package formulario;
/**
 *<br>
 *La clase Masde50 es parte del patron Double Dispatch para la categoria del formulario RangoEtario
 */
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
		return "Mas de 50 años";
	}
	
	
}

