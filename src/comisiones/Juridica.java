package comisiones;

public class Juridica implements IPersona {


	@Override
	public double calcularComisiones(IRubro rubro) {
		return rubro.comisionJuridica();
	}

	@Override
	public String toString() {
		return "Juridica";
	}

	
}
