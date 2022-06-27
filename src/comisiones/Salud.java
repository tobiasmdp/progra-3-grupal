package comisiones;
/**
 * <br>
 * Clase que representa el tipo de rubro de la clase empleador.
 */
public class Salud extends TipoRubro {
	
	private Comisiones persona;
	
	public Salud(Comisiones persona) {
		this.persona = persona;
	}
	/**
	 * <br>
	 * Metodo que decoro el metodo getComision() del tipo persona.
	 */
	@Override
	public double getComision() {
		return this.persona.getComision();
	}
	
	@Override
	public String toString() {
		return "Salud";
	}

}
