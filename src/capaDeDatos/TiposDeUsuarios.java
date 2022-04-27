package capaDeDatos;

import java.util.GregorianCalendar;

import capaDeNegocios.Agencia;
import capaDeNegocios.Contratacion;
import capaDeNegocios.Formulario;
import excepciones.*;//mirarlo

public abstract class TiposDeUsuarios  {
	private String nombreUsuario;
	private String password;
	protected boolean logeado;
	
	protected TiposDeUsuarios(String nombreUsuario, String password) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.logeado=true;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	
	public void login(String nombreUsuario,String contra) throws LoginException {//PUEDEN LLEGAR A IRSE
		if(!nombreUsuario.equals(this.nombreUsuario))
			throw new NombreUsuarioException("el nombre de usuario ingresado no coincide", nombreUsuario);
		else if(!contra.equals(this.password))
			throw new ContraException("la contraseña ingresada no es la correcta", contra);
		else
			System.out.println("sesion iniciada correctamente");
	}

	public void logout() {//PUEDEN LLEGAR A IRSE
		this.logeado=false;
	}
	
}
