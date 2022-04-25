package agencia;

public class Juridica implements IPersona {

	@Override
	public double comisionSalud() {
		return 0.8;
	}

	@Override
	public double comisionLocal() {
		return 0.9;
	}

	@Override
	public double comisionInternacional() {
		return 1;
	}

	@Override
	public double calcularComisiones(IComisionesPersona p) {
		return p.comisionJuridica();
	}

}
