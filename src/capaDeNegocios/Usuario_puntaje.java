package capaDeNegocios;

import capaDeDatos.TiposDeUsuarios;

/**
 *<b>
 * Esta clase es la que compone las listas de asignaciones.
 */
public class Usuario_puntaje {
	private TiposDeUsuarios usuario;
	private double puntaje;
	
	/**
	 * <b>Pre: </b> Se ejecuta durante la ronda de encuentros laborales.
	 * @param usuario : puede ser empleado pretenso o empleador.
	 * @param puntaje : el puntaje obtenido.
	 */
	public Usuario_puntaje(TiposDeUsuarios usuario, double puntaje) {
		this.usuario = usuario;
		this.puntaje = puntaje;
	}

	public TiposDeUsuarios getUsuario() {
		return usuario;
	}

	public double getPuntaje() {
		return puntaje;
	}

	@Override
	public String toString() {
		return "        "  + puntaje +"      " + usuario;
	}
	
	
}
