package formulario;

public abstract class TipoPuesto {
	protected String tipoPuestoNombre;
	
	public abstract double comisionPuesto();
	public abstract double compara(TipoPuesto otracaract);
	public abstract double comparaJunior();
	public abstract double comparaSenior();
	public abstract double comparaManagment();

	public String getTipoPuestoNombre() {
		return tipoPuestoNombre;
	}

}
