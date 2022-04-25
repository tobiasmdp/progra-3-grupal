package agencia;

import agencia.Agencia;
import dispatch.Formulario;
import tickets.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Empleador extends Usuario {
	private String nombre;
	private Persona tPersona;
	private Rubro rubro;
	
	private double pesoLocacion;
	private double pesoRemuneracion;
	private double pesoCargaHoraria;
	private double pesoTipoPuesto;
	private double pesoRangoEtario;
	private double pesoExperienciaPrevia;
	private double pesoEstudiosCursados;
	//private TicketEmpleador ticket;
	
	private Empleador(String nombreUsuario,String contra) {
		super(nombreUsuario,contra);
		Agencia.getInstance().addEmpleador(this);
	}
	
	
	private Empleador(String nombreUsuario,String contra,String nombre, Persona tPersona, Rubro rubro) {
		super(nombreUsuario,contra);
		Agencia.getInstance().addEmpleador(this);
		this.nombre = nombre;
		this.tPersona = tPersona;
		this.rubro = rubro;
		
	}
	
	public void visualizacionLista() {
		ArrayList<Usuario_puntaje> empleadosPretensos = this.ticket.getLista();
		for (Usuario_puntaje empleadoPretenso : empleadosPretensos) {
			System.out.println(empleadoPretenso.getUsuario()); //mostrar el usuario? o el nombre?
		}
	}
	
	public void nuevoTicket(GregorianCalendar fecha, Formulario formulario,int cantEmpleadosBuscados,int estado ) { //alta
		this.ticket = new TicketEmpleador(fecha,formulario,cantEmpleadosBuscados,estado); //terminar la creacion de un empleador
	}

	public Empleador registro(String nombreUsuario,String contra,String nombre, Persona tPersona, Rubro rubro) {
		return new Empleador(nombreUsuario,contra,nombre,tPersona,rubro);
	}
	
	public Empleador registro(String nombreUsuario,String contra) {
		return new Empleador(nombreUsuario,contra);
	}
	
	public TicketEmpleador getTicket() {
		return (TicketEmpleador) this.ticket;
	}
	
	public String getNombre() {
		return nombre;
	}
	public Persona gettPersona() {
		return tPersona;
	}
	public Rubro getRubro() {
		return rubro;
	}
	
	public void establecerPesos(double pesoLocacion,double pesoRemuneracion,double pesoCargaHoraria,double pesoTipoPuesto,double pesoRangoEtario,
			double pesoExperienciaPrevia,double pesoEstudiosCursados) {
		this.pesoLocacion = pesoLocacion;
		this.pesoRemuneracion = pesoRemuneracion;
		this.pesoCargaHoraria = pesoCargaHoraria;
		this.pesoTipoPuesto = pesoTipoPuesto;
		this.pesoRangoEtario = pesoRangoEtario;
		this.pesoExperienciaPrevia = pesoExperienciaPrevia;
		this.pesoEstudiosCursados = pesoEstudiosCursados;
	}
	
	public double calculoPuntajesEmpleador(Formulario formEmpleado) {
		double aux=0;
		Formulario formEmpleador = this.ticket.getFormulario();
		
		aux += this.pesoLocacion * formEmpleador.getLocacion().compara(formEmpleado.getLocacion());
		aux += this.pesoRemuneracion * formEmpleador.getRemuneracion().compara(formEmpleado.getRemuneracion());
		aux += this.pesoCargaHoraria * formEmpleador.getCargaHoraria().compara(formEmpleado.getCargaHoraria());
		aux += this.pesoEstudiosCursados * formEmpleador.getEstudiosCursados().compara(formEmpleado.getEstudiosCursados());
		aux += this.pesoRangoEtario * formEmpleador.getRangoEtario().compara(formEmpleado.getRangoEtario());
		aux += this.pesoTipoPuesto * formEmpleador.getTipoPuesto().compara(formEmpleado.getTipoPuesto());
		aux += this.pesoExperienciaPrevia * formEmpleador.getExperienciaPrevia().compara(formEmpleado.getExperienciaPrevia());
		
		
		return aux;
	}
	
	
	@Override
	public void actualizarPuntaje() {
		/*
		por cada Ticket finalizado suma 50 puntos
 		por no ser elegido por ningún empleado pretenso resta 20 puntos.
 		por ser primero en la Lista de Empleadores suma 10 puntos por cada una.
		*/
	}

	@Override
	public double calcularComisiones() {
		return tPersona.calcularComisiones(rubro);
	}

}
