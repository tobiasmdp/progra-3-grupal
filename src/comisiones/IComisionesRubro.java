package comisiones;

public interface IComisionesRubro {
	public double calcularComisiones(IComisionesPersona p);
	public double comisionSalud();
	public double comisionLocal();
	public double comisionInternacional();	
}
