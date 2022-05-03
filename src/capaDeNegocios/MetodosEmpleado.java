package capaDeNegocios;

import java.util.GregorianCalendar;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.TicketEmpleado;

public class MetodosEmpleado {
	private static MetodosEmpleado instance = null;


	private MetodosEmpleado() {
	}
	
	protected static MetodosEmpleado getInstance() {//SINGLETON
		if (MetodosEmpleado.instance == null) {
			MetodosEmpleado.instance = new MetodosEmpleado();
		}
		return instance;
	}
	

	protected void actualizarPuntaje(EmpleadoPretenso empleado) {
		/*
		por cada Ticket finalizado suma 50 puntos
 		por no ser elegido por ningún empleado pretenso resta 20 puntos.
 		por ser primero en la Lista de Empleadores suma 10 puntos por cada una.
		*/
	}
	
	protected double calculoPuntajes(Formulario formempleado, Formulario formempleador) {
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

	protected void mostrarLista(EmpleadoPretenso empleado) {
		int i;
		Usuario_puntaje auxUsuario;
		System.out.println( "Puesto   Puntaje     Empleado       Apellido         Edad         Locacion          Remuneracion               Carga horaria      Tipo de puesto        Experiencia previa    Rango etario        Estudios cursados");
		for (i=0;i<empleado.getTicket().getEmpleadoresmatcheados().size();i++) {
			auxUsuario=empleado.getTicket().getEmpleadoresmatcheados().get(i);
			System.out.println((i+1)+":"+auxUsuario);
		}
	}
	protected void nuevoTicket(GregorianCalendar fecha, Formulario formulario) {
		this.ticket = new TicketEmpleado(fecha, formulario);
	}
}
