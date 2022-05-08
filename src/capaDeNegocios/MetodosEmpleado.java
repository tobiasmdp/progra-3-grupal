package capaDeNegocios;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.TicketEmpleado;
import capaDePresentacion.UEmpleado;
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
		 * por cada Ticket finalizado suma 50 puntos por no ser elegido por ning�n
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
		for (i = 0; i < empleado.getTicket().getListaAsignacion().getLista().size(); i++) {
			auxUsuario = empleado.getTicket().getListaAsignacion().getLista().get(i);
			System.out.println((i + 1) + ":" + auxUsuario);
		}
	}

	public void crearTicketEmpleado(String locacion, double remuneracion, String cargaHoraria, String tipoPuesto,
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
			if (aux.get(i).getEmpleado().getTicket().getEstado().equalsIgnoreCase("cancelado"))
				actualizarPuntaje(aux.get(i).getEmpleado(),-1);
		}
	}
	
	public void cambiarEstadoTicket(String estado, EmpleadoPretenso empleado) {
			empleado.getTicket().setEstado(estado);
			if (empleado.getTicket().getEstado().equalsIgnoreCase("cancelado"))
				actualizarPuntaje(empleado,-1);
			if (empleado.getTicket().getEstado().equalsIgnoreCase("finalizado"))
				actualizarPuntaje(empleado,10);
	}
	
	

	public void cobraComision(EmpleadoPretenso empleado) {
        double modificadorcomision,remuneracion,descuento;
        TipodePuesto puesto;
        int puntaje;
        puesto=empleado.getTicket().getFormulario().getTipoPuesto();
        remuneracion=empleado.getTicket().getFormulario().getRemuneraciondoub();
        modificadorcomision=puesto.calculaComision();

        puntaje=empleado.getPuntaje();
        if (puntaje>100)
            descuento=1;
        else
            descuento=puntaje*0.01;//penalizacion de pagar mas de la remuneracion por tener negativo

        empleado.setComision(remuneracion*modificadorcomision*(1-descuento));
    }
	
	public void actualizarPuntaje(EmpleadoPretenso empleado, int valor) {
		empleado.setPuntaje(empleado.getPuntaje()+valor);
	}
	

}
