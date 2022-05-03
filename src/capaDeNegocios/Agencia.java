package capaDeNegocios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import capaDeDatos.Administrador;
import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;
import capaDeDatos.TicketEmpleado;
import capaDeDatos.TicketEmpleador;
import capaDeDatos.TiposDeUsuarios;
import excepciones.ContraException;
import excepciones.LoginException;
import excepciones.NombreUsuarioException;


public class Agencia{
	
	private static Agencia instance = null; // arranca valiendo null, aplico SINGLETON, 
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso>();
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	private ArrayList<Administrador> administradores = new ArrayList<Administrador>();
	private int V1=50000,V2=150000;
	private ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>();
	private MetodosEmpleado zonaEmpleados;
	private MetodosEmpleador zonaEmpleador;
	private ArrayList<NodoLogeoEmpleado> logeoempleados=new ArrayList<NodoLogeoEmpleado>();
	private ArrayList<NodoLogeoEmpleador> logeoempleadores=new ArrayList<NodoLogeoEmpleador>();
	
	public ArrayList<Contratacion> getContrataciones() {
		return contrataciones;
		
	}
	
	private Agencia() {
		this.zonaEmpleados =  MetodosEmpleado.getInstance();
		this.zonaEmpleador =  MetodosEmpleador.getInstance();
	}
	
	public static Agencia getInstance() {//SINGLETON
		if (Agencia.instance == null) {
			Agencia.instance=new Agencia();
		}
		return instance;
	}
	
	/******GETTERS DE ARRAYLISTS******/
	public ArrayList<EmpleadoPretenso> getEmpleadosPretensos() {
		return empleadosPretensos;
	}

	public ArrayList<Empleador> getEmpleadores() {
		return empleadores;
	}
	
	public ArrayList<NodoLogeoEmpleado> getLogeoempleados() {
		return logeoempleados;
	}


	public ArrayList<NodoLogeoEmpleador> getLogeoempleadores() {
		return logeoempleadores;
	}
	
	/*public EmpleadoPretenso registro(String nombreUsuario,String contra) {//Dudas: no sera void?
		Agencia.getInstance().addEmpleadoPretenso(this);
		return new EmpleadoPretenso(nombreUsuario,contra);
	}*/

	/******AGREGADOS DE ARRAYLISTS******/

	public void addLogeoEmpleadores(NodoLogeoEmpleador usuario) {//Agrega un administrador logeado al arreglo de logeos empleadores
		this.logeoempleadores.add(usuario);
	}

	public void addLogeoEmpleadoPretenso(NodoLogeoEmpleado usuario) {//Agrega un empleado logeado al arreglo de logeos empleados
		this.logeoempleados.add(usuario);
	}
	
	public void addLogeoAdministrador(Administrador usuario) {//Agrega un administrador logeado al arreglo de logeos admins
		this.administradores.add(usuario);
	}

	public void addAdministrador(Administrador usuario) {//Agrega un administrador  al arreglo de admins 
		this.administradores.add(usuario);
	}
	
	public void addEmpleadoPretenso(EmpleadoPretenso empleadoPretenso) {//Agrega un empleado  al arreglo de empleados
		this.empleadosPretensos.add(empleadoPretenso);
	}

	public void addEmpleador(Empleador empleador) {//Agrega un empleador  al arreglo de empleadores
		this.empleadores.add(empleador);
	}
	
	/******REMOVEDORES DE ARRAYLISTS******/
	
	public void removeEmpleadoPretenso(EmpleadoPretenso empleadoPretenso) {
		this.empleadosPretensos.remove(empleadoPretenso);
	}
	
	public void removeEmpleador(Empleador empleador) {
		this.empleadores.remove(empleador);
	}
	
	
	
	public void login(String nombreUsuario,String contra) throws LoginException {
		Empleador auxempleador;
		EmpleadoPretenso auxempleado;
		Administrador auxadmin;
		NodoLogeoEmpleado auxnodoempleado;
		NodoLogeoEmpleador auxnodoempleador;
		TiposDeUsuarios auxusuario;
		
		int i=0,bandera=0;
		
		do{
			auxempleado=empleadosPretensos.get(i);
			i++;
		}while(i<empleadosPretensos.size() && (auxempleado.getNombreUsuario()!=nombreUsuario));
		
		if(bandera==1) {
			auxusuario.setNombreUsuario(nombreUsuario);
			auxusuario.setPassword(contra);
			auxnodoempleado=new NodoLogeoEmpleado(auxusuario,auxempleado);
			addLogeoEmpleadoPretenso(auxnodoempleado);
		}
		bandera=0;
		i=0;
		
		if(bandera==0) {
			do{
				auxempleador= empleadores.get(i);
				i++;
			}while( i<empleadosPretensos.size() && (auxempleador.getNombreUsuario()!=nombreUsuario));
			bandera=0;
			i=0;
		}
		
		if(bandera==1) {
			auxusuario.setNombreUsuario(nombreUsuario);
			auxusuario.setPassword(contra);
			auxnodoempleador=new NodoLogeoEmpleador(auxusuario,auxempleador);
			addLogeoEmpleadores(auxnodoempleador);
		}
		if(bandera==0) {
			do{
				auxadmin=administradores.get(i);
				i++;
			}while(i<administradores.size() && (auxadmin.getNombreUsuario()!=nombreUsuario));
			bandera=0;
			i=0;
		}
		
		if(i==usuarios.size() && (auxusuario.getNombreUsuario()!=nombreUsuario))
			throw new NombreUsuarioException("el nombre de usuario ingresado no coincide", nombreUsuario);
		else if(auxusuario.getPassword()!=contra)
			throw new ContraException("la contraseña ingresada no es la correcta", contra);
		else {
			System.out.println("sesion iniciada correctamente");
		}
		
	}
	
	
	/*public void logout() {//PUEDEN LLEGAR A IRSE
	this.logeado=false;
}*/
	
	
	public void rondaEncuentrosLaborales() {
		Empleador auxEmpleador;
		EmpleadoPretenso auxEmpleado;
		double puntaje;
		Usuario_puntaje aux;
		for (int i=0; i < empleadores.size(); i++) {
			auxEmpleador=empleadores.get(i);
			
			for (int j=0; j < empleadosPretensos.size(); j++) {
				auxEmpleado=empleadosPretensos.get(j);
				puntaje=zonaEmpleador.calculoPuntajes(auxEmpleador.getTicket(),auxEmpleado.getTicket().getFormulario());
				aux=new Usuario_puntaje(auxEmpleado,puntaje);
				auxEmpleador.getTicket().nuevoEmpleadoMatcheado(aux);
			}
			

			Collections.sort(auxEmpleador.getTicket().getEmpleadosmatcheados(), new UsuarioComparator());//Le paso la lista como 1er parametor
			
		}
		for (int i=0; i < empleadosPretensos.size(); i++) {
			auxEmpleado=empleadosPretensos.get(i);
			
			for (int j=0; j < empleadores.size(); j++) {
				auxEmpleador=empleadores.get(j);
				puntaje=zonaEmpleados.calculoPuntajes(auxEmpleado.getTicket().getFormulario(),auxEmpleador.getTicket().getFormulario());
				aux=new Usuario_puntaje(auxEmpleador,puntaje);
				auxEmpleado.getTicket().nuevoEmpleadorMatcheado(aux);
			}
			//Collections.sort(auxEmpleador.getTicket().getEmpleadosmatcheados(), new UsuarioComparator());
		}
		//genero las listas de asignaciones
	}
	
	
	/**
	 * llegado el momento de contratacion, al tratar las listas ordenadas, si el empleado eligiese 2 empresas, 
	 * siempre seria contratado por la que le dio mejor puntaje
	 */
	private void rondaContrataciones() {
		double comisionEmpleado, comisionEmpleador;
		TicketEmpleador ticketEmpleador,ticketEmpleadorElegido;
		TicketEmpleado ticketEmpleado;
		ArrayList<Usuario_puntaje> eleccionEmpleador,eleccionEmpleado;
		Empleador empleadorElegido;
		EmpleadoPretenso empleadoElegido;
		for(Empleador empleador:this.empleadores) {
			ticketEmpleador = empleador.getTicket();
			eleccionEmpleador= ticketEmpleador.getUsuariosElegidos(); //tomo el array de empleados elegidos por el empleado
			Collections.sort(eleccionEmpleador, new UsuarioComparator()); 
			
			for (Usuario_puntaje usuarioElegidoPorEmpleador:eleccionEmpleador) { // para cada usuario_puntaje elegido por ese ticket de empleador
				empleadoElegido = (EmpleadoPretenso) usuarioElegidoPorEmpleador.getUsuario();
				ticketEmpleado = empleadoElegido.getTicket();
				eleccionEmpleado = ticketEmpleado.getUsuariosElegidos();
				Collections.sort(eleccionEmpleado, new UsuarioComparator());	
				
				for (Usuario_puntaje usuarioElegidoPorEmpleado:eleccionEmpleado) { //el empleadorElegido si castear, siendo usuario
					empleadorElegido = (Empleador) usuarioElegidoPorEmpleado.getUsuario();
					ticketEmpleadorElegido= empleadorElegido.getTicket(); 
					if (ticketEmpleador.equals(ticketEmpleadorElegido)){ 
						zonaEmpleador.actualizarPuntaje(empleador);
						zonaEmpleados.actualizarPuntaje(empleadoElegido);	
						
						comisionEmpleado = 1;//calcular comision empleador
						comisionEmpleador = 1;//calcular comision empleado
						
						this.contrataciones.add(new Contratacion(empleadoElegido, empleador,comisionEmpleado, comisionEmpleador));
						
						ticketEmpleador.setCantempleadosobtenidos(ticketEmpleador.getCantempleadosbuscados() + 1 );
						if (ticketEmpleador.getCantempleadosbuscados() == ticketEmpleador.getCantempleadosobtenidos()){
							ticketEmpleador.setEstado("finalizado");
						}
						ticketEmpleado.setEstado("finalizado");
//						ticketEmpleado.setResultado(0); hay que poner un exito o fracaso?
						// dar de baja "ticketEmpleador"
						//dar de baja "ticketEmpleado"
					}
				}
			}
		}
	}

	
	
	
	
	public void actualizarPuntaje() {
	}
	
	/*
	@Override
	public double calcularComisiones() {
		return tPersona.calcularComisiones(rubro);
	}
	*/

	public int getV1() {
		return V1;
	}

	public void setV1(int v1) {
		V1 = v1;
	}

	public int getV2() {
		return V2;
	}

	public void setV2(int v2) {
		V2 = v2;
	}

	public void mostrarContrataciones() {
		for(Contratacion contratacion:Agencia.getInstance().getContrataciones()) {
			System.out.println(contratacion);
		}
	}
	//********METODOS DE LOGEO****//////////
	
}
