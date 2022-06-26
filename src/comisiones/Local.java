package comisiones;

public class Local extends TipoRubro {
	private Comisiones persona;
	
	public Local(Comisiones persona) {
		this.persona = persona;
	}
	
	@Override
	public double getComision() {
		return this.persona.getComision() + 0.1;
	}
	@Override
	public String toString() {
		return "Local";
	}

	
	
}
