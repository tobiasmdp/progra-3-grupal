package dominio;

public class Internacional extends Rubro {

	@Override
	public double comisionFisica() {
		return 0.8;
	}

	@Override
	public double comisionJuridica() {
		return 1;
	}

	@Override
	public double calcularComisiones(IComisionesRubro p) {
		// TODO Auto-generated method stub
		return 0;
	}



}
