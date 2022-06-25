package Persistencia;

import java.util.ArrayList;
import java.util.Calendar;

import capaDeDatos.Empleador;
import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.ListaDeAsignacion;
import capaDeDatos.Ticket;
import capaDeDatos.TicketEmpleador;
import capaDeDatos.TiposDeUsuarios;
import capaDeDatos.Formulario;
import capaDeNegocios.Usuario_puntaje;

public class UtilAgencia {
	
	
	public static EmpleadorDTO EmpleadorDTOFromEmpleador(Empleador empleador) {
		EmpleadorDTO empleadorDTO = new EmpleadorDTO();
		//TiposDeUsuariosDTO
		empleadorDTO.setNombreUsuario(empleador.getNombreUsuario());
		empleadorDTO.setPassword(empleador.getPassword());
		//ClienteDTO
		empleadorDTO.setPuntaje(empleador.getPuntaje());
		//EmpledorDTO
		empleadorDTO.setNombre(empleador.getNombre());
		empleadorDTO.settPersona(empleador.gettPersona().toString());
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
		tPersona = empleadorDTO.gettPersona();
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
//		ticketEmpleadorDTO.setListaAsignacion(ListaDeAsignacionDTOFromListaDeAsignacion(ticketEmpleador.getListaAsignacion()));
//
//		ArrayList<Usuario_puntajeDTO> usuariosElegidos = new ArrayList<Usuario_puntajeDTO>();
//		for (Usuario_puntaje usuario_puntaje : ticketEmpleador.getUsuariosElegidos())
//			usuariosElegidos.add(Usuario_puntajeDTOFromUsuario_puntaje(usuario_puntaje));
//		ticketEmpleadorDTO.setUsuariosElegidos(usuariosElegidos);

		ticketEmpleadorDTO.setRondasTranscurridas(ticketEmpleador.getRondasTranscurridas());
		//ticketEmpleadorDTO
		ticketEmpleadorDTO.setCantempleadosbuscados(ticketEmpleador.getCantempleadosbuscados());
		ticketEmpleadorDTO.setCantempleadosobtenidos(ticketEmpleador.getCantempleadosobtenidos());
		ticketEmpleadorDTO.setpRemuneracion(ticketEmpleador.getpRemuneracion());
		ticketEmpleadorDTO.setpLocacion(ticketEmpleador.getpLocacion());
		ticketEmpleadorDTO.setpCargaHoraria(ticketEmpleador.getpCargaHoraria());
		ticketEmpleadorDTO.setpTipodePuesto(ticketEmpleador.getpTipodePuesto());
		ticketEmpleadorDTO.setpExperienciaPrevia(ticketEmpleador.getpExperienciaPrevia());
		ticketEmpleadorDTO.setpRangoEtario(ticketEmpleador.getpRangoEtario());
		ticketEmpleadorDTO.setpEstudiosCursados(ticketEmpleador.getpEstudiosCursados());
		
		return ticketEmpleadorDTO;
	}

	public static TicketEmpleador TicketEmpleadorFromTicketEmpleadorDTO (TicketEmpleadorDTO ticketEmpleadorDTO) {
		//ticketEmpleador
		int cantempleadosbuscados, pLocacion, pRemuneracion, pCargaHoraria, pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados;
		cantempleadosbuscados = ticketEmpleadorDTO.getCantempleadosbuscados();
		pLocacion = ticketEmpleadorDTO.getpLocacion();
		pRemuneracion = ticketEmpleadorDTO.getpRemuneracion();
		pCargaHoraria = ticketEmpleadorDTO.getpCargaHoraria();
		pTipodePuesto = ticketEmpleadorDTO.getpTipodePuesto();
		pExperienciaPrevia = ticketEmpleadorDTO.getpExperienciaPrevia();
		pRangoEtario = ticketEmpleadorDTO.getpExperienciaPrevia();
		pEstudiosCursados = ticketEmpleadorDTO.getpEstudiosCursados();
		
		//ticket
		Formulario formulario = FormularioFromFormularioDTO(ticketEmpleadorDTO.getFormulario());
		
		TicketEmpleador ticketEmpleador = new TicketEmpleador(formulario, cantempleadosbuscados, pLocacion, pRemuneracion, pCargaHoraria, pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados);
		
		//ticketEmpleador
		ticketEmpleador.setCantempleadosobtenidos(ticketEmpleadorDTO.getCantempleadosobtenidos());
		
		//ticket
		ticketEmpleador.setFecha(ticketEmpleadorDTO.getFecha());
		ticketEmpleador.setEstado(ticketEmpleadorDTO.getEstado());
		
//		for (Usuario_puntajeDTO usuario_PuntajeDTO : ticketEmpleadorDTO.getListaAsignacion().getListaAsignacion()) {
//			Usuario_puntaje usuario_Puntaje = Usuario_puntajeFromUsuario_puntajeDTO(usuario_PuntajeDTO); 
//			ticketEmpleador.addUsuarioAsignacion(usuario_Puntaje);
//			ticketEmpleador.elegirUsuario_puntaje(usuario_Puntaje);
//			// se agregan por nombre, no por usuario_Puntaje
//			// se agregan aca porque no es instancia a uno nuevo, sino q tenes q elegir a los de la lista de asignacion 
//			// puede q este todo mal hecho o parciamente, porque las listas de asignacion se hacen referencia a otros usuarios, aca cyo estoy instanciando nuevos
//			// las elecciones creo que tendria q ser un proceso aparte, porque es hacer referencia a otros tmb, creo que tendria q tener un array con los nombres, auxiliar del Util.
//		
//		}
		
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
	
	//======================================================================================
//	public static ListaDeAsignacionDTO ListaDeAsignacionDTOFromListaDeAsignacion(ListaDeAsignacion listaDeAsignacion) {
//		ListaDeAsignacionDTO listaDeAsignacionDTO = new ListaDeAsignacionDTO();
//		listaDeAsignacionDTO.setFecha(listaDeAsignacion.getFecha());
//		ArrayList<Usuario_puntajeDTO> listaAsignacion = new ArrayList<Usuario_puntajeDTO>();
//		for (Usuario_puntaje usuario_puntaje : listaDeAsignacion.getLista())
//			listaAsignacion.add(Usuario_puntajeDTOFromUsuario_puntaje(usuario_puntaje));
//		listaDeAsignacionDTO.setListaAsignacion(listaAsignacion);
//		return listaDeAsignacionDTO;
//	}
//	
//	public static ListaDeAsignacion ListaDeAsignacionFromListaDeAsignacionDTO(ListaDeAsignacionDTO listaDeAsignacionDTO) {
//		ListaDeAsignacion listaDeAsignacion = new ListaDeAsignacion();
//		listaDeAsignacion.setFecha(listaDeAsignacionDTO.getFecha());
//		for (Usuario_puntajeDTO usuario_puntajeDTO : listaDeAsignacionDTO.getListaAsignacion())
//			listaDeAsignacion.addlista(Usuario_puntajeFromUsuario_puntajeDTO(usuario_puntajeDTO));
//		return listaDeAsignacion;
//	}
	//======================================================================================
	
//	public static Usuario_puntajeDTO Usuario_puntajeDTOFromUsuario_puntaje(Usuario_puntaje usuario_puntaje) {
//		Usuario_puntajeDTO usuario_puntajeDTO = new Usuario_puntajeDTO();
//		usuario_puntajeDTO.setPuntaje(usuario_puntaje.getPuntaje());
//		usuario_puntajeDTO.setUsuario(TiposDeUsuariosDTOFromTiposDeUsuarios(usuario_puntaje.getUsuario()));
//		return usuario_puntajeDTO;
//	}
//	
//	public static Usuario_puntaje Usuario_puntajeFromUsuario_puntajeDTO(Usuario_puntajeDTO usuario_puntajeDTO) {
//		TiposDeUsuarios tiposDeUsuarios= TiposDeUsuariosFromTiposDeUsuariosDTO(usuario_puntajeDTO.getUsuario());
//		double puntaje = usuario_puntajeDTO.getPuntaje();
//		Usuario_puntaje usuario_puntaje = new Usuario_puntaje(tiposDeUsuarios, puntaje);
//		return usuario_puntaje;
//	}
//	
//	public static TiposDeUsuariosDTO TiposDeUsuariosDTOFromTiposDeUsuarios(TiposDeUsuarios tiposDeUsuarios) {
//		TiposDeUsuariosDTO tiposDeUsuariosDTO = new TiposDeUsuariosDTO();
//		tiposDeUsuariosDTO.setNombreUsuario(tiposDeUsuarios.getNombreUsuario());
//		tiposDeUsuariosDTO.setPassword(tiposDeUsuarios.getPassword());
//		return tiposDeUsuariosDTO;
//	}
//	
//	public static TiposDeUsuarios TiposDeUsuariosFromTiposDeUsuariosDTO(TiposDeUsuariosDTO tiposDeUsuariosDTO) {
//		String nombreUsuario, password;
//		nombreUsuario = tiposDeUsuariosDTO.getNombreUsuario();
//		password = tiposDeUsuariosDTO.getPassword();
//		TiposDeUsuarios tiposDeUsuarios = new TiposDeUsuarios(nombreUsuario, password);  
//		return tiposDeUsuarios;
//	}
}
