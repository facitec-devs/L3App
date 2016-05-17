package py.edu.facitec.l3app.formulario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class FormCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormCliente dialog = new FormCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormCliente() {
		setBounds(100, 100, 476, 338);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblRegistroCliente = new JLabel("Registro Cliente");
		lblRegistroCliente.setBounds(172, 0, 89, 14);
		contentPanel.add(lblRegistroCliente);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 32, 46, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 64, 46, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblRuc = new JLabel("RUC:");
		lblRuc.setBounds(10, 93, 46, 14);
		contentPanel.add(lblRuc);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 119, 46, 14);
		contentPanel.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 154, 46, 14);
		contentPanel.add(lblEmail);
		
		JLabel lblFechaRegistro = new JLabel("Fecha Registro:");
		lblFechaRegistro.setBounds(10, 214, 76, 14);
		contentPanel.add(lblFechaRegistro);
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setBounds(10, 239, 46, 14);
		contentPanel.add(lblSueldo);
		
		textField = new JTextField();
		textField.setBounds(52, 29, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(52, 57, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(52, 89, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 116, 86, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(52, 151, 86, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(96, 211, 86, 20);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(52, 236, 86, 20);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		
		JCheckBox chckbxActivo = new JCheckBox("Activo");
		chckbxActivo.setBounds(55, 185, 97, 23);
		contentPanel.add(chckbxActivo);
	}
}
