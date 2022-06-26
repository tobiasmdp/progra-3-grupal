package formulario;
/**
 *<br>
 *La clase Junior es parte del patron Double Dispatch para la categoria del formulario TipodePuesto
 */
public class Junior extends Decorator{
	private TipoPuestoBase puestoBase;
	
	public Junior(TipoPuestoBase puestoBase) {
		this.puestoBase = puestoBase;
		this.tipoPuestoNombre = "Junior";
	}
	
	@Override
	public double comisionPuesto() {
		return this.puestoBase.comisionPuesto();
	}
	
	@Override
	public double compara(TipoPuesto otracaract) {
		return otracaract.comparaJunior();
	}
	
	public double comparaJunior() {
		return this.puestoBase.comparaJunior() + 1;
	}

	public double comparaSenior() {
		return this.puestoBase.comparaSenior() - 0.5;
	} 

	public double comparaManagment() {
		return this.puestoBase.comparaManagment() -1;
	}
	
	@Override
	public String toString() {
		return "Junior";
	}
}
 