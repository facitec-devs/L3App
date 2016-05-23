package py.edu.facitec.l3app.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import py.edu.facitec.l3app.formulario.FormMotivo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuMotivo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuMotivo frame = new MenuMotivo();
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
	public MenuMotivo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnMotivo = new JButton("motivo");
		btnMotivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		FormMotivo formMotivo= new FormMotivo();
		formMotivo.setVisible(true);
			}
		});
		contentPane.add(btnMotivo, BorderLayout.NORTH);
	}

}
