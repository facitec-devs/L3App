package py.edu.facitec.l3app.formulario;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import py.edu.facitec.l3app.dao.ProductoDao;
import py.edu.facitec.l3app.dao.motivoDAO;
import py.edu.facitec.l3app.model.Motivo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FormMotivo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfCantidad;
	private JTextField tfMotivo;
	private JRadioButton rdbtnActivo;
	private JTextField tfCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormMotivo dialog = new FormMotivo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormMotivo() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(30, 60, 59, 14);
		contentPanel.add(lblCantidad);
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setBounds(30, 91, 46, 14);
		contentPanel.add(lblMotivo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(30, 139, 46, 14);
		contentPanel.add(lblEstado);
		
		tfCantidad = new JTextField();
		tfCantidad.setBounds(113, 57, 86, 20);
		contentPanel.add(tfCantidad);
		tfCantidad.setColumns(10);
		
		tfMotivo = new JTextField();
		tfMotivo.setBounds(113, 88, 86, 20);
		contentPanel.add(tfMotivo);
		tfMotivo.setColumns(10);
		Date fecha = new Date();
	SimpleDateFormat data = new SimpleDateFormat("dd/MMMM/yyyy");
		
	rdbtnActivo = new JRadioButton("Activo");
		rdbtnActivo.setBounds(111, 135, 109, 23);
		contentPanel.add(rdbtnActivo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		guardarMotivo();
			}
		});
		btnGuardar.setBounds(149, 213, 89, 23);
		contentPanel.add(btnGuardar);
		
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			eliminarMotivo();
			}
		});
		btnEliminar.setBounds(335, 213, 89, 23);
		contentPanel.add(btnEliminar);
		
		JButton btnModificar = new JButton("modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			modificarMotivo();				
	
			}
		});
		btnModificar.setBounds(241, 213, 89, 23);
		contentPanel.add(btnModificar);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(113, 21, 86, 20);
		contentPanel.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(30, 24, 46, 14);
		contentPanel.add(lblCodigo);
	}
	//metodo para guardar
	private  void guardarMotivo(){
		Motivo motivo= new Motivo();
		motivo.setCodigo(Integer.parseInt(tfCodigo.getText()));
		motivo.setCantidad(Integer.parseInt(tfCantidad.getText()));
		motivo.setMotivo(tfMotivo.getText());
		motivo.setEstado(rdbtnActivo.isSelected());
		motivoDAO.guardarMotivo(motivo);	
	}
	private void eliminarMotivo(){
		int codigo= Integer.parseInt(tfCodigo.getText());
		motivoDAO.eliminarMotivo(codigo);
	}
	private void modificarMotivo(){
		Motivo motivo = new Motivo();
		motivo.setCodigo(Integer.parseInt(tfCodigo.getText()));
		motivo.setCantidad(Integer.parseInt(tfCantidad.getText()));
		motivo.setMotivo(tfMotivo.getText());
		motivo.setEstado(rdbtnActivo.isSelected());
		motivoDAO.modificarMotivo(motivo);
	}
}
