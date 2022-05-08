package capaDeNegocios;

import capaDeDatos.TiposDeUsuarios;

public class Usuario_puntaje {
	private TiposDeUsuarios usuario;
	private double puntaje;
	
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
