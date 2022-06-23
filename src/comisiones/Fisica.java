package comisiones;

public class Fisica implements IPersona {

	@Override
	public double calcularComisiones(IRubro rubro) {
		return rubro.comisionFisica();
	}

	@Override
	public String toString() {
		return "Fisica  ";
	}
	
}
