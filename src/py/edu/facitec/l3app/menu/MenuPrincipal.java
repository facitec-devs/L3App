package py.edu.facitec.l3app.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import py.edu.facitec.l3app.formulario.FmrProveedores;
import py.edu.facitec.l3app.formulario.FormCompras;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setTitle("Menu Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/img/Top Menu.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegistros = new JMenu("Registros");
		mnRegistros.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/Plus Math.png")));
		menuBar.add(mnRegistros);
		
		JMenuItem mntmProveedores = new JMenuItem("Proveedores");
		mntmProveedores.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/Move .png")));
		mntmProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FmrProveedores fmrProveedores = new FmrProveedores();
				fmrProveedores.setVisible(true);
			}
		});
		mnRegistros.add(mntmProveedores);
		
		JMenu mnMovimientos = new JMenu("Movimientos");
		mnMovimientos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/Shopping Cart.png")));
		menuBar.add(mnMovimientos);
		
		JMenuItem mntmCompras = new JMenuItem("Compras");
		mntmCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormCompras formCompras = new FormCompras();
				formCompras.setVisible(true);
			}
		});
		mntmCompras.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/Shopping Bag.png")));
		mnMovimientos.add(mntmCompras);
		
		JMenu mnMs = new JMenu("M\u00E1s");
		mnMs.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/Expand Arrow.png")));
		menuBar.add(mnMs);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mntmSalir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/Shutdown.png")));
		mnMs.add(mntmSalir);
		contentPane = new FondoMenu("/img/fondo1.jpg");
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Principal");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(437, 11, 423, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormCompras formCompras = new FormCompras();
				formCompras.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/Add Shopping Cart.png")));
		btnNewButton.setBounds(1129, 293, 108, 83);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FmrProveedores fmrProveedores = new FmrProveedores();
				fmrProveedores.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/Shipped.png")));
		button.setBounds(183, 293, 108, 83);
		contentPane.add(button);
		
		JLabel lblRegistroProveedores = new JLabel("Registro Proveedores");
		lblRegistroProveedores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistroProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroProveedores.setBounds(118, 168, 244, 83);
		contentPane.add(lblRegistroProveedores);
		
		JLabel lblRegistroCompras = new JLabel("Movimiento Compras");
		lblRegistroCompras.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroCompras.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistroCompras.setBounds(1055, 168, 244, 83);
		contentPane.add(lblRegistroCompras);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/Delete.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(1129, 614, 189, 56);
		contentPane.add(btnNewButton_1);
		setExtendedState(MAXIMIZED_BOTH);
	}
}
