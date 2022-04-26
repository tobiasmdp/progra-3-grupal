package formulario;

public class CargaExtendida implements CargaHoraria{

	public double compara(CargaHoraria otracaract) {
		return otracaract.extendida();
	}

	public double media() {
		return -1;
	}

	public double completa() {
		return -0.5;
	}

	public double extendida() {
		return 1;
	}

	@Override
	public String toString() {
		return "Extendida";
	}
	
	
}