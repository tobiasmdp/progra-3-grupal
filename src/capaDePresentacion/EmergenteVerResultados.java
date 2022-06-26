package capaDePresentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class EmergenteVerResultados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel labelComision = new JLabel("");
	private JLabel labelFelicidades = new JLabel("");

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @param b 
	 * @param vista 
	 * @param controladorSistema 
	 */
	public EmergenteVerResultados(ControladorSistema controladorSistema, InterfazVista vista, boolean b) {
		setBounds(100, 100, 450, 196);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				labelFelicidades.setFont(new Font("Arial", Font.PLAIN, 20));
				labelFelicidades.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(labelFelicidades, BorderLayout.NORTH);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("En breve nos contactaremos a tu telefono y/o email");
				lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
				panel.add(lblNewLabel_1, BorderLayout.CENTER);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			contentPanel.add(panel, BorderLayout.CENTER);
			{
				JLabel lblNewLabel_2 = new JLabel("La comision a cobrar es de :");
				panel.add(lblNewLabel_2);
			}
			{
				labelComision.setFont(new Font("Arial", Font.PLAIN, 15));
				panel.add(labelComision);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JLabel getLabelComision() {
		return labelComision;
	}

	public void versionEmpleado(double comision) {
		this.labelFelicidades.setText("Felicidades! Conseguiste un nuevo trabajo!");
		this.labelComision.setText( " "+comision);
	}
	public void versionEmpleador(double comision) {
		this.labelFelicidades.setText("Felicidades! Conseguiste nuevos empleados!");
		this.labelComision.setText( " "+comision);
	}
	
}
