package capaDeNegocios;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;
import capaDeDatos.TicketEmpleador;

public class MetodosEmpleador {
	private static MetodosEmpleador instance = null;

	
	private MetodosEmpleador() {//Constructor
	}
	
	protected static  MetodosEmpleador getInstance() {//SINGLETON
		if (MetodosEmpleador.instance == null) {
			MetodosEmpleador.instance = new MetodosEmpleador();
		}
		return instance;
	}

	protected void actualizarPuntaje(Empleador empleador) {
		/*
		por cada Ticket finalizado suma 50 puntos
 		por no ser elegido por ningún empleado pretenso resta 20 puntos.
 		por ser primero en la Lista de Empleadores suma 10 puntos por cada una.
		*/
	}
	
	protected double calculoPuntajes(TicketEmpleador ticketempleador, Formulario formfempleado) {//Calcula puntajes
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
	
	

	protected void mostrarLista(Empleador empleador) {
		int i;
		Usuario_puntaje auxUsuario; 
		System.out.println( "Puesto    Puntaje    Empleador        Rubro       Tipo Persona   Locacion          Remuneracion               Carga horaria      Tipo de puesto        Experiencia previa    Rango etario        Estudios cursados");
		for (i=0;i<empleador.getTicket().getEmpleadosmatcheados().size();i++) {
			auxUsuario=empleador.getTicket().getEmpleadosmatcheados().get(i);
			System.out.println((i+1) +":"+auxUsuario);
		}
		
	}
	
	
	protected void nuevoTicket(GregorianCalendar fecha, Formulario formulario, String estado, int cantempleadosbuscados, int pLocacion, int pRemuneracion, int pCargaHoraria,
			int pTipodePuesto, int pExperienciaPrevia, int pRangoEtario, int pEstudiosCursados) {
		this.ticket = new TicketEmpleador(fecha, formulario,estado, cantempleadosbuscados, pLocacion,pRemuneracion, pCargaHoraria,
				pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados); 
	}
	
}
