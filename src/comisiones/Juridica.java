package comisiones;
/**
 * <br>
 * Clase que representa el tipo de persona de la clase empleador.
 */
public class Juridica extends TipoPersona {

	@Override
	public double getComision() {
		return 0.8;
	}

	@Override
	public String toString() {
		return "Juridica";
	}

	
}