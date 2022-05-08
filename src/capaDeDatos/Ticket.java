package capaDeDatos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import capaDeNegocios.Formulario;
import capaDeNegocios.Usuario_puntaje;
import excepciones.UsuarioNoEncontradoException;
/**
 * @author mikel
 * la clase ticket es abstracta y es para generar los tickets de empleados y empleadores
 */
/**
 * @author mikel
 *
 */
public abstract class Ticket { 
	private Calendar fecha;
	private String estado= "Activo";
	protected Formulario formulario;
	protected ListaDeAsignacion listaAsignacion; //permito que se pueda elegir varios tickets en empleado tmb, luego se limita desde su ticket
	protected ArrayList<Usuario_puntaje> usuariosElegidos = new ArrayList<Usuario_puntaje>();
	protected int rondasTranscurridas;
	
	/**        
	 *<b>Pos:</b> 
	 * @param fecha en el constructor cada vez que se genera un  nuevo ticket, en el parametro fecha, crear siempre un nuevo objeto de Gregorian Calenadar
	 * @param estado a la hora de crear el ticket, el estado esta en activo por defecto.
	 * @param formulario, en el constructor cada vez que se genera un  nuevo ticket, en el parametro formulario, crear siempre un nuevo objeto de Formulario
	 */
	
	public Ticket(Formulario formulario) {  //inicializa el ticket en activo por default
		this.fecha = GregorianCalendar.getInstance();
		this.formulario=formulario;
		this.estado = "Activo";
		this.rondasTranscurridas = 0;
	}
	
	public void setRondasTranscurridas(int rondasTranscurridas) {
		this.rondasTranscurridas = rondasTranscurridas;
	}

	public int getRondasTranscurridas() {
		return rondasTranscurridas;
	}

	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado de no estar entre los valores 1(activo), 2(suspendido), 3(cancelado),4(finalizado), no se puede ingresar un estado negativo
	 */
	public void setEstado(String estado) {
		if (this.estado.equalsIgnoreCase("Cancelado")) // asi haria que no se cambie a otro si fue cancelado
			this.estado="Cancelado";
		else
			if (this.estado.equalsIgnoreCase("Activo") || this.estado.equalsIgnoreCase("Finalizado")) 
				this.estado=estado;
	}
	
	public Calendar getFecha() {
		return fecha;
	}
	
	
	public Formulario getFormulario() {
		return this.formulario;
	}
	
	public void elegirUsuario_puntaje(String nombreUsuario) throws UsuarioNoEncontradoException{
		int i=0;
		while(i<listaAsignacion.getLista().size() && !listaAsignacion.getLista().get(i).getUsuario().getNombreUsuario().equals(nombreUsuario)) {
			i++;
		}
		if(i==listaAsignacion.getLista().size())
			throw new UsuarioNoEncontradoException("El usuario no se encuentra en la lista de asignacion");
		else
			this.usuariosElegidos.add(listaAsignacion.getLista().get(i));
		
	}
	
	public ArrayList<Usuario_puntaje> getUsuariosElegidos() {
		return usuariosElegidos;
	}


	public void nuevaLista() {
		this.listaAsignacion= new ListaDeAsignacion();
	}

	public void addUsuarioAsignacion(Usuario_puntaje usuario) { 
		this.listaAsignacion.addlista(usuario);
	}
	

	public ListaDeAsignacion getListaAsignacion() {
		return listaAsignacion;
	}

	
	@Override
	public String toString() {
		return ""+formulario ;
	}
	
	
	
}