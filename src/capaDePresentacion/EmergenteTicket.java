package capaDePresentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmergenteTicket extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton botonAceptar = new JButton("Aplicar");
	private JComboBox comboBox = new JComboBox();
	/**
	 * Create the dialog.
	 * @param vista 
	 * @param b 
	 * @param vista 
	 */
	public EmergenteTicket(ControladorSistema controladorSistema, InterfazVista vista, boolean modal){
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setModal(modal);
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel_1 = new JLabel("Nuevo estado:");
			lblNewLabel_1.setBorder(new EmptyBorder(0, 80, 0, 20));
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_1, BorderLayout.WEST);
		}
		{
			JLabel lblNewLabel = new JLabel("Cambia el estado de tu ticket");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(80, 0, 80, 80));
			panel.setBounds(new Rectangle(40, 40, 50, 50));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JComboBox comboBox = new JComboBox();
				comboBox.addItem("Activo");	
				comboBox.addItem("Cancelado");
				panel.add(comboBox);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				botonAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						botonAceptar.addActionListener(controladorSistema);
						botonAceptar.setActionCommand(vista.CONFIRMARELEGIRTICKETEMPLEADO);
					}
				});
				botonAceptar.setActionCommand("OK");
				buttonPane.add(botonAceptar);
				getRootPane().setDefaultButton(botonAceptar);
			}
			{
				JButton botonCancelar = new JButton("Cancelar");
				botonCancelar.setActionCommand("Cancel");
				buttonPane.add(botonCancelar);
			}
		}
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	
	
}
