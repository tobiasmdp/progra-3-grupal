package agencia;

import java.util.ArrayList;
import paquete.Empleador;
import paquete.EmpleadoPretenso;


public class Agencia {
	
	private static Agencia instance = null; // arranca valiendo null, aplico SINGLETON, 
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso>();
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	
	private Agencia() {
	}
	
	public static Agencia getInstance() {
		if (Agencia.instance == null)
			Agencia.instance = new Agencia();
		return instance;
	}

	public ArrayList<EmpleadoPretenso> getEmpleadosPretensos() {
		return empleadosPretensos;
	}

	public ArrayList<Empleador> getEmpleadores() {
		return empleadores;
	}
	
	public void addEmpleadoPretenso(EmpleadoPretenso empleadoPretenso) {
		this.empleadosPretensos.add(empleadoPretenso);
	}
	
	public void addEmpleador(Empleador empleador) {
		this.empleadores.add(empleador);
	}
	
	public void removeEmpleadoPretenso(EmpleadoPretenso empleadoPretenso) {
		this.empleadosPretensos.remove(empleadoPretenso);
	}
	
	public void removeEmpleador(Empleador empleador) {
		this.empleadores.remove(empleador);
	}
	
	public void rondaEncuentrosLaborales() {
		for (int i=0; i < empleadores.size(); i++) {
			for (int j=0; j < empleadosPretensos.size(); j++) {
				
			}
		}
		//genero las listas de asignaciones
	}
}
