package capaDeNegocios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import capaDeDatos.TicketEmpleado;
import capaDeDatos.TicketEmpleador;


public class Agencia{
	
	private static Agencia instance = null; // arranca valiendo null, aplico SINGLETON, 
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso>();
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	private int V1=50000,V2=150000;
	private ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>();
	
	public ArrayList<Contratacion> getContrataciones() {
		return contrataciones;
	}
	

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
	
	
	private double calculoPuntajesEmpleado(Formulario formempleado, Formulario formempleador) {
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
	
	/**
	 * llegado el momento de contratacion, al tratar las listas ordenadas, si el empleado eligiese 2 empresas, 
	 * siempre seria contratado por la que le dio mejor puntaje
	 */
	private void rondaContrataciones() {
		double comisionEmpleado, comisionEmpleador;
		TicketEmpleador ticketEmpleador,ticketEmpleadorElegido;
		TicketEmpleado ticketEmpleado;
		ArrayList<Usuario_puntaje> eleccionEmpleador,eleccionEmpleado;
		Empleador empleadorElegido;
		EmpleadoPretenso empleadoElegido;
		for(Empleador empleador:this.empleadores) {
			ticketEmpleador = empleador.getTicket();
			eleccionEmpleador= ticketEmpleador.getUsuariosElegidos(); //tomo el array de empleados elegidos por el empleado
			Collections.sort(eleccionEmpleador, new UsuarioComparator()); 
			
			for (Usuario_puntaje usuarioElegidoPorEmpleador:eleccionEmpleador) { // para cada usuario_puntaje elegido por ese ticket de empleador
				empleadoElegido = (EmpleadoPretenso) usuarioElegidoPorEmpleador.getUsuario();
				ticketEmpleado = empleadoElegido.getTicket();
				eleccionEmpleado = ticketEmpleado.getUsuariosElegidos();
				Collections.sort(eleccionEmpleado, new UsuarioComparator());	
				
				for (Usuario_puntaje usuarioElegidoPorEmpleado:eleccionEmpleado) { //el empleadorElegido si castear, siendo usuario
					empleadorElegido = (Empleador) usuarioElegidoPorEmpleado.getUsuario();
					ticketEmpleadorElegido= empleadorElegido.getTicket(); 
					if (ticketEmpleador.equals(ticketEmpleadorElegido)){ 
						empleador.actualizarPuntaje();
						empleadoElegido.actualizarPuntaje();	
						
						comisionEmpleado = 1;//calcular comision empleador
						comisionEmpleador = 1;//calcular comision empleado
						
						this.contrataciones.add(new Contratacion(empleadoElegido, empleador,comisionEmpleado, comisionEmpleador));
						
						ticketEmpleador.setCantempleadosobtenidos(ticketEmpleador.getCantempleadosbuscados() + 1 );
						if (ticketEmpleador.getCantempleadosbuscados() == ticketEmpleador.getCantempleadosobtenidos()){
							ticketEmpleador.setEstado("finalizado");
						}
						ticketEmpleado.setEstado("finalizado");
//						ticketEmpleado.setResultado(0); hay que poner un exito o fracaso?
						// dar de baja "ticketEmpleador"
						//dar de baja "ticketEmpleado"
					}
				}
			}
		}
	}

	


	@Override
	public void actualizarPuntaje() {
		/*
		por cada Ticket finalizado suma 50 puntos
 		por no ser elegido por ningún empleado pretenso resta 20 puntos.
 		por ser primero en la Lista de Empleadores suma 10 puntos por cada una.
		*/
	}
	
	/*
	@Override
	public double calcularComisiones() {
		return tPersona.calcularComisiones(rubro);
	}
	*/

	public int getV1() {
		return V1;
	}

	public void setV1(int v1) {
		V1 = v1;
	}

	public int getV2() {
		return V2;
	}

	public void setV2(int v2) {
		V2 = v2;
	}

	public void mostrarContrataciones() {
		for(Contratacion contratacion:Agencia.getInstance().getContrataciones()) {
			System.out.println(contratacion);
		}
	}
}
