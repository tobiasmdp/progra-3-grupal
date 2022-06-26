package capaDeDatos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import capaDeNegocios.Usuario_puntaje;
import excepciones.UsuarioNoEncontradoException;
/**
 * <br>
 * La clase ticket es abstracta y es para generar los tickets de empleados y empleadores.
 */
public abstract class Ticket { 
	protected Calendar fecha;
	protected String estado= "Activo";
	protected Formulario formulario;
	protected ListaDeAsignacion listaAsignacion; //permito que se pueda elegir varios tickets en empleado tmb, luego se limita desde su ticket
	protected ArrayList<Usuario_puntaje> usuariosElegidos = new ArrayList<Usuario_puntaje>();
	protected int rondasTranscurridas;
	
	/**
	 * @param formulario
	 * Para crear el ticket se pasa el formulario ya que este lo compone y ademas se le pone la fecha actual.
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
			this.estado=estado;
	}
	
	public Calendar getFecha() {
		return fecha;
	}
	
	
	public Formulario getFormulario() {
		return this.formulario;
	}
	
	/**
	 * <br>
	 * Busca en la lista de asignacion el nombre de usuario pasado por parametro y si lo encuentra lo agrega a la lista usuario elegidos. <br>
	 * <b>Pre: </b> Se tiene que haber ejecutado la ronda de contratacion.<br> 
	 * @param nombreUsuario: el nombre del usuario a agregar.
	 * @throws UsuarioNoEncontradoException: se lanza si no se encuentra el nombre de usuario pasado por parametro en la lista de asignacion.
	 * 
	 */
	
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
		return "Fecha de generacion: "+fecha.get(fecha.DATE)+ " / "+ fecha.get(fecha.MONTH)+ " / "+fecha.get(fecha.YEAR)+"\nEstado: " +estado+"\nRondas sin ser elegido:" + rondasTranscurridas + formulario ;
	}
	
	
	
}