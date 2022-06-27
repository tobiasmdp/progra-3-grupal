package persistencia;

public class ContratacionDTO {
	private EmpleadoDTO empleado;
	private EmpleadorDTO empleador;
	
	public ContratacionDTO() {
		super();
	}
	
	public EmpleadoDTO getEmpleado() {
		return empleado;
	}
	public void setEmpleado(EmpleadoDTO empleado) {
		this.empleado = empleado;
	}
	public EmpleadorDTO getEmpleador() {
		return empleador;
	}
	public void setEmpleador(EmpleadorDTO empleador) {
		this.empleador = empleador;
	}
	
	
}
