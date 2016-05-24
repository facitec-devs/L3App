package py.edu.facitec.l3app.formulario;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import py.edu.facitec.l3app.dao.ProductoDao;
import py.edu.facitec.l3app.model.Productos;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InterfaceAddress;

import javax.swing.JPanel;

public class FormProducto extends JDialog {
	private JTextField tfPrecio;
	private JTextField tfStock;
	private JTextField tfCodigo;
	private JTextField tfProveedor;
	private JTextField tfCosto;
	private JTextPane tpDescripcion;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProducto dialog = new FormProducto();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FormProducto() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				//				cerrar();
			}
		});


		setTitle("producto");
		setBounds(100, 100, 575, 446);
		getContentPane().setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(35, 30, 46, 14);
		getContentPane().add(lblCodigo);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(16, 73, 75, 14);
		getContentPane().add(lblDescripcion);

		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(16, 154, 75, 14);
		getContentPane().add(lblProveedor);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(21, 207, 46, 14);
		getContentPane().add(lblPrecio);

		tfPrecio = new JTextField();
		tfPrecio.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_RIGHT){
					tfStock.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					tfProveedor.requestFocus();	
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					btnGuardar.requestFocus();	
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				int c= e.getKeyChar();
				if(!Character.isDigit(c) ){
					e.consume();
				}}
		});
		tfPrecio.setBounds(72, 204, 86, 20);
		getContentPane().add(tfPrecio);
		tfPrecio.setColumns(10);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(194, 207, 46, 14);
		getContentPane().add(lblStock);

		tfStock = new JTextField();
		tfStock.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					btnGuardar.requestFocus();	
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					tfCosto.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					tfPrecio.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					tfProveedor.requestFocus();	
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				int c= e.getKeyChar();
				if(!Character.isDigit(c) ){
					e.consume();
				}
			}
		});
		tfStock.setBounds(250, 204, 86, 20);
		getContentPane().add(tfStock);
		tfStock.setColumns(10);

		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(386, 207, 46, 14);
		getContentPane().add(lblCosto);

		tpDescripcion = new JTextPane();
		tpDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					tfProveedor.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					tfCodigo.requestFocus();
				}
			}
		});
		tpDescripcion.setBounds(104, 70, 220, 47);
		getContentPane().add(tpDescripcion);

		tfCodigo = new JTextField();
		tfCodigo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				consultarClientePorCodigo();
			}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					tpDescripcion.requestFocus();
				}
			}
			public void keyTyped(KeyEvent e) {
				int c= e.getKeyChar();
				if(!Character.isDigit(c) ){
					e.consume();
				}
			}
		});
		tfCodigo.setBounds(101, 27, 86, 20);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);

		tfProveedor = new JTextField();
		tfProveedor.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_UP){
					tpDescripcion.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					tfPrecio.requestFocus();

				}

			}
		});
		tfProveedor.setBounds(104, 148, 220, 20);
		getContentPane().add(tfProveedor);
		tfProveedor.setColumns(10);

		 btnGuardar = new JButton("guardar");
		btnGuardar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					guardarProducto();
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
				tfPrecio.requestFocus();
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					btnModificar.requestFocus();
					}
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarProducto();
			}
		});
		btnGuardar.setBounds(10, 354, 89, 23);
		getContentPane().add(btnGuardar);

		 btnModificar = new JButton("modificar");
		 btnModificar.addKeyListener(new KeyAdapter() {
		 	@Override
		 	public void keyPressed(KeyEvent e) {
		 		if(e.getKeyCode()==KeyEvent.VK_UP){
					tfPrecio.requestFocus();
					}
		 		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					btnEliminar.requestFocus();
					}
		 		if(e.getKeyCode()==KeyEvent.VK_LEFT){
					btnGuardar.requestFocus();
					}
		 		if(e.getKeyCode()==KeyEvent.VK_ENTER){
		 			modificarProducto();
		 		}

		 	}
		 });
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarProducto();
			}
		});
		btnModificar.setBounds(104, 354, 89, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("eliminar");
		btnEliminar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_UP){
					tfPrecio.requestFocus();
					}
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					btnModificar.requestFocus();
					}
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					eliminarProducto();
					
				}
				
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					eliminarProducto();
					}
		});
		btnEliminar.setBounds(205, 354, 89, 23);
		getContentPane().add(btnEliminar);

		tfCosto = new JTextField();
		tfCosto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					btnGuardar.requestFocus();	
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					tfStock.requestFocus();	
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					tfProveedor.requestFocus();	
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				int c= e.getKeyChar();
				if(!Character.isDigit(c) ){
					e.consume();
				}
			}
		});
		tfCosto.setBounds(426, 204, 86, 20);
		getContentPane().add(tfCosto);
		tfCosto.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(194, 11, 63, 36);
		getContentPane().add(panel);

		JButton btnBuscar = new JButton("buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarClientePorCodigo();
			}
		});
		panel.add(btnBuscar);
	}
	//guarda los productos
	private void guardarProducto(){
		Productos producto= new Productos();
		producto.setCodigo(Integer.parseInt(tfCodigo.getText()));
		producto.setDescripcion(tpDescripcion.getText());
		producto.setProveedor(tfProveedor.getText());
		producto.setPrecio(Integer.parseInt(tfPrecio.getText())); 
		producto.setStock(Integer.parseInt(tfStock.getText())); 
		producto.setCosto(Integer.parseInt(tfCosto.getText())); 
		ProductoDao.guardarProducto(producto);
		limpiarPantalla();
	}
	//modifica los productos
	private void modificarProducto(){

		Productos producto = new Productos();
		producto.setCodigo(Integer.parseInt(tfCodigo.getText()));
		producto.setDescripcion(tpDescripcion.getText());
		producto.setProveedor(tfProveedor.getText());
		producto.setPrecio(Integer.parseInt(tfPrecio.getText())); 
		producto.setStock(Integer.parseInt(tfStock.getText())); 
		producto.setCosto(Integer.parseInt(tfCosto.getText())); 
		ProductoDao.modificarCliente(producto);
	}
	//elimina los productos
	private void eliminarProducto(){
		int a = JOptionPane.showConfirmDialog(null	, "estas seguro","eliminar", JOptionPane.YES_NO_OPTION);
		if(a==0){
		int codigo= Integer.parseInt(tfCodigo.getText());
		ProductoDao.eliminarProdcutoPorCodigo(codigo);
		limpiarPantalla();
		}
		}
	//buscar por codigo
	private void consultarClientePorCodigo(){
		int codigo= Integer.parseInt(tfCodigo.getText());
		Productos productos= ProductoDao.recuperarProductoPorCodigo(codigo);
		if(productos!=null){
			tpDescripcion.setText(productos.getDescripcion());
			tfProveedor.setText(productos.getProveedor());

			tfPrecio.setText(String.valueOf(productos.getPrecio()));
			tfStock.setText(productos.getStock()+"");
			tfCosto.setText(productos.getCosto()+"");


		}else{
			JOptionPane.showMessageDialog(null, "el producto no existe");
		}
	}
	private void limpiarPantalla(){
		tfCodigo.requestFocus();
		tfCodigo.setText("");
		//0descripcion, proveedor,costo, stock,precio
		tpDescripcion.setText("");
		tfProveedor.setText("");
		tfCosto.setText("");
		tfStock.setText("");
		tfPrecio.setText("");

	}
}