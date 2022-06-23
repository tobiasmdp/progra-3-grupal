package Persistencia;

import java.util.ArrayList;
import java.util.Calendar;

import capaDeDatos.Empleador;
import capaDeDatos.ListaDeAsignacion;
import capaDeDatos.Ticket;
import capaDeDatos.TiposDeUsuarios;
import capaDeDatos.Formulario;
import capaDeNegocios.Usuario_puntaje;

public class UtilEmpleador {
	
	public static EmpleadorDTO EmpleadorDTOFromEmpleador(Empleador empleador) {
		EmpleadorDTO empleadorDTO = new EmpleadorDTO();
		TicketDTO ticketDTO;// = UtilEmpleador.TicketDTOFromTicket(empleador.getTicket())
		//usuarioDTO
		empleadorDTO.setNombreUsuario(empleador.getNombreUsuario());
		empleadorDTO.setPassword(empleador.getPassword());
		//clienteDTO
		empleadorDTO.setPuntaje(empleador.getPuntaje());
		//empledorDTO
		empleadorDTO.setNombre(empleador.getNombre());
		empleadorDTO.settPersona(empleador.gettPersona().toString());
		empleadorDTO.setRubro(empleador.getRubro().toString());
		empleadorDTO.setComision(empleador.getComision());	
		
		
		return empleadorDTO;
	}
	
	public static TicketDTO TicketDTOFromTicket(Ticket ticket) {
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO.setFecha(ticket.getFecha());
		ticketDTO.setEstado(ticket.getEstado());
		ticketDTO.setFormulario(FormularioDTOFromFormulario(ticket.getFormulario()));
		ticketDTO.setListaAsignacion(ListaDeAsignacionDTOFromListaDeAsignacion(ticket.getListaAsignacion()));
		
		ArrayList<Usuario_puntajeDTO> usuariosElegidos = new ArrayList<Usuario_puntajeDTO>();
		for (Usuario_puntaje usuario_puntaje : ticket.getUsuariosElegidos())
			usuariosElegidos.add(Usuario_puntajeDTOFromUsuario_puntaje(usuario_puntaje));
		
		ticketDTO.setRondasTranscurridas(ticket.getRondasTranscurridas());
		
		return ticketDTO;
	}
	
	public static Ticket TicketFromTicketDTO(TicketDTO ticketDTO) {
		Calendar fecha = ticketDTO.getFecha();
		String estado = ticketDTO.getEstado();
		Formulario formulario = FormularioFromFormularioDTO(ticketDTO.getFormulario());
		ListaDeAsignacionDTO lista
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
	
	public static ListaDeAsignacionDTO ListaDeAsignacionDTOFromListaDeAsignacion(ListaDeAsignacion listaDeAsignacion) {
		ListaDeAsignacionDTO listaDeAsignacionDTO = new ListaDeAsignacionDTO();
		listaDeAsignacionDTO.setFecha(listaDeAsignacion.getFecha());
		ArrayList<Usuario_puntajeDTO> listaAsignacion = new ArrayList<Usuario_puntajeDTO>();
		for (Usuario_puntaje usuario_puntaje : listaDeAsignacion.getLista())
			listaAsignacion.add(Usuario_puntajeDTOFromUsuario_puntaje(usuario_puntaje));
		listaDeAsignacionDTO.setListaAsignacion(listaAsignacion);
		return listaDeAsignacionDTO;
	}
	
	public static ListaDeAsignacion ListaDeAsignacionFromListaDeAsignacionDTO (ListaDeAsignacionDTO listaDeAsignacionDTO) {
		ListaDeAsignacion listaDeAsignacion = new ListaDeAsignacion();
		listaDeAsignacion.setFecha(listaDeAsignacionDTO.getFecha());
		for (Usuario_puntajeDTO usuario_puntajeDTO : listaDeAsignacionDTO.getListaAsignacion())
			listaDeAsignacion.addlista(Usuario_puntajeFromUsuario_puntajeDTO(usuario_puntajeDTO));
		return listaDeAsignacion;
	}
	
	public static Usuario_puntajeDTO Usuario_puntajeDTOFromUsuario_puntaje(Usuario_puntaje usuario_puntaje) {
		Usuario_puntajeDTO usuario_puntajeDTO = new Usuario_puntajeDTO();
		usuario_puntajeDTO.setPuntaje(usuario_puntaje.getPuntaje());
		usuario_puntajeDTO.setUsuario(TiposDeUsuariosDTOFromTiposDeUsuarios(usuario_puntaje.getUsuario()));
		return usuario_puntajeDTO;
	}
	
	public static Usuario_puntaje Usuario_puntajeFromUsuario_puntajeDTO(Usuario_puntajeDTO usuario_puntajeDTO) {
		TiposDeUsuarios tiposDeUsuarios= TiposDeUsuariosFromTiposDeUsuariosDTO(usuario_puntajeDTO.getUsuario());
		double puntaje = usuario_puntajeDTO.getPuntaje();
		Usuario_puntaje usuario_puntaje = new Usuario_puntaje(tiposDeUsuarios, puntaje);
		return usuario_puntaje;
	}
	
	public static TiposDeUsuariosDTO TiposDeUsuariosDTOFromTiposDeUsuarios(TiposDeUsuarios tiposDeUsuarios) {
		TiposDeUsuariosDTO tiposDeUsuariosDTO = new TiposDeUsuariosDTO();
		tiposDeUsuariosDTO.setNombreUsuario(tiposDeUsuarios.getNombreUsuario());
		tiposDeUsuariosDTO.setPassword(tiposDeUsuarios.getPassword());
		return tiposDeUsuariosDTO;
	}
	
	public static TiposDeUsuarios TiposDeUsuariosFromTiposDeUsuariosDTO(TiposDeUsuariosDTO tiposDeUsuariosDTO) {
		String nombreUsuario, password;
		nombreUsuario = tiposDeUsuariosDTO.getNombreUsuario();
		password = tiposDeUsuariosDTO.getPassword();
		TiposDeUsuarios tiposDeUsuarios = new TiposDeUsuarios(nombreUsuario, password);  
		return tiposDeUsuarios;
	}
}
