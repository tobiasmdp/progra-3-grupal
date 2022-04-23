package dominio;

public class Salud extends Rubro{

	@Override
	public double comisionFisica() {
		return 0.6;
	}

	@Override
	public double comisionJuridica() {
		return 0.8;
	}

	@Override
	public double calcularComisiones(IComisionesRubro p) {
		return p.comisionSalud();
	}

	
}
