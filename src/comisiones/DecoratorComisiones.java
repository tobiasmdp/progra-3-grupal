package comisiones;
/**
 * <br>
 * Clase decorator para que los hijos implementen el metodo a decorar.
 */
public abstract class DecoratorComisiones extends Comisiones {
	
	@Override
	public abstract double getComision();
	
}
