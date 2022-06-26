package capaDePresentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;

public class EmergenteTicketEmpleador extends JDialog implements KeyListener {

	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroupLocacion = new ButtonGroup();
	private final ButtonGroup buttonGroupTipodePuesto = new ButtonGroup();
	private final ButtonGroup buttonGroupCargaHoraria = new ButtonGroup();
	private final ButtonGroup buttonGroupExperienciaPrevia = new ButtonGroup();
	private final ButtonGroup buttonGroupEstudiosCursados = new ButtonGroup();
	private JButton botonCrearTicket = new JButton("Crear Ticket");
	private JTextField textoEdad;
	private JTextField textoRemuneracion;
	private JTextField textoCantidadEmpleados;
	private JComboBox comboBoxEstudios = new JComboBox();
	private JComboBox comboBoxLocacion = new JComboBox();
	private JComboBox comboBoxRemuneracion = new JComboBox();
	private JComboBox comboBoxCargaHoraria = new JComboBox();
	private JComboBox comboBoxEdad = new JComboBox();
	private JComboBox comboBoxPuesto = new JComboBox();
	private JComboBox comboBoxExperienciaPrevia = new JComboBox();
	

	/**
	 * Create the dialog.
	 * @param b 
	 * @param vista 
	 * @param controladorSistema 
	 */
	public EmergenteTicketEmpleador(ControladorSistema controladorSistema, InterfazVista vista, boolean b) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 683);
		setLocationRelativeTo(null);
		setModal(b);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(35, 35, 35, 35));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelFormulario = new JPanel();
			panelFormulario.setBorder(new EmptyBorder(30, 30, 30, 30));
			panelFormulario.setBackground(Color.WHITE);
			contentPanel.add(panelFormulario, BorderLayout.CENTER);
			panelFormulario.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JLabel lblNewLabel_1 = new JLabel("Cantidad de empleados buscados:");
				lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
				panelFormulario.add(lblNewLabel_1);
			}
			{
				JPanel panelLocacion = new JPanel();
				panelLocacion.setBackground(Color.WHITE);
				panelFormulario.add(panelLocacion);
				{

					textoCantidadEmpleados = new JTextField();
					this.textoCantidadEmpleados.addKeyListener(this);
					textoCantidadEmpleados.setColumns(10);
					panelLocacion.add(textoCantidadEmpleados);
				}
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Locacion:");
				lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
				panelFormulario.add(lblNewLabel_1);
			}
			{
				JPanel panelLocacion = new JPanel();
				panelLocacion.setBackground(Color.WHITE);
				panelFormulario.add(panelLocacion);
				{
					JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Presencial");
					rdbtnNewRadioButton_1.setSelected(true);
					buttonGroupLocacion.add(rdbtnNewRadioButton_1);
					rdbtnNewRadioButton_1.setBackground(Color.WHITE);
					rdbtnNewRadioButton_1.setActionCommand("Presencial");
					panelLocacion.add(rdbtnNewRadioButton_1);
				}
				{
					JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Home Office");
					buttonGroupLocacion.add(rdbtnNewRadioButton_2);
					rdbtnNewRadioButton_2.setBackground(Color.WHITE);
					rdbtnNewRadioButton_2.setActionCommand("Home Office");
					panelLocacion.add(rdbtnNewRadioButton_2);
				}
				{
					JRadioButton rdbtnNewRadioButton = new JRadioButton("Indistinto");
					buttonGroupLocacion.add(rdbtnNewRadioButton);
					rdbtnNewRadioButton.setBackground(Color.WHITE);
					rdbtnNewRadioButton.setActionCommand("Indistinto");
					panelLocacion.add(rdbtnNewRadioButton);
				}
				{
					JLabel labelRelevanciaLocacion = new JLabel("          Relevancia:");
					panelLocacion.add(labelRelevanciaLocacion);
				}
				{
					comboBoxLocacion.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
					panelLocacion.add(comboBoxLocacion);
				}
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Remuneracion:");
				lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
				panelFormulario.add(lblNewLabel_2);
			}
			{
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(Color.WHITE);
					panelFormulario.add(panel_1);
					{
						textoRemuneracion = new JTextField();
						this.textoRemuneracion.addKeyListener(this);
						textoRemuneracion.setColumns(10);
						panel_1.add(textoRemuneracion);
					}
					{
						JLabel lblRelevancia = new JLabel("                                                              Relevancia:");
						panel_1.add(lblRelevancia);
					}
					{
						comboBoxRemuneracion.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
						panel_1.add(comboBoxRemuneracion);
					}
				}
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Edad:");
				lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
				panelFormulario.add(lblNewLabel_3);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				panelFormulario.add(panel_1);
				{
					textoEdad = new JTextField();
					this.textoEdad.addKeyListener(this);
					panel_1.add(textoEdad);
					textoEdad.setColumns(10);
				}
				{
					JLabel lblRelevancia = new JLabel("                                                              Relevancia:");
					panel_1.add(lblRelevancia);
				}
				{
					comboBoxEdad.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
					panel_1.add(comboBoxEdad);
				}
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Tipo de Puesto:");
				lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
				panelFormulario.add(lblNewLabel_3);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				panelFormulario.add(panel_1);
				{
					JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Junior      ");
					rdbtnNewRadioButton_3.setSelected(true);
					buttonGroupTipodePuesto.add(rdbtnNewRadioButton_3);
					rdbtnNewRadioButton_3.setBackground(Color.WHITE);
					rdbtnNewRadioButton_3.setActionCommand("Junior");
					panel_1.add(rdbtnNewRadioButton_3);
				}
				{
					JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Senior      ");
					buttonGroupTipodePuesto.add(rdbtnNewRadioButton_4);
					rdbtnNewRadioButton_4.setBackground(Color.WHITE);
					rdbtnNewRadioButton_4.setActionCommand("Senior");
					panel_1.add(rdbtnNewRadioButton_4);
				}
				{
					JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Managment");
					buttonGroupTipodePuesto.add(rdbtnNewRadioButton_5);
					rdbtnNewRadioButton_5.setActionCommand("Managment");
					rdbtnNewRadioButton_5.setBackground(Color.WHITE);
					panel_1.add(rdbtnNewRadioButton_5);
				}
				{
					JLabel labelRelevanciaPuesto = new JLabel("           Relevancia:");
					panel_1.add(labelRelevanciaPuesto);
				}
				{
					comboBoxPuesto.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
					panel_1.add(comboBoxPuesto);
				}
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Carga horaria:");
				lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 13));
				panelFormulario.add(lblNewLabel_6);
			}
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 255));
				panelFormulario.add(panel);
				{
					JRadioButton rdbtnNewRadioButton_12 = new JRadioButton("Media      ");
					rdbtnNewRadioButton_12.setSelected(true);
					buttonGroupCargaHoraria.add(rdbtnNewRadioButton_12);
					rdbtnNewRadioButton_12.setActionCommand("CargaExtendida");
					rdbtnNewRadioButton_12.setBackground(Color.WHITE);
					panel.add(rdbtnNewRadioButton_12);
				}
				{
					JRadioButton rdbtnNewRadioButton_13 = new JRadioButton("Completa  ");
					buttonGroupCargaHoraria.add(rdbtnNewRadioButton_13);
					rdbtnNewRadioButton_13.setBackground(Color.WHITE);
					rdbtnNewRadioButton_13.setActionCommand("CargaCompleta");
					panel.add(rdbtnNewRadioButton_13);
				}
				{
					JRadioButton rdbtnNewRadioButton_14 = new JRadioButton("Extendida ");
					buttonGroupCargaHoraria.add(rdbtnNewRadioButton_14);
					rdbtnNewRadioButton_14.setBackground(Color.WHITE);
					rdbtnNewRadioButton_14.setActionCommand("CargaMedia");
					panel.add(rdbtnNewRadioButton_14);
				}
				{
					JLabel labelRelevanciaCargaHorari = new JLabel("           Relevancia:");
					panel.add(labelRelevanciaCargaHorari);
				}
				{
					comboBoxCargaHoraria.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
					panel.add(comboBoxCargaHoraria);
				}
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Experiencia Previa:");
				lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 13));
				panelFormulario.add(lblNewLabel_4);
			}
			{
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				panelFormulario.add(panel);
				{
					JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Nada       ");
					rdbtnNewRadioButton_6.setSelected(true);
					buttonGroupExperienciaPrevia.add(rdbtnNewRadioButton_6);
					rdbtnNewRadioButton_6.setActionCommand("ExperienciaNada");
					rdbtnNewRadioButton_6.setBackground(Color.WHITE);
					panel.add(rdbtnNewRadioButton_6);
				}
				{
					JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Media        ");
					buttonGroupExperienciaPrevia.add(rdbtnNewRadioButton_7);
					rdbtnNewRadioButton_7.setBackground(Color.WHITE);
					rdbtnNewRadioButton_7.setActionCommand("ExperienciaMedia");
					panel.add(rdbtnNewRadioButton_7);
				}
				{
					JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("Mucha      ");
					buttonGroupExperienciaPrevia.add(rdbtnNewRadioButton_8);
					rdbtnNewRadioButton_8.setBackground(Color.WHITE);
					rdbtnNewRadioButton_8.setActionCommand("ExperienciaMucha");
					panel.add(rdbtnNewRadioButton_8);
				}
				{
					JLabel labelRelevanciaExperiencia = new JLabel("           Relevancia:");
					panel.add(labelRelevanciaExperiencia);
				}
				{
					comboBoxExperienciaPrevia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
					panel.add(comboBoxExperienciaPrevia);
				}
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Estudios cursados:");
				lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 13));
				panelFormulario.add(lblNewLabel_5);
			}
			{
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				panelFormulario.add(panel);
				{
					JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("Primario  ");
					rdbtnNewRadioButton_9.setSelected(true);
					buttonGroupEstudiosCursados.add(rdbtnNewRadioButton_9);
					rdbtnNewRadioButton_9.setBackground(Color.WHITE);
					rdbtnNewRadioButton_9.setActionCommand("Primario");
					panel.add(rdbtnNewRadioButton_9);
				}
				{
					JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("Secundario");
					buttonGroupEstudiosCursados.add(rdbtnNewRadioButton_10);
					rdbtnNewRadioButton_10.setBackground(Color.WHITE);
					rdbtnNewRadioButton_10.setActionCommand("Secundario");
					panel.add(rdbtnNewRadioButton_10);
				}
				{
					JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("Terciario   ");
					buttonGroupEstudiosCursados.add(rdbtnNewRadioButton_11);
					rdbtnNewRadioButton_11.setBackground(Color.WHITE);
					rdbtnNewRadioButton_11.setActionCommand("Terciario");
					panel.add(rdbtnNewRadioButton_11);
				}
				{
					JLabel labelRelevanciaEstudios = new JLabel("           Relevancia:");
					panel.add(labelRelevanciaEstudios);
				}
				{
					comboBoxEstudios.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
					panel.add(comboBoxEstudios);
				}
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Crea tu ticket con las caracteristicas que deseas en tus empleados:");
			lblNewLabel.setForeground(Color.DARK_GRAY);
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				botonCrearTicket.setFont(new Font("Arial", Font.PLAIN, 16));
				botonCrearTicket.addActionListener(controladorSistema);
				botonCrearTicket.setActionCommand(vista.CONFIRMARNUEVOTICKETEMPLEADOR);
				botonCrearTicket.setEnabled(false);
				buttonPane.add(botonCrearTicket);
				getRootPane().setDefaultButton(botonCrearTicket);
			}
			{
				JButton botonCancelar = new JButton("Cancelar");
				botonCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
				botonCancelar.setActionCommand("Cancel");
				buttonPane.add(botonCancelar);
			}
		}
	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	public ButtonGroup getButtonGroupLocacion() {
		return buttonGroupLocacion;
	}



	public ButtonGroup getButtonGroupTipodePuesto() {
		return buttonGroupTipodePuesto;
	}



	public ButtonGroup getButtonGroupCargaHoraria() {
		return buttonGroupCargaHoraria;
	}



	public ButtonGroup getButtonGroupExperienciaPrevia() {
		return buttonGroupExperienciaPrevia;
	}



	public ButtonGroup getButtonGroupEstudiosCursados() {
		return buttonGroupEstudiosCursados;
	}



	public JTextField getTextoEdad() {
		return textoEdad;
	}



	public JTextField getTextoRemuneracion() {
		return textoRemuneracion;
	}



	public JTextField getTextoCantidadEmpleados() {
		return textoCantidadEmpleados;
	}



	public JComboBox getComboBoxEstudios() {
		return comboBoxEstudios;
	}



	public JComboBox getComboBoxLocacion() {
		return comboBoxLocacion;
	}



	public JComboBox getComboBoxRemuneracion() {
		return comboBoxRemuneracion;
	}



	public JComboBox getComboBoxCargaHoraria() {
		return comboBoxCargaHoraria;
	}



	public JComboBox getComboBoxEdad() {
		return comboBoxEdad;
	}



	public JComboBox getComboBoxPuesto() {
		return comboBoxPuesto;
	}



	public JComboBox getComboBoxExperienciaPrevia() {
		return comboBoxExperienciaPrevia;
	}



	@Override
	public void keyReleased(KeyEvent e) {
		if(this.textoRemuneracion.getText().isEmpty() || this.textoCantidadEmpleados.getText().isEmpty()|| this.textoEdad.getText().isEmpty())
			this.botonCrearTicket.setEnabled(false);
		else
			this.botonCrearTicket.setEnabled(true);
	}

}

