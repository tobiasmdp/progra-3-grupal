package agencia;

import java.util.ArrayList;

import excepciones.*;//mirarlo
import tickets.Ticket;

public abstract class Usuario implements IPuntaje,ITicket {
	private String nombreUsuario;
	private String password;
	protected int puntaje;	
	protected Ticket ticket;
	private static ArrayList<String> nombreUsuariosCreados = new ArrayList<String>(); 
	
	protected Usuario(String nombreUsuario, String password) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.puntaje = 0;
		Usuario.nombreUsuariosCreados.add(nombreUsuario);
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
	
	public void altaTicket(Ticket ticket) { //solo se da de alta si no hay ticket
		if(this.ticket == null)
			this.ticket = ticket;
	}
	
	public void bajaTicket() {
		this.ticket = null;
	}
	
	public void modificacionTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public Ticket consultaTicket() {
		return this.ticket;
	}
	
	public static boolean validarRegistro(String nombreUsuario,String password) throws LoginException {
		boolean valido = false;
		if(password.length()>=6 ){ //validoContra minimo 6
			if(!Usuario.nombreUsuariosCreados.contains(nombreUsuario))//si no es repetido el usuario
				valido = true;
			else
				throw new NombreUsuarioException("nombre de usuario ya creado", nombreUsuario);//usuario repetido
		}else
			throw new ContraException("contraseña menor a 6 caracter", password);//contra menor a 6 
		return valido;
	}
	
	public void login(String nombreUsuario,String contra) throws LoginException {
		if(!nombreUsuario.equals(this.nombreUsuario))
			throw new NombreUsuarioException("el nombre de usuario ingresado no coincide", nombreUsuario);
		else if(!contra.equals(this.password))
			throw new ContraException("la contraseña ingresada no es la correcta", contra);
		else
			System.out.println("sesion iniciada correctamente");
	}
	
}
