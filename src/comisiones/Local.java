package comisiones;
/**
 * <br>
 * Clase que representa el tipo de rubro de la clase empleador.
 */
public class Local extends TipoRubro {
	private Comisiones persona;
	
	public Local(Comisiones persona) {
		this.persona = persona;
	}
	/**
	 * <br>
	 * Metodo que decoro el metodo getComision() del tipo persona.
	 */
	@Override
	public double getComision() {
		return this.persona.getComision() + 0.1;
	}
	@Override
	public String toString() {
		return "Comercio Local";
	}

	
	
}
