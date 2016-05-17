package py.edu.facitec.l3app.formulario;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class FormProducto extends JDialog {

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

	/**
	 * Create the dialog.
	 */
	public FormProducto() {
		setBounds(100, 100, 450, 300);

	}

}
