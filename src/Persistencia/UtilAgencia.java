package Persistencia;

import java.util.ArrayList;
import java.util.Calendar;

import capaDeDatos.Empleador;
import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.TicketEmpleado;
import capaDeDatos.TicketEmpleador;
import capaDeDatos.Formulario;
import capaDeNegocios.Agencia;
import capaDeNegocios.Contratacion;

public class UtilAgencia {

	/**
	 * Persiste la agencia, no necesita parametro debido a la Agencia aplica el
	 * patron Singleton
	 * 
	 * @return
	 */
	public static AgenciaDTO AgenciaDTOFromAgencia() {
		AgenciaDTO agenciaDTO = new AgenciaDTO();
		// Empleadores
		ArrayList<EmpleadorDTO> empleadores = new ArrayList<EmpleadorDTO>();
		for (Empleador empleador : Agencia.getInstance().getEmpleadores())
			empleadores.add(EmpleadorDTOFromEmpleador(empleador));
		agenciaDTO.setEmpleadores(empleadores);
		// Empleados
		ArrayList<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
		for (EmpleadoPretenso empleado : Agencia.getInstance().getEmpleadosPretensos())
			empleados.add(EmpleadoDTOFromEmpleado(empleado));
		agenciaDTO.setEmpleados(empleados);
		// Contrataciones
		ArrayList<ContratacionDTO> contrataciones = new ArrayList<ContratacionDTO>();
		for (Contratacion contratacion : Agencia.getInstance().getContrataciones())
			contrataciones.add(ContratacionDTOFromContratacion(contratacion));
		agenciaDTO.setContrataciones(contrataciones);
		return agenciaDTO;
	}

	/**
	 * @param agenciaDTO Carga datos en la agencia, es void debido a que Agencia
	 *                   aplica Singleton, de este se modifican sus parametros, no
	 *                   se genera una nueva Instancia de agencia
	 */
	public static void AgenciaFromAgenciaDTO(AgenciaDTO agenciaDTO) {
		// Empleadores
		for (EmpleadorDTO empleadorDTO : agenciaDTO.getEmpleadores())
			Agencia.getInstance().addEmpleador(EmpleadorFromEmpleadorDTO(empleadorDTO));
		for (EmpleadoDTO empleadoDTO : agenciaDTO.getEmpleados())
			Agencia.getInstance().addEmpleadoPretenso(EmpleadoFromEmpleadoDTO(empleadoDTO));
		for (ContratacionDTO contratacionDTO : agenciaDTO.getContrataciones())
			Agencia.getInstance().addContratacion(ContratacionFromContratacionDTO(contratacionDTO));
	}

	/**
	 * Requerido por agenciaDTO para persistir las contrataciones
	 * 
	 * @param contratacion
	 * @return
	 */
	public static ContratacionDTO ContratacionDTOFromContratacion(Contratacion contratacion) {
		ContratacionDTO contratacionDTO = new ContratacionDTO();
		contratacionDTO.setEmpleado(EmpleadoDTOFromEmpleado(contratacion.getEmpleado()));
		contratacionDTO.setEmpleador(EmpleadorDTOFromEmpleador(contratacion.getEmpleador()));

		return contratacionDTO;
	}

	/**
	 * Reuqerido para obtener los datos del .xml y cargar las contrataciones
	 * previas.
	 * 
	 * @param contratacionDTO
	 * @return
	 */
	public static Contratacion ContratacionFromContratacionDTO(ContratacionDTO contratacionDTO) {
		EmpleadoPretenso empleado = EmpleadoFromEmpleadoDTO(contratacionDTO.getEmpleado());
		Empleador empleador = EmpleadorFromEmpleadorDTO(contratacionDTO.getEmpleador());
		Contratacion contratacion = new Contratacion(empleado, empleador);
		return contratacion;
	}

	/**
	 * Requerido por AgenciaDTO para persistir los datos.
	 * 
	 * @param empleado
	 * @return
	 */
	public static EmpleadoDTO EmpleadoDTOFromEmpleado(EmpleadoPretenso empleado) {
		EmpleadoDTO empleadoDTO = new EmpleadoDTO();
		// TiposDeUsuariosDTO
		empleadoDTO.setNombreUsuario(empleado.getNombreUsuario());
		empleadoDTO.setPassword(empleado.getPassword());
		// ClienteDTO
		empleadoDTO.setPuntaje(empleado.getPuntaje());
		// empladorDTO
		empleadoDTO.setNombre(empleado.getNombre());
		empleadoDTO.setApellido(empleado.getApellido());
		empleadoDTO.setTelefono(empleado.getTelefono());
		empleadoDTO.setTicket(TicketEmpleadoDTOFromTicketEmpleado(empleado.getTicket()));
		empleadoDTO.setEdad(empleado.getEdad());
		empleadoDTO.setComision(empleado.getComision());
		return empleadoDTO;
	}

	/**
	 * Reuqerido para obtener los datos del .xml y cargar los empleados en la
	 * agencia.
	 * 
	 * @param empleadoDTO
	 * @return
	 */
	public static EmpleadoPretenso EmpleadoFromEmpleadoDTO(EmpleadoDTO empleadoDTO) {
		String nombreUsuario, password, nombre, apellido, telefono;
		int edad;
		// TiposDeUsuariosDTO
		nombreUsuario = empleadoDTO.getNombreUsuario();
		password = empleadoDTO.getPassword();
		// EmpleadoDTO
		nombre = empleadoDTO.getNombre();
		apellido = empleadoDTO.getApellido();
		telefono = empleadoDTO.getTelefono();
		edad = empleadoDTO.getEdad();

		EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(nombreUsuario, password, nombre, apellido, telefono,
				edad);

		// ClienteDTO
		empleadoPretenso.setPuntaje(empleadoDTO.getPuntaje());
		// EmpleadoDTO
		empleadoPretenso.setTicket(TicketEmpleadoFromTicketEmpleadoDTO(empleadoDTO.getTicket()));
		empleadoPretenso.setComision(empleadoDTO.getComision());

		return empleadoPretenso;
	}

	/**
	 * Requerido por EmpleadoDTO para persistir el ticket de cada uno de ellos.
	 * 
	 * @param ticketEmpleado
	 * @return
	 */
	public static TicketEmpleadoDTO TicketEmpleadoDTOFromTicketEmpleado(TicketEmpleado ticketEmpleado) {
		TicketEmpleadoDTO ticketEmpleadoDTO = new TicketEmpleadoDTO();
		// ticketDTO
		ticketEmpleadoDTO.setFecha(ticketEmpleado.getFecha());
		ticketEmpleadoDTO.setEstado(ticketEmpleado.getEstado());
		ticketEmpleadoDTO.setFormulario(FormularioDTOFromFormulario(ticketEmpleado.getFormulario()));
		ticketEmpleadoDTO.setRondasTranscurridas(ticketEmpleado.getRondasTranscurridas());
		return ticketEmpleadoDTO;
	}

	/**
	 * Requerido para cargar los datos del .xml, y cargar el ticketEmpleado dentro
	 * de cada Empleado en el archivo.
	 * 
	 * @param ticketEmpleadoDTO
	 * @return
	 */
	public static TicketEmpleado TicketEmpleadoFromTicketEmpleadoDTO(TicketEmpleadoDTO ticketEmpleadoDTO) {
		// ticket
		Calendar fecha = ticketEmpleadoDTO.getFecha();
		Formulario formulario = FormularioFromFormularioDTO(ticketEmpleadoDTO.getFormulario());

		TicketEmpleado ticketEmpleado = new TicketEmpleado(fecha, formulario);

		ticketEmpleado.nuevaLista();

		return ticketEmpleado;
	}

	/**
	 * Requerido por AgenciaDTO para persistir los datos
	 * 
	 * @param empleador
	 * @return
	 */
	public static EmpleadorDTO EmpleadorDTOFromEmpleador(Empleador empleador) {
		EmpleadorDTO empleadorDTO = new EmpleadorDTO();
		// TiposDeUsuariosDTO
		empleadorDTO.setNombreUsuario(empleador.getNombreUsuario());
		empleadorDTO.setPassword(empleador.getPassword());
		// ClienteDTO
		empleadorDTO.setPuntaje(empleador.getPuntaje());
		// EmpledorDTO
		empleadorDTO.setNombre(empleador.getNombre());
		empleadorDTO.setTPersona(empleador.gettPersona().toString());
		empleadorDTO.setRubro(empleador.getRubro().toString());
		empleadorDTO.setComision(empleador.getComision());
		empleadorDTO.setTicket(TicketEmpleadorDTOFromTicketEmpleador(empleador.getTicket()));
		return empleadorDTO;
	}

	/**
	 * Reuqerido para obtener los datos del .xml y cargar los empleadores en la
	 * agencia.
	 * 
	 * @param empleadorDTO
	 * @return
	 */
	public static Empleador EmpleadorFromEmpleadorDTO(EmpleadorDTO empleadorDTO) {
		String nombreUsuario, password, nombre, tPersona, rubro;
		// TiposDeUsuariosDTO
		nombreUsuario = empleadorDTO.getNombreUsuario();
		password = empleadorDTO.getPassword();
		// EmpleadorDTO
		nombre = empleadorDTO.getNombre();
		tPersona = empleadorDTO.getTPersona();
		rubro = empleadorDTO.getRubro();

		Empleador empleador = new Empleador(nombreUsuario, password, nombre, tPersona, rubro);

		// Cliente
		empleador.setPuntaje(empleadorDTO.getPuntaje());
		// Empleador
		empleador.setTicket(TicketEmpleadorFromTicketEmpleadorDTO(empleadorDTO.getTicket()));
		empleador.setComision(empleadorDTO.getComision());

		return empleador;
	}

	/**
	 * Requerido por EmpleadorDTO para persistir el ticket de cada uno de ellos.
	 * 
	 * @param ticketEmpleador
	 * @return
	 */
	public static TicketEmpleadorDTO TicketEmpleadorDTOFromTicketEmpleador(TicketEmpleador ticketEmpleador) {
		TicketEmpleadorDTO ticketEmpleadorDTO = new TicketEmpleadorDTO();
		// ticketDTO
		ticketEmpleadorDTO.setFecha(ticketEmpleador.getFecha());
		ticketEmpleadorDTO.setEstado(ticketEmpleador.getEstado());
		ticketEmpleadorDTO.setFormulario(FormularioDTOFromFormulario(ticketEmpleador.getFormulario()));

		ticketEmpleadorDTO.setRondasTranscurridas(ticketEmpleador.getRondasTranscurridas());
		// ticketEmpleadorDTO
		ticketEmpleadorDTO.setCantempleadosbuscados(ticketEmpleador.getCantempleadosbuscados());
		ticketEmpleadorDTO.setCantempleadosobtenidos(ticketEmpleador.getCantempleadosobtenidos());
		ticketEmpleadorDTO.setPRemuneracion(ticketEmpleador.getpRemuneracion());
		ticketEmpleadorDTO.setPLocacion(ticketEmpleador.getpLocacion());
		ticketEmpleadorDTO.setPCargaHoraria(ticketEmpleador.getpCargaHoraria());
		ticketEmpleadorDTO.setPTipodePuesto(ticketEmpleador.getpTipodePuesto());
		ticketEmpleadorDTO.setPExperienciaPrevia(ticketEmpleador.getpExperienciaPrevia());
		ticketEmpleadorDTO.setPRangoEtario(ticketEmpleador.getpRangoEtario());
		ticketEmpleadorDTO.setPEstudiosCursados(ticketEmpleador.getpEstudiosCursados());

		return ticketEmpleadorDTO;
	}

	/**
	 * Requerido para cargar los datos del .xml, y obtener el ticketEmpleador dentro
	 * de cada Empleador en el archivo.
	 * 
	 * @param ticketEmpleadorDTO
	 * @return
	 */
	public static TicketEmpleador TicketEmpleadorFromTicketEmpleadorDTO(TicketEmpleadorDTO ticketEmpleadorDTO) {
		// ticketEmpleador
		int cantempleadosbuscados, pLocacion, pRemuneracion, pCargaHoraria, pTipodePuesto, pExperienciaPrevia,
				pRangoEtario, pEstudiosCursados;
		cantempleadosbuscados = ticketEmpleadorDTO.getCantempleadosbuscados();
		pLocacion = ticketEmpleadorDTO.getPLocacion();
		pRemuneracion = ticketEmpleadorDTO.getPRemuneracion();
		pCargaHoraria = ticketEmpleadorDTO.getPCargaHoraria();
		pTipodePuesto = ticketEmpleadorDTO.getPTipodePuesto();
		pExperienciaPrevia = ticketEmpleadorDTO.getPExperienciaPrevia();
		pRangoEtario = ticketEmpleadorDTO.getPExperienciaPrevia();
		pEstudiosCursados = ticketEmpleadorDTO.getPEstudiosCursados();

		// ticket
		Formulario formulario = FormularioFromFormularioDTO(ticketEmpleadorDTO.getFormulario());

		TicketEmpleador ticketEmpleador = new TicketEmpleador(formulario, cantempleadosbuscados, pLocacion,
				pRemuneracion, pCargaHoraria, pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados);

		// ticketEmpleador
		ticketEmpleador.setCantempleadosobtenidos(ticketEmpleadorDTO.getCantempleadosobtenidos());

		// ticket
		ticketEmpleador.setFecha(ticketEmpleadorDTO.getFecha());
		ticketEmpleador.setEstado(ticketEmpleadorDTO.getEstado());
		ticketEmpleador.nuevaLista();

		ticketEmpleador.setRondasTranscurridas(ticketEmpleador.getRondasTranscurridas());

		return ticketEmpleador;
	}

	/**
	 * Necesario tanto por el TickerEMpleadorDTO como por TicketEmpleadoDTO para
	 * persistir el fomrulario contenido dentro de cada ticket.
	 * 
	 * @param formulario
	 * @return
	 */
	public static FormularioDTO FormularioDTOFromFormulario(Formulario formulario) {
		FormularioDTO formularioDTO = new FormularioDTO();
		formularioDTO.setCargaHoraria(formulario.getCargaHoraria().toString());
		formularioDTO.setCursados(formulario.getEstudiosCursados().toString());
		formularioDTO.setExperienciaprevia(formulario.getExperienciaPrevia().toString());
		formularioDTO.setLocacion(formulario.getLocacion().toString());
		formularioDTO.setRangoEtario(formulario.getRangoEtario().toString());
		formularioDTO.setRemuneracion(formulario.getRemuneraciondoub());
		formularioDTO.setTipoPuesto(formulario.getTipoPuesto().toString());
		return formularioDTO;
	}

	/**
	 * Requerido para cargar los datos del .xml, y obtener el el fomrulario para
	 * cada ticket.
	 * 
	 * @param formularioDTO
	 * @return
	 */
	public static Formulario FormularioFromFormularioDTO(FormularioDTO formularioDTO) {
		String locacion, cargaHoraria, tipoPuesto, experienciaprevia, rangoEtarioAux, cursados;
		double remuneracion;
		int rangoEtario;

		locacion = formularioDTO.getLocacion();
		cargaHoraria = formularioDTO.getCargaHoraria();
		tipoPuesto = formularioDTO.getTipoPuesto();
		experienciaprevia = formularioDTO.getExperienciaprevia();
		cursados = formularioDTO.getCursados();
		remuneracion = formularioDTO.getRemuneracion();

		rangoEtarioAux = formularioDTO.getRangoEtario();
		// realmente la edad no es significativa, solo su rango etario, por ende se da
		// una edad que entre en el rango etario deseado
		if (rangoEtarioAux == "Menos de 40 años")
			rangoEtario = 30;
		else if (rangoEtarioAux == "Entre 40 y 50 años")
			rangoEtario = 45;
		else
			rangoEtario = 60;

		Formulario formulario = new Formulario(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario,
				experienciaprevia, cursados);
		return formulario;
	}

}
