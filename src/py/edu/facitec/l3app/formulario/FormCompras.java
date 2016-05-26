package py.edu.facitec.l3app.formulario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import py.edu.facitec.l3app.dao.ComprasDao;
import py.edu.facitec.l3app.model.Compras;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormCompras extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfCodigo;
	private JTextField tfCantidad;
	private JTextField tfCosto;
	private JTextField tfPrecioVenta;
	private JEditorPane epDescripcion;
	private JComboBox cbDeposito;
	private Object entero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormCompras dialog = new FormCompras();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormCompras() {
		setTitle("FmrCompras");
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormCompras.class.getResource("/img/Buy.png")));
		setBounds(100, 100, 508, 432);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblMovimientoDeVentas = new JLabel("Movimiento de Ventas");
		lblMovimientoDeVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovimientoDeVentas.setBounds(164, 11, 127, 14);
		contentPanel.add(lblMovimientoDeVentas);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 54, 69, 14);
		contentPanel.add(lblCodigo);

		tfCodigo = new JTextField();
		tfCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					consultarComprasPorCodigo();
				}
				if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
					limpiarCompras();
					
				}
				if (e.getKeyCode()==KeyEvent.VK_DELETE) {
					int a= JOptionPane.showConfirmDialog(null, "Desea eliminar los datos", "Eliminar", JOptionPane.YES_NO_OPTION);
					if (a==0) {
						eliminarCompras();
					}else{
						tfCodigo.requestFocus();
					}
					
				}
				if (e.getKeyCode()==KeyEvent.VK_DOWN) {
					tfCantidad.requestFocus();
					
				}
				
			}
		});
		tfCodigo.setBounds(112, 51, 100, 20);
		contentPanel.add(tfCodigo);
		tfCodigo.setColumns(10);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 104, 69, 14);
		contentPanel.add(lblCantidad);

		tfCantidad = new JTextField();
		tfCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					tfCosto.requestFocus();
				}
				if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
					limpiarCompras();
				}
				if (e.getKeyCode()==KeyEvent.VK_DOWN) {
					tfCosto.requestFocus();
					
				}
				if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
					tfCosto.requestFocus();
			}
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					tfCodigo.requestFocus();
			}
			}
		});
		tfCantidad.setBounds(112, 101, 100, 20);
		contentPanel.add(tfCantidad);
		tfCantidad.setColumns(10);

		JLabel lblDesripcion = new JLabel("Desripcion:");
		lblDesripcion.setBounds(10, 206, 69, 14);
		contentPanel.add(lblDesripcion);

		epDescripcion = new JEditorPane();
		epDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					cbDeposito.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					tfPrecioVenta.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					cbDeposito.requestFocus();
				}
			}
		});
		epDescripcion.setBounds(113, 206, 311, 66);
		contentPanel.add(epDescripcion);

		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(245, 104, 69, 14);
		contentPanel.add(lblCosto);

		JLabel lblNewLabel = new JLabel("Costo de Venta:");
		lblNewLabel.setBounds(10, 161, 100, 14);
		contentPanel.add(lblNewLabel);

		tfCosto = new JTextField();
		tfCosto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfPrecioVenta.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					tfCantidad.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					tfCantidad.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					tfPrecioVenta.requestFocus();
				}
			}
		});
		tfCosto.setBounds(324, 101, 100, 20);
		contentPanel.add(tfCosto);
		tfCosto.setColumns(10);

		tfPrecioVenta = new JTextField();
		tfPrecioVenta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					epDescripcion.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					tfCosto.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					epDescripcion.requestFocus();
				}
			}
		});
		tfPrecioVenta.setBounds(112, 158, 100, 20);
		contentPanel.add(tfPrecioVenta);
		tfPrecioVenta.setColumns(10);

		JLabel lblDeposito = new JLabel("Deposito:");
		lblDeposito.setBounds(10, 308, 69, 14);
		contentPanel.add(lblDeposito);

		cbDeposito = new JComboBox();
		cbDeposito.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_UP){
					epDescripcion.requestFocus();
				}
			}
		});
		cbDeposito.setModel(new DefaultComboBoxModel(new String[] {"Principal", "Electr\u00F3nica", "Perfumer\u00EDa", "Bebidas", "Cocina", "Jugueter\u00EDa"}));
		cbDeposito.setBounds(112, 305, 100, 20);
		contentPanel.add(cbDeposito);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarComprasPorCodigo();
			}
		});
		btnBuscar.setIcon(new ImageIcon(FormCompras.class.getResource("/img/Search.png")));
		btnBuscar.setBounds(225, 50, 100, 23);
		contentPanel.add(btnBuscar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCompras();
			}
		});
		btnLimpiar.setIcon(new ImageIcon(FormCompras.class.getResource("/img/Broom.png")));
		btnLimpiar.setBounds(335, 50, 100, 23);
		contentPanel.add(btnLimpiar);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int re= JOptionPane.showConfirmDialog(null, "Deseas guardar los datos?","Guardar",JOptionPane.YES_NO_OPTION);
				if(re==0){
					guardarCompras();
					limpiarCompras();
					tfCantidad.requestFocus();	
				}else{
					tfCantidad.requestFocus();
				}
				
			}
		});
		btnGuardar.setIcon(new ImageIcon(FormCompras.class.getResource("/img/Save.png")));
		btnGuardar.setBounds(12, 359, 106, 23);
		contentPanel.add(btnGuardar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Desea modificar los cambios?", "Modificar", JOptionPane.YES_NO_OPTION);
				if (a==0) {
					modificarCompras();
					tfCantidad.requestFocus();	
					
				}else{
					tfCantidad.requestFocus();
				}
				
			}
		});
		btnModificar.setIcon(new ImageIcon(FormCompras.class.getResource("/img/Edit Property.png")));
		btnModificar.setBounds(130, 359, 106, 23);
		contentPanel.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int re= JOptionPane.showConfirmDialog(null, "Deseas eliminar los datos?","Eliminar",JOptionPane.YES_NO_OPTION);
				if(re==0){
					eliminarCompras();
					limpiarCompras();
					tfCantidad.requestFocus();
				}else{
					tfCantidad.requestFocus();
				}
			}
		});
		btnEliminar.setIcon(new ImageIcon(FormCompras.class.getResource("/img/Trash.png")));
		btnEliminar.setBounds(248, 359, 106, 23);
		contentPanel.add(btnEliminar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(FormCompras.class.getResource("/img/Shutdown.png")));
		btnSalir.setBounds(366, 359, 110, 23);
		contentPanel.add(btnSalir);
	}
	private void limpiarCompras() {
		tfCodigo.setText(null);
		tfCantidad.setText(null);
		tfCosto.setText(null);
		tfPrecioVenta.setText(null);
		epDescripcion.setText(null);
		cbDeposito.setSelectedIndex(0);
	}
	private void guardarCompras() {
		Compras compras = new Compras();

		compras.setCantidad(Integer.parseInt(tfCantidad.getText()));
		compras.setCosto(Double.parseDouble(tfCosto.getText()));
		compras.setPrecioVenta(Double.parseDouble(tfPrecioVenta.getText()));
		compras.setDescripcion(epDescripcion.getText());
		compras.setDeposito(cbDeposito.getSelectedIndex());

		ComprasDao.guradarCompras(compras);

	}
	private void consultarComprasPorCodigo() {
		int codigo= Integer.parseInt(tfCodigo.getText());
		Compras compras = ComprasDao.recuperarComprasPorCodigo(codigo);
		if(compras!=null){
			tfCantidad.setText(compras.getCantidad()+"");
			tfCosto.setText(compras.getCosto()+"");
			tfPrecioVenta.setText(compras.getPrecioVenta()+"");
			epDescripcion.setText(compras.getDescripcion());
			cbDeposito.setSelectedIndex(compras.getDeposito());
			
			
		}
		

	}

	private void modificarCompras() {
		Compras c = new Compras();

		c.setCodigo(Integer.parseInt(tfCodigo.getText()));

		c.setCantidad(Integer.parseInt(tfCantidad.getText()));
		c.setCosto(Double.parseDouble(tfCosto.getText()));;
		c.setPrecioVenta(Double.parseDouble(tfPrecioVenta.getText()));
		c.setDescripcion(epDescripcion.getText());;
		c.setDeposito(cbDeposito.getSelectedIndex());;

		ComprasDao.modificarCompras(c);

	}
	private void eliminarCompras() {
		int codigo = Integer.parseInt(tfCodigo.getText());

		ComprasDao.eliminarComprasPorCodigo(codigo);
		limpiarCompras();

	}
}
