package capaDePresentacion;

import capaDeNegocios.Agencia;
import capaDeNegocios.Usuario_puntaje;

public class UEmpleador extends Usuario{

	public UEmpleador(String usuario, String contrasenia) {
		Agencia.getInstance().registroEmpleador(usuario, contrasenia);
	}
	
	public UEmpleador(String usuario, String contrasenia, String nombre, 
			String tPersona, String rubro) {
		Agencia.getInstance().registroEmpleado(usuario, contrasenia, nombre, tPersona, rubro);
	}

	public void crearTicket(String locacion, int remuneracion, String cargaHoraria, String tipoPuesto, 
			int rangoEtario, String experienciaPrevia, String estudiosCursados, int cantEmpleados) {
		Agencia.getInstance().crearTicketEmpleador(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario, experienciaPrevia, estudiosCursados, cantEmpleados, this);
	}
	
	public void cambiarEstadoTicket(String estado) {
		Agencia.getInstance().cambiarEstadoTicket(estado, this);
	}
	
	public void elegirUsuario_puntaje(Usuario_puntaje usuario) {
		Agencia.getInstance().elegirUsuario_puntaje(usuario, this);		
	}
	
	

}
