package agencia;

public class Local implements IRubro {

	@Override
	public double comisionFisica() {
		return 0.7;
	}

	@Override
	public double comisionJuridica() {
		return 0.9;
	}

	@Override
	public double calcularComisiones(IComisionesRubro p) {
		return p.comisionLocal();
	}

	@Override
	public String toString() {
		return "Local";
	}
	
}
