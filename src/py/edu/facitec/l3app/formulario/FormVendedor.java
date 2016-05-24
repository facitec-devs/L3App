package py.edu.facitec.l3app.formulario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import py.edu.facitec.l3app.dao.VendedorDAO;
import py.edu.facitec.l3app.model.Vendedor;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormVendedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JTextField tfDireccion;
	private JTextField tfDocumento;
	private JTextField tfTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormVendedor dialog = new FormVendedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormVendedor() {
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(20, 37, 76, 14);
		contentPanel.add(lblCodigo);
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 76, 76, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Direccion");
		lblNewLabel.setBounds(20, 101, 76, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(20, 126, 76, 14);
		contentPanel.add(lblDocumento);
		
		tfCodigo = new JTextField();
		tfCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER ){
				tfNombre.requestFocus();
				
			}
			}
		});
		tfCodigo.setBounds(94, 34, 96, 20);
		contentPanel.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfDireccion.requestFocus();
				}
			}
		});
		tfNombre.setBounds(94, 73, 185, 20);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfDireccion = new JTextField();
		tfDireccion.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e){
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				tfDocumento.requestFocus();
			}
			}
		});
		tfDireccion.setBounds(94, 98, 185, 20);
		contentPanel.add(tfDireccion);
		tfDireccion.setColumns(10);
		
		tfDocumento = new JTextField();
		tfDocumento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfTelefono.requestFocus();
				}
			}
		});
		tfDocumento.setBounds(94, 123, 185, 20);
		contentPanel.add(tfDocumento);
		tfDocumento.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarVendedor();
			}
		});
		btnGuardar.setBounds(91, 228, 89, 23);
		contentPanel.add(btnGuardar);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(20, 157, 76, 14);
		contentPanel.add(lblTelefono);
		
		tfTelefono = new JTextField();
		tfTelefono.setBounds(94, 151, 185, 20);
		contentPanel.add(tfTelefono);
		tfTelefono.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarVentasPorCodigo();
			}
		});
		btnBuscar.setBounds(190, 33, 89, 23);
		contentPanel.add(btnBuscar);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarVendedor();
			}
		});
		btnNewButton.setBounds(190, 228, 89, 23);
		contentPanel.add(btnNewButton);
		
	}
	private void registrarVendedor(){
	
		Vendedor vd=new Vendedor();
		vd.setCodigo(Integer.parseInt(tfCodigo.getText()));
		vd.setNombre(tfNombre.getText());
		vd.setDireccion(tfDireccion.getText());
		vd.setDocumento(tfDocumento.getText());
		vd.setTelefono(tfTelefono.getText());
	   
		VendedorDAO.guardarVendedor(vd);
		
	}
	private void consultarVentasPorCodigo(){
		int codigo = Integer.parseInt(tfCodigo.getText());
		Vendedor vendedor = VendedorDAO.recuperarVendedorPorCodigo(codigo);
		
	}
	public void modificarVendedor(){
		Vendedor vd =new Vendedor();
		vd.setCodigo(Integer.parseInt(tfCodigo.getText()));
		vd.setNombre(tfNombre.getText());
		vd.setDireccion(tfDocumento.getText());
		vd.setDocumento(tfDocumento.getText());
		vd.setTelefono(tfTelefono.getText());
		VendedorDAO.modificarVendedor(vd);
		
	}
}
