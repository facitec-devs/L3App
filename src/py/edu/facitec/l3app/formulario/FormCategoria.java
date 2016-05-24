package py.edu.facitec.l3app.formulario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import py.edu.facitec.l3app.dao.CategoriaDao;
import py.edu.facitec.l3app.model.Categoria;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FormCategoria extends JDialog {
	SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
	private JTextField tfCodigo;
	private JTextField tfFecha;
	private JTextField tfNomenclatura;
	private JTextField tfDescripcion;
	private JLabel lblObligatorio1;
	private JLabel lblObligatorio2;
	private JCheckBox chActivo;
	private JTable tbTabla;
	private Object scrollPane;
	private JLabel lblCamposObligatorios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormCategoria dialog = new FormCategoria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormCategoria() {
		getContentPane().setBackground(new Color(255, 255, 224));
		setTitle("Registro Categorias");
		setBounds(100, 100, 561, 360);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gridBagLayout.columnWidths = new int[]{133, 139, 114, 83, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.anchor = GridBagConstraints.WEST;
		gbc_lblCodigo.insets = new Insets(10, 10, 5, 5);
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 0;
		gbc_lblCodigo.gridwidth=1;
		gbc_lblCodigo.gridheight=1;
		getContentPane().add(lblCodigo, gbc_lblCodigo);
		
		tfCodigo = new JTextField();
		tfCodigo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfFecha.requestFocus();
				}
			}
		});
		tfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_tfCodigo = new GridBagConstraints();
		gbc_tfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCodigo.insets = new Insets(10, 3, 5, 10);
		gbc_tfCodigo.gridx = 1;
		gbc_tfCodigo.gridy = 0;
		gbc_tfCodigo.gridwidth=1;
		gbc_tfCodigo.gridheight=1;
		getContentPane().add(tfCodigo, gbc_tfCodigo);
		tfCodigo.setColumns(10);
		
		lblObligatorio2 = new JLabel("* ");
		lblObligatorio2.setForeground(Color.RED);
		lblObligatorio2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblObligatorio2 = new GridBagConstraints();
		gbc_lblObligatorio2.insets = new Insets(10, 5, 5, 10);
		gbc_lblObligatorio2.gridx = 4;
		gbc_lblObligatorio2.gridy = 3;
		lblObligatorio2.setVisible(false);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarCategoria();
				}
		});
		
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(10, 10, 5, 10);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 0;
		gbc_btnBuscar.gridheight=1;
		gbc_btnBuscar.gridwidth=1;
		getContentPane().add(btnBuscar, gbc_btnBuscar);
		
		lblCamposObligatorios = new JLabel("* Campos Obligatorios");
		lblCamposObligatorios.setVisible(false);
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCamposObligatorios.setForeground(Color.RED);
		GridBagConstraints gbc_lblCamposObligatorios = new GridBagConstraints();
		gbc_lblCamposObligatorios.insets = new Insets(10, 10, 5, 10);
		gbc_lblCamposObligatorios.gridx = 3;
		gbc_lblCamposObligatorios.gridy = 0;
		gbc_lblCamposObligatorios.gridheight = 1;
		gbc_lblCamposObligatorios.gridwidth = 2;
		getContentPane().add(lblCamposObligatorios, gbc_lblCamposObligatorios);
		getContentPane().add(lblObligatorio2, gbc_lblObligatorio2);

		
		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.WEST;
		gbc_lblFecha.insets = new Insets(10, 10, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 1;
		gbc_lblFecha.gridwidth=1;
		gbc_lblFecha.gridheight=1;
		getContentPane().add(lblFecha, gbc_lblFecha);
		
		tfFecha = new JTextField();
		tfFecha.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				tfFecha.selectAll();
			}
		});
		tfFecha.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfNomenclatura.requestFocus();
				}
			}
		});
		tfFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_tfFecha = new GridBagConstraints();
		gbc_tfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFecha.insets = new Insets(10, 3, 5, 10);
		gbc_tfFecha.gridx = 1;
		gbc_tfFecha.gridy = 1;
		gbc_tfFecha.gridwidth=3;
		gbc_tfFecha.gridheight=1;
		tfFecha.setText(fechaActual());
		getContentPane().add(tfFecha, gbc_tfFecha);
		tfFecha.setColumns(10);
		
		JLabel lblNomenclatura = new JLabel("Nomenclatura:");
		lblNomenclatura.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNomenclatura = new GridBagConstraints();
		gbc_lblNomenclatura.anchor = GridBagConstraints.WEST;
		gbc_lblNomenclatura.insets = new Insets(10, 10, 5, 5);
		gbc_lblNomenclatura.gridx = 0;
		gbc_lblNomenclatura.gridy = 2;
		gbc_lblNomenclatura.gridwidth=1;
		gbc_lblNomenclatura.gridwidth=1;
		getContentPane().add(lblNomenclatura, gbc_lblNomenclatura);
		
		tfNomenclatura = new JTextField();
		tfNomenclatura.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				tfNomenclatura.selectAll();
			}
		});
		tfNomenclatura.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfDescripcion.requestFocus();
				}
			}
		});
		
				
		
		tfNomenclatura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_tfNomenclatura = new GridBagConstraints();
		gbc_tfNomenclatura.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNomenclatura.insets = new Insets(10, 3, 5, 10);
		gbc_tfNomenclatura.gridx = 1;
		gbc_tfNomenclatura.gridy = 2;
		gbc_tfNomenclatura.gridwidth=3;
		gbc_tfNomenclatura.gridheight=1;
		getContentPane().add(tfNomenclatura, gbc_tfNomenclatura);
		tfNomenclatura.setColumns(10);
		
		lblObligatorio1 = new JLabel("* ");
		lblObligatorio1.setForeground(Color.RED);
		lblObligatorio1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblObligatorio1 = new GridBagConstraints();
		gbc_lblObligatorio1.insets = new Insets(10, 5, 5, 10);
		gbc_lblObligatorio1.gridx = 4;
		gbc_lblObligatorio1.gridy = 2;
		lblObligatorio1.setVisible(false);
		getContentPane().add(lblObligatorio1, gbc_lblObligatorio1);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcion.insets = new Insets(10, 10, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 3;
		gbc_lblDescripcion.gridwidth=1;
		gbc_lblDescripcion.gridheight=1;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		tfDescripcion = new JTextField();
		tfDescripcion.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				tfDescripcion.selectAll();
			}
		});
		tfDescripcion.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					chActivo.requestFocus();
				}
			}
		});
		tfDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_tfDescripcion = new GridBagConstraints();
		gbc_tfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDescripcion.insets = new Insets(10, 3, 5, 10);
		gbc_tfDescripcion.gridx = 1;
		gbc_tfDescripcion.gridy = 3;
		gbc_tfDescripcion.gridwidth=3;
		gbc_tfDescripcion.gridheight=1;
		getContentPane().add(tfDescripcion, gbc_tfDescripcion);
		tfDescripcion.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.WEST;
		gbc_lblEstado.insets = new Insets(10, 10, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 4;
		gbc_lblEstado.gridheight=1;
		gbc_lblEstado.gridwidth=1;
		getContentPane().add(lblEstado, gbc_lblEstado);
		
		chActivo = new JCheckBox("Activo");
		chActivo.setBackground(new Color(255, 255, 224));
		chActivo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_chActivo = new GridBagConstraints();
		gbc_chActivo.fill = GridBagConstraints.HORIZONTAL;
		gbc_chActivo.insets = new Insets(10, 10, 5, 5);
		gbc_chActivo.gridx = 1;
		gbc_chActivo.gridy = 4;
		gbc_chActivo.gridheight=1;
		gbc_chActivo.gridwidth=1;
		getContentPane().add(chActivo, gbc_chActivo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoObligado2();
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		
		gbc_btnModificar.insets = new Insets(10, 10, 5, 5);
		gbc_btnModificar.gridx = 1;
		gbc_btnModificar.gridy = 5;
		getContentPane().add(btnModificar, gbc_btnModificar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				campoObligado1();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(10, 10, 5, 5);
		
		gbc_btnGuardar.gridx = 3;
		gbc_btnGuardar.gridy =5;
		getContentPane().add(btnGuardar, gbc_btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elimminar();
				limpiarJText();
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEliminar.gridx = 2;
		gbc_btnEliminar.gridy = 5;
		gbc_btnEliminar.gridheight=1;
		gbc_btnEliminar.gridwidth=1;
		getContentPane().add(btnEliminar, gbc_btnEliminar);
		
		
		
		
		
	}
	
	public void campoObligado1(){
		if((tfNomenclatura.getText().length()==0) | (tfDescripcion.getText().length()==0)) {
			lblObligatorio1.setVisible(true);
			lblObligatorio2.setVisible(true);
			lblCamposObligatorios.setVisible(true);
					}
		else{
			lblObligatorio1.setVisible(false);
			lblObligatorio2.setVisible(false);
			lblCamposObligatorios.setVisible(false);
			registrar();
			limpiarJText();
		}
	}
	
	public void campoObligado2(){
		if((tfNomenclatura.getText().length()==0) | (tfDescripcion.getText().length()==0)) {
			lblObligatorio1.setVisible(true);
			lblObligatorio2.setVisible(true);
					}
		else{
			lblObligatorio1.setVisible(false);
			lblObligatorio2.setVisible(false);
			modoficarCategoria();
			limpiarJText();
		}
	}
	
	
	public String fechaActual(){
		Date fecha= new Date();
		return formatoFecha.format(fecha);
	}
	
	public void limpiarJText(){
		tfCodigo.setText("");
		tfDescripcion.setText("");
		tfNomenclatura.setText("");
		chActivo.setSelected(false);
		
	}
	private void registrar() {
		Categoria categoria = new Categoria();
		try {
			Date f=formatoFecha.parse(tfFecha.getText());
			categoria.setFecha(f);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		categoria.setNomenclatura(tfNomenclatura.getText());
		categoria.setDescripcion(tfDescripcion.getText());
		categoria.setEstado(chActivo.isSelected());
		CategoriaDao.guardarCategoria(categoria);
	}
	
	private void consultarCategoria(){
		int codigo = Integer.parseInt(tfCodigo.getText());
		Categoria categoria = CategoriaDao.recuperarCategoriaPorCodigo(codigo);
		if (categoria != null){
			tfFecha.setText(formatoFecha.format(categoria.getFecha()));
			tfNomenclatura.setText(categoria.getNomenclatura());
			tfDescripcion.setText(categoria.getDescripcion());
			chActivo.setSelected(categoria.isEstado());
		}
	}
	
	private void modoficarCategoria(){
		Categoria categoria = new Categoria();
		categoria.setId(Integer.parseInt(tfCodigo.getText()));
		categoria.setFecha(new Date(tfFecha.getText()));
		categoria.setNomenclatura(tfNomenclatura.getText());
		categoria.setDescripcion(tfDescripcion.getText());
		categoria.setEstado(chActivo.isSelected());
		CategoriaDao.modificarCategoria(categoria);
	}
	
	private void elimminar(){
		int codigo = Integer.parseInt(tfCodigo.getText());
		CategoriaDao.eliminarCategoria(codigo);
	}
	

}
