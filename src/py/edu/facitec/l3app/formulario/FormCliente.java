package py.edu.facitec.l3app.formulario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import py.edu.facitec.l3app.dao.ClienteDao;
import py.edu.facitec.l3app.model.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JTextField tfRuc;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfFechaRegistro;
	private JTextField tfSueldo;
	private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField tfDireccion;
	private JCheckBox chActivo;

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
		setBounds(100, 100, 538, 439);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblRegistroCliente = new JLabel("Registro Cliente");
		lblRegistroCliente.setBounds(235, 0, 89, 14);
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
		lblFechaRegistro.setBounds(10, 263, 76, 14);
		contentPanel.add(lblFechaRegistro);
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setBounds(10, 291, 46, 14);
		contentPanel.add(lblSueldo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(66, 29, 130, 20);
		contentPanel.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(66, 60, 379, 20);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfRuc = new JTextField();
		tfRuc.setBounds(66, 90, 130, 20);
		contentPanel.add(tfRuc);
		tfRuc.setColumns(10);
		
		tfTelefono = new JTextField();
		tfTelefono.setBounds(66, 116, 130, 20);
		contentPanel.add(tfTelefono);
		tfTelefono.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(66, 151, 384, 20);
		contentPanel.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfFechaRegistro = new JTextField();
		tfFechaRegistro.setBounds(96, 260, 100, 20);
		contentPanel.add(tfFechaRegistro);
		tfFechaRegistro.setColumns(10);
		tfFechaRegistro.setText(formatoFecha.format(new Date()));
		
		tfSueldo = new JTextField();
		tfSueldo.setBounds(66, 288, 130, 20);
		contentPanel.add(tfSueldo);
		tfSueldo.setColumns(10);
		
		chActivo = new JCheckBox("Activo");
		chActivo.setBounds(66, 230, 97, 23);
		contentPanel.add(chActivo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarClientePorCodigo();
			}
		});
		btnBuscar.setBounds(220, 28, 89, 23);
		contentPanel.add(btnBuscar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				guardarCliente();
			}
		});
		btnGuardar.setBounds(220, 353, 89, 23);
		contentPanel.add(btnGuardar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarCliente();
			}
		});
		btnModificar.setBounds(319, 353, 89, 23);
		contentPanel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarCliente();
			}
		});
		btnEliminar.setBounds(418, 353, 89, 23);
		contentPanel.add(btnEliminar);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 234, 46, 14);
		contentPanel.add(lblEstado);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 197, 53, 14);
		contentPanel.add(lblDireccion);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(65, 194, 385, 20);
		contentPanel.add(tfDireccion);
		tfDireccion.setColumns(10);
	}
	
	private void guardarCliente(){
		Cliente cliente = new Cliente();
		cliente.setNombre(tfNombre.getText());
		cliente.setRuc(tfRuc.getText());
		cliente.setTelefono(tfTelefono.getText());
		cliente.setEmail(tfEmail.getText());
		cliente.setDireccion(tfDireccion.getText());
		cliente.setActivo(chActivo.isSelected());
		cliente.setFecha_registro(new Date());
		cliente.setSueldo(Double.parseDouble(tfSueldo.getText()));
		ClienteDao.guardarCliente(cliente);
		
	}
	
	private void consultarClientePorCodigo(){
		int codigo = Integer.parseInt(tfCodigo.getText());
		Cliente cliente = ClienteDao.recuperarClientePorCodigo(codigo);
		System.out.println(cliente);
		if(cliente != null){
			tfNombre.setText(cliente.getNombre());
			tfRuc.setText(cliente.getRuc());
			tfTelefono.setText(cliente.getTelefono());
			tfEmail.setText(cliente.getEmail());
			tfDireccion.setText(cliente.getDireccion());
			chActivo.setSelected(cliente.isActivo());
			tfFechaRegistro.setText(formatoFecha.format(cliente.getFecha_registro()));
			tfSueldo.setText(cliente.getSueldo()+"");
				
		}
		
	}
	
	private void modificarCliente(){
		Cliente cliente = new Cliente();
		cliente.setCodigo(Integer.parseInt(tfCodigo.getText()));
		cliente.setNombre(tfNombre.getText());
		cliente.setRuc(tfRuc.getText());
		cliente.setTelefono(tfTelefono.getText());
		cliente.setEmail(tfEmail.getText());
		cliente.setDireccion(tfDireccion.getText());
		cliente.setActivo(chActivo.isSelected());
		cliente.setSueldo(Double.parseDouble(tfSueldo.getText()));
		ClienteDao.modificarCliente(cliente);	
		
	}
	
	private void eliminarCliente(){
		int codigo = Integer.parseInt(tfCodigo.getText());
		ClienteDao.eliminarClientePorCodigo(codigo);
	}
}
