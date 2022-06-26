package capaDePresentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmergenteListaDeAsignacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel modeloTableListaEmpleado= new DefaultTableModel();
	private JTable tableListaEmpleado = new JTable (modeloTableListaEmpleado);
	private JScrollPane scrollTableListaEmpleado = new JScrollPane(tableListaEmpleado);
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @param b 
	 * @param vista 
	 * @param controladorSistema 
	 */
	public EmergenteListaDeAsignacion(ControladorSistema controladorSistema, InterfazVista vista, boolean modal) {
		setBounds(100, 100, 1047, 565);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//setModal(modal);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("Estos son los empleadores disponibles con su respectivo puntaje:");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			{
				JLabel lblNewLabel_1 = new JLabel("Elegi uno de la lista con quien prefieras emparejarte, luego pulsa aceptar");
				lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
				panel.add(lblNewLabel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(0, 0, 30, 30));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				scrollTableListaEmpleado.setPreferredSize(new Dimension(850,400));
				panel.add(scrollTableListaEmpleado);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton botonAceptar = new JButton("Aceptar");
				botonAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						botonAceptar.addActionListener(controladorSistema);
						botonAceptar.setActionCommand(vista.CONFIRMARMOSTRARLISTAEMPLEADO);
					}
				});
				botonAceptar.setActionCommand("OK");
				buttonPane.add(botonAceptar);
				getRootPane().setDefaultButton(botonAceptar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void mirarlistaEmpleado() {
		modeloTableListaEmpleado.addColumn("Nombre");
		modeloTableListaEmpleado.addColumn("Puntaje");
		modeloTableListaEmpleado.addColumn("Carga Horaria");
		modeloTableListaEmpleado.addColumn("Remuneracion");
		modeloTableListaEmpleado.addColumn("Locacion");
		modeloTableListaEmpleado.addColumn("Tipo de puesto");
		modeloTableListaEmpleado.addColumn("Estudios cursados");
		modeloTableListaEmpleado.addColumn("Experiencia previa");
		modeloTableListaEmpleado.addColumn("Rango etario");
		modeloTableListaEmpleado.addColumn("Nombre de usuario");
		revalidate();
		repaint();
	}

	public DefaultTableModel getModeloTableListaEmpleado() {
		return modeloTableListaEmpleado;
	}

	public JTable getTableListaEmpleado() {
		return tableListaEmpleado;
	}
	
}
