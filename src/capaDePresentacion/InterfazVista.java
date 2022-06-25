package capaDePresentacion;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public interface InterfazVista {
	public void arranca(); //Se encarga de arrancar la visualizacion de la vista
	
	//Declaracion de constantes strings
	static final String LOGIN= "LOGIN";
	static final String REGISTRAR = "REGISTRAR";
	static final String UNIRSE = "UNIRSE";
	static final String EMPLEADOR = "EMPLEADOR";
	static final String EMPLEADO = "EMPLEADO";
	static final String SIGUIENTEEMPLEADOR = "SIGUIENTE";
	static final String SIGUIENTEEMPLEADO = "SIGUIENTEEMPLEADO";
	static final String NUEVOTICKETEMPLEADOR = "NUEVOTICKETEMPLEADOR";
	static final String NUEVOTICKETEMPLEADO = "NUEVOTICKETEMPLEADO";
	static final String SIMULADOR = "SIMULADOR";
	static final String RONDAENCUENTROS = "RONDAENCUENTROS";
	static final String RONDACONTRATACION = "RONDACONTRATACION";
	static final String VALORESREMUNERACION = "VALORESREMUNERACION";
	static final String ELEGIRTICKET = "ELEGIRTICKET";
	static final String CONFIRMARELEGIRTICKETEMPLEADO = "CONFIRMARELEGIRTICKETEMPLEADO";
	static final String MOSTRARLISTAEMPLEADO = "MOSTRARLISTAEMPLEADO";
	static final String MOSTRARLISTAEMPLEADOR = "MOSTRARLISTAEMPLEADOR";
	static final String CERRARSESION = "CERRARSESION";
	
	public void setActionListener(ControladorSistema controladorSistema);
	public void registroPasoUno();
	public void cambioALogin();
	public void registroPasoDos();
	public void registroEmpleador();
	public void registroEmpleado(); 
	public void ticketsEmpleador();
	public void ticketsEmpleado();
	public void MenuPrincipalEmpleador();
	public void MenuPrincipalEmpleado();
	public void NuevoTicketEmpleador();
	public void NuevoTicketEmpleado();
	public void simulador();
	public void pantallaPrincipal();
	public JList<String> getListaEmpleadosBolsaTrabajo();
	
	public JTextField getTextoUsuario() ;
	public JTextField getTextoUsuarioRegistro() ;
	public JTextField getTextoContraseña();
	public JTextField getTextoRepetirContraseña();
	public JTextField getTextoEmail();
	public JTextField getTextoNombre();
	public JTextField getTextoApellido();
	public JTextField getTextoEdad() ;
	public JTextField getTextoTelefono();
	public JTextField getTextoRubro();
	public JLabel getLabelErrorUsuario();
	public JLabel getLabelErrorContrasenia();
	public JList<String> getListaEmpleadosPretensos();
	public void Maximizar();
	public JTextArea getTicket();
	public void deshabilitarBotones();
	public void MenuPrincipalAdministrador();
	public void menuRondaEncuentros();
	public void menuRondaContratacion();
	public void menuValoresRemuneracion();
	public JTextField getTextovalorMinimo();
	public ButtonGroup getGrupoTipoPersona();
	public JTextArea getAcciones();
	public ButtonGroup getGrupoTipoRubro();
	public JTextField getTextovalorMaximo();
	public void elegirticket();
	public JComboBox<String> getComboBoxEstadoTickets();
	public void actualizar();
	public DefaultTableModel getModeloTableBolsaTrabajo();
	public DefaultTableModel getModeloTableListaEmpleado();
	public void mirarlistaEmpleado();
	public JLabel getLabelErrorUsuarioRepetido();
	public JPasswordField  getTextoContraseñaRegistro();
}
