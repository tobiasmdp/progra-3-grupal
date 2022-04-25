package agencia;

import tickets.Ticket;

public interface ITicket {
	public void altaTicket(Ticket ticket);
	public void bajaTicket();
	public void modificacionTicket(Ticket ticketNuevo);
	public Ticket consultaTicket();
}
