package capaDeNegocios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import Persistencia.AgenciaDTO;
import Persistencia.EmpleadorDTO;
import Persistencia.IPersistencia;
import Persistencia.PersistenciaXML;
import Persistencia.UtilAgencia;
import capaDeDatos.Administrador;
import capaDeDatos.Cliente;
import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;
import capaDeDatos.ListaDeAsignacion;
import capaDeDatos.TicketEmpleado;
import capaDeDatos.TicketEmpleador;
import capaDeDatos.TicketSimplificado;
import capaDePresentacion.UAdministrador;
import capaDePresentacion.UCliente;
import capaDePresentacion.UEmpleado;
import capaDePresentacion.UEmpleador;
import capaDePresentacion.Usuario;
import excepciones.ContraException;
import excepciones.LoginException;
import excepciones.NombreUsuarioException;
import excepciones.UsuarioNoEncontradoException;

public class Agencia {

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
	private ArrayList<TicketSimplificado> bolsaDeTrabajo = new ArrayList<TicketSimplificado>();
	
	public ArrayList<TicketSimplificado> getBolsaDeTrabajo(){
		return this.bolsaDeTrabajo;
	}
	
	public void agregarTicketBolsa(TicketSimplificado ticket) {
		this.bolsaDeTrabajo.add(ticket);
	}
	
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
	
	public void addContratacion(Contratacion contratacion) {
		this.contrataciones.add(contratacion);
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
	public void login(String nombreUsuario, String contra, Usuario usuario) throws LoginException {
		int i = 0;

		while (i < empleadosPretensos.size() && !(empleadosPretensos.get(i).getNombreUsuario().equals(nombreUsuario)))
			i++;
		if (i < empleadosPretensos.size() && empleadosPretensos.get(i).getNombreUsuario().equals(nombreUsuario)) // agrego a logeado
			if (empleadosPretensos.get(i).getPassword().equals(contra)) {
				addLogeoEmpleadoPretenso(new NodoLogeoEmpleado(usuario, empleadosPretensos.get(i)));
				System.out.println("sesion iniciada correctamente");
			} else
				throw new ContraException("la contrase�a ingresada no es la correcta", contra);
		else {
			i = 0;
			while (i < empleadores.size() && !(empleadores.get(i).getNombreUsuario().equals(nombreUsuario)))
				i++;
			if (i < empleadores.size() && empleadores.get(i).getNombreUsuario().equals(nombreUsuario)) // agrego a logeado
				if (empleadores.get(i).getPassword().equals(contra)) {
					addLogeoEmpleadores(new NodoLogeoEmpleador(usuario, empleadores.get(i)));
					System.out.println("sesion iniciada correctamente");
				} else
					throw new ContraException("la contrase�a ingresada no es la correcta", contra);
			else {
				i = 0;
				while (i < administradores.size() && !(administradores.get(i).getNombreUsuario().equals(nombreUsuario)))
					i++;
				if (i < administradores.size() && administradores.get(i).getNombreUsuario().equals(nombreUsuario)) // agrego a logeado
					if (administradores.get(i).getPassword().equals(contra)) {
						addLogeoAdministrador(new NodoLogeoAdministrador(usuario, administradores.get(i)));
						System.out.println("sesion iniciada correctamente");
					} else
						throw new ContraException("la contrase�a ingresada no es la correcta", contra);
				else
					throw new NombreUsuarioException("el nombre de usuario ingresado no coincide", nombreUsuario); // si llego hasta aca 
																							//es que no lo encontro en ningun lado
			}
		}
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
	public void registroEmpleador(String usuario, String contrasenia, UEmpleador uEmpleador) {
		Empleador aux = new Empleador(usuario, contrasenia);
		addEmpleador(aux);
		try {
			login(usuario, contrasenia, uEmpleador);
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
	}

	public void registroEmpleador(String usuario, String contrasenia, String nombre, String tPersona, String rubro,
			UEmpleador uEmpleador) {
		Empleador aux = new Empleador(usuario, contrasenia, nombre, tPersona, rubro);
		addEmpleador(aux);
		try {
			login(usuario, contrasenia, uEmpleador);
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
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

	public void cambiarEstadoTicket(String estado, Empleador empleador) {
		zonaEmpleador.cambiarEstadoTicket(estado, empleador);
	}

	// Solicitud UEmpleado
	
	/**
	 * Crea el objeto empleado y lo agrega al sistema.
	 * Una vez registrado el empleado, se logea automaticamente.
	 */
	public void registroEmpleado(String usuario, String contrasenia, UEmpleado uEmpleado) {
		EmpleadoPretenso aux = new EmpleadoPretenso(usuario, contrasenia);
		addEmpleadoPretenso(aux);
		try {
			login(usuario, contrasenia, uEmpleado);
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
	}

	public void registroEmpleado(String usuario, String contrasenia, String nombre, String apellido, String telefono,
			int edad, UEmpleado uEmpleado) {
		EmpleadoPretenso aux = new EmpleadoPretenso(usuario, contrasenia, nombre, apellido, telefono, edad);
		addEmpleadoPretenso(aux);
		try {
			login(usuario, contrasenia, uEmpleado);
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
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
	public void registroAdministrador(String usuario, String contrasenia, UAdministrador uAdministrador) {
		Administrador aux = new Administrador(usuario, contrasenia);
		addAdministrador(aux);
		try {
			login(usuario, contrasenia, uAdministrador);
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
	}

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
			if (ticketEmpleador.getEstado().equalsIgnoreCase("activo")) {
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
					if (ticketEmpleado.getEstado().equalsIgnoreCase("activo")) {
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


	
	//------------------  Persistencia  ------------------//
	
	public void guardarAgencia(String nombreArchivo) {
		IPersistencia persistencia = new PersistenciaXML();
		try {
			persistencia.abrirOutput(nombreArchivo);
			System.out.println(nombreArchivo + " creado.");
			AgenciaDTO agenciaDTO = UtilAgencia.AgenciaDTOFromAgencia();
			persistencia.escribir(agenciaDTO);
			System.out.println("Exito al grabar.");
			persistencia.cerrarOutput();
			System.out.println("Exito al cerrar.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarAgencia(String nombreArchivo) {
		IPersistencia persistencia = new PersistenciaXML();
		try {
			persistencia.abrirInput(nombreArchivo);
			System.out.println(nombreArchivo + " abierto.");
			AgenciaDTO agenciaDTO = (AgenciaDTO) persistencia.leer();
			UtilAgencia.AgenciaFromAgenciaDTO(agenciaDTO);
			System.out.println("Exito al leer.");
			persistencia.cerrarInput();
			System.out.println("Exito al cerrar.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}