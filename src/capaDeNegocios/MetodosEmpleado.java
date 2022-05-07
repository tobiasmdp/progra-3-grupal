package capaDeNegocios;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;
import capaDeDatos.TicketEmpleado;
import capaDePresentacion.UEmpleado;
import comisiones.IPersona;
import comisiones.IRubro;
import formulario.TipodePuesto;

public class MetodosEmpleado {
	private static MetodosEmpleado instance = null;

	private MetodosEmpleado() {
	}

	protected static MetodosEmpleado getInstance() {// SINGLETON
		if (MetodosEmpleado.instance == null) {
			MetodosEmpleado.instance = new MetodosEmpleado();
		}
		return instance;
	}

	protected void actualizarPuntaje(EmpleadoPretenso empleado) {
		/*
		 * por cada Ticket finalizado suma 50 puntos por no ser elegido por ningún
		 * empleado pretenso resta 20 puntos. por ser primero en la Lista de Empleadores
		 * suma 10 puntos por cada una.
		 */
	}

	protected double calculoPuntajes(Formulario formempleado, Formulario formempleador) {
		double aux = 0;
		aux += formempleado.getLocacion().compara(formempleador.getLocacion());
		aux += formempleado.getRemuneracion().compara(formempleador.getRemuneracion());
		aux += formempleado.getCargaHoraria().compara(formempleador.getCargaHoraria());
		aux += formempleado.getCargaHoraria().compara(formempleador.getCargaHoraria());
		aux += formempleado.getTipoPuesto().compara(formempleador.getTipoPuesto());
		aux += formempleado.getExperienciaPrevia().compara(formempleador.getExperienciaPrevia());
		aux += formempleado.getRangoEtario().compara(formempleador.getRangoEtario());
		aux += formempleado.getEstudiosCursados().compara(formempleador.getEstudiosCursados());
		// Agregar las otras comparaciones
		return aux;
	}

	protected void mostrarLista(EmpleadoPretenso empleado) {
		int i;
		Usuario_puntaje auxUsuario;
		System.out.println(
				"Puesto   Puntaje     Empleado       Apellido         Edad         Locacion          Remuneracion               Carga horaria      Tipo de puesto        Experiencia previa    Rango etario        Estudios cursados");
		for (i = 0; i < empleado.getTicket().getEmpleadoresmatcheados().size(); i++) {
			auxUsuario = empleado.getTicket().getEmpleadoresmatcheados().get(i);
			System.out.println((i + 1) + ":" + auxUsuario);
		}
	}

	public void crearTicketEmpleado(String locacion, int remuneracion, String cargaHoraria, String tipoPuesto,
			int rangoEtario, String experienciaPrevia, String estudiosCursados, UEmpleado uEmpleado) {
		Formulario nuevofor = new Formulario(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario,
				experienciaPrevia, estudiosCursados);
		TicketEmpleado nuevoticket = new TicketEmpleado(GregorianCalendar.getInstance(), nuevofor);
		int i = 0;
		ArrayList <NodoLogeoEmpleado> aux = Agencia.getInstance().getLogeoempleados();
		int arreglologeado = Agencia.getInstance().logged(uEmpleado);
		if (arreglologeado == 1) {
			while (i < aux.size() && !uEmpleado.equals(aux.get(i).getUsuario()))
				i++;
			aux.get(i).getEmpleado().setTicket(nuevoticket);
		}
	}
	
	public void cambiarEstadoTicket(String estado, UEmpleado uEmpleado) {
		int i=0;
		ArrayList <NodoLogeoEmpleado> aux = Agencia.getInstance().getLogeoempleados();
		int arreglologeado = Agencia.getInstance().logged(uEmpleado);
		if (arreglologeado==1) {
			while (i < aux.size() && !uEmpleado.equals(aux.get(i).getUsuario()))
				i++;
			aux.get(i).getEmpleado().getTicket().setEstado(estado);
		}
	}

	public void cobraComision(EmpleadoPretenso empleado) {
		double modificadorcomision,remuneracion,descuento;
		TipodePuesto puesto;
		//*Extraigo datos*//
		puesto=empleado.getTicket().getFormulario().getTipoPuesto();
		remuneracion=empleado.getTicket().getFormulario().getRemuneracionint();
		//*Calculo el modificador de la comision*//
		modificadorcomision=puesto.calculaComision();
		//*Calculo el descuento por puntaje//*
		descuento=empleado.getPuntaje()*0.01;
		//*Seteo la comision*//
		empleado.setComision(remuneracion*modificadorcomision*descuento);
		
		
	}
	
	public void actualizarPuntaje(EmpleadoPretenso empleado, int valor) {
		empleado.setPuntaje(empleado.getPuntaje()+valor);
		
	}
}
