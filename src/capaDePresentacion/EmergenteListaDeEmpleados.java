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

public class EmergenteListaDeEmpleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel modeloTableListaEmpleado= new DefaultTableModel();
	private JTable tableListaEmpleado = new JTable (modeloTableListaEmpleado);
	private JScrollPane scrollTableListaEmpleado = new JScrollPane(tableListaEmpleado);
	
	/**
	 * <br>
	 * Muestra los empleados registrados.
	 */
	public EmergenteListaDeEmpleados(ControladorSistema controladorSistema, InterfazVista vista, boolean modal) {
		setBounds(100, 100, 1047, 565);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//setModal(modal);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("Estos son los empleados registrados en la agencia");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			{
				
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
			
		}
	}

	public void mirarlistaEmpleado() {
		modeloTableListaEmpleado.addColumn("Nombre de usuario");
		revalidate();
		repaint();
	}
	public void mirarlistaEmpleador() {
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
