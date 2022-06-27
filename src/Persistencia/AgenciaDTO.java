package persistencia;

import java.util.ArrayList;

public class AgenciaDTO {
	private ArrayList<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
	private ArrayList<EmpleadorDTO> empleadores = new ArrayList<EmpleadorDTO>();
	private ArrayList<ContratacionDTO> contrataciones = new ArrayList<ContratacionDTO>();
	
	public AgenciaDTO() {
		super();
	}

	public ArrayList<EmpleadoDTO> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(ArrayList<EmpleadoDTO> empleados) {
		this.empleados = empleados;
	}

	
	public ArrayList<ContratacionDTO> getContrataciones() {
		return contrataciones;
	}


	public void setContrataciones(ArrayList<ContratacionDTO> contrataciones) {
		this.contrataciones = contrataciones;
	}


	public ArrayList<EmpleadorDTO> getEmpleadores() {
		return empleadores;
	}

	public void setEmpleadores(ArrayList<EmpleadorDTO> empleadores) {
		this.empleadores = empleadores;
	}
	
}
