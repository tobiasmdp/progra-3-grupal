package dispatch;

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
	
}
