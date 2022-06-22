package Persistencia;

import capaDeDatos.Empleador;

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
}
