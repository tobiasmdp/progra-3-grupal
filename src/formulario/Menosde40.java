package formulario;

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
		return "Menos de 40 años  ";
	}
	
}
