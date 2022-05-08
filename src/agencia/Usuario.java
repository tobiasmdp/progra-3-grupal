package agencia;

import excepciones.*;//mirarlo

public abstract class Usuario implements IPuntaje {
	private String nombreUsuario;
	private String password;
	protected int puntaje;
	protected boolean logeado;
	
	protected Usuario(String nombreUsuario, String password) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.puntaje = 0;
		this.logeado = true;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public String getPassword() {
		return password;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public void login(String nombreUsuario,String contra) throws LoginException {
		if(!nombreUsuario.equals(this.nombreUsuario))
			throw new NombreUsuarioException("el nombre de usuario ingresado no coincide", nombreUsuario);
		else if(!contra.equals(this.password))
			throw new ContraException("la contraseña ingresada no es la correcta", contra);
		else
			System.out.println("sesion iniciada correctamente");
	}
	
	public void logout() {
		this.logeado=false;
	}
	
	public void mostrarContrataciones() {
		for(Contratacion contratacion:Agencia.getInstance().getContrataciones()) {
			System.out.println(contratacion);
		}
	}
}
