package capaDePresentacion;

import capaDeNegocios.Agencia;
import capaDeNegocios.Usuario_puntaje;

public class UEmpleado extends Usuario{

	public UEmpleado(String usuario, String contrasenia) {
		Agencia.getInstance().registroEmpleado(usuario, contrasenia,this);
	}
	
	public UEmpleado(String usuario, String contrasenia, String nombre, 
			String apellido, String telefono, String edad) {
		Agencia.getInstance().registroEmpleado(usuario, contrasenia, nombre, apellido, telefono, edad);
	}
	
	public void crearTicket(String locacion, int remuneracion, String cargaHoraria, String tipoPuesto, 
			int rangoEtario, String experienciaPrevia, String estudiosCursados) {
		Agencia.getInstance().crearTicketEmpleado(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario, experienciaPrevia, estudiosCursados, this);
	}
	
	public void cambiarEstadoTicket(String estado) {
		Agencia.getInstance().cambiarEstadoTicket(estado, this);
	}
	
	public void elegirUsuario_puntaje(Usuario_puntaje usuario) {
		Agencia.getInstance().elegirUsuario_puntaje(usuario, this);
	}
}
