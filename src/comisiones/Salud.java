package comisiones;

public class Salud extends TipoRubro {
	
	private Comisiones persona;
	
	public Salud(Comisiones persona) {
		this.persona = persona;
	}
	
	@Override
	public double getComision() {
		return this.persona.getComision();
	}
	
	@Override
	public String toString() {
		return "Salud";
	}

}
