package persistencia;

public class EmpleadorDTO extends ClienteDTO{
	private String nombre;
	private String tPersona; //se persiste como String para levantarlo con un Factory
	private String rubro;
	private TicketEmpleadorDTO ticketDTO;
	private double comision;
	
	public EmpleadorDTO() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TicketEmpleadorDTO getTicket() {
		return ticketDTO;
	}

	public void setTicket(TicketEmpleadorDTO ticket) {
		this.ticketDTO = ticket;
	}

	public String getTPersona() {
		return tPersona;
	}

	public void setTPersona(String tPersona) {
		this.tPersona = tPersona;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}
	
	
}
