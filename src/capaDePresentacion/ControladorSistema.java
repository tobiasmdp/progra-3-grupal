package capaDePresentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
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
	private EmergenteListaDeAsignacionEmpleado emergenteListaDeAsignacionEmpleado;
	private EmergenteTicketEmpleado emergenteTicketEmpleado;
	private EmergenteTicketEmpleador emergenteTicketEmpleador;
	private EmergenteVerResultados emergenteVerResultados;
	private EmergenteListaDeEmpleados emergenteListaDeEmpleados;
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
		ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso>();
		ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
		EmpleadoPretenso empleado;
		Empleador empleador;
		String pesoLocacion;
		String pesoRemuneracion;
		String pesoCargaHoraria;
		String pesoTipodePuesto;
		String pesoExperienciaprevia;
		String pesoEdad;
		String pesoEstudiosCursados;
		double comision;
		
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
		else if (evento.getActionCommand().equals(InterfazVista.NUEVOTICKETEMPLEADO)) {//creacion de ticket de empresa 
			emergenteTicketEmpleado=new EmergenteTicketEmpleado(this,this.vista,true);
			emergenteTicketEmpleado.setVisible(true);
			
		}
		else if (evento.getActionCommand().equals(InterfazVista.NUEVOTICKETEMPLEADOR)) {//creacion de ticket de empleador 
			emergenteTicketEmpleador=new EmergenteTicketEmpleador(this,this.vista,true);
			emergenteTicketEmpleador.setVisible(true);
		}
		else if (evento.getActionCommand().equals(InterfazVista.CONFIRMARNUEVOTICKETEMPLEADO)) {//creacion de ticket de empresa 
			modelo.crearTicketEmpleado(emergenteTicketEmpleado.getButtonGroupLocacion().getSelection().getActionCommand(), Integer.parseInt(emergenteTicketEmpleado.getTextoRemuneracion().getText()),emergenteTicketEmpleado.getButtonGroupCargaHoraria().getSelection().getActionCommand(),emergenteTicketEmpleado.getButtonGroupTipodePuesto().getSelection().getActionCommand(),emergenteTicketEmpleado.getButtonGroupExperienciaPrevia().getSelection().getActionCommand(), emergenteTicketEmpleado.getButtonGroupEstudiosCursados().getSelection().getActionCommand(), (UEmpleado)usuario);
			emergenteTicketEmpleado.setVisible(false);
			InicioSesionEmpleado();
		}
		else if (evento.getActionCommand().equals(InterfazVista.CONFIRMARNUEVOTICKETEMPLEADOR)) {//creacion de ticket de empresa
			pesoLocacion=(String)emergenteTicketEmpleador.getComboBoxLocacion().getSelectedItem();
			pesoRemuneracion=(String)emergenteTicketEmpleador.getComboBoxRemuneracion().getSelectedItem();
			pesoCargaHoraria=(String)emergenteTicketEmpleador.getComboBoxCargaHoraria().getSelectedItem();
			pesoTipodePuesto=(String)emergenteTicketEmpleador.getComboBoxPuesto().getSelectedItem();
			pesoExperienciaprevia=(String)emergenteTicketEmpleador.getComboBoxExperienciaPrevia().getSelectedItem();;
			pesoEdad=(String)emergenteTicketEmpleador.getComboBoxEdad().getSelectedItem();
			pesoEstudiosCursados=(String)emergenteTicketEmpleador.getComboBoxEstudios().getSelectedItem();
			modelo.crearTicketEmpleador(emergenteTicketEmpleador.getButtonGroupLocacion().getSelection().getActionCommand(), (double)Integer.parseInt(emergenteTicketEmpleador.getTextoRemuneracion().getText()),emergenteTicketEmpleador.getButtonGroupCargaHoraria().getSelection().getActionCommand(),emergenteTicketEmpleador.getButtonGroupTipodePuesto().getSelection().getActionCommand(),Integer.parseInt(emergenteTicketEmpleador.getTextoEdad().getText()),emergenteTicketEmpleador.getButtonGroupExperienciaPrevia().getSelection().getActionCommand(), emergenteTicketEmpleador.getButtonGroupEstudiosCursados().getSelection().getActionCommand(),
					Integer.parseInt(emergenteTicketEmpleador.getTextoCantidadEmpleados().getText()),Integer.parseInt(pesoLocacion),Integer.parseInt(pesoRemuneracion),Integer.parseInt(pesoCargaHoraria),Integer.parseInt(pesoTipodePuesto),Integer.parseInt(pesoExperienciaprevia),Integer.parseInt(pesoEdad),Integer.parseInt(pesoEstudiosCursados),(UEmpleador)usuario);
			emergenteTicketEmpleador.setVisible(false);
			InicioSesionEmpleador();
		}
		else if(evento.getActionCommand().equals(InterfazVista.GATILLAR)) {
            modelo.gatillarRonda();
           
		}else if (evento.getActionCommand().equals(InterfazVista.VALORESREMUNERACION)) {
			modelo.setV1(Integer.parseInt(vista.getTextovalorMinimo().getText() ) );
			modelo.setV2(Integer.parseInt(vista.getTextovalorMaximo().getText() ) );
			vista.menuValoresRemuneracion();
		}else if (evento.getActionCommand().equals(InterfazVista.ELEGIRTICKETEMPLEADO)) {
			emergenteticket= new EmergenteTicket(this,this.vista,true,0);
			emergenteticket.setVisible(true);
			vista.elegirticket();
		}else if (evento.getActionCommand().equals(InterfazVista.ELEGIRTICKETEMPLEADOR)) {
			emergenteticket= new EmergenteTicket(this,this.vista,true,1);
			emergenteticket.setVisible(true);
			vista.elegirticket();
		}else if (evento.getActionCommand().equals(InterfazVista.CONFIRMARELEGIRTICKETEMPLEADO)) {
			modelo.cambiarEstadoTicket((String)emergenteticket.getComboBox().getSelectedItem(), (UEmpleado)usuario);
			emergenteticket.setVisible(false);
			InicioSesionEmpleado();
		}else if (evento.getActionCommand().equals(InterfazVista.CONFIRMARELEGIRTICKETEMPLEADOR)) {
			emergenteticket.setVisible(false);
			modelo.cambiarEstadoTicket((String)emergenteticket.getComboBox().getSelectedItem(), (UEmpleador)usuario);
			InicioSesionEmpleador();
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
		}else if (evento.getActionCommand().equals(InterfazVista.MOSTRARLISTAEMPLEADOR)) { //ACA ENTRA EL USUARIO DE TIPO EMPLEADOR
				emergenteListaDeAsignacionEmpleado= new EmergenteListaDeAsignacionEmpleado(this,this.vista,true);
				emergenteListaDeAsignacionEmpleado.setVisible(true);
				emergenteListaDeAsignacionEmpleado.mirarlistaEmpleado();
				
				
				this.emergenteListaDeAsignacionEmpleado.getModeloTableListaEmpleado().setRowCount(0);
				listaAsignacion=this.modelo.getListaDeAsignacion((UCliente)usuario);
				for(int i=0; i<listaAsignacion.getLista().size();i++){
					empleador= (Empleador)listaAsignacion.getLista().get(i).getUsuario();
					Object[] fila= {
						empleador.getNombre(),
						listaAsignacion.getLista().get(i).getPuntaje(),
						empleador.getRubro(),
						empleador.getTicket().getFormulario().getCargaHoraria(),
						empleador.getTicket().getFormulario().getRemuneracion(),
						empleador.getTicket().getFormulario().getLocacion(),
						empleador.getTicket().getFormulario().getTipoPuesto(),
						empleador.getTicket().getFormulario().getEstudiosCursados(),
						empleador.getTicket().getFormulario().getExperienciaPrevia(),
						empleador.getTicket().getFormulario().getRangoEtario(),
						empleador.getNombreUsuario(),
					};
					this.emergenteListaDeAsignacionEmpleado.getModeloTableListaEmpleado().addRow(fila);
				}
		}else if (evento.getActionCommand().equals(InterfazVista.CONFIRMARELEGIRLISTAEMPLEADO)) {
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
		}else if (evento.getActionCommand().equals(InterfazVista.CONFIRMARELEGIRLISTAEMPLEADOR)) {
			numfila=emergenteListaDeAsignacionEmpleado.getTableListaEmpleado().getSelectedRow();
			if(numfila!=-1 ) {
				try {
					modelo.elegirUsuario_puntaje(emergenteListaDeAsignacionEmpleado.getModeloTableListaEmpleado().getValueAt(numfila, 10).toString(), (UCliente)usuario);
				} catch (UsuarioNoEncontradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			emergenteListaDeAsignacionEmpleado.setVisible(false);
		}else if (evento.getActionCommand().equals(InterfazVista.MOSTRARRESULTADOSEMPLEADO)) {
			emergenteVerResultados= new EmergenteVerResultados(this,this.vista,true);
			comision=modelo.getComisionEmpleado((UEmpleado)usuario);
			if(comision!=0){
				emergenteVerResultados.versionEmpleado(comision);
			}
			else {
				emergenteVerResultados.versionFracaso();
			}
			emergenteVerResultados.setVisible(true);
				
		}else if (evento.getActionCommand().equals(InterfazVista.MOSTRARRESULTADOSEMPLEADOR)) {
			emergenteVerResultados= new EmergenteVerResultados(this,this.vista,true);
			comision=modelo.getComisionEmpleado((UEmpleador)usuario);
			if(comision!=0){
				emergenteVerResultados.versionEmpleador(comision);
			}
			else {
				emergenteVerResultados.versionFracaso();
			}
			emergenteVerResultados.setVisible(true);
		}else if (evento.getActionCommand().equals(InterfazVista.LISTAEMPLEADOSAGENCIA)) {
			emergenteListaDeEmpleados= new EmergenteListaDeEmpleados(this,this.vista,true);
			emergenteListaDeEmpleados.setVisible(true);
			emergenteListaDeEmpleados.mirarlistaEmpleado();
			
			this.emergenteListaDeEmpleados.getModeloTableListaEmpleado().setRowCount(0);
			empleadosPretensos=this.modelo.getEmpleadosPretensos();
			for(int i=0; i<empleadosPretensos.size();i++){
				empleado= empleadosPretensos.get(i);
				Object[] fila= {
					empleado.getNombreUsuario(),
				};
				this.emergenteListaDeEmpleados.getModeloTableListaEmpleado().addRow(fila);
			}
		}else if (evento.getActionCommand().equals(InterfazVista.LISTAEMPLEADORESAGENCIA)) {
			emergenteListaDeEmpleados= new EmergenteListaDeEmpleados(this,this.vista,true);
			emergenteListaDeEmpleados.setVisible(true);
			emergenteListaDeEmpleados.mirarlistaEmpleador();
			
			this.emergenteListaDeEmpleados.getModeloTableListaEmpleado().setRowCount(0);
			empleadores=this.modelo.getEmpleadores();
			for(int i=0; i<empleadores.size();i++){
				empleador= empleadores.get(i);
				Object[] fila= {
					empleador.getNombreUsuario(),
				};
				this.emergenteListaDeEmpleados.getModeloTableListaEmpleado().addRow(fila);
			}
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
		else if(arg.equals("encuentros") || arg.equals("contrataciones")) {
            this.vista.actualizarVistaAdministrador((String) arg);
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
		this.vista.habilitarBotones();
		ModeloListaEmpleado modeloListaEmpleado= new ModeloListaEmpleado();
			
		if(this.modelo.getTicketEmpleado(usuario)!=null) {
			vista.getTicket().setText(this.modelo.getTicketEmpleado(usuario).toString());
			if(this.modelo.getListaDeAsignacion((UCliente)usuario)==null)
				this.vista.getBotonMirarLista().setEnabled(false);
		}
		else {
			vista.getTicket().setText("No tiene ticket creado aun. Para crear un ticket presione el boton Crear Ticket");
			this.vista.deshabilitarBotones();
		}
		vista.getListaEmpleadosPretensos().setModel(modeloListaEmpleado);
		vista.MenuPrincipalEmpleado();
	}
	
	public void InicioSesionEmpleador() {
		vista.Maximizar();
		this.vista.habilitarBotones();
		ModeloListaEmpleado modeloListaEmpleado= new ModeloListaEmpleado();
		
		
		if(this.modelo.getTicketEmpleador(usuario)!=null) {
			vista.getTicket().setText(this.modelo.getTicketEmpleador(usuario).toString());
			if(this.modelo.getListaDeAsignacion((UCliente)usuario)==null)
				this.vista.getBotonMirarLista().setEnabled(false);
		}
		else {
			vista.getTicket().setText("No tiene ticket creado.");
			this.vista.deshabilitarBotones();
		}
		
		vista.getListaEmpleadosPretensos().setModel(modeloListaEmpleado);
		vista.MenuPrincipalEmpleador();
	}
	
	
}
