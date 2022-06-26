package formulario;
/**
 *<br>
 *La clase Senior es parte del patron Double Dispatch para la categoria del formulario TipodePuesto
 */
public class Senior extends Decorator{
	private TipoPuestoBase puestoBase;
	
	public Senior(TipoPuestoBase puestoBase) {
		this.puestoBase = puestoBase;
		this.tipoPuestoNombre = "Senior";
	}
	
	@Override
	public double comisionPuesto() {
		return this.puestoBase.comisionPuesto() + 0.1;
	}

	@Override
	public double compara(TipoPuesto otracaract) {
		return otracaract.comparaSenior();
	}

	@Override
	public double comparaJunior() {
		return this.puestoBase.comparaSenior() - 1.5 ;
	}

	@Override
	public double comparaSenior() {
		return this.puestoBase.comparaSenior();
	}

	@Override
	public double comparaManagment() {
		return this.puestoBase.comparaSenior();
	}
	
	@Override
	public String toString() {
		return "Senior";
	}
}
