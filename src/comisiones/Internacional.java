package comisiones;

public class Internacional extends TipoRubro {
	private Comisiones persona;
	
	public Internacional(Comisiones persona) {
		this.persona = persona;
	}
	
	@Override
	public double getComision() {
		return this.persona.getComision() + 0.2;
	}

	@Override
	public String toString() {
		return "Internacional";
	}

}
