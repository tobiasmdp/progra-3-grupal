package comisiones;

public class Internacional implements IRubro {

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

	@Override
	public String toString() {
		return "Internacional";
	}

	

}
