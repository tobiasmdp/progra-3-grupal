package Persistencia;

import capaDeDatos.Empleador;

public class UtilEmpleador {
	
	public static EmpleadorDTO EmpleadorDTOFromEmpleador(Empleador empleador) {
		EmpleadorDTO empleadorDTO = new EmpleadorDTO();
		empleadorDTO.setNombre(empleador.getNombre());
		empleadorDTO.setComision(empleador.getComision());
		empleadorDTO.setRubro(empleador.getRubro());
		empleadorDTO.settPersona(empleador.gettPersona());
		return empleadorDTO;
	}
}
