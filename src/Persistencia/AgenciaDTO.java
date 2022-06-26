package Persistencia;

import java.util.ArrayList;

import capaDeDatos.Administrador;
import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;
import capaDeNegocios.Contratacion;

public class AgenciaDTO {
//	private ArrayList<EmpleadoPretensoDTO> empleadosPretensos = new ArrayList<EmpleadoPretensoDTO>();
	private ArrayList<EmpleadorDTO> empleadores = new ArrayList<EmpleadorDTO>();
//	private ArrayList<AdministradorDTO> administradores = new ArrayList<AdministradorDTO>();
//	private ArrayList<ContratacionDTO> contrataciones = new ArrayList<ContratacionDTO>();
	
	public AgenciaDTO() {
		super();
	}

//	public ArrayList<EmpleadoPretensoDTO> getEmpleadosPretensos() {
//		return empleadosPretensos;
//	}
//
//	public void setEmpleadosPretensos(ArrayList<EmpleadoPretensoDTO> empleadosPretensos) {
//		this.empleadosPretensos = empleadosPretensos;
//	}
//
//	
//
//	public ArrayList<AdministradorDTO> getAdministradores() {
//		return administradores;
//	}
//
//	public void setAdministradores(ArrayList<AdministradorDTO> administradores) {
//		this.administradores = administradores;
//	}
//
//	public ArrayList<ContratacionDTO> getContrataciones() {
//		return contrataciones;
//	}
//
//	public void setContrataciones(ArrayList<ContratacionDTO> contrataciones) {
//		this.contrataciones = contrataciones;
//	}
//	
	public ArrayList<EmpleadorDTO> getEmpleadores() {
		return empleadores;
	}

	public void setEmpleadores(ArrayList<EmpleadorDTO> empleadores) {
		this.empleadores = empleadores;
	}
	
}
