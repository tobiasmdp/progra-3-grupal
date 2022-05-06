package capaDeNegocios;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;
import capaDeDatos.TicketEmpleado;
import capaDeDatos.TicketEmpleador;
import capaDePresentacion.UEmpleado;
import capaDePresentacion.UEmpleador;

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
	
	
	public void crearTicketEmpleador(String locacion, int remuneracion, String cargaHoraria, String tipoPuesto,
			int rangoEtario, String experienciaPrevia, String estudiosCursados, int cantEmpleados,
			UEmpleador uEmpleador){
		Formulario nuevofor = new Formulario(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario,
				experienciaPrevia, estudiosCursados);
		TicketEmpleador nuevoticket = new TicketEmpleador(GregorianCalendar.getInstance(), nuevofor,cantEmpleados);
		int i = 0;
		ArrayList <NodoLogeoEmpleador> aux = Agencia.getInstance().getLogeoempleadores();
		int arreglologeado = Agencia.getInstance().logged(uEmpleador);
		if (arreglologeado == 2) {
			while (i < aux.size() && !uEmpleador.equals(aux.get(i).getUsuario()))
				i++;
			aux.get(i).getEmpleador().setTicket(nuevoticket);
		}
	}
	
	public void cambiarEstadoTicket(String estado, UEmpleador uEmpleador) {
		ArrayList <NodoLogeoEmpleador> aux = Agencia.getInstance().getLogeoempleadores();
		int i=0;
		int arreglologeado=Agencia.getInstance().logged(uEmpleador);
		if (arreglologeado==1) {
			while (i < aux.size() && !uEmpleador.equals(aux.get(i).getUsuario()))
				i++;
			aux.get(i).getEmpleador().getTicket().setEstado(estado);
		}
	}
}
