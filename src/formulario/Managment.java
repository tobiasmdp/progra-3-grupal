package formulario;
/**
 *<br>
 *La clase Managment es parte del patron Double Dispatch para la categoria del formulario TipodePuesto
 */
public class Managment extends Decorator{
	private TipoPuestoBase puestoBase;
	
	public Managment(TipoPuestoBase puestoBase) {
		this.puestoBase = puestoBase;
		this.tipoPuestoNombre = "Managment";
	}
	@Override
	public double comisionPuesto() {
		return this.puestoBase.comisionPuesto() + 0.2;
	}
	
	@Override
	public double compara(TipoPuesto otracaract) {
		return otracaract.comparaSenior();
	}
	@Override
	public double comparaJunior() {
		return this.puestoBase.comparaManagment() - 0.5;
	}
	@Override
	public double comparaSenior() {
		return this.puestoBase.comparaManagment();
	}
	@Override
	public double comparaManagment() {
		return this.puestoBase.comparaManagment();
	}
	@Override
	public String toString() {
		return "Managment";
	}
}
