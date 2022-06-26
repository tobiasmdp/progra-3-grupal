package formulario;

public class TipoPuestoBase extends TipoPuesto {
	public TipoPuestoBase() {}
	
	@Override
	public double comisionPuesto() {
		return 0.8;
	}

	@Override
	public double compara(TipoPuesto otracaract) {
		return 0;
	}

	@Override
	public double comparaJunior() {
		return 0;
	}

	@Override
	public double comparaSenior() {
		return 1;
	}

	@Override
	public double comparaManagment() {
		return -0.5;
	}

}
