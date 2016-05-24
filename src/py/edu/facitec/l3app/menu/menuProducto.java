package py.edu.facitec.l3app.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import py.edu.facitec.l3app.formulario.FormProducto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class menuProducto extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuProducto frame = new menuProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menuProducto() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			FormProducto producto = new FormProducto();
			producto.setVisible(true);
			}
		});
		btnProductos.setBounds(10, 11, 111, 34);
		contentPane.add(btnProductos);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(menuProducto.class.getResource("/py/edu/facitec/l3app/dao/Logo.png")));
		label.setBounds(544, 109, 544, 435);
		contentPane.add(label);

	}
}
