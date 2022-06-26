package comisiones;

public class Fisica extends TipoPersona {

	@Override
	public double getComision() {
		return 0.6;
	}
	
	@Override
	public String toString() {
		return "Fisica";
	}
	
}
