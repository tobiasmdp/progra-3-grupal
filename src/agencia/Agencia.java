package agencia;

import java.util.ArrayList;

import formulario.Formulario;


public class Agencia {
	
	private static Agencia instance = null; // arranca valiendo null, aplico SINGLETON, 
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso>();
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	
	private Agencia() {
	}
	
	public static Agencia getInstance() {//SINGLETON
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
	
	/*public EmpleadoPretenso registro(String nombreUsuario,String contra) {//Dudas: no sera void?
		Agencia.getInstance().addEmpleadoPretenso(this);
		return new EmpleadoPretenso(nombreUsuario,contra);
	}*/

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
		Empleador auxEmpleador;
		EmpleadoPretenso auxEmpleado;
		double puntaje;
		Usuario_puntaje aux;
		for (int i=0; i < empleadores.size(); i++) {
			auxEmpleador=empleadores.get(i);
			
			for (int j=0; j < empleadosPretensos.size(); j++) {
				auxEmpleado=empleadosPretensos.get(i);
				puntaje=calculoPuntajesEmpleador(auxEmpleador.getTicket().getFormulario(),auxEmpleado.getTicket().getFormulario());
				aux=new Usuario_puntaje(auxEmpleado,puntaje);
				auxEmpleador.getTicket().nuevoEmpleadoMatcheado(aux);
				
			}
		}
		for (int i=0; i < empleadosPretensos.size(); i++) {
			auxEmpleado=empleadosPretensos.get(i);
			
			for (int j=0; j < empleadores.size(); j++) {
				auxEmpleador=empleadores.get(i);
				puntaje=calculoPuntajesEmpleado(auxEmpleado.getTicket().getFormulario(),auxEmpleador.getTicket().getFormulario());
				aux=new Usuario_puntaje(auxEmpleador,puntaje);
				auxEmpleado.getTicket().nuevoEmpleadorMatcheado(aux);
			}
		}
		//genero las listas de asignaciones
	}
	
	public double calculoPuntajesEmpleador(Formulario formempleador, Formulario formfempleado) {
		double aux=0;
		aux+=formempleador.getLocacion().compara(formfempleado.getLocacion());
		aux+=formempleador.getRemuneracion().compara(formfempleado.getRemuneracion() );
		//Agregar las otras comparaciones
		
		return aux;
	}
	
	public double calculoPuntajesEmpleado(Formulario formempleado, Formulario formempleador) {
		double aux=0;
		aux+=formempleado.getLocacion().compara(formempleador.getLocacion());
		aux+=formempleado.getRemuneracion().compara(formempleador.getRemuneracion() );
		//Agregar las otras comparaciones
		return aux;
	}
	
}
