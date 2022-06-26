package capaDePresentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.table.DefaultTableModel;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;
import capaDeDatos.ListaDeAsignacion;
import capaDeNegocios.Agencia;
import capaDeNegocios.BolsaDeTrabajo;
import capaDeNegocios.EmpleadoSimulado;
import capaDeNegocios.EmpleadorSimulado;
import excepciones.ContraException;
import excepciones.LoginException;
import excepciones.NewRegisterException;
import excepciones.NombreUsuarioException;
import excepciones.UsuarioNoEncontradoException;

public class ControladorSistema implements ActionListener, Observer, KeyListener{
	private InterfazVista vista;
	private Agencia modelo= Agencia.getInstance();
	private Usuario usuario=null; //Usuario que controla la interfaz una vez se logea
	private int tipoUsuario=0; //0 empleado //1 empleador //2 administrador
	private EmergenteTicket emergenteticket;
	private EmergenteListaDeAsignacion emergenteListaDeAsignacion;
	public ControladorSistema() {
		super();
		this.vista = new VentanaEmpleos();
		this.vista.setActionListener(this);
		this.modelo = Agencia.getInstance();
		this.modelo.addObserver(this);
		this.modelo.getBolsatrabajo().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		ListaDeAsignacion listaAsignacion;
		EmpleadoPretenso empleado;
		Empleador empleador;
		int numfila;
		if (evento.getActionCommand().equals(InterfazVista.REGISTRAR)) {//registrar en la principal
			vista.Maximizar();
			vista.registroPasoUno();
		}
		else if (evento.getActionCommand().equals(InterfazVista.LOGIN)) {//login en la principal
			
			this.vista.getLabelErrorUsuario().setVisible(false);
			this.vista.getLabelErrorContrasenia().setVisible(false);
			try {
				this.usuario=modelo.login(this.vista.getTextoUsuario().getText(), this.vista.getTextoContraseña().getText());
				CambioVistas();
					
			} catch (NombreUsuarioException e) {
				this.vista.getLabelErrorUsuario().setVisible(true);
				this.usuario=null;
			} catch (ContraException e) {
				this.vista.getLabelErrorContrasenia().setVisible(true);
				this.usuario=null;
			} 
		}
		else if (evento.getActionCommand().equals(InterfazVista.UNIRSE)) {//primer campo para completar datos comunes, contrasenia, etc
			try {
                modelo.checkRegister(this.vista.getTextoUsuarioRegistro().getText()); 
                vista.registroPasoDos();
            } catch (NewRegisterException e) {
				vista.getLabelErrorUsuarioRepetido().setVisible(true);
            }
			
			
		}
		else if (evento.getActionCommand().equals(InterfazVista.EMPLEADOR)) {//si elige soy empleador
			vista.registroEmpleador();
		}
		else if (evento.getActionCommand().equals(InterfazVista.EMPLEADO)) {//si elige soy empleado
			vista.registroEmpleado();
		}

		else if (evento.getActionCommand().equals(InterfazVista.SIGUIENTEEMPLEADOR)) {//campo de datos personales de tipo empresa 
			this.usuario=modelo.registroEmpleador(vista.getTextoUsuarioRegistro().getText(), vista.getTextoContraseñaRegistro().getText(), vista.getTextoNombre().getText() , vista.getGrupoTipoPersona().getSelection().getActionCommand(), vista.getGrupoTipoRubro().getSelection().getActionCommand());
			InicioSesionEmpleador();
		}
		else if (evento.getActionCommand().equals(InterfazVista.SIGUIENTEEMPLEADO)) {//campo de datos personales de tipo empleador
			this.usuario=modelo.registroEmpleado(vista.getTextoUsuarioRegistro().getText(), vista.getTextoContraseñaRegistro().getText(), vista.getTextoNombre().getText() , vista.getTextoApellido().getText(), vista.getTextoTelefono().getText(), Integer.parseInt(vista.getTextoEdad().getText()));
			InicioSesionEmpleado();
		}
		else if (evento.getActionCommand().equals(InterfazVista.NUEVOTICKETEMPLEADOR)) {//creacion de ticket de empresa 
			vista.NuevoTicketEmpleador();
		}
		else if (evento.getActionCommand().equals(InterfazVista.NUEVOTICKETEMPLEADOR)) {//creacion de ticket de empleador 
			vista.NuevoTicketEmpleado();
		}
		else if (evento.getActionCommand().equals(InterfazVista.RONDAENCUENTROS)) {//c
			modelo.rondaEncuentrosLaborales();
			vista.menuRondaEncuentros();
		}
		else if (evento.getActionCommand().equals(InterfazVista.RONDACONTRATACION)) { 
			modelo.rondaContrataciones();
			vista.menuRondaContratacion();
		}
		else if (evento.getActionCommand().equals(InterfazVista.VALORESREMUNERACION)) {
			modelo.setV1(Integer.parseInt(vista.getTextovalorMinimo().getText() ) );
			modelo.setV2(Integer.parseInt(vista.getTextovalorMaximo().getText() ) );
			vista.menuValoresRemuneracion();
		}else if (evento.getActionCommand().equals(InterfazVista.ELEGIRTICKETEMPLEADO)) {
			emergenteticket= new EmergenteTicket(this,this.vista,true);
			emergenteticket.setVisible(true);
			vista.elegirticket();
		}else if (evento.getActionCommand().equals(InterfazVista.CONFIRMARELEGIRTICKETEMPLEADO)) {
			emergenteticket.setVisible(false);
			modelo.cambiarEstadoTicket((String)emergenteticket.getComboBox().getSelectedItem(), (UEmpleado)usuario);
			InicioSesionEmpleado();
		}else if (evento.getActionCommand().equals(InterfazVista.CERRARSESION)) {
			this.usuario=null;
			vista.InicializarPaneles();
			vista.pantallaPrincipal();
		}
		else if (evento.getActionCommand().equals(InterfazVista.MOSTRARLISTAEMPLEADO)) { //ACA ENTRA EL USUARIO DE TIPO EMPLEADOR
			emergenteListaDeAsignacion= new EmergenteListaDeAsignacion(this,this.vista,true);
			emergenteListaDeAsignacion.setVisible(true);
			emergenteListaDeAsignacion.mirarlistaEmpleado();
			
			this.emergenteListaDeAsignacion.getModeloTableListaEmpleado().setRowCount(0);
			listaAsignacion=this.modelo.getListaDeAsignacion((UCliente)usuario);
			for(int i=0; i<listaAsignacion.getLista().size();i++){
				empleado= (EmpleadoPretenso)listaAsignacion.getLista().get(i).getUsuario();
				Object[] fila= {
					empleado.getNombre(),
					listaAsignacion.getLista().get(i).getPuntaje(),
					empleado.getTicket().getFormulario().getCargaHoraria(),
					empleado.getTicket().getFormulario().getRemuneracion(),
					empleado.getTicket().getFormulario().getLocacion(),
					empleado.getTicket().getFormulario().getTipoPuesto(),
					empleado.getTicket().getFormulario().getEstudiosCursados(),
					empleado.getTicket().getFormulario().getExperienciaPrevia(),
					empleado.getTicket().getFormulario().getRangoEtario(),
					empleado.getNombreUsuario(),
				};
				this.emergenteListaDeAsignacion.getModeloTableListaEmpleado().addRow(fila);
			}
		}else if (evento.getActionCommand().equals(InterfazVista.CONFIRMARMOSTRARLISTAEMPLEADO)) {
			numfila=emergenteListaDeAsignacion.getTableListaEmpleado().getSelectedRow();
			if(numfila!=-1 ) {
				try {
					modelo.elegirUsuario_puntaje(emergenteListaDeAsignacion.getModeloTableListaEmpleado().getValueAt(numfila, 9).toString(), (UCliente)usuario);
				} catch (UsuarioNoEncontradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			emergenteListaDeAsignacion.setVisible(false);
		
		}else if (evento.getActionCommand().equals(InterfazVista.SIMULADOR)) {//entra al simulador

			vista.simulador();
			modelo.simulacion();
			for (int i = 0 ; i < this.modelo.getSimempleado().size() ; i++)
				this.modelo.getSimempleado().get(i).addObserver(this);
			for (int i = 0 ; i < this.modelo.getSimempleadores().size() ; i++)
				this.modelo.getSimempleadores().get(i).addObserver(this);
			modelo.iniciarSimulacion();
			
			this.vista.actualizar();
		}
	}



	@Override
	public void update(Observable o, Object arg) {
		EmpleadoSimulado empleadoSimulado;
		EmpleadorSimulado empleadorSimulado;
		BolsaDeTrabajo bolsaTrabajo;
		DefaultTableModel modeloListaBolsaTrabajo= new DefaultTableModel();
		if(arg.equals("Empleado")) {
			this.tipoUsuario=0;
		}
		else if(arg.equals("Empleador")) {
			this.tipoUsuario=1;
		} 
		else if(arg.equals("Administrador")) {
			this.tipoUsuario=2;
		} 
		else if(arg.equals("EstadoEmpleado")) {
			empleadoSimulado=(EmpleadoSimulado)o;
			this.vista.getAcciones().append(empleadoSimulado.getEstado()+"\n");
		} 
		else if(arg.equals("EstadoEmpleador")) {
			empleadorSimulado=(EmpleadorSimulado)o;
			this.vista.getAcciones().append(empleadorSimulado.getEstado()+"\n");
		} 
		else if(arg.equals("EstadoBolsa")) {
			bolsaTrabajo=(BolsaDeTrabajo)o;
			this.vista.getAcciones().append(bolsaTrabajo.getEstado()+"\n");
		} 
		else if(arg.equals("EstadoBolsaTrabajo")) {
			this.vista.getModeloTableBolsaTrabajo().setRowCount(0);
			for(int i=0; i<this.modelo.getBolsatrabajo().getPuestoTrabajos().size();i++) {
				if(this.modelo.getBolsatrabajo().getPuestoTrabajos()!=null) {
					Object[] fila= {
						this.modelo.getBolsatrabajo().getPuestoTrabajos().get(i).getEmpleador().getNombre(),
						this.modelo.getBolsatrabajo().getPuestoTrabajos().get(i).getLocacion(),
						this.modelo.getBolsatrabajo().getPuestoTrabajos().get(i).getRubro(),
						this.modelo.getBolsatrabajo().getPuestoTrabajos().get(i).getEstado(),
					};
					this.vista.getModeloTableBolsaTrabajo().addRow(fila);
				}
			}
			
			
		} 
		this.vista.actualizar();
	}

	@Override
	public void keyTyped(KeyEvent evento) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent evento) {
		
		 if (evento.getKeyCode() == KeyEvent.VK_ENTER) {
			this.vista.getLabelErrorUsuario().setVisible(false);
			this.vista.getLabelErrorContrasenia().setVisible(false);
			try {
				this.usuario=modelo.login(this.vista.getTextoUsuario().getText(), this.vista.getTextoContraseña().getText());
				CambioVistas();
				
				
			} catch (NombreUsuarioException e) {
				this.vista.getLabelErrorUsuario().setVisible(true);
				this.usuario=null;
			} catch (ContraException e) {
				this.vista.getLabelErrorContrasenia().setVisible(true);
				this.usuario=null;
			} 
		}
		
	}
	

	private void CambioVistas() {
		if(this.tipoUsuario==0)
			InicioSesionEmpleado();
		else if(this.tipoUsuario==1)
			InicioSesionEmpleador();
		else if(this.tipoUsuario==2)
			vista.MenuPrincipalAdministrador();
		
	}

	@Override
	public void keyReleased(KeyEvent evento) {
		
	}	
	
	public void InicioSesionEmpleado() {
		vista.Maximizar();
		ModeloListaEmpleado modeloListaEmpleado= new ModeloListaEmpleado();
		if(this.modelo.getTicketEmpleado(usuario)!=null)
			vista.getTicket().setText(this.modelo.getTicketEmpleado(usuario).toString());
		else {
			vista.getTicket().setText("No tiene ticket creado.");
			vista.deshabilitarBotones();
		}
		vista.getListaEmpleadosPretensos().setModel(modeloListaEmpleado);
		vista.MenuPrincipalEmpleado();
	}
	
	public void InicioSesionEmpleador() {
		vista.Maximizar();
		if(this.modelo.getTicketEmpleador(usuario)!=null)
			vista.getTicket().setText(this.modelo.getTicketEmpleador(usuario).toString());
		else {
			vista.getTicket().setText("No tiene ticket creado.");
			vista.deshabilitarBotones();
		}
		
		ModeloListaEmpleado modeloListaEmpleado= new ModeloListaEmpleado();
		vista.getListaEmpleadosPretensos().setModel(modeloListaEmpleado);
		vista.MenuPrincipalEmpleador();
	}
	
	
}
