package comisiones;

public interface IPersona {
	public double comisionSalud();
	public double comisionLocal();
	public double comisionInternacional();
	public double calcularComisiones(IComisionesPersona p);
	
}
