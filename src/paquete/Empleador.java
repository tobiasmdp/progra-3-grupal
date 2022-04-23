package dominio;

public class Empleador extends Usuario {
	private String nombre;
	private Persona tPersona;
	private Rubro rubro;
	
	private Empleador(String nombreUsuario,String contra) {
		super(nombreUsuario,contra);
	}
	
	private Empleador(String nombreUsuario,String contra,String nombre, Persona tPersona, Rubro rubro) {
		super(nombreUsuario,contra);
		this.nombre = nombre;
		this.tPersona = tPersona;
		this.rubro = rubro;
	}
	
	public Empleador registro(String nombreUsuario,String contra,String nombre, Persona tPersona, Rubro rubro) {
		return new Empleador(nombreUsuario,contra,nombre,tPersona,rubro);
	}
	
	public Empleador registro(String nombreUsuario,String contra) {
		return new Empleador(nombreUsuario,contra);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public Persona gettPersona() {
		return tPersona;
	}
	public Rubro getRubro() {
		return rubro;
	}

	@Override
	public void actualizarPuntaje() {
		/*
		por cada Ticket finalizado suma 50 puntos
 		por no ser elegido por ningún empleado pretenso resta 20 puntos.
 		por ser primero en la Lista de Empleadores suma 10 puntos por cada una.
		*/
	}

	@Override
	public double calcularComisiones() {
		return tPersona.calcularComisiones(rubro);
	}

}
