package capaDePresentacion;

import capaDeNegocios.Agencia;
import capaDeNegocios.Usuario_puntaje;

public class UEmpleador extends Usuario{

<<<<<<< HEAD
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
=======
	public UEmpleador() {
	}
	
	public void registrarse(String usuario, String contrasenia, String nombre, 
			String tPersona, String rubro) {
		Agencia.getInstance().registroEmpleador(usuario, contrasenia, nombre, tPersona, rubro,this);
	}

	public void crearTicket(String locacion, int remuneracion, String cargaHoraria, String tipoPuesto, 
			int rangoEtario, String experienciaPrevia, String estudiosCursados, int cantEmpleados, int pLocacion,int pRemuneracion,int pCargaHoraria,int pTipodePuesto,int pExperienciaPrevia,int pRangoEtario,int pEstudiosCursados) {
		Agencia.getInstance().crearTicketEmpleador(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario, experienciaPrevia, estudiosCursados,
				cantEmpleados,pLocacion,pRemuneracion, pCargaHoraria, pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados, this);
>>>>>>> main
	}
	
	public void cambiarEstadoTicket(String estado) {
		Agencia.getInstance().cambiarEstadoTicket(estado, this);
	}
<<<<<<< HEAD
	
	public void elegirUsuario_puntaje(Usuario_puntaje usuario) {
		Agencia.getInstance().elegirUsuario_puntaje(usuario, this);		
	}
	
	
=======
	/*
	public void elegirUsuario_puntaje(String nombreUsuario) {
		Agencia.getInstance().elegir(nombreUsuario, this);		
	}
	*/
	
	public void elegirUsuario_puntaje(String nombreUsuario) {
        Agencia.getInstance().elegir(nombreUsuario, this);
    }
>>>>>>> main

}
