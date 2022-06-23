package capaDePresentacion;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
	public JList<String> getListaEmpleadosBolsaTrabajo();
	public JList<String> getListaBolsaTrabajo() ;
	
	public JTextField getTextoUsuario() ;
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

	public ButtonGroup getGrupoTipoRubro();
	public JTextField getTextovalorMaximo();
}
