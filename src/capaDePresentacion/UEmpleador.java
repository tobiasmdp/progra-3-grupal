package capaDePresentacion;

import capaDeNegocios.Agencia;
import capaDeNegocios.Usuario_puntaje;

public class UEmpleador extends Usuario{

	public UEmpleador(String usuario, String contrasenia) {
		Agencia.getInstance().registroEmpleador(usuario, contrasenia,this);
	}
	
	public UEmpleador(String usuario, String contrasenia, String nombre, 
			String tPersona, String rubro) {
		Agencia.getInstance().registroEmpleador(usuario, contrasenia, nombre, tPersona, rubro,this);
	}

	public void crearTicket(String locacion, int remuneracion, String cargaHoraria, String tipoPuesto, 
			int rangoEtario, String experienciaPrevia, String estudiosCursados, int cantEmpleados) {
		Agencia.getInstance().crearTicketEmpleador(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario, experienciaPrevia, estudiosCursados, cantEmpleados, this);
	}
	
	public void cambiarEstadoTicket(String estado) {
		Agencia.getInstance().cambiarEstadoTicket(estado, this);
	}
	
	public void elegirUsuario_puntaje(String nombreUsuario) {
		Agencia.getInstance().elegir(nombreUsuario, this);		
	}
	
	

}
