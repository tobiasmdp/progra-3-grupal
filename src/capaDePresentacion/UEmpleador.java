package capaDePresentacion;

import capaDeNegocios.Agencia;

public class UEmpleador extends UCliente{

	public UEmpleador() {
	}
	
	public void registrarse(String usuario, String contrasenia, String nombre, 
			String tPersona, String rubro) {
		Agencia.getInstance().registroEmpleador(usuario, contrasenia, nombre, tPersona, rubro,this);
	}

	public void crearTicket(String locacion, double remuneracion, String cargaHoraria, String tipoPuesto, 
			int rangoEtario, String experienciaPrevia, String estudiosCursados, int cantEmpleados, int pLocacion,int pRemuneracion,int pCargaHoraria,int pTipodePuesto,int pExperienciaPrevia,int pRangoEtario,int pEstudiosCursados) {
		Agencia.getInstance().crearTicketEmpleador(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario, experienciaPrevia, estudiosCursados,
				cantEmpleados,pLocacion,pRemuneracion, pCargaHoraria, pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados, this);
	}

	@Override
	public void cambiarEstadoTicket(String estado) {
		Agencia.getInstance().cambiarEstadoTicket(estado, this);
	}

}
