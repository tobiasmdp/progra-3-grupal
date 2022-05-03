package capaDePresentacion;

import excepciones.LoginException;

public abstract class IUsuarios {
	protected String nombreUsuario;
	protected String contrase�a;

	
	
	public void login(String nombreUsuario, String contra)  {
		try {
			Login.getInstance().login(this.nombreUsuario,this.contrase�a);
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void logout() {
		
	}
	
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	
	public String getContra() {
		return contrase�a;
	}
	
}
