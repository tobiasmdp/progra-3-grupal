package capaDePresentacion;

import capaDeNegocios.Agencia;

public class UEmpleado extends UCliente{

	public UEmpleado() {
	}
	
	public void registrarse(String nombreUsuario, String contrasenia, String nombre, 
			String apellido, String telefono, int edad) {
		Agencia.getInstance().registroEmpleado(nombreUsuario, contrasenia, nombre, apellido, telefono, edad,this);
	}
	
	public void crearTicket(String locacion, int remuneracion, String cargaHoraria, String tipoPuesto, 
			int rangoEtario, String experienciaPrevia, String estudiosCursados) {
		Agencia.getInstance().crearTicketEmpleado(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario, experienciaPrevia, estudiosCursados, this);
	}
	
}
