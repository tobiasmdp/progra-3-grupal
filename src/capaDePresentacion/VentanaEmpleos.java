package capaDePresentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import capaDeDatos.Empleador;
import capaDeNegocios.Agencia;

public class VentanaEmpleos extends JFrame implements InterfazVista,KeyListener,MouseListener{
	
	private JPanel panelPrincipal;
	private JPanel panelPrincipalNorte;
	private JPanel panelPrincipalCentral;
	private JPanel panelPrincipalSur;
	private JPanel panelLogo;
	private JPanel panelLogin;
	private JPanel panelVacio;
	private JPanel panelRegistro;
	private JPanel panelRegistroFormulario;
	private JPanel panelRegistroSur;
	private JPanel panelZonaBotonesRadialesHorizontalPersona;
	private JPanel panelZonaBotonesRadialesHorizontalRubro;
	private JPanel panelRegistroNorte;
	private JPanel panelMenuTicket;
	private JPanel panelTicket;
	private JPanel panelzonaRegistro;
	private JPanel panelzonaRegistro__titulo;
	private JPanel panelzonaRegistro__botones;
	private JPanel panelElegirTicket;
	private JPanel panelRegistroEmpleador;
	private JPanel panelRegistroEmpleado;
	private JPanel panelSimuladorNorte;
	private JPanel panelSimuladorCentral;
	private JPanel panelSimuladorSur;
	private JComboBox<String> ComboBoxEstadoTickets;
	private GridLayout gridPanelPrincipalSur = new GridLayout(0,2);

	private JTextArea acciones=new JTextArea();

	private DefaultTableModel modeloTableBolsaTrabajo= new DefaultTableModel();
	private JTable tableBolsaTrabajo = new JTable (modeloTableBolsaTrabajo);

	private JScrollPane scrollTableBolsaTrabajo = new JScrollPane(tableBolsaTrabajo);
	private JScrollPane scrollListaAcciones = new JScrollPane(acciones);
	private JList<String> ListaEmpleadosBolsaTrabajo = new JList<String>();
	private JList<String> ListaEmpleadosPretensos = new JList<String>();
	private JList<String> ListaEmpleadores = new JList<String>();
	private JList<String> ListaTicketEmpleado = new JList<String>();

	
	private JButton botonLogin;
	private JButton botonRegistro;
	private JButton botonunirse;
	private JButton botonEmpleador;
	private JButton botonEmpleado;
	private JButton botonSiguienteEmpleado;
	private JButton botonSiguienteEmpleador;
	private JButton botonSimulador;


	private JButton botonRondaEncuentros;
	private JButton botonRondaContratacion;
	private JButton botonCambiarValoresRemuneracion;

	private JButton botonCrearTicket;
	private JButton botonDarTicketBaja;
	private JButton botonConfirmaCambioTicket;
	private JButton botonModificarTicket;
	private JButton botonMirarLista;
	private JButton botonElegirTrabajo;
	private JButton botonVerResultados;
	private JButton botonCerrarSesion;
	
	private JRadioButton botontipoPersona1;
	private JRadioButton botontipoPersona2;
	private JRadioButton botonrubro1;
	private JRadioButton botonrubro2;
	private JRadioButton botonrubro3;
	
	private ButtonGroup grupoTipoPersona;
	private JTextField textoUsuario;
	private JTextField textoUsuarioRegistro;
	private JPasswordField textoContraseña;
	private JPasswordField textoContraseñaRegistro;
	private JTextField textoRepetirContraseña;
	private JTextField textoEmail;
	private JTextField textoNombre;
	private JTextField textoApellido;
	private JTextField textoEdad;
	private JTextField textoTelefono;
	private JTextField textoRubro;
	
	private JTextField textoEdadPretendida;
	private JTextField textoCargaHoraria;
	private JTextField textoLocacion;
	private JTextField textoTipodePuesto;
	private JTextField textoRemuneracion;
	private JTextField textoEstudiosCursados;
	private JTextField textoExperienciaPrevia;
	
	private JTextField textoPesoEdadPretendida;
	private JTextField textoPesoCargaHoraria;
	private JTextField textoPesoLocacion;
	private JTextField textoPesoTipodePuesto;
	private JTextField textoPesoRemuneracion;
	private JTextField textoPesoEstudiosCursados;
	private JTextField textoPesoExperienciaPrevia;
	

	private JTextArea ticket;
	

	private JTextField textovalorMinimo;
	private JTextField textovalorMaximo;
	private JLabel labelvalorMinimo;
	private JLabel labelvalorMaximo;

	private JLabel labelElegirTicket;
	private JLabel labelRegistro;
	private JLabel labelUsuario;
	private JLabel labelErrorUsuario;
	private JLabel labelContrasenia;
	private JLabel labelErrorContrasenia;
	private JLabel labelEmail;
	private JLabel labelRepetirContrasenia;
	private JLabel labelcambioRegistro;
	private JLabel logoEmpresa;
	private JLabel label__titulo;
	private JLabel label__subtitulo;
	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelTelefono;
	private JLabel labelRubro;
	private JLabel labelTipodePersona;
	private JLabel labelTicket;
	private JLabel labelErrorUsuarioRepetido;

	private JLabel labelSimulador__empleados;
	private JLabel labelSimulador__bolsaTrabajo;
	private JLabel labelSimulador__acciones;
	
	private JLabel labelEdad;
	private JLabel labelCargaHoraria;
	private JLabel labelLocacion;
	private JLabel labelTipodePuesto;
	private JLabel labelRemuneracion;
	private JLabel labelEstudiosCursados;
	private JLabel labelExperienciaPrevia;
	
	private JLabel labelPesoEdad;
	private JLabel labelPesoCargaHoraria;
	private JLabel labelPesoLocacion;
	private JLabel labelPesoTipodePuesto;
	private JLabel labelPesoRemuneracion;
	private JLabel labelPesoEstudiosCursados;
	private JLabel labelPesoExperienciaPrevia;
	
	private Dimension D500x300= new Dimension(500,300);
	private Dimension D700x500= new Dimension(700,700);
	private Dimension D1024x768= new Dimension(1024,768);
	private ButtonGroup grupoTipoRubro;
	public VentanaEmpleos() {

		
		setPreferredSize(D1024x768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JobsProg: La mejor interfaz de empleo!");
		this.setResizable(false); 
		setLayout(null);
		
		this.InicializarPaneles();
		
		this.botonunirse = new JButton("Registrarme");
		this.botonEmpleador = new JButton("Soy empresa");
		this.botonEmpleador.setFont(new Font("Arial",Font.PLAIN,20));
		this.botonEmpleado = new JButton("Soy empleado");
		this.botonEmpleado.setFont(new Font("Arial",Font.PLAIN,20));
		this.botonSiguienteEmpleado = new JButton("Continuar");
		this.botonSiguienteEmpleador = new JButton("Continuar");
		
		this.botonRondaEncuentros=new JButton("Ejecutar Ronda de encuentros laborales");
		this.botonRondaContratacion=new JButton("Ejecutar Ronda de contrataciones");
		this.botonCambiarValoresRemuneracion=new JButton("Cambiar valores de rango de remuneracion");
		
		this.botontipoPersona1= new JRadioButton("Persona fisica",false);
		this.botontipoPersona2= new JRadioButton("Persona juridica",false);
		this.botonrubro1= new JRadioButton("Salud",false);
		this.botonrubro2= new JRadioButton("Comercio Internacional",false);
		this.botonrubro3= new JRadioButton("Comercio local",false);
		
		this.logoEmpresa= new JLabel(new ImageIcon("LogoJobsProg.jpg"));
		
		this.ComboBoxEstadoTickets=new JComboBox<String>();
		this.ComboBoxEstadoTickets.setBounds(10,10,80,20);
		this.ComboBoxEstadoTickets.addItem("Cancelado");
		this.ComboBoxEstadoTickets.addItem("Activo");
		
		this.labelUsuario= new JLabel();
		this.textoUsuario = new JTextField();
		this.textoUsuarioRegistro = new JTextField();
		this.labelErrorUsuario= new JLabel();
		this.labelContrasenia= new JLabel();
		this.textoContraseña = new JPasswordField();
		this.textoContraseñaRegistro = new JPasswordField();
		this.labelErrorContrasenia= new JLabel();
		this.panelVacio=new JPanel();
		this.botonLogin = new JButton("Iniciar Sesion");
		this.labelcambioRegistro= new JLabel();
		this.botonRegistro = new JButton("Registrarse");
		this.botonSimulador = new JButton("Ir al simulador");
		this.botonSimulador.setActionCommand(SIMULADOR);
		this.labelSimulador__empleados= new JLabel();
		this.labelSimulador__bolsaTrabajo= new JLabel();
		this.labelSimulador__acciones= new JLabel();
		this.labelNombre= new JLabel();
		this.labelNombre.setText("Nombre o Razon social");
		this.labelApellido= new JLabel();
		this.labelApellido.setText("Apellido");
		this.labelTelefono= new JLabel();
		this.labelTelefono.setText("Telefono");
		this.labelRubro= new JLabel();
		this.labelRubro.setText("Rubro");
		this.labelTipodePersona= new JLabel();
		this.labelTipodePersona.setText("Tipo de persona");
		this.labelEdad= new JLabel();
		this.labelEdad.setText("Edad");
		this.labelErrorUsuarioRepetido= new JLabel();
		this.labelErrorUsuarioRepetido.setText("El nombre de usuario no esta disponible");
		this.textoEdad=new JTextField();
		this.textoNombre=new JTextField();
		this.textoApellido=new JTextField();
		this.textoTelefono=new JTextField();
		this.textoRubro=new JTextField();
		this.textoEmail = new JTextField();

		this.label__titulo= new JLabel();
		this.label__subtitulo= new JLabel();
		this.label__titulo.setFont(new Font("Arial",Font.PLAIN,30));
		this.label__titulo.setHorizontalAlignment(JLabel.CENTER);
		this.label__titulo.setHorizontalAlignment(JLabel.CENTER);
		this.label__subtitulo.setFont(new Font("Arial",Font.PLAIN,17));
		this.textovalorMinimo= new JTextField();
		this.textovalorMaximo= new JTextField();
		this.labelvalorMinimo= new JLabel();
		this.labelvalorMaximo= new JLabel();
		this.labelElegirTicket= new JLabel();
		

		this.ticket= new JTextArea();
		this.ticket.setEditable(false);
		this.acciones.setEditable(false);
		this.labelCargaHoraria= new JLabel();
		this.labelLocacion= new JLabel();
		this.labelTipodePuesto= new JLabel();
		this.labelRemuneracion= new JLabel();
		this.labelEstudiosCursados= new JLabel();
		this.labelExperienciaPrevia= new JLabel();
		this.labelTicket= new JLabel();
		
		this.textoEdadPretendida= new JTextField();
		this.textoCargaHoraria= new JTextField();
		this.textoLocacion= new JTextField();
		this.textoTipodePuesto= new JTextField();
		this.textoRemuneracion= new JTextField();
		this.textoEstudiosCursados= new JTextField();
		this.textoExperienciaPrevia= new JTextField();
		this.textoRepetirContraseña = new JPasswordField();
		this.botonCrearTicket = new JButton("Crear Ticket de busqueda ");
		this.botonDarTicketBaja = new JButton("Dar ticket de baja");
		this.botonConfirmaCambioTicket = new JButton("Aceptar cambios");
		this.botonModificarTicket = new JButton("Cambiar estado del ticket");
		this.botonMirarLista = new JButton("Mirar lista");
		this.botonElegirTrabajo = new JButton("Elegir Trabajo");
		this.botonVerResultados = new JButton("Ver resultados");
		this.botonCerrarSesion = new JButton("Cerrar Sesion");
		this.botonCrearTicket.setFont(new Font("Arial",Font.PLAIN,15));
		this.botonDarTicketBaja.setFont(new Font("Arial",Font.PLAIN,15));
		this.botonConfirmaCambioTicket.setFont(new Font("Arial",Font.PLAIN,15));
		this.botonModificarTicket.setFont(new Font("Arial",Font.PLAIN,15));
		this.botonMirarLista.setFont(new Font("Arial",Font.PLAIN,15));
		this.botonElegirTrabajo.setFont(new Font("Arial",Font.PLAIN,15));
		this.botonVerResultados.setFont(new Font("Arial",Font.PLAIN,15));
		this.botonCerrarSesion.setFont(new Font("Arial",Font.PLAIN,15));
		this.botonCrearTicket.setEnabled(false);
		this.botonCerrarSesion.setAlignmentX(JLabel.TRAILING);

		this.botonCerrarSesion.setActionCommand(CERRARSESION);
		this.pantallaPrincipal();
		this.arranca();
	}
	
	public void InicializarPaneles() {
		this.panelPrincipal = new JPanel();
		setContentPane(this.panelPrincipal);
		this.panelPrincipal.setLayout(new BorderLayout());
		this.panelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelPrincipal.setBackground(Color.white);
		
		this.panelLogo = new JPanel();
		this.panelLogin = new JPanel();
		this.panelzonaRegistro=new JPanel();
		this.panelTicket=new JPanel();
		this.panelPrincipalNorte=new JPanel();
		this.panelPrincipalSur=new JPanel();
		this.panelPrincipalCentral=new JPanel();
		this.panelSimuladorNorte= new JPanel();
		this.panelSimuladorCentral= new JPanel();
		this.panelSimuladorSur= new JPanel();
		this.panelElegirTicket= new JPanel();
		this.panelZonaBotonesRadialesHorizontalPersona=new JPanel();
		this.panelZonaBotonesRadialesHorizontalPersona.setBackground(Color.white);
		this.panelZonaBotonesRadialesHorizontalRubro=new JPanel();
		this.panelZonaBotonesRadialesHorizontalRubro.setBackground(Color.white);
		this.panelPrincipalNorte.setBackground(Color.white);
		this.panelPrincipalSur.setBackground(Color.white);
		this.panelPrincipalCentral.setBackground(Color.white);
		this.panelPrincipalNorte.setBorder(new EmptyBorder(40, 40, 20, 40));
		this.panelPrincipalCentral.setBorder(new EmptyBorder(20, 40, 20, 40));
		this.panelPrincipalSur.setBorder(new EmptyBorder(20, 40, 40, 40));
		this.gridPanelPrincipalSur.setHgap(100);
		this.gridPanelPrincipalSur.setVgap(10);
	}
	
	public void pantallaPrincipal(){
		this.panelPrincipal.removeAll();
		this.panelPrincipalNorte.removeAll();
		this.panelPrincipalSur.removeAll();
		this.panelPrincipalCentral.removeAll();
	
		this.panelPrincipalNorte.setLayout(new BorderLayout());
		this.panelPrincipalNorte.add(botonSimulador,BorderLayout.NORTH);
		this.panelPrincipalNorte.add(panelLogo,BorderLayout.CENTER);
		
		
		this.panelLogo.setLayout(new GridLayout(0,1));
		this.panelLogo.setVisible(true);
		panelLogo.setBackground(Color.white);
		this.panelLogo.setPreferredSize(new Dimension(700,350));
		
		this.panelLogin.setLayout(new GridLayout(0,1));
		this.panelLogin.setVisible(true);
		panelLogin.setBackground(Color.white);

		this.logoEmpresa.setEnabled(true);
		this.panelLogo.add(this.logoEmpresa);
		
		this.labelUsuario.setText("Nombre de usuario");
		this.labelUsuario.setEnabled(true);
		this.panelLogin.add(this.labelUsuario);
		
		this.panelLogin.add(this.textoUsuario);
		
		this.labelErrorUsuario.setText("Nombre de usuario incorrecto. ");
		this.labelErrorUsuario.setForeground(Color.red);
		this.labelErrorUsuario.setVisible(false);
		this.panelLogin.add(this.labelErrorUsuario);
		
		this.labelContrasenia.setText("Contraseña");
		this.labelContrasenia.setEnabled(true);
		this.panelLogin.add(this.labelContrasenia);
		
		this.panelLogin.add(this.textoContraseña);
	
		this.labelErrorContrasenia.setText("Contraseña incorrecta. ");
		this.labelErrorContrasenia.setVisible(false);
		this.labelErrorContrasenia.setForeground(Color.red);
		this.panelLogin.add(this.labelErrorContrasenia);
		
		this.panelLogin.add(this.panelVacio);
		this.panelVacio.setBackground(Color.white);
		
		this.botonLogin.setActionCommand(LOGIN);
		this.botonLogin.setEnabled(true);
		this.panelLogin.add(this.botonLogin);
		this.botonLogin.setMnemonic(KeyEvent.VK_SHIFT);
		
		this.labelcambioRegistro.setText("No estas registrado? ");
		this.panelLogin.add(this.labelcambioRegistro);
		
		this.botonRegistro.setEnabled(true);
		this.botonRegistro.setActionCommand(REGISTRAR);
		this.panelLogin.add(this.botonRegistro);

		this.panelPrincipal.add(panelPrincipalNorte,BorderLayout.NORTH);
		this.panelPrincipal.add(panelLogin,BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	
	@Override
	public void arranca() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.white);
	}

	@Override
	public void setActionListener(ControladorSistema controladorSistema) {
		this.botonRegistro.addActionListener(controladorSistema);
		this.botonLogin.addActionListener(controladorSistema);
		this.botonLogin.addKeyListener(controladorSistema);
		this.botonSimulador.addActionListener(controladorSistema);
		this.textoUsuario.addKeyListener(controladorSistema);
		this.textoContraseña.addKeyListener(controladorSistema);
		this.textoContraseñaRegistro.addKeyListener(controladorSistema);
		this.botonunirse.addActionListener(controladorSistema);
		this.botonEmpleado.addActionListener(controladorSistema);
		this.botonEmpleador.addActionListener(controladorSistema);
		this.botonSiguienteEmpleado.addActionListener(controladorSistema);
		this.botonSiguienteEmpleador.addActionListener(controladorSistema);
		this.botonCrearTicket.addActionListener(controladorSistema);
		this.botonDarTicketBaja.addActionListener(controladorSistema);
		this.botonConfirmaCambioTicket.addActionListener(controladorSistema);
		this.botonModificarTicket.addActionListener(controladorSistema);
		this.botonMirarLista.addActionListener(controladorSistema);
		this.botonElegirTrabajo.addActionListener(controladorSistema);
		this.botonVerResultados.addActionListener(controladorSistema);
		this.botonCerrarSesion.addActionListener(controladorSistema);
		this.botonRondaEncuentros.addActionListener(controladorSistema);
		this.botonRondaContratacion.addActionListener(controladorSistema);
		this.botonCambiarValoresRemuneracion.addActionListener(controladorSistema);
		this.textoUsuarioRegistro.addKeyListener(this);
		this.textoUsuario.addKeyListener(this);
		this.textoContraseña.addKeyListener(this);
		this.textoContraseñaRegistro.addKeyListener(this);
		this.textoRepetirContraseña.addKeyListener(this);
		this.textoEmail.addKeyListener(this);
		this.textoNombre.addKeyListener(this);
		this.textoApellido.addKeyListener(this);
		this.textoTelefono.addKeyListener(this);
		this.textoEdad.addKeyListener(this);

		this.botontipoPersona1.addMouseListener(this);
		this.botontipoPersona2.addMouseListener(this);
		this.botontipoPersona1.setActionCommand("Fisica");
		this.botontipoPersona2.setActionCommand("Juridica");
		this.botonrubro1.setActionCommand("Salud");
		this.botonrubro2.setActionCommand("Comercio internacional");
		this.botonrubro3.setActionCommand("Comercio local");
		
	}
	
	@Override
	public void registroPasoUno() {
		this.panelPrincipal.removeAll();
		
		//VISTA DE REGISTRO
				this.panelRegistro=new JPanel();
				this.panelRegistro.setBackground(Color.white);
				this.panelRegistro.setVisible(true);
				this.panelRegistro.setLayout(new BorderLayout());
				
				this.panelRegistroFormulario=new JPanel();
				this.panelRegistroFormulario.setBackground(Color.white);
				this.panelRegistroFormulario.setVisible(true);
				this.panelRegistroFormulario.setLayout(new GridLayout(0,1));
				
				this.panelRegistroNorte=new JPanel();
				this.panelRegistroNorte.setBackground(Color.white);
				this.panelRegistroNorte.setVisible(true);
				this.panelRegistroNorte.setLayout(new GridLayout(0,1));

				this.label__titulo.setText("Regístrate");
				this.label__subtitulo.setText("Completá los siguientes datos:");
				
				this.panelRegistroSur=new JPanel();
				this.panelRegistroSur.setBackground(Color.white);
				this.panelRegistroSur.setVisible(true);
				this.panelRegistroSur.setLayout(new FlowLayout());
				
				this.labelRepetirContrasenia= new JLabel();
				this.labelRepetirContrasenia.setText("Repetir contraseña");

				this.labelEmail= new JLabel();
				this.labelEmail.setText("Email");
				
				
				this.textoRepetirContraseña.setColumns(10);
				
				this.textoEmail.setColumns(10);
				
				this.botonunirse.setEnabled(false);
				this.botonunirse.setActionCommand(UNIRSE);
				this.botonunirse.setMinimumSize(new Dimension(20,20));
				this.botonunirse.setMaximumSize(new Dimension(20,60));
				this.botonunirse.setPreferredSize(new Dimension(150,30));
				
				this.panelRegistro.add(panelRegistroFormulario,BorderLayout.CENTER);
				this.panelRegistro.add(panelRegistroSur,BorderLayout.SOUTH);
				this.panelRegistro.add(panelRegistroNorte,BorderLayout.NORTH);
				
				this.panelRegistroNorte.add(label__titulo);
				this.panelRegistroNorte.add(label__subtitulo);
				this.panelRegistroFormulario.add(this.labelUsuario);
				this.panelRegistroFormulario.add(textoUsuarioRegistro);
				this.panelRegistroFormulario.add(this.labelErrorUsuarioRepetido);
				this.labelErrorUsuarioRepetido.setVisible(false);
				this.labelErrorUsuarioRepetido.setForeground(Color.red);
				this.panelRegistroFormulario.add(this.labelContrasenia);
				this.panelRegistroFormulario.add(textoContraseñaRegistro);
				this.panelRegistroFormulario.add(this.labelRepetirContrasenia);
				this.panelRegistroFormulario.add(textoRepetirContraseña);
				this.panelRegistroFormulario.add(this.labelEmail);
				this.panelRegistroFormulario.add(this.textoEmail);
				this.panelRegistroSur.add(this.botonunirse);
				
				
				this.panelPrincipal.add(panelRegistro);
				this.panelPrincipal.setVisible(true);
		revalidate();
		repaint();
	}
	
	@Override
	public void registroPasoDos() {
		this.panelPrincipal.removeAll();
		this.panelzonaRegistro.setLayout(new BorderLayout());
		this.panelzonaRegistro.setVisible(true);
		//*VISTA DE REGISTRO LUEGO DE MI USUARIO Y CONTRASEñA
				
		
				//SUBPANEL 1
				this.panelzonaRegistro__titulo=new JPanel();
				this.panelzonaRegistro__titulo.setBackground(Color.white);
				this.panelzonaRegistro__titulo.setLayout(new BorderLayout());
				this.panelzonaRegistro.add(this.panelzonaRegistro__titulo,BorderLayout.NORTH);
				
				//SUBPANEL 2
				this.panelzonaRegistro__botones=new JPanel();
				this.panelzonaRegistro__botones.setBackground(Color.white);
				this.panelzonaRegistro__botones.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
				this.panelzonaRegistro.add(panelzonaRegistro__botones,BorderLayout.SOUTH);
				
				//ELEMENTOS PANEL1
				this.label__titulo.setText("Completá los siguientes datos");
				
				this.panelzonaRegistro__titulo.add(label__titulo,BorderLayout.NORTH);
				
				this.label__subtitulo.setText("¿Que estas buscando?");
				this.panelzonaRegistro__titulo.add(label__subtitulo,BorderLayout.SOUTH);
				this.panelzonaRegistro.add(this.label__subtitulo);
			
				//ELEMENTOS PANEL2
				this.botonEmpleador.setActionCommand(EMPLEADOR);
				this.botonEmpleador.setEnabled(true);
				this.panelzonaRegistro__botones.add(this.botonEmpleador,BorderLayout.EAST);
				this.botonEmpleador.setMinimumSize(new Dimension(30,30));
				this.botonEmpleador.setMaximumSize(new Dimension(200,200));
				this.botonEmpleador.setPreferredSize(new Dimension(200,200));
				
				this.botonEmpleado.setActionCommand(EMPLEADO);
				this.botonEmpleado.setEnabled(true);
				this.botonEmpleado.setMinimumSize(new Dimension(30,30));
				this.botonEmpleado.setMaximumSize(new Dimension(200,200));
				this.botonEmpleado.setPreferredSize(new Dimension(200,200));
		
				this.panelzonaRegistro__botones.add(this.botonEmpleado,BorderLayout.WEST);
		this.panelzonaRegistro.add(panelzonaRegistro__titulo,BorderLayout.NORTH);
		this.panelzonaRegistro.add(panelzonaRegistro__botones,BorderLayout.SOUTH);
		
		this.panelPrincipal.add(panelzonaRegistro);
		revalidate();
		repaint();
	}
	@Override
	public void registroEmpleador() {
		this.panelPrincipal.removeAll();
		this.panelRegistroEmpleador=new JPanel();
		this.panelRegistroEmpleador.setBackground(Color.white);
		this.panelRegistroEmpleador.setLayout(new BorderLayout());
		//RESETEOS
		this.panelzonaRegistro__titulo.removeAll();
		this.panelRegistroFormulario.removeAll();
		this.panelzonaRegistro__botones.removeAll();
		//AGREGAR ELEMENTOS
		this.labelEdad.setText("Edad");
		this.label__titulo.setText("Completá los siguientes datos");
		this.panelzonaRegistro__titulo.add(label__titulo,BorderLayout.NORTH);
		this.label__subtitulo.setText("Necesitamos que completes tus datos");
		this.panelzonaRegistro__titulo.add(label__subtitulo,BorderLayout.SOUTH);
		
		this.botontipoPersona1.setBackground(Color.white);
		this.botontipoPersona2.setBackground(Color.white);

		this.botonrubro1.setBackground(Color.white);
		this.botonrubro2.setBackground(Color.white);
		this.botonrubro3.setBackground(Color.white);
		this.grupoTipoPersona=new ButtonGroup();
		this.grupoTipoRubro=new ButtonGroup();
		this.grupoTipoRubro.add(botonrubro1);
		this.grupoTipoRubro.add(botonrubro2);
		this.grupoTipoRubro.add(botonrubro3);
		this.grupoTipoPersona.add(botontipoPersona1);
		this.grupoTipoPersona.add(botontipoPersona2);
		
		this.panelZonaBotonesRadialesHorizontalPersona.setLayout(new GridLayout(0,2));
		this.panelZonaBotonesRadialesHorizontalRubro.setLayout(new GridLayout(0,3));
		
		this.panelZonaBotonesRadialesHorizontalPersona.add(botontipoPersona1);
		this.panelZonaBotonesRadialesHorizontalPersona.add(botontipoPersona2);
		this.panelZonaBotonesRadialesHorizontalRubro.add(botonrubro1);
		this.panelZonaBotonesRadialesHorizontalRubro.add(botonrubro2);
		this.panelZonaBotonesRadialesHorizontalRubro.add(botonrubro3);
		this.botonSiguienteEmpleador.setActionCommand(SIGUIENTEEMPLEADOR);
		
		this.botontipoPersona1.setHorizontalAlignment(JLabel.CENTER);
		this.botontipoPersona2.setHorizontalAlignment(JLabel.CENTER);
		this.botonrubro1.setHorizontalAlignment(JLabel.CENTER);
		this.botonrubro2.setHorizontalAlignment(JLabel.CENTER);
		this.botonrubro3.setHorizontalAlignment(JLabel.CENTER);
		
		this.panelRegistroFormulario.add(labelNombre);
		this.panelRegistroFormulario.add(textoNombre);
		this.panelRegistroFormulario.add(labelTelefono);
		this.panelRegistroFormulario.add(textoTelefono);
		this.panelRegistroFormulario.add(labelRubro);
		this.panelRegistroFormulario.add(panelZonaBotonesRadialesHorizontalRubro);
		this.panelRegistroFormulario.add(labelTipodePersona);
		this.panelRegistroFormulario.add(panelZonaBotonesRadialesHorizontalPersona);
		this.panelzonaRegistro__botones.add(botonSiguienteEmpleador);

		this.panelRegistroEmpleador.add(panelzonaRegistro__titulo,BorderLayout.NORTH);
		this.panelRegistroEmpleador.add(panelRegistroFormulario,BorderLayout.CENTER);
		this.panelRegistroEmpleador.add(panelzonaRegistro__botones,BorderLayout.SOUTH);
		
		this.panelPrincipal.add(panelRegistroEmpleador);
		revalidate();
		repaint();
		
	}
	@Override
	public void registroEmpleado() {
		this.panelPrincipal.removeAll();
		this.panelRegistroEmpleador=new JPanel();
		this.panelRegistroEmpleador.setBackground(Color.white);
		this.panelRegistroEmpleador.setLayout(new BorderLayout());
		//RESETEOS
		this.panelzonaRegistro__titulo.removeAll();
		this.panelRegistroFormulario.removeAll();
		this.panelzonaRegistro__botones.removeAll();
		//AGREGAR ELEMENTOS
		this.label__titulo.setText("Completá los siguientes datos");
		this.panelzonaRegistro__titulo.add(label__titulo,BorderLayout.NORTH);
		this.label__subtitulo.setText("Necesitamos que completes tus datos");
		this.panelzonaRegistro__titulo.add(label__subtitulo,BorderLayout.SOUTH);
		

		this.labelNombre.setText("Nombre");
		
		this.botonSiguienteEmpleado.setActionCommand(SIGUIENTEEMPLEADO);
		
		
		this.panelRegistroFormulario.add(labelNombre);
		this.panelRegistroFormulario.add(textoNombre);
		this.panelRegistroFormulario.add(labelApellido);
		this.panelRegistroFormulario.add(textoApellido);
		this.panelRegistroFormulario.add(labelTelefono);
		this.panelRegistroFormulario.add(textoTelefono);
		this.panelRegistroFormulario.add(labelEdad);
		this.panelRegistroFormulario.add(textoEdad);
		this.panelzonaRegistro__botones.add(botonSiguienteEmpleado);

		this.panelRegistroEmpleador.add(panelzonaRegistro__titulo,BorderLayout.NORTH);
		this.panelRegistroEmpleador.add(panelRegistroFormulario,BorderLayout.CENTER);
		this.panelRegistroEmpleador.add(panelzonaRegistro__botones,BorderLayout.SOUTH);
		
		this.panelPrincipal.add(panelRegistroEmpleador);
		revalidate();
		repaint();
		
		
	}
	

	@Override
	public void MenuPrincipalEmpleador() {
		this.panelPrincipal.removeAll();
		this.panelPrincipalNorte.removeAll();
		this.panelPrincipalSur.removeAll();
		this.panelPrincipalCentral.removeAll();

		this.panelPrincipalNorte.setLayout(new BorderLayout());
		this.panelPrincipalCentral.setLayout(new BorderLayout());
		this.panelPrincipalSur.setLayout(gridPanelPrincipalSur);
		
		this.botonCerrarSesion.setPreferredSize(new Dimension(180,30));
		this.label__titulo.setText("Pagina empleador");
		this.panelPrincipalNorte.add(botonCerrarSesion,BorderLayout.EAST);
		this.panelPrincipalNorte.add(label__titulo,BorderLayout.CENTER);
		this.botonMirarLista.setActionCommand(MOSTRARLISTAEMPLEADO);
		this.botonModificarTicket.setActionCommand(ELEGIRTICKETEMPLEADOR);
		this.labelTicket.setText("Ticket de busqueda de empleados");
		this.ticket.setBackground(Color.lightGray);
		this.ticket.setPreferredSize(D500x300);
		this.panelPrincipalCentral.add(labelTicket,BorderLayout.NORTH);
		this.panelPrincipalCentral.add(ticket,BorderLayout.CENTER);	
		this.panelPrincipalSur.add(botonModificarTicket);
		this.panelPrincipalSur.add(botonMirarLista);
		this.panelPrincipalSur.add(botonElegirTrabajo);
		this.panelPrincipalSur.add(botonVerResultados);
		this.panelPrincipalSur.add(botonCrearTicket);
		this.panelPrincipal.add(panelPrincipalNorte,BorderLayout.NORTH);
		this.panelPrincipal.add(panelPrincipalCentral,BorderLayout.CENTER);
		this.panelPrincipal.add(panelPrincipalSur,BorderLayout.SOUTH);
		this.panelPrincipalSur.setBorder(new EmptyBorder(20, 200, 40, 200));

		revalidate();
		repaint();
	}
	//*MENUEMPLEADO
	
	@Override
	public void MenuPrincipalEmpleado() {
		this.panelPrincipal.removeAll();
		this.panelPrincipalNorte.removeAll();
		this.panelPrincipalSur.removeAll();
		this.panelPrincipalCentral.removeAll();
		setPreferredSize(D1024x768);


		this.panelPrincipalNorte.setLayout(new BorderLayout());
		this.panelPrincipalCentral.setLayout(new BorderLayout());
		this.panelPrincipalSur.setLayout(gridPanelPrincipalSur);
		
		this.botonCerrarSesion.setPreferredSize(new Dimension(180,30));
		this.label__titulo.setText("Pagina empleado");
		this.panelPrincipalNorte.add(botonCerrarSesion,BorderLayout.EAST);
		this.panelPrincipalNorte.add(label__titulo,BorderLayout.CENTER);

		this.botonMirarLista.setActionCommand(MOSTRARLISTAEMPLEADOR);
		this.botonModificarTicket.setActionCommand(ELEGIRTICKETEMPLEADO);
		this.labelTicket.setText("Ticket de busqueda de empleado");
		this.ticket.setBackground(Color.lightGray);
		this.panelPrincipalCentral.add(labelTicket,BorderLayout.NORTH);
		this.panelPrincipalCentral.add(ticket,BorderLayout.CENTER);	
		this.panelPrincipalCentral.setPreferredSize(D500x300);
		this.panelPrincipalSur.add(botonModificarTicket);
		this.panelPrincipalSur.add(botonMirarLista);
		this.panelPrincipalSur.add(botonElegirTrabajo);
		this.panelPrincipalSur.add(botonVerResultados);
		this.panelPrincipalSur.add(botonCrearTicket);
		this.panelPrincipalSur.setVisible(true);
		this.panelPrincipalNorte.setVisible(true);
		this.panelPrincipal.add(panelPrincipalNorte,BorderLayout.NORTH);
		this.panelPrincipal.add(panelPrincipalCentral,BorderLayout.CENTER);
		this.panelPrincipal.add(panelPrincipalSur,BorderLayout.SOUTH);
		this.panelPrincipalSur.setBorder(new EmptyBorder(20, 200, 40, 200));
		revalidate();
		repaint();
		
	}
	@Override
	public void elegirticket() {
		this.botonConfirmaCambioTicket.setActionCommand(CONFIRMARELEGIRTICKETEMPLEADO);
		this.labelElegirTicket.setText("Cambia el estado de tu ticket");
		this.labelElegirTicket.setVisible(true);

		this.botonConfirmaCambioTicket.setPreferredSize(new Dimension(20,10));

		this.labelElegirTicket.setFont(new Font("Arial",Font.PLAIN,20));
		revalidate();
		repaint();
	}

	//*MENUADMINISTRADOR
	@Override
	public void MenuPrincipalAdministrador() {
		this.panelPrincipal.removeAll();
		this.panelPrincipalCentral.removeAll();
		this.panelPrincipalNorte.removeAll();

		botonRondaEncuentros.setActionCommand(RONDAENCUENTROS);
		botonRondaContratacion.setActionCommand(RONDACONTRATACION);
		botonCambiarValoresRemuneracion.setActionCommand(VALORESREMUNERACION);
		
		this.panelPrincipalNorte.setLayout(new BorderLayout());
		this.botonCerrarSesion.setPreferredSize(new Dimension(180,30));
		this.label__titulo.setText("Administrador");
		this.panelPrincipalNorte.add(botonCerrarSesion,BorderLayout.EAST);
		this.panelPrincipalNorte.add(label__titulo,BorderLayout.CENTER);
		
		this.textovalorMinimo= new JTextField();
		this.textovalorMaximo= new JTextField();
		this.labelvalorMinimo.setText("Limite Inferior de remuneracion");		
		this.labelvalorMaximo.setText("Limite Superior de remuneracion");	
		
		this.panelPrincipalCentral.setLayout(new GridLayout(0,1));
		this.panelPrincipalCentral.add(botonRondaEncuentros);
		this.panelPrincipalCentral.add(botonRondaContratacion);
		this.panelPrincipalCentral.add(botonCambiarValoresRemuneracion);
		this.panelPrincipalCentral.add(labelvalorMinimo);
		this.panelPrincipalCentral.add(textovalorMinimo);
		this.panelPrincipalCentral.add(labelvalorMaximo);
		this.panelPrincipalCentral.add(textovalorMaximo);

		this.panelPrincipalCentral.setVisible(true);
		this.panelPrincipal.add(panelPrincipalNorte,BorderLayout.NORTH);
		this.panelPrincipal.add(panelPrincipalCentral,BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	
	
	
	@Override
	public void ticketsEmpleador() {
		this.panelPrincipal.removeAll();
		this.panelTicket.removeAll();
	
		
		this.panelPrincipal.add(this.panelTicket);
		revalidate();
		repaint();
	}
	@Override
	public void ticketsEmpleado() {
		this.panelPrincipal.removeAll();
		this.panelTicket.removeAll();
		
		this.panelPrincipal.add(this.panelTicket);
		revalidate();
		repaint();
		
	}
	

	
	@Override
	public void NuevoTicketEmpleador() {
		this.panelPrincipal.removeAll();
		this.label__titulo.setText("Crea tu ticket");
		this.label__subtitulo.setText("Para la creacion del ticket te pedimos que coloques las caracteristicas del puesto a ofrecer:");
		
		this.labelLocacion.setText("Locacion");
		this.labelRemuneracion.setText("Remuneracion");
		this.labelCargaHoraria.setText("Carga horaria");
		this.labelTipodePuesto.setText("Tipo de puesto");
		this.labelExperienciaPrevia.setText("Experiencia Previa");
		this.labelEdad.setText("Rango Etario");
		this.labelEstudiosCursados.setText("Estudios cursados");
		
		this.panelPrincipalCentral.add(labelLocacion);
		this.panelPrincipalCentral.add(textoLocacion);
		this.panelPrincipalCentral.add(labelRemuneracion);
		this.panelPrincipalCentral.add(textoRemuneracion);
		this.panelPrincipalCentral.add(labelCargaHoraria);
		this.panelPrincipalCentral.add(textoCargaHoraria);
		this.panelPrincipalCentral.add(labelTipodePuesto);
		this.panelPrincipalCentral.add(textoTipodePuesto);
		this.panelPrincipalCentral.add(labelExperienciaPrevia);
		this.panelPrincipalCentral.add(textoExperienciaPrevia);
		this.panelPrincipalCentral.add(labelEdad);
		this.panelPrincipalCentral.add(textoEdadPretendida);
		this.panelPrincipalCentral.add(labelEstudiosCursados);
		this.panelPrincipalCentral.add(textoEstudiosCursados);
		
		this.panelPrincipalNorte.add(this.label__titulo);
		this.panelPrincipalNorte.add(this.label__subtitulo);
		
		this.panelPrincipalNorte.setVisible(true);
		this.panelPrincipalCentral.setVisible(true);
		
		this.panelPrincipal.add(this.panelPrincipalNorte,BorderLayout.NORTH);
		this.panelPrincipal.add(this.panelPrincipalCentral,BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	@Override
	public void NuevoTicketEmpleado() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deshabilitarBotones() {
		this.botonModificarTicket.setEnabled(false);
		this.botonMirarLista.setEnabled(false);
		this.botonElegirTrabajo.setEnabled(false);
		this.botonVerResultados.setEnabled(false);
		this.botonCrearTicket.setEnabled(true);
		
	}
	
	@Override
	public void menuRondaEncuentros() {
		
	}

	@Override
	public void menuRondaContratacion() {
		
	}

	@Override
	public void menuValoresRemuneracion() {
		
	}
	
	
	@Override
	public void cambioALogin() {
		
		
	}
	@Override
	public void simulador() {
		
		
		this.scrollTableBolsaTrabajo.setPreferredSize(new Dimension(900,300));
		this.scrollListaAcciones.setPreferredSize(new Dimension(900,300));
		modeloTableBolsaTrabajo.addColumn("Nombre");
		modeloTableBolsaTrabajo.addColumn("Locacion");
		modeloTableBolsaTrabajo.addColumn("Rubro");
		modeloTableBolsaTrabajo.addColumn("Estado");

		this.panelPrincipalCentral.setLayout(new BorderLayout());
		
		this.panelPrincipal.removeAll();
		this.labelSimulador__bolsaTrabajo.setText("Bolsa de trabajo:");
		this.labelSimulador__acciones.setText("Acciones:");

		this.labelSimulador__bolsaTrabajo.setFont(new Font("Arial",Font.PLAIN,20));
		this.labelSimulador__acciones.setFont(new Font("Arial",Font.PLAIN,20));
		this.panelSimuladorCentral.add(this.labelSimulador__bolsaTrabajo);
		this.panelSimuladorCentral.add(scrollTableBolsaTrabajo);
		this.panelSimuladorCentral.add(this.labelSimulador__acciones);
		this.panelSimuladorCentral.add(scrollListaAcciones);
		this.panelPrincipal.add(panelSimuladorCentral,BorderLayout.CENTER);


		revalidate();
		repaint();
	}

	public JList<String> getListaEmpleadosBolsaTrabajo() {
		return ListaEmpleadosBolsaTrabajo;
	}


	public JList<String> getListaEmpleadosPretensos() {
		return ListaEmpleadosPretensos;
	}

	public JList<String> getListaEmpleadores() {
		return ListaEmpleadores;
	}
	
	public void Maximizar() {
		setPreferredSize(D1024x768);
		
	}

	public JTextArea getTicket() {
		return ticket;
	}

	
	public JTextArea getAcciones() {
		return acciones;
	}

	public JTextField getTextoUsuario() {
		return textoUsuario;
	}
	public JTextField getTextoUsuarioRegistro() {
		return textoUsuarioRegistro;
	}
	public JTextField getTextoContraseña() {
		return textoContraseña;
	}
	public JTextField getTextoRepetirContraseña() {
		return textoRepetirContraseña;
	}
	public JTextField getTextoEmail() {
		return textoEmail;
	}
	public JTextField getTextoNombre() {
		return textoNombre;
	}
	public JTextField getTextoApellido() {
		return textoApellido;
	}
	public JTextField getTextoEdad() {
		return textoEdad;
	}
	public JTextField getTextoTelefono() {
		return textoTelefono;
	}
	public JTextField getTextoRubro() {
		return textoRubro;
	}
	public JLabel getLabelErrorUsuario() {
		return labelErrorUsuario;
	}
	public JLabel getLabelErrorContrasenia() {
		return labelErrorContrasenia;
	}

	public JButton getBotonunirse() {
		return botonunirse;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if((this.textoUsuarioRegistro.getText().isEmpty() || this.textoContraseñaRegistro.getText().isEmpty() || this.textoRepetirContraseña.getText().isEmpty() || this.textoEmail.getText().isEmpty() || !this.textoRepetirContraseña.getText().equals(this.textoContraseñaRegistro.getText())))
			this.botonunirse.setEnabled(false);
		else
			this.botonunirse.setEnabled(true);
		
		if((this.textoNombre.getText().isEmpty() || this.textoApellido.getText().isEmpty() || this.textoTelefono.getText().isEmpty() || this.textoEdad.getText().isEmpty() ))
			this.botonSiguienteEmpleado.setEnabled(false);
		else
			this.botonSiguienteEmpleado.setEnabled(true);
		
		if((this.textoNombre.getText().isEmpty() || this.textoTelefono.getText().isEmpty() || (!this.botonrubro1.isSelected() && !this.botonrubro2.isSelected() && !this.botonrubro3.isSelected()) || (!this.botontipoPersona2.isSelected() && !this.botontipoPersona1.isSelected() )))
			this.botonSiguienteEmpleador.setEnabled(false);
		else
			this.botonSiguienteEmpleador.setEnabled(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if((this.textoNombre.getText().isEmpty() || this.textoTelefono.getText().isEmpty() || (!this.botonrubro1.isSelected() && !this.botonrubro2.isSelected() && !this.botonrubro3.isSelected()) || (!this.botontipoPersona2.isSelected() && !this.botontipoPersona1.isSelected() )))
			this.botonSiguienteEmpleador.setEnabled(false);
		else
			this.botonSiguienteEmpleador.setEnabled(true);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public JTextField getTextovalorMinimo() {
		return textovalorMinimo;
	}

	public JTextField getTextovalorMaximo() {
		return textovalorMaximo;
	}

	public ButtonGroup getGrupoTipoPersona() {
		return grupoTipoPersona;
	}

	public ButtonGroup getGrupoTipoRubro() {
		return grupoTipoRubro;
	}

	public JComboBox<String> getComboBoxEstadoTickets() {
		return ComboBoxEstadoTickets;
	}

	public DefaultTableModel getModeloTableBolsaTrabajo() {
		return modeloTableBolsaTrabajo;
	}

	
	public JLabel getLabelErrorUsuarioRepetido() {
		return labelErrorUsuarioRepetido;
	}

	@Override
	public void actualizar() {
		revalidate();
		repaint();
	}



	@Override
	public JPasswordField getTextoContraseñaRegistro() {
		// TODO Auto-generated method stub
		return textoContraseñaRegistro;
	}

	


	


	
}
