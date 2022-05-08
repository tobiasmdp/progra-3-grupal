package capaDeNegocios;

import java.util.ArrayList;

import capaDeDatos.Empleador;
import capaDeDatos.TicketEmpleador;
import capaDePresentacion.UEmpleador;
import comisiones.IPersona;
import comisiones.IRubro;

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
		for (i=0;i<empleador.getTicket().getListaAsignacion().getLista().size();i++) {
			auxUsuario=empleador.getTicket().getListaAsignacion().getLista().get(i);
			System.out.println((i+1) +":"+auxUsuario);
		}
		
	}
	
	
	public void crearTicketEmpleador(String locacion, int remuneracion, String cargaHoraria, String tipoPuesto,
			int rangoEtario, String experienciaPrevia, String estudiosCursados, int cantEmpleados,int pLocacion,int pRemuneracion,int pCargaHoraria,int pTipodePuesto,int pExperienciaPrevia,int pRangoEtario,int pEstudiosCursados,
			UEmpleador uEmpleador){
		Formulario nuevofor = new Formulario(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario,
				experienciaPrevia, estudiosCursados);
		TicketEmpleador nuevoticket = new TicketEmpleador(nuevofor,cantEmpleados,pLocacion,pRemuneracion, pCargaHoraria, pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados);
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

	

	public void cobraComision(Empleador empleador) {
		double modificadorcomision,remuneracion,descuento;
		IRubro rubro;
		IPersona persona;
		//*Extraigo datos*//
		persona=empleador.gettPersona();
		rubro=empleador.getRubro();
		remuneracion=empleador.getTicket().getFormulario().getRemuneracionint();//problema ya que la remu no es int?
		//*Calculo el modificador de la comision*//
		modificadorcomision=persona.calcularComisiones(rubro);
		//*Calculo el descuento por puntaje//*
		descuento=empleador.getPuntaje()*0.01;
		//*Seteo la comision*//
		empleador.setComision(remuneracion*modificadorcomision*descuento);
	}

	public void actualizarPuntaje(Empleador empleador, int valor) {
		empleador.setPuntaje(empleador.getPuntaje()+valor);
		
		
	}
	
}
