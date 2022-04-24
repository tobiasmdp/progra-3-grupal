package agencia;

public class Fisica extends Persona {

	@Override
	public double comisionSalud() {
		return 0.6;
	}

	@Override
	public double comisionLocal() {
		return 0.7;
	}

	@Override
	public double comisionInternacional() {
		return 0.8;
	}

	@Override
	public double calcularComisiones(IComisionesPersona p) {
		return p.comisionFisica();
	}

}