package formulario;
/**
 *<br>
 *La clase CargaMedia es parte del patron Double Dispatch para la categoria del formulario CargaHoraria
 */
public class CargaMedia implements CargaHoraria{
	public double compara(CargaHoraria otracaract) {
		return otracaract.media();
	}

	public double media() {
		return 1;
	}
	public double completa() {
		return -0.5;
	}
	public double extendida() {
		return -1;
	}

	@Override
	public String toString() {
		return "CargaMedia";
	}
	
	
}
