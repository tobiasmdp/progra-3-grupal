package agencia;

import java.util.ArrayList;
import java.util.Collections;

import formulario.Formulario;
import tickets.TicketEmpleador;


public class Agencia{
	
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
				auxEmpleado=empleadosPretensos.get(j);
				puntaje=calculoPuntajesEmpleador(auxEmpleador.getTicket(),auxEmpleado.getTicket().getFormulario());
				aux=new Usuario_puntaje(auxEmpleado,puntaje);
				auxEmpleador.getTicket().nuevoEmpleadoMatcheado(aux);
			}
			

			Collections.sort(auxEmpleador.getTicket().getEmpleadosmatcheados(), new UsuarioComparator());
			
		}
		for (int i=0; i < empleadosPretensos.size(); i++) {
			auxEmpleado=empleadosPretensos.get(i);
			
			for (int j=0; j < empleadores.size(); j++) {
				auxEmpleador=empleadores.get(j);
				puntaje=calculoPuntajesEmpleado(auxEmpleado.getTicket().getFormulario(),auxEmpleador.getTicket().getFormulario());
				aux=new Usuario_puntaje(auxEmpleador,puntaje);
				auxEmpleado.getTicket().nuevoEmpleadorMatcheado(aux);
			}
			//Collections.sort(auxEmpleador.getTicket().getEmpleadosmatcheados(), new UsuarioComparator());
		}
		//genero las listas de asignaciones
	}
	
	public double calculoPuntajesEmpleador(TicketEmpleador ticketempleador, Formulario formfempleado) {//Calcula puntajes
		double aux=0;
		aux+=ticketempleador.getFormulario().getLocacion().compara(formfempleado.getLocacion())*ticketempleador.getpLocacion();
		aux+=ticketempleador.getFormulario().getRemuneracion().compara(formfempleado.getRemuneracion())*ticketempleador.getpRemuneracion();
		aux+=ticketempleador.getFormulario().getCargaHoraria().compara(formfempleado.getCargaHoraria())*ticketempleador.getpCargaHoraria();
		aux+=ticketempleador.getFormulario().getTipoPuesto().compara(formfempleado.getTipoPuesto())*ticketempleador.getpTipodePuesto();
		aux+=ticketempleador.getFormulario().getExperienciaPrevia().compara(formfempleado.getExperienciaPrevia())*ticketempleador.getpExperienciaPrevia();
		aux+=ticketempleador.getFormulario().getRangoEtario().compara(formfempleado.getRangoEtario())*ticketempleador.getpRangoEtario();
		aux+=ticketempleador.getFormulario().getEstudiosCursados().compara(formfempleado.getEstudiosCursados())*ticketempleador.getpEstudiosCursados();
		return aux;
	}
	
	public double calculoPuntajesEmpleado(Formulario formempleado, Formulario formempleador) {
		double aux=0;
		aux+=formempleado.getLocacion().compara(formempleador.getLocacion());
		aux+=formempleado.getRemuneracion().compara(formempleador.getRemuneracion() );
		aux+=formempleado.getCargaHoraria().compara(formempleador.getCargaHoraria());
		aux+=formempleado.getCargaHoraria().compara(formempleador.getCargaHoraria() );
		aux+=formempleado.getTipoPuesto().compara(formempleador.getTipoPuesto());
		aux+=formempleado.getExperienciaPrevia().compara(formempleador.getExperienciaPrevia() );
		aux+=formempleado.getRangoEtario().compara(formempleador.getRangoEtario());
		aux+=formempleado.getEstudiosCursados().compara(formempleador.getEstudiosCursados() );
		//Agregar las otras comparaciones
		return aux;
	}
	
	/*
	@Override
	public double calcularComisiones() {
		return tPersona.calcularComisiones(rubro);
	}
	*/
	
}
