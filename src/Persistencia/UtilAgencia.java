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
	
	
	public static AgenciaDTO AgenciaDTOFromAgencia() {
		AgenciaDTO agenciaDTO = new AgenciaDTO();
		//Empleadores
		ArrayList<EmpleadorDTO> empleadores = new ArrayList<EmpleadorDTO>();
		for (Empleador empleador : Agencia.getInstance().getEmpleadores())
			empleadores.add(EmpleadorDTOFromEmpleador(empleador));
		agenciaDTO.setEmpleadores(empleadores);
		//Empleados
		ArrayList<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
		for (EmpleadoPretenso empleado : Agencia.getInstance().getEmpleadosPretensos())
			empleados.add(EmpleadoDTOFromEmpleado(empleado));
		agenciaDTO.setEmpleados(empleados);
		//Elecciones
		
		//Contrataciones
		ArrayList<ContratacionDTO> contrataciones = new ArrayList<ContratacionDTO>();
		for (Contratacion contratacion : Agencia.getInstance().getContrataciones())
			contrataciones.add(ContratacionDTOFromContratacion(contratacion));
		agenciaDTO.setContrataciones(contrataciones);
		return agenciaDTO;
	}
	
	public static void AgenciaFromAgenciaDTO(AgenciaDTO agenciaDTO) {
		//Empleadores
		for (EmpleadorDTO empleadorDTO : agenciaDTO.getEmpleadores())
			Agencia.getInstance().addEmpleador(EmpleadorFromEmpleadorDTO(empleadorDTO));
		for (EmpleadoDTO empleadoDTO : agenciaDTO.getEmpleados())
			Agencia.getInstance().addEmpleadoPretenso(EmpleadoFromEmpleadoDTO(empleadoDTO));;
		for (ContratacionDTO contratacionDTO : agenciaDTO.getContrataciones())
			Agencia.getInstance().addContratacion(ContratacionFromContratacionDTO(contratacionDTO));
	}
	
	public static ContratacionDTO ContratacionDTOFromContratacion (Contratacion contratacion) {
		ContratacionDTO contratacionDTO = new ContratacionDTO();
		contratacionDTO.setEmpleado(EmpleadoDTOFromEmpleado(contratacion.getEmpleado()));
		contratacionDTO.setEmpleador(EmpleadorDTOFromEmpleador(contratacion.getEmpleador()));
		
		return contratacionDTO;
	}
	
	public static Contratacion ContratacionFromContratacionDTO (ContratacionDTO contratacionDTO) {
		EmpleadoPretenso empleado = EmpleadoFromEmpleadoDTO(contratacionDTO.getEmpleado());
		Empleador empleador = EmpleadorFromEmpleadorDTO(contratacionDTO.getEmpleador());
		Contratacion contratacion = new Contratacion(empleado, empleador);
		return contratacion; 
	}
	
	public static EmpleadoDTO EmpleadoDTOFromEmpleado(EmpleadoPretenso empleado) {
		EmpleadoDTO empleadoDTO = new EmpleadoDTO();
		empleadoDTO.setNombre(empleado.getNombre());
		empleadoDTO.setApellido(empleado.getApellido());
		empleadoDTO.setTelefono(empleado.getTelefono());
		empleadoDTO.setTicket(TicketEmpleadoDTOFromTicketEmpleado(empleado.getTicket()));		
		empleadoDTO.setEdad(empleado.getEdad());
		empleadoDTO.setComision(empleado.getComision());
		return empleadoDTO;
	}
	
	public static EmpleadoPretenso EmpleadoFromEmpleadoDTO(EmpleadoDTO empleadoDTO) {
		String nombreUsuario, password, nombre, apellido, telefono;
		int edad;
		//TiposDeUsuariosDTO
		nombreUsuario = empleadoDTO.getNombreUsuario();
		password = empleadoDTO.getPassword();
		//EmpleadoDTO
		nombre = empleadoDTO.getNombre();
		apellido = empleadoDTO.getApellido();
		telefono = empleadoDTO.getTelefono();
		edad = empleadoDTO.getEdad();
		
		EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(nombreUsuario, password, nombre, apellido, telefono, edad);
		
		//ClienteDTO
		empleadoPretenso.setPuntaje(empleadoDTO.getPuntaje());
		//EmpleadoDTO
		empleadoPretenso.setTicket(TicketEmpleadoFromTicketEmpleadoDTO(empleadoDTO.getTicket()));
		empleadoPretenso.setComision(empleadoDTO.getComision());
		
		return empleadoPretenso;
	}
	
	public static TicketEmpleadoDTO TicketEmpleadoDTOFromTicketEmpleado(TicketEmpleado ticketEmpleado) {
		TicketEmpleadoDTO ticketEmpleadoDTO = new TicketEmpleadoDTO();
		//ticketDTO
		ticketEmpleadoDTO.setFecha(ticketEmpleado.getFecha());
		ticketEmpleadoDTO.setEstado(ticketEmpleado.getEstado());
		ticketEmpleadoDTO.setFormulario(FormularioDTOFromFormulario(ticketEmpleado.getFormulario()));
		ticketEmpleadoDTO.setRondasTranscurridas(ticketEmpleado.getRondasTranscurridas());
		return ticketEmpleadoDTO;
	}
	
	public static TicketEmpleado TicketEmpleadoFromTicketEmpleadoDTO(TicketEmpleadoDTO ticketEmpleadoDTO) {
		//ticket
		Calendar fecha = ticketEmpleadoDTO.getFecha();
		Formulario formulario = FormularioFromFormularioDTO(ticketEmpleadoDTO.getFormulario());
		
		TicketEmpleado ticketEmpleado = new TicketEmpleado(fecha, formulario);
		
		return ticketEmpleado;
	}
	
	
	public static EmpleadorDTO EmpleadorDTOFromEmpleador(Empleador empleador) {
		EmpleadorDTO empleadorDTO = new EmpleadorDTO();
		//TiposDeUsuariosDTO
		empleadorDTO.setNombreUsuario(empleador.getNombreUsuario());
		empleadorDTO.setPassword(empleador.getPassword());
		//ClienteDTO
		empleadorDTO.setPuntaje(empleador.getPuntaje());
		//EmpledorDTO
		empleadorDTO.setNombre(empleador.getNombre());
		empleadorDTO.setTPersona(empleador.gettPersona().toString());
		empleadorDTO.setRubro(empleador.getRubro().toString());
		empleadorDTO.setComision(empleador.getComision());	
		empleadorDTO.setTicket(TicketEmpleadorDTOFromTicketEmpleador(empleador.getTicket()));
		return empleadorDTO;
	}
	
	public static Empleador EmpleadorFromEmpleadorDTO(EmpleadorDTO empleadorDTO) {
		String nombreUsuario, password, nombre, tPersona, rubro;
		//TiposDeUsuariosDTO
		nombreUsuario = empleadorDTO.getNombreUsuario();
		password = empleadorDTO.getPassword();
		//EmpleadorDTO
		nombre = empleadorDTO.getNombre();
		tPersona = empleadorDTO.getTPersona();
		rubro = empleadorDTO.getRubro();
	
		Empleador empleador = new Empleador(nombreUsuario, password, nombre, tPersona, rubro);
		
		//Cliente
		empleador.setPuntaje(empleadorDTO.getPuntaje());
		//Empleador
		empleador.setTicket(TicketEmpleadorFromTicketEmpleadorDTO(empleadorDTO.getTicket()));
		empleador.setComision(empleadorDTO.getComision());
		
		return empleador;
	}
	

	public static TicketEmpleadorDTO TicketEmpleadorDTOFromTicketEmpleador(TicketEmpleador ticketEmpleador) {
		TicketEmpleadorDTO ticketEmpleadorDTO = new TicketEmpleadorDTO();
		//ticketDTO
		ticketEmpleadorDTO.setFecha(ticketEmpleador.getFecha());
		ticketEmpleadorDTO.setEstado(ticketEmpleador.getEstado());
		ticketEmpleadorDTO.setFormulario(FormularioDTOFromFormulario(ticketEmpleador.getFormulario()));

		ticketEmpleadorDTO.setRondasTranscurridas(ticketEmpleador.getRondasTranscurridas());
		//ticketEmpleadorDTO
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

	public static TicketEmpleador TicketEmpleadorFromTicketEmpleadorDTO (TicketEmpleadorDTO ticketEmpleadorDTO) {
		//ticketEmpleador
		int cantempleadosbuscados, pLocacion, pRemuneracion, pCargaHoraria, pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados;
		cantempleadosbuscados = ticketEmpleadorDTO.getCantempleadosbuscados();
		pLocacion = ticketEmpleadorDTO.getPLocacion();
		pRemuneracion = ticketEmpleadorDTO.getPRemuneracion();
		pCargaHoraria = ticketEmpleadorDTO.getPCargaHoraria();
		pTipodePuesto = ticketEmpleadorDTO.getPTipodePuesto();
		pExperienciaPrevia = ticketEmpleadorDTO.getPExperienciaPrevia();
		pRangoEtario = ticketEmpleadorDTO.getPExperienciaPrevia();
		pEstudiosCursados = ticketEmpleadorDTO.getPEstudiosCursados();
		
		//ticket
		Formulario formulario = FormularioFromFormularioDTO(ticketEmpleadorDTO.getFormulario());
		
		TicketEmpleador ticketEmpleador = new TicketEmpleador(formulario, cantempleadosbuscados, pLocacion, pRemuneracion, pCargaHoraria, pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados);
		
		//ticketEmpleador
		ticketEmpleador.setCantempleadosobtenidos(ticketEmpleadorDTO.getCantempleadosobtenidos());
		
		//ticket
		ticketEmpleador.setFecha(ticketEmpleadorDTO.getFecha());
		ticketEmpleador.setEstado(ticketEmpleadorDTO.getEstado());
		
		ticketEmpleador.setRondasTranscurridas(ticketEmpleador.getRondasTranscurridas());
		
		return ticketEmpleador;
	}
	
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
	
	public static Formulario FormularioFromFormularioDTO(FormularioDTO formularioDTO){
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
	  //realmente la edad no es significativa, solo su rango etario, por ende se da una edad que entre en el rango etario deseado
	    if (rangoEtarioAux == "Menos de 40 años  ")
	    	rangoEtario = 30;  
	    else if (rangoEtarioAux == "Entre 40 y 50 años")
	    	rangoEtario = 45;
	    else
	    	rangoEtario = 60;
	    	
	    Formulario formulario = new Formulario(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario, experienciaprevia, cursados);
	    return formulario;
	}
	
}
