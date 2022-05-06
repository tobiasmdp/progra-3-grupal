package capaDeNegocios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import capaDeDatos.Administrador;
import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;
import capaDeDatos.TicketEmpleado;
import capaDeDatos.TicketEmpleador;
import capaDeDatos.TiposDeUsuarios;
import capaDePresentacion.UAdministrador;
import capaDePresentacion.UEmpleado;
import capaDePresentacion.UEmpleador;
import capaDePresentacion.Usuario;
import excepciones.ContraException;
import excepciones.LoginException;
import excepciones.NombreUsuarioException;

public class Agencia {

	private static Agencia instance = null; // arranca valiendo null, aplico SINGLETON,
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso>();
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	private ArrayList<Administrador> administradores = new ArrayList<Administrador>();
	private int V1 = 50000, V2 = 150000;
	private ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>();
	private MetodosEmpleado zonaEmpleados;
	private MetodosEmpleador zonaEmpleador;
	private ArrayList<NodoLogeoEmpleado> logeoempleados = new ArrayList<NodoLogeoEmpleado>();
	private ArrayList<NodoLogeoEmpleador> logeoempleadores = new ArrayList<NodoLogeoEmpleador>();
	private ArrayList<NodoLogeoAdministrador> logeoadministradores = new ArrayList<NodoLogeoAdministrador>();

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

	/*
	 * public EmpleadoPretenso registro(String nombreUsuario,String contra)
	 * {//Dudas: no sera void? Agencia.getInstance().addEmpleadoPretenso(this);
	 * return new EmpleadoPretenso(nombreUsuario,contra); }
	 */

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
	 * @param nombreUsuario
	 * @param contra
	 * @param usuario
	 * @throws LoginException
	 */
	public void login(String nombreUsuario, String contra, Usuario usuario) throws LoginException {
		int i = 0;

		while (i < empleadosPretensos.size() && !(empleadosPretensos.get(i).getNombreUsuario().equals(nombreUsuario)))
			i++;
		if (empleadosPretensos.get(i).getNombreUsuario().equals(nombreUsuario)) // agrego a logeado
			if (empleadosPretensos.get(i).getPassword().equals(contra)) {
				addLogeoEmpleadoPretenso(new NodoLogeoEmpleado(usuario, empleadosPretensos.get(i)));
				System.out.println("sesion iniciada correctamente");
			} else
				throw new ContraException("la contraseņa ingresada no es la correcta", contra);
		else {
			i = 0;
			while (i < empleadores.size() && !(empleadores.get(i).getNombreUsuario().equals(nombreUsuario)))
				i++;
			if (empleadores.get(i).getNombreUsuario().equals(nombreUsuario)) // agrego a logeado
				if (empleadores.get(i).getPassword().equals(contra)) {
					addLogeoEmpleadores(new NodoLogeoEmpleador(usuario, empleadores.get(i)));
					System.out.println("sesion iniciada correctamente");
				} else
					throw new ContraException("la contraseņa ingresada no es la correcta", contra);
			else {
				i = 0;
				while (i < administradores.size() && (administradores.get(i).getNombreUsuario().equals(nombreUsuario)))
					i++;
				if (administradores.get(i).getNombreUsuario().equals(nombreUsuario)) // agrego a logeado
					if (empleadores.get(i).getPassword().equals(contra)) {
						addLogeoAdministrador(new NodoLogeoAdministrador(usuario, administradores.get(i)));
						System.out.println("sesion iniciada correctamente");
					} else
						throw new ContraException("la contraseņa ingresada no es la correcta", contra);
				else
					throw new NombreUsuarioException("el nombre de usuario ingresado no coincide", nombreUsuario); // si
																													// llego
																													// hasta
																													// aca
																													// es
																													// que
																													// no
																													// lo
																													// encontro
																													// en
																													// ningun
																													// lado
			}
		}
	}

	/**
	 * @param usuario recibe un usuario de la presentacion para poder saber si esta
	 *                logeado o no
	 * @return retorna 1 si es emplado, 2 si es empleador, 3 si es admin y 0 si no
	 *         esta logeado
	 */
	private int logged(Usuario usuario) {
		int i = 0;
		while (i < logeoempleados.size() && !usuario.equals(logeoempleados.get(i).getUsuario()))
			i++;
		if (usuario.equals(logeoempleados.get(i).getUsuario()))
			return 1;
		i = 0;
		while (i < logeoempleadores.size() && !usuario.equals(logeoempleadores.get(i).getUsuario()))
			i++;
		if (usuario.equals(logeoempleadores.get(i).getUsuario()))
			return 2;
		i = 0;
		while (i < logeoadministradores.size() && !usuario.equals(logeoadministradores.get(i).getUsuario()))
			i++;
		if (usuario.equals(logeoadministradores.get(i).getUsuario()))
			return 3;
		else
			return 0;

	}

	/**
	 * @param usuario recibe un usuario para poder hacerle el logout del sistema
	 */
	public void logout(Usuario usuario) {
		int i = 0;
		while (i < logeoempleados.size() && !usuario.equals(logeoempleados.get(i).getUsuario()))
			i++;
		if (usuario.equals(logeoempleados.get(i).getUsuario()))
			removeLogeoEmpleados(logeoempleados.get(i));
		else {
			i = 0;
			while (i < logeoempleadores.size() && !usuario.equals(logeoempleadores.get(i).getUsuario()))
				i++;
			if (usuario.equals(logeoempleadores.get(i).getUsuario()))
				removeLogeoEmpleador(logeoempleadores.get(i));
			else {
				i = 0;
				while (i < logeoadministradores.size() && !usuario.equals(logeoadministradores.get(i).getUsuario()))
					i++;
				if (usuario.equals(logeoadministradores.get(i).getUsuario()))
					removeLogeoAdministrador(logeoadministradores.get(i));
			}
		}
	}

	////////////////////////////////////////////// SOLICITUDES////////////////////////////////////////////////////

	// Solicitudes Usuario

	public void borrarCuenta(Usuario usuario) { // este esta raro
		int nroarreglo = logged(usuario);
		if (nroarreglo == 1) {

		} else if (nroarreglo == 2) {

		} else {

		}

	}

	// Solicitudes UEmpleador

	/**
	 * Una vez registrado el empleador, se logea automaticamente
	 * @param usuario
	 * @param contrasenia
	 * @throws LoginException 
	 */
	public void registroEmpleador(String usuario, String contrasenia, UEmpleador uempleador) throws LoginException { 
		Empleador nuevo= new Empleador(usuario,contrasenia);
		login(usuario,contrasenia,uempleador);
	}

	public void registroEmpleador(String usuario, String contrasenia, String nombre, String tPersona, String rubro, UEmpleador uempleador) throws LoginException {
		Empleador nuevo= new Empleador(usuario,contrasenia,nombre,tPersona,rubro);	
		login(usuario,contrasenia,uempleador);
	}

	public void crearTicketEmpleador(String locacion, int remuneracion, String cargaHoraria, String tipoPuesto,
			int rangoEtario, String experienciaPrevia, String estudiosCursados, int cantEmpleados,
			UEmpleador uEmpleador) {
		Formulario nuevofor=new Formulario(locacion,remuneracion,cargaHoraria,tipoPuesto,rangoEtario,experienciaPrevia,estudiosCursados);
		TicketEmpleador nuevoticket=new TicketEmpleador(GregorianCalendar.getInstance(),nuevofor,cantEmpleados);
		int i=0;
		int arreglologeado=logged(uEmpleador);
		if (arreglologeado==1) {
			while (i < logeoempleadores.size() && !uEmpleador.equals(logeoempleadores.get(i).getUsuario()))
				i++;
			logeoempleadores.get(i).getEmpleador().setTicket(nuevoticket);
		}
	}

	public void cambiarEstadoTicket(String estado, UEmpleador uEmpleador) {
		int i=0;
		int arreglologeado=logged(uEmpleador);
		if (arreglologeado==1) {
			while (i < logeoempleadores.size() && !uEmpleador.equals(logeoempleadores.get(i).getUsuario()))
				i++;
			logeoempleadores.get(i).getEmpleador().getTicket().setEstado(estado);
		}
	}

	public void elegirUsuario_puntaje(Usuario_puntaje usuario, UEmpleador uEmpleador) {
		// TODO Auto-generated method stub

	}

	// Solicitud UEmpleado

	public void registroEmpleado(String usuario, String contrasenia, UEmpleado uempleado) throws LoginException {
		EmpleadoPretenso nuevo= new EmpleadoPretenso(usuario,contrasenia);
		login(usuario,contrasenia,uempleado);
	}

	public void registroEmpleado(String usuario, String contrasenia, String nombre, String apellido, String telefono,
			String edad, UEmpleado uempleado) throws LoginException {
		EmpleadoPretenso nuevo= new EmpleadoPretenso(usuario,contrasenia,nombre,apellido,telefono,edad);
		login(usuario,contrasenia,uempleado);

	}

	public void crearTicketEmpleado(String locacion, int remuneracion, String cargaHoraria, String tipoPuesto,
			int rangoEtario, String experienciaPrevia, String estudiosCursados, UEmpleado uEmpleado) {
		Formulario nuevofor=new Formulario(locacion,remuneracion,cargaHoraria,tipoPuesto,rangoEtario,experienciaPrevia,estudiosCursados);
		TicketEmpleado nuevoticket=new TicketEmpleado(GregorianCalendar.getInstance(),nuevofor);
		int i=0;
		int arreglologeado=logged(uEmpleado);
		if (arreglologeado==2) {
			while (i < logeoempleados.size() && !uEmpleado.equals(logeoempleados.get(i).getUsuario()))
				i++;
			logeoempleados.get(i).getEmpleado().setTicket(nuevoticket);;
		}

	}

	public void cambiarEstadoTicket(String estado, UEmpleado uEmpleado) {
		int i=0;
		int arreglologeado=logged(uEmpleado);
		if (arreglologeado==1) {
			while (i < logeoempleados.size() && !uEmpleado.equals(logeoempleados.get(i).getUsuario()))
				i++;
			logeoempleados.get(i).getEmpleado().getTicket().setEstado(estado);
		}

	}

	public void elegirUsuario_puntaje(Usuario_puntaje usuario, UEmpleado uEmpleado) {
		// TODO Auto-generated method stub

	}

	// UAdministrador

	public void registroAdministrador(String usuario, String contrasenia, UAdministrador uAdministrador) throws LoginException {
		Administrador nuevo= new Administrador(usuario,contrasenia);
		login(usuario,contrasenia,uAdministrador);

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void rondaEncuentrosLaborales() {
		Empleador auxEmpleador;
		EmpleadoPretenso auxEmpleado;
		double puntaje;
		Usuario_puntaje aux;
		for (int i = 0; i < empleadores.size(); i++) {
			auxEmpleador = empleadores.get(i);

			for (int j = 0; j < empleadosPretensos.size(); j++) {
				auxEmpleado = empleadosPretensos.get(j);
				puntaje = zonaEmpleador.calculoPuntajes(auxEmpleador.getTicket(),
						auxEmpleado.getTicket().getFormulario());
				aux = new Usuario_puntaje(auxEmpleado, puntaje);
				auxEmpleador.getTicket().nuevoEmpleadoMatcheado(aux);
			}

			Collections.sort(auxEmpleador.getTicket().getEmpleadosmatcheados(), new UsuarioComparator());// Le paso la
																											// lista
																											// como 1er
																											// parametor

		}
		for (int i = 0; i < empleadosPretensos.size(); i++) {
			auxEmpleado = empleadosPretensos.get(i);

			for (int j = 0; j < empleadores.size(); j++) {
				auxEmpleador = empleadores.get(j);
				puntaje = zonaEmpleados.calculoPuntajes(auxEmpleado.getTicket().getFormulario(),
						auxEmpleador.getTicket().getFormulario());
				aux = new Usuario_puntaje(auxEmpleador, puntaje);
				auxEmpleado.getTicket().nuevoEmpleadorMatcheado(aux);
			}
			// Collections.sort(auxEmpleador.getTicket().getEmpleadosmatcheados(), new
			// UsuarioComparator());
		}
		// genero las listas de asignaciones
	}

	/**
	 * llegado el momento de contratacion, al tratar las listas ordenadas, si el
	 * empleado eligiese 2 empresas, siempre seria contratado por la que le dio
	 * mejor puntaje
	 */
	private void rondaContrataciones() {
		double comisionEmpleado, comisionEmpleador;
		TicketEmpleador ticketEmpleador, ticketEmpleadorElegido;
		TicketEmpleado ticketEmpleado;
		ArrayList<Usuario_puntaje> eleccionEmpleador, eleccionEmpleado;
		Empleador empleadorElegido;
		EmpleadoPretenso empleadoElegido;
		for (Empleador empleador : this.empleadores) {
			ticketEmpleador = empleador.getTicket();
			eleccionEmpleador = ticketEmpleador.getUsuariosElegidos(); // tomo el array de empleados elegidos por el
																		// empleado
			Collections.sort(eleccionEmpleador, new UsuarioComparator());

			for (Usuario_puntaje usuarioElegidoPorEmpleador : eleccionEmpleador) { // para cada usuario_puntaje elegido
																					// por ese ticket de empleador
				empleadoElegido = (EmpleadoPretenso) usuarioElegidoPorEmpleador.getUsuario();
				ticketEmpleado = empleadoElegido.getTicket();
				eleccionEmpleado = ticketEmpleado.getUsuariosElegidos();
				Collections.sort(eleccionEmpleado, new UsuarioComparator());

				for (Usuario_puntaje usuarioElegidoPorEmpleado : eleccionEmpleado) { // el empleadorElegido si castear,
																						// siendo usuario
					empleadorElegido = (Empleador) usuarioElegidoPorEmpleado.getUsuario();
					ticketEmpleadorElegido = empleadorElegido.getTicket();
					if (ticketEmpleador.equals(ticketEmpleadorElegido)) {
						zonaEmpleador.actualizarPuntaje(empleador);
						zonaEmpleados.actualizarPuntaje(empleadoElegido);

						comisionEmpleado = 1;// calcular comision empleador
						comisionEmpleador = 1;// calcular comision empleado

						this.contrataciones
								.add(new Contratacion(empleadoElegido, empleador, comisionEmpleado, comisionEmpleador));

						ticketEmpleador.setCantempleadosobtenidos(ticketEmpleador.getCantempleadosbuscados() + 1);
						if (ticketEmpleador.getCantempleadosbuscados() == ticketEmpleador.getCantempleadosobtenidos()) {
							ticketEmpleador.setEstado("finalizado");
						}
						ticketEmpleado.setEstado("finalizado");
//						ticketEmpleado.setResultado(0); hay que poner un exito o fracaso?
						// dar de baja "ticketEmpleador"
						// dar de baja "ticketEmpleado"
					}
				}
			}
		}
	}

	public void actualizarPuntaje() {
	}

	/*
	 * @Override public double calcularComisiones() { return
	 * tPersona.calcularComisiones(rubro); }
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

}
