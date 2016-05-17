package py.edu.facitec.l3app.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FmrProveedores extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FmrProveedores dialog = new FmrProveedores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FmrProveedores() {
		setTitle("FmrProveedores");
		setBounds(100, 100, 592, 432);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblRegistroDeProveedores = new JLabel("Registro De Proveedores");
		lblRegistroDeProveedores.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegistroDeProveedores.setBounds(189, 11, 171, 21);
		contentPanel.add(lblRegistroDeProveedores);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCerrar.setBounds(477, 359, 89, 23);
		contentPanel.add(btnCerrar);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 66, 63, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre Proveedor:");
		lblNombre.setBounds(10, 109, 112, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblRucci = new JLabel("Ruc/CI:");
		lblRucci.setBounds(10, 159, 63, 14);
		contentPanel.add(lblRucci);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 210, 63, 14);
		contentPanel.add(lblTelefono);
		
		JLabel lblNewLabel = new JLabel("Direcci\u00F3n:");
		lblNewLabel.setBounds(10, 266, 63, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblFechaRegistro = new JLabel("Fecha Registro:");
		lblFechaRegistro.setBounds(10, 314, 89, 14);
		contentPanel.add(lblFechaRegistro);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10, 359, 89, 23);
		contentPanel.add(btnGuardar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(123, 359, 89, 23);
		contentPanel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(259, 359, 89, 23);
		contentPanel.add(btnEliminar);
		setLocationRelativeTo(null);
	}
}
