package agencia;

public class Contratacion {
	private EmpleadoPretenso empleado;
	private Empleador empleador;
	private double comisionEmpleado;
	private double comisionEmpleador;
	
	
	public Contratacion(EmpleadoPretenso empleado, Empleador empleador, double comisionEmpleado,
			double comisionEmpleador) {
		super();
		this.empleado = empleado;
		this.empleador = empleador;
		this.comisionEmpleado = comisionEmpleado;
		this.comisionEmpleador = comisionEmpleador;
	}


	public EmpleadoPretenso getEmpleado() {
		return empleado;
	}


	public Empleador getEmpleador() {
		return empleador;
	}


	public double getComisionEmpleado() {
		return comisionEmpleado;
	}


	public double getComisionEmpleador() {
		return comisionEmpleador;
	}


	@Override
	public String toString() {
		return "El empleado " + empleado + ", fue contratado por el empleador " + empleador + ".";
	}
	
	
}
