package formulario;

public class CargaCompleta implements CargaHoraria{


	public double compara(CargaHoraria otracaract) {
		return otracaract.completa();
	}

	public double media() {
		return -0.5;
	}

	public double completa() {
		return 1;
	}

	public double extendida() {
		return 1;
	}

	@Override
	public String toString() {
		return "Carga Completa";
	}

	
}
