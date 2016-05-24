package py.edu.facitec.l3app.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import py.edu.facitec.l3app.formulario.FormVendedor;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.text.Normalizer.Form;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MenuVendedor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuVendedor frame = new MenuVendedor();
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
	public MenuVendedor() {
		setTitle("Vendedor");
		//setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(20, 0, 73, 21);
		contentPane.add(menuBar);
		
		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		JMenuItem mntmRegistroDeVendedor = new JMenuItem("Registro de vendedor");
		mntmRegistroDeVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormVendedor s = new FormVendedor();
				s.setVisible(true);
			}
		});
		mnVentas.add(mntmRegistroDeVendedor);
	}
}
