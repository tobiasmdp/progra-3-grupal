package capaDePresentacion;

import capaDeNegocios.Agencia;
import capaDeNegocios.Usuario_puntaje;

public class UEmpleado extends Usuario{

<<<<<<< HEAD
	public UEmpleado(String usuario, String contrasenia) {
		Agencia.getInstance().registroEmpleado(usuario, contrasenia);
	}
	
	public UEmpleado(String usuario, String contrasenia, String nombre, 
			String apellido, String telefono, String edad) {
		Agencia.getInstance().registroEmpleado(usuario, contrasenia, nombre, apellido, telefono, edad);
=======
	public UEmpleado() {
	}
	
	public void registrarse(String nombreUsuario, String contrasenia, String nombre, 
			String apellido, String telefono, int edad) {
		Agencia.getInstance().registroEmpleado(nombreUsuario, contrasenia, nombre, apellido, telefono, edad,this);
>>>>>>> main
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
<<<<<<< HEAD
=======
	
	public void elegirUsuario_puntaje(String nombreUsuario) {
        Agencia.getInstance().elegir(nombreUsuario, this);
    }
>>>>>>> main
}
