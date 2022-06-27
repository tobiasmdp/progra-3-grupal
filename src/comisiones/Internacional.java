package comisiones;

/**
 * <br>
 * Clase que representa el tipo de rubro de la clase empleador.
 */
public class Internacional extends TipoRubro {
	private Comisiones persona;
	
	public Internacional(Comisiones persona) {
		this.persona = persona;
	}
	
	/**
	 * <br>
	 * Metodo que decoro el metodo getComision() del tipo persona.
	 */
	@Override
	public double getComision() {
		return this.persona.getComision() + 0.2;
	}

	@Override
	public String toString() {
		return "Internacional";
	}

}
