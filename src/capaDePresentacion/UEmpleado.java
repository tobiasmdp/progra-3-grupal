package capaDePresentacion;

import capaDeNegocios.Agencia;
import capaDeNegocios.Usuario_puntaje;

public class UEmpleado extends Usuario{

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
	
	public void cambiarEstadoTicket(String estado) {
		Agencia.getInstance().cambiarEstadoTicket(estado, this);
	}
	
	public void elegirUsuario_puntaje(Usuario_puntaje usuario) {
		Agencia.getInstance().elegirUsuario_puntaje(usuario, this);
	}
	
	public void elegirUsuario_puntaje(String nombreUsuario) {
        Agencia.getInstance().elegir(nombreUsuario, this);
    }
}
