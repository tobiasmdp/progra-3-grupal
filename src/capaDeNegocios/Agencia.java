package capaDeNegocios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;

import capaDeDatos.Administrador;
import capaDeDatos.Cliente;
import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;
import capaDeDatos.ListaDeAsignacion;
import capaDeDatos.PuestoTrabajo;
import capaDeDatos.TicketEmpleado;
import capaDeDatos.TicketEmpleador;
import capaDePresentacion.UAdministrador;
import capaDePresentacion.UCliente;
import capaDePresentacion.UEmpleado;
import capaDePresentacion.UEmpleador;
import capaDePresentacion.Usuario;
import excepciones.ContraException;
import excepciones.LoginException;
import excepciones.NewRegisterException;
import excepciones.NombreUsuarioException;
import excepciones.UsuarioNoEncontradoException;

public class Agencia extends Observable{

	private static Agencia instance = null; // arranca valiendo null, aplico SINGLETON,
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso>();
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	private ArrayList<Administrador> administradores = new ArrayList<Administrador>();
	private int V1 = 50000, V2 = 150000;
	private int vencimientoTicket;
	private ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>();
	private MetodosEmpleado zonaEmpleados;
	private MetodosEmpleador zonaEmpleador;
	private ArrayList<NodoLogeoEmpleado> logeoempleados = new ArrayList<NodoLogeoEmpleado>();
	private ArrayList<NodoLogeoEmpleador> logeoempleadores = new ArrayList<NodoLogeoEmpleador>();
	private ArrayList<NodoLogeoAdministrador> logeoadministradores = new ArrayList<NodoLogeoAdministrador>();
	//nuevo
	private Random rand = new Random();
    private BolsaDeTrabajo bolsatrabajo=new BolsaDeTrabajo(); //nueva y unica bolsa;
    private ArrayList<Thread> simempleadoresT = new ArrayList<Thread>();
    private ArrayList<Thread> simempleadoT = new ArrayList<Thread>();
    private ArrayList<EmpleadorSimulado> simempleadores = new ArrayList<EmpleadorSimulado>();
    private ArrayList<EmpleadoSimulado> simempleado = new ArrayList<EmpleadoSimulado>();
	
	
	public ListaDeAsignacion getListaDeAsignacion(UCliente uCliente) {
		ListaDeAsignacion listaDeAsignacion;
		Cliente cliente;
		cliente = getCliente(uCliente);
		listaDeAsignacion = cliente.getListaDeAsignacion();
		return listaDeAsignacion;
	}

	public ArrayList<Contratacion> getContrataciones() {
		return contrataciones;
	}

	private Agencia() {
		this.zonaEmpleados = MetodosEmpleado.getInstance();
		this.zonaEmpleador = MetodosEmpleador.getInstance();
	}

	public static Agencia getInstance() {// SINGLETON
		if (Agencia.instance == null) {
			Agencia.instance = new Agencia();
		}
		return instance;
	}

	/****** GETTERS DE ARRAYLISTS ******/

	public ArrayList<EmpleadoPretenso> getEmpleadosPretensos() {
		return empleadosPretensos;
	}

	public ArrayList<Empleador> getEmpleadores() {
		return empleadores;
	}

	public ArrayList<NodoLogeoEmpleado> getLogeoempleados() {
		return logeoempleados;
	}

	public ArrayList<NodoLogeoEmpleador> getLogeoempleadores() {
		return logeoempleadores;
	}

	/****** AGREGADOS DE ARRAYLISTS ******/

	public void addLogeoEmpleadores(NodoLogeoEmpleador usuario) {// Agrega un administrador logeado al arreglo de logeos
																	// empleadores
		this.logeoempleadores.add(usuario);
	}

	public void addLogeoEmpleadoPretenso(NodoLogeoEmpleado usuario) {// Agrega un empleado logeado al arreglo de logeos
																		// empleados
		this.logeoempleados.add(usuario);
	}

	public void addLogeoAdministrador(NodoLogeoAdministrador usuario) {// Agrega un administrador logeado al arreglo de
																		// logeos admins
		this.logeoadministradores.add(usuario);
	}

	public void addAdministrador(Administrador usuario) {// Agrega un administrador al arreglo de admins
		this.administradores.add(usuario);
	}

	public void addEmpleadoPretenso(EmpleadoPretenso empleadoPretenso) {// Agrega un empleado al arreglo de empleados
		this.empleadosPretensos.add(empleadoPretenso);
	}

	public void addEmpleador(Empleador empleador) {// Agrega un empleador al arreglo de empleadores
		this.empleadores.add(empleador);
	}

	/****** REMOVEDORES DE ARRAYLISTS ******/

	public void removeEmpleadoPretenso(EmpleadoPretenso empleadoPretenso) {
		this.empleadosPretensos.remove(empleadoPretenso);
	}

	public void removeEmpleador(Empleador empleador) {
		this.empleadores.remove(empleador);
	}

	public void removeAdministrador(Administrador administrador) {
		this.administradores.remove(administrador);
	}

	public void removeLogeoEmpleados(NodoLogeoEmpleado empleado) {
		this.logeoempleados.remove(empleado);
	}

	public void removeLogeoEmpleador(NodoLogeoEmpleador empleador) {
		this.logeoempleadores.remove(empleador);
	}

	public void removeLogeoAdministrador(NodoLogeoAdministrador administrador) {
		this.logeoadministradores.remove(administrador);
	}

	/*------------------------------------logs-------------------------------------------------------------*/

	/**
	 * Intenta logearse en el sistema.
	 * @throws LoginException: clase padre de las dos excepciones que puede lanzar. (ContraException y NombreUsuarioException)
	 * ContraException en caso de que la contrasenia ingresada no sea la correcta.
	 * NombreUsuarioException en caso de que no se encuentre el nombre de usuario ingresado.
	 */
	public Usuario login(String nombreUsuario, String contra) throws ContraException,NombreUsuarioException {
		int i = 0;
		Usuario auxUsuario;
		while (i < empleadosPretensos.size() && !(empleadosPretensos.get(i).getNombreUsuario().equals(nombreUsuario)))
			i++;
		if (i < empleadosPretensos.size() && empleadosPretensos.get(i).getNombreUsuario().equals(nombreUsuario)) // agrego a logeado
			if (empleadosPretensos.get(i).getPassword().equals(contra)) {
				auxUsuario=new UEmpleado();
				addLogeoEmpleadoPretenso(new NodoLogeoEmpleado(auxUsuario, empleadosPretensos.get(i)));
				setChanged();
				notifyObservers("Empleado");
				
			} else
				throw new ContraException("la contrase�a ingresada no es la correcta", contra);
		else {
			i = 0;
			while (i < empleadores.size() && !(empleadores.get(i).getNombreUsuario().equals(nombreUsuario)))
				i++;
			if (i < empleadores.size() && empleadores.get(i).getNombreUsuario().equals(nombreUsuario)) // agrego a logeado
				if (empleadores.get(i).getPassword().equals(contra)) {
					auxUsuario=new UEmpleador();
					addLogeoEmpleadores(new NodoLogeoEmpleador(auxUsuario, empleadores.get(i)));
					setChanged();
					notifyObservers("Empleador");
				} else
					throw new ContraException("la contrase�a ingresada no es la correcta", contra);
			else {
				i = 0;
				while (i < administradores.size() && !(administradores.get(i).getNombreUsuario().equals(nombreUsuario)))
					i++;
				if (i < administradores.size() && administradores.get(i).getNombreUsuario().equals(nombreUsuario)) // agrego a logeado
					if (administradores.get(i).getPassword().equals(contra)) {
						auxUsuario=new UAdministrador();
						addLogeoAdministrador(new NodoLogeoAdministrador(auxUsuario, administradores.get(i)));
						setChanged();
						notifyObservers("Administrador");
					} else
						throw new ContraException("la contrase�a ingresada no es la correcta", contra);
				else
					throw new NombreUsuarioException("el nombre de usuario ingresado no coincide", nombreUsuario); // si llego hasta aca 
																							//es que no lo encontro en ningun lado
			}
		}
		return auxUsuario;
	}

	/**
	 * @param usuario recibe un usuario de la presentacion para poder saber si esta
	 *                logeado o no
	 * @return retorna 1 si es emplado, 2 si es empleador, 3 si es admin y 0 si no
	 *         esta logeado
	 */
	public int logged(Usuario usuario) {
        int i = 0;
        while (i < logeoempleados.size() && !usuario.equals(logeoempleados.get(i).getUsuario()))
            i++;
        if (i < logeoempleados.size() && usuario.equals(logeoempleados.get(i).getUsuario()))
            return 1;
        else {
            i = 0;
            while (i < logeoempleadores.size() && !usuario.equals(logeoempleadores.get(i).getUsuario()))
                i++;
            if (i < logeoempleadores.size() && usuario.equals(logeoempleadores.get(i).getUsuario()))
                return 2;
            else {
                i = 0;
                while (i < logeoadministradores.size() && !usuario.equals(logeoadministradores.get(i).getUsuario()))
                    i++;
                if (i < logeoadministradores.size() && usuario.equals(logeoadministradores.get(i).getUsuario()))
                    return 3;
                else
                    return 0;
            }
        }
    }

	/**
	 * @param usuario recibe un usuario para poder hacerle el logout del sistema
	 */
	public void logout(Usuario usuario) {
		int i = 0;
		while (i < logeoempleados.size() && !usuario.equals(logeoempleados.get(i).getUsuario()))
			i++;
		if (i < logeoempleados.size() && usuario.equals(logeoempleados.get(i).getUsuario()))
			removeLogeoEmpleados(logeoempleados.get(i));
		else {
			i = 0;
			while (i < logeoempleadores.size() && !usuario.equals(logeoempleadores.get(i).getUsuario()))
				i++;
			if (i < logeoempleadores.size() && usuario.equals(logeoempleadores.get(i).getUsuario()))
				removeLogeoEmpleador(logeoempleadores.get(i));
			else {
				i = 0;
				while (i < logeoadministradores.size() && !usuario.equals(logeoadministradores.get(i).getUsuario()))
					i++;
				if (i < logeoadministradores.size() && usuario.equals(logeoadministradores.get(i).getUsuario()))
					removeLogeoAdministrador(logeoadministradores.get(i));
			}
		}
	}

	////////////////////////////////////////////// SOLICITUDES////////////////////////////////////////////////////

	// Solicitudes Usuario

	public void borrarCuenta(Usuario usuario) {
		int i = 0;
		while (i < logeoempleados.size() && !usuario.equals(logeoempleados.get(i).getUsuario()))
			i++;
		if (i < logeoempleados.size() && usuario.equals(logeoempleados.get(i).getUsuario())) {
			removeEmpleadoPretenso(logeoempleados.get(i).getEmpleado());
			removeLogeoEmpleados(logeoempleados.get(i));
		} else {
			i = 0;
			while (i < logeoempleadores.size() && !usuario.equals(logeoempleadores.get(i).getUsuario()))
				i++;
			if (i < logeoempleadores.size() && usuario.equals(logeoempleadores.get(i).getUsuario())) {
				removeEmpleador(logeoempleadores.get(i).getEmpleador());
				removeLogeoEmpleador(logeoempleadores.get(i));
			} else {
				i = 0;
				while (i < logeoadministradores.size() && !usuario.equals(logeoadministradores.get(i).getUsuario()))
					i++;
				if (i < logeoadministradores.size() && usuario.equals(logeoadministradores.get(i).getUsuario())) {
					removeAdministrador(logeoadministradores.get(i).getAdministrador());
					removeLogeoAdministrador(logeoadministradores.get(i));
				}
			}
		}
	}

	public void miPuntaje(UCliente cliente) {
		Cliente aux = getCliente(cliente);
		aux.getPuntaje();
	}

	// Solicitudes UEmpleador

	/**
	 * Crea el objeto empleador y lo agrega al sistema.
	 * Una vez registrado el empleador, se logea automaticamente.
	 */
	public Usuario registroEmpleador(String usuario, String contrasenia) {
		Empleador aux = new Empleador(usuario, contrasenia);
		Usuario uEmpleador=null;
		addEmpleador(aux);
		try {
			uEmpleador=login(usuario, contrasenia);
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
		return uEmpleador;
	}

	public Usuario registroEmpleador(String usuario, String contrasenia, String nombre, String tPersona, String rubro) {
		
		Empleador aux = new Empleador(usuario, contrasenia, nombre, tPersona, rubro);
		addEmpleador(aux);
		Usuario uEmpleador=null;
		try {
			uEmpleador=login(usuario, contrasenia);
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
		return uEmpleador;
	}

	public void crearTicketEmpleador(String locacion, double remuneracion, String cargaHoraria, String tipoPuesto,
			int rangoEtario, String experienciaPrevia, String estudiosCursados, int cantEmpleados, int pLocacion,
			int pRemuneracion, int pCargaHoraria, int pTipodePuesto, int pExperienciaPrevia, int pRangoEtario,
			int pEstudiosCursados, UEmpleador uEmpleador) {
		zonaEmpleador.crearTicketEmpleador(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario,
				experienciaPrevia, estudiosCursados, cantEmpleados, pLocacion, pRemuneracion, pCargaHoraria,
				pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados, uEmpleador);
	}

	public void cambiarEstadoTicket(String estado, UEmpleador uEmpleador) {
		if (!estado.equalsIgnoreCase("cancelado"))
			zonaEmpleador.cambiarEstadoTicket(estado, uEmpleador);
	}

	public TicketEmpleado getTicketEmpleado(Usuario usuario) {

		return zonaEmpleados.getTicket((UEmpleado)usuario);
	}
	public TicketEmpleador getTicketEmpleador(Usuario usuario) {

		return zonaEmpleador.getTicket((UEmpleador)usuario);
	}

	
	public void cambiarEstadoTicket(String estado, Empleador empleador) {
		zonaEmpleador.cambiarEstadoTicket(estado, empleador);
	}

	// Solicitud UEmpleado
	
	/**
	 * Crea el objeto empleado y lo agrega al sistema.
	 * Una vez registrado el empleado, se logea automaticamente.
	 */

	public Usuario registroEmpleado(String usuario, String contrasenia) {
		EmpleadoPretenso aux = new EmpleadoPretenso(usuario, contrasenia);
		addEmpleadoPretenso(aux);
		Usuario uEmpleado=null;
		try {
			uEmpleado= login(usuario, contrasenia);
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
		return uEmpleado;
	}

	public Usuario registroEmpleado(String usuario, String contrasenia, String nombre, String apellido, String telefono,
			int edad) {
		EmpleadoPretenso aux = new EmpleadoPretenso(usuario, contrasenia, nombre, apellido, telefono, edad);
		addEmpleadoPretenso(aux);
		Usuario uEmpleador=null;
		try {
			uEmpleador=login(usuario, contrasenia);
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
		return uEmpleador;
	}
	public Usuario registroAdministrador(String usuario, String contrasenia) {
		Administrador aux = new Administrador(usuario, contrasenia);
		this.addAdministrador(aux);
		Usuario uAdministrador=null;
		try {
			uAdministrador=login(usuario, contrasenia);
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
		return uAdministrador;
	}

	public void crearTicketEmpleado(String locacion, double remuneracion, String cargaHoraria, String tipoPuesto,
			int rangoEtario, String experienciaPrevia, String estudiosCursados, UEmpleado uEmpleado) {
		zonaEmpleados.crearTicketEmpleado(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario,
				experienciaPrevia, estudiosCursados, uEmpleado);
	}

	public void cambiarEstadoTicket(String estado, UEmpleado uEmpleado) {
		if (!estado.equalsIgnoreCase("cancelado"))
			zonaEmpleados.cambiarEstadoTicket(estado, uEmpleado);
	}

	public void cambiarEstadoTicket(String estado, EmpleadoPretenso empleado) {
		zonaEmpleados.cambiarEstadoTicket(estado, empleado);
	}

	// UAdministrador
	
	/**
	 * Crea el objeto administrador y lo agrega al sistema.
	 * Una vez registrado el administrador, se logea automaticamente.
	 */
	/*
	public void registroAdministrador(String usuario, String contrasenia, UAdministrador uAdministrador) {
		Administrador aux = new Administrador(usuario, contrasenia);
		addAdministrador(aux);
		try {
			login(usuario, contrasenia, uAdministrador);
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
	}
*/
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Recorre todos los empleadores que tengan los tickets en activo. Y calcula el puntaje de todos los empleados para con ese empleador.
	 * Una vez calculados todos los puntajes los guarda en la lista de asignacion del empleador.
	 * Luego hace los mismo con los empleados y recorre todos los empleadores.
	 * <b>Post: </b> Se crean las listas de asignaciones.
	 */
	public void rondaEncuentrosLaborales() {
		Empleador auxEmpleador;
		EmpleadoPretenso auxEmpleado;
		double puntaje;
		Usuario_puntaje aux;
		int k;
		for (int i = 0; i < empleadores.size(); i++) {
			auxEmpleador = empleadores.get(i);
			if (auxEmpleador.getTicket() != null && auxEmpleador.getTicket().getEstado().equalsIgnoreCase("activo")) {
				auxEmpleador.getTicket().nuevaLista();
				for (int j = 0; j < empleadosPretensos.size(); j++) {
					auxEmpleado = empleadosPretensos.get(j);
					if (auxEmpleado.getTicket() != null && auxEmpleado.getTicket().getEstado().equalsIgnoreCase("activo")) {
						puntaje = zonaEmpleador.calculoPuntajes(auxEmpleador.getTicket(),
								auxEmpleado.getTicket().getFormulario());
						aux = new Usuario_puntaje(auxEmpleado, puntaje);
						auxEmpleador.getTicket().addUsuarioAsignacion(aux);
					}
				}
				Collections.sort(auxEmpleador.getTicket().getListaAsignacion().getLista(), new UsuarioComparator());																								
				if(auxEmpleador.getTicket().getListaAsignacion().getLista()!=null) {
	                k = auxEmpleador.getTicket().getListaAsignacion().getLista().size() - 1;
					zonaEmpleados.actualizarPuntaje((EmpleadoPretenso) auxEmpleador.getTicket().getListaAsignacion().getLista().get(k).getUsuario(),-5);
					zonaEmpleados.actualizarPuntaje((EmpleadoPretenso) auxEmpleador.getTicket().getListaAsignacion().getLista().get(0).getUsuario(),5);
				}
			}
		}
		for (int i = 0; i < empleadosPretensos.size(); i++) {
			auxEmpleado = empleadosPretensos.get(i);
			if (auxEmpleado.getTicket() != null && auxEmpleado.getTicket().getEstado().equalsIgnoreCase("activo")) {
				auxEmpleado.getTicket().nuevaLista();
				if (this.vencimientoTicket > auxEmpleado.getTicket().getRondasTranscurridas())
					auxEmpleado.getTicket().setRondasTranscurridas(auxEmpleado.getTicket().getRondasTranscurridas()+1);
				else
					zonaEmpleados.cambiarEstadoTicket("cancelado",auxEmpleado);
				for (int j = 0; j < empleadores.size(); j++) {
					auxEmpleador = empleadores.get(j);
					if (auxEmpleador.getTicket() != null
							&& auxEmpleador.getTicket().getEstado().equalsIgnoreCase("activo")) {
						puntaje = zonaEmpleados.calculoPuntajes(auxEmpleado.getTicket().getFormulario(),
								auxEmpleador.getTicket().getFormulario());
						aux = new Usuario_puntaje(auxEmpleador, puntaje);
						auxEmpleado.getTicket().addUsuarioAsignacion(aux);
					}
				}
				Collections.sort(auxEmpleado.getTicket().getListaAsignacion().getLista(), new UsuarioComparator());
				
                zonaEmpleador.actualizarPuntaje((Empleador) auxEmpleado.getTicket().getListaAsignacion().getLista().get(0).getUsuario(), 10);
			}
		}
	}

	/**
	 * Busca en cada ticket de cada empleador los empleados elegidos y se fija si estos que eligio, lo eligieron a el.
	 * <b>Pre: </b> Se tiene que haber gatillado la ronda de encuentros laborales.
	 * <b>Post: </b> Se cambian los estados de los tickets correspondientes, se calculan las comisiones, se modifican algunos puntajes.
	 * Y se crean contratos en caso de que se elijan mutuamente.
	 */
	public void rondaContrataciones() {
		TicketEmpleador ticketEmpleador;
		TicketEmpleado ticketEmpleado;
		ArrayList<Usuario_puntaje> eleccionEmpleador, eleccionEmpleado;
		EmpleadoPretenso empleadoElegido;
		int i;

		for (Empleador empleador : this.empleadores) {
			ticketEmpleador = empleador.getTicket();
			if (ticketEmpleador!=null && ticketEmpleador.getEstado().equalsIgnoreCase("activo")) {
				if (checkElegido(empleador) == false)
					zonaEmpleador.actualizarPuntaje(empleador, -20);
				eleccionEmpleador = ticketEmpleador.getUsuariosElegidos(); // tomo el array de empleados elegidos por el
																			// empleador
				Collections.sort(eleccionEmpleador, new UsuarioComparator());
				for (Usuario_puntaje usuarioElegidoPorEmpleador : eleccionEmpleador) { // para cada usuario_puntaje
																						// elegido por ese ticket de
																						// empleador
					empleadoElegido = (EmpleadoPretenso) usuarioElegidoPorEmpleador.getUsuario();
					ticketEmpleado = empleadoElegido.getTicket();
					if (ticketEmpleado!=null && ticketEmpleado.getEstado().equalsIgnoreCase("activo")) {
						eleccionEmpleado = ticketEmpleado.getUsuariosElegidos(); // todos los empleadores elegidos
						Collections.sort(eleccionEmpleado, new UsuarioComparator());
						i = 0;
						while (i < eleccionEmpleado.size() && eleccionEmpleado.get(i).getUsuario() != empleador) {
							i++;
						}
						if (i < eleccionEmpleado.size()) {// el empleado eligio al empleador
					
							this.contrataciones.add(new Contratacion(empleadoElegido, empleador));

							ticketEmpleador.setCantempleadosobtenidos(ticketEmpleador.getCantempleadosbuscados() + 1);
							if (ticketEmpleador.getCantempleadosbuscados() == ticketEmpleador
									.getCantempleadosobtenidos()) {
								zonaEmpleador.cambiarEstadoTicket("finalizado",empleador);
							}
							zonaEmpleados.cambiarEstadoTicket("finalizado",empleadoElegido);
							zonaEmpleador.cobraComision(empleador);
							zonaEmpleados.cobraComision(empleadoElegido);
						}
					}
				}
			}
		}
	}
	
	/**
	 * Se fija si el empleador no fue elegido por ningun empleado pretenso.
	 * @return true en caso de que lo haya elegido al menos una vez.
	 */
	private boolean checkElegido(Empleador empleador) {
		int i = 0, j = 0;
		boolean esta = false;
		EmpleadoPretenso empleado;
		while (i < this.empleadosPretensos.size() && !esta) {
			empleado = this.empleadosPretensos.get(i);
			while (j < empleado.getTicket().getListaAsignacion().getLista().size() && !esta) {
				if (empleado.getTicket().getListaAsignacion().getLista().get(j).getUsuario() == empleador)
					esta = true;
				j++;
			}
			i++;
		}
		return esta;
	}

	/**
	 * Elige el empleado/empleador (depende el caso) cuyo nombre de usuario en pasado por parametro.
	 * @param nombreUsuario: nombre de usuario elegido.
	 * @param uCliente: puede ser UEmpleadoPretenso / UEmpleador.
	 * @throws UsuarioNoEncontradoException: en caso de que el nombre de usuario pasado por parametro no se encuentre en el sistema.
	 */
	public void elegirUsuario_puntaje(String nombreUsuario, UCliente uCliente) throws UsuarioNoEncontradoException {
		Cliente cliente;
		cliente = getCliente(uCliente);
		if(cliente!=null)
            cliente.elegirUsuario_puntaje(nombreUsuario);
        else
            throw new UsuarioNoEncontradoException(nombreUsuario);
	}

	private Cliente getCliente(UCliente usuario) { // retorna cliente correspondiente a usuario
		int i = 0;
		Cliente cliente = null;
		while (i < logeoempleados.size() && !usuario.equals(logeoempleados.get(i).getUsuario()))
			i++;
		if (i < logeoempleados.size() && usuario.equals(logeoempleados.get(i).getUsuario()))
			cliente = logeoempleados.get(i).getEmpleado();
		else {
			i = 0;
			while (i < logeoempleadores.size() && !usuario.equals(logeoempleadores.get(i).getUsuario()))
				i++;
			if (i < logeoempleadores.size() && usuario.equals(logeoempleadores.get(i).getUsuario()))
				cliente = logeoempleadores.get(i).getEmpleador();
		}
		return cliente;
	}
	
	public void limpiarTickets() {
		for (Empleador empleador : this.empleadores) 
			if (empleador.getTicket().getEstado().equals("cancelado") || empleador.getTicket().getEstado().equals("finalizado"))
					empleador.setTicket(null);
		for (EmpleadoPretenso empleado : this.empleadosPretensos) 
			if (empleado.getTicket().getEstado().equals("cancelado") || empleado.getTicket().getEstado().equals("finalizado"))
					empleado.setTicket(null);		
	}

	public int getV1() {
		return this.V1;
	}

	public void setV1(int v1) {
		this.V1 = v1;
	}

	public int getV2() {
		return V2;
	}

	public void setV2(int v2) {
		V2 = v2;
	}

	public int getVencimientoTicket() {
		return vencimientoTicket;
	}

	public void setVencimientoTicket(int vencimientoTicket) {
		this.vencimientoTicket = vencimientoTicket;
	}
	
	//parte 2

	public ArrayList<EmpleadorSimulado> getSimempleadores() {
		return simempleadores;
	}

	public ArrayList<EmpleadoSimulado> getSimempleado() {
		return simempleado;
	}

	
	public BolsaDeTrabajo getBolsatrabajo() {
        return bolsatrabajo;
    }

    public void setBolsatrabajo(BolsaDeTrabajo bolsatrabajo) {
        this.bolsatrabajo = bolsatrabajo;
    }

    public void simulacion() { //el nombre es bastante descriptivo
        int cantempleadores = rand.nextInt(35);
        int cantempleados = rand.nextInt(35);
        int i, j, cantpuestos;
        EmpleadorSimulado auxempleador;
        EmpleadoSimulado auxempleado;
        String empleado = "Empleado";
        String empleador = "Empleador";
        String rubros[]= {"salud","local","internacional"};
        String locaciones[]={"home office","presencial","indistinto"};
        for (i = 0; i <= cantempleadores; i++) {
            auxempleador = new EmpleadorSimulado(empleador + i, this.bolsatrabajo);
            simempleadores.add(auxempleador);
            simempleadoresT.add(new Thread(auxempleador));
            cantpuestos = rand.nextInt(4);
            for (j = 0; j < cantpuestos; j++)
                auxempleador.nuevosPuestosTrabajos(new PuestoTrabajo(auxempleador,locaciones[rand.nextInt(3)],rubros[rand.nextInt(3)]));
        }
        for (i = 0; i <= cantempleados; i++) {
            auxempleado = new EmpleadoSimulado(empleado + i, rubros[rand.nextInt(3)], this.bolsatrabajo, locaciones[rand.nextInt(3)]);
            simempleado.add(auxempleado);
            simempleadoT.add(new Thread(auxempleado));
        }
       
    }
    public void iniciarSimulacion() {
    	 int i;
    	 for(i=0;i<simempleadores.size();i++)
             simempleadoresT.get(i).start();
         for(i=0;i<simempleado.size();i++)
             simempleadoT.get(i).start();

    }
    
    public void checkRegister(String nombreregistro) throws NewRegisterException {
        int i=0;
            while(i<empleadosPretensos.size() && !empleadosPretensos.get(i).getNombreUsuario().equalsIgnoreCase(nombreregistro))
                i++;
            if (i<empleadosPretensos.size()) 
                throw new NewRegisterException("el nombre de usuario ingresado ya existe");
            else {
                i=0;
                while(i<empleadores.size() && !empleadores.get(i).getNombreUsuario().equalsIgnoreCase(nombreregistro))
                    i++;
                if (i<empleadores.size())
                    throw new NewRegisterException("el nombre de usuario ingresado ya existe");
                else {
                    i=0;
                    while(i<administradores.size() && !administradores.get(i).getNombreUsuario().equalsIgnoreCase(nombreregistro))
                        i++;
                    if (i<administradores.size())
                        throw new NewRegisterException("el nombre de usuario ingresado ya existe");
                    	
                }
            }
            
    }
}
