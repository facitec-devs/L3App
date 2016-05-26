package py.edu.facitec.l3app.formulario;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.postgresql.jdbc2.optional.SimpleDataSource;

import py.edu.facitec.l3app.dao.ProveedoresDao;
import py.edu.facitec.l3app.model.Proveedores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class FmrProveedores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfCodigo;
	private JTextField tfNombreProveedor;
	private JTextField tfRucCi;
	private JTextField tfTelefono;
	private JTextField tfFecha;
	private JEditorPane epDireccion;
	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FmrProveedores.class.getResource("/img/Move by Trolley.png")));
		setModal(true);
		setTitle("FmrProveedores");
		setBounds(100, 100, 508, 432);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblRegistroDeProveedores = new JLabel("Registro De Proveedores");
		lblRegistroDeProveedores.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegistroDeProveedores.setBounds(162, 11, 171, 21);
		contentPanel.add(lblRegistroDeProveedores);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FmrProveedores.class.getResource("/img/Shutdown.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCerrar.setBounds(373, 359, 109, 23);
		contentPanel.add(btnCerrar);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 63, 63, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre Proveedor:");
		lblNombre.setBounds(10, 100, 112, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblRucci = new JLabel("Ruc/CI:");
		lblRucci.setBounds(10, 150, 63, 14);
		contentPanel.add(lblRucci);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 201, 63, 14);
		contentPanel.add(lblTelefono);
		
		JLabel lblNewLabel = new JLabel("Direcci\u00F3n:");
		lblNewLabel.setBounds(10, 248, 63, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblFechaRegistro = new JLabel("Fecha Registro:");
		lblFechaRegistro.setBounds(10, 314, 89, 14);
		contentPanel.add(lblFechaRegistro);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(FmrProveedores.class.getResource("/img/Save.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int a= JOptionPane.showConfirmDialog(null, "Deseas guardar los datos?","Guardar",JOptionPane.YES_NO_OPTION);
				
				if (a==0) {
					registrarProveedores();
					limpiarProveedores();
					tfNombreProveedor.requestFocus();
				}else{
					tfNombreProveedor.requestFocus();
				}
						
			}

		});
		btnGuardar.setBounds(16, 359, 112, 23);
		contentPanel.add(btnGuardar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a= JOptionPane.showConfirmDialog(null, "Desea modificar los cambios", "Modificar", JOptionPane.YES_NO_OPTION);
				if (a==0) {
					modificarProveedores();
					tfNombreProveedor.requestFocus();
				}else{
					tfNombreProveedor.requestFocus();
				}
				
			}
		});
		btnModificar.setIcon(new ImageIcon(FmrProveedores.class.getResource("/img/Edit Property.png")));
		btnModificar.setBounds(135, 359, 112, 23);
		contentPanel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a= JOptionPane.showConfirmDialog(null, "Desea eliminar los datos", "Eliminar", JOptionPane.YES_NO_OPTION);
				if (a==0) {
					eliminarProveedores();
					limpiarProveedores();
					tfNombreProveedor.requestFocus();
				}else{
				tfNombreProveedor.requestFocus();
				}
			}
		});
		btnEliminar.setIcon(new ImageIcon(FmrProveedores.class.getResource("/img/Trash.png")));
		btnEliminar.setBounds(254, 359, 109, 23);
		contentPanel.add(btnEliminar);
		
		tfCodigo = new JTextField();
		tfCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
					consultarProveedoresPorCodigo();
					
				}
				if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
					limpiarProveedores();
				}
				if (e.getKeyCode()==KeyEvent.VK_DELETE) {
					int a= JOptionPane.showConfirmDialog(null, "Deseas eliminar los datos?", "Eliminar", JOptionPane.YES_NO_OPTION);
					if (a==0) {
						eliminarProveedores();
					}else{
						tfCodigo.requestFocus();
					}
					
				}
				if (e.getKeyCode()==KeyEvent.VK_DOWN) {
					tfNombreProveedor.requestFocus();
					
				}
			}
		});
		tfCodigo.setBounds(132, 60, 103, 20);
		contentPanel.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNombreProveedor = new JTextField();
		tfNombreProveedor.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfRucCi.requestFocus();
				}
				if (e.getKeyCode()==KeyEvent.VK_DOWN) {
					tfRucCi.requestFocus();
				}
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					tfCodigo.requestFocus();
				}
			}
		});
		tfNombreProveedor.setBounds(132, 97, 258, 20);
		contentPanel.add(tfNombreProveedor);
		tfNombreProveedor.setColumns(10);
		
		tfRucCi = new JTextField();
		tfRucCi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfTelefono.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					tfTelefono.requestFocus();
				}
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					epDireccion.requestFocus();
				}
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					tfNombreProveedor.requestFocus();
				}
			}
		});
		tfRucCi.setBounds(132, 147, 258, 20);
		contentPanel.add(tfRucCi);
		tfRucCi.setColumns(10);
		
		tfTelefono = new JTextField();
		tfTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					epDireccion.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					epDireccion.requestFocus();
				}
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					tfRucCi.requestFocus();
				}
			}
		});
		tfTelefono.setBounds(132, 198, 258, 20);
		contentPanel.add(tfTelefono);
		tfTelefono.setColumns(10);
		
		tfFecha = new JTextField();
		tfFecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
				int A = JOptionPane.showConfirmDialog(null,"Deseas guardar los cambios","Guardar",JOptionPane.YES_NO_OPTION);	
				if (A==0) {
					registrarProveedores();
					limpiarProveedores();
					tfNombreProveedor.requestFocus();
				}else{
					tfNombreProveedor.requestFocus();
				}			
					}
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					epDireccion.requestFocus();
				}
					
				}
			
		});
		tfFecha.setBounds(132, 311, 106, 20);
		contentPanel.add(tfFecha);
		tfFecha.setColumns(10);
		
		epDireccion = new JEditorPane();
		epDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfFecha.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					tfFecha.requestFocus();
			}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					tfTelefono.requestFocus();
			}
			}
		});
		epDireccion.setBounds(132, 242, 258, 58);
		contentPanel.add(epDireccion);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(FmrProveedores.class.getResource("/img/Search.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarProveedoresPorCodigo();
			}
		});
		btnBuscar.setBounds(259, 59, 103, 23);
		contentPanel.add(btnBuscar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(FmrProveedores.class.getResource("/img/Broom.png")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarProveedores();
			}
		});
		btnLimpiar.setBounds(379, 59, 103, 23);
		contentPanel.add(btnLimpiar);
		setLocationRelativeTo(null);
	}
	private void limpiarProveedores() {
		tfCodigo.setText(null);
		tfNombreProveedor.setText(null);
		tfRucCi.setText(null);
		tfTelefono.setText(null);
		epDireccion.setText(null);
		tfFecha.setText(null);
		
	}
	private void registrarProveedores() {
		Proveedores proveedores = new Proveedores();
		proveedores.setNombre(tfNombreProveedor.getText());
		proveedores.setRucCi(tfRucCi.getText());
		proveedores.setTelefono(tfTelefono.getText());
		proveedores.setDireccion(epDireccion.getText());
		proveedores.setFechaRegistro(new Date());
	
		ProveedoresDao.guardarProveedores(proveedores);
	}
	private void consultarProveedoresPorCodigo() {
		int codigo= Integer.parseInt(tfCodigo.getText());
		Proveedores proveedores = ProveedoresDao.recuperarProveedoresPorCodigo(codigo);
		
		if(proveedores!=null){
			
			tfNombreProveedor.setText(proveedores.getNombre());
			tfRucCi.setText(proveedores.getRucCi());
			tfTelefono.setText(proveedores.getTelefono());
			epDireccion.setText(proveedores.getDireccion());
			tfFecha.setText(formatoFecha.format(proveedores.getFechaRegistro()));
			
			
		}
		

	}
	private void modificarProveedores() {
	  Proveedores p = new Proveedores();
	  
	  p.setCodigo(Integer.parseInt(tfCodigo.getText()));
	  
	  p.setNombre(tfNombreProveedor.getText());
	  p.setRucCi(tfRucCi.getText());
	  p.setTelefono(tfTelefono.getText());
	  p.setDireccion(epDireccion.getText());
	  p.setFechaRegistro(new Date(tfFecha.getText()));
	  
	  ProveedoresDao.modificarProveedores(p);

	}
	private void eliminarProveedores() {
		int codigo = Integer.parseInt(tfCodigo.getText());
		
		ProveedoresDao.eliminarProveedoresPorCodigo(codigo);
		limpiarProveedores();

	}
}
