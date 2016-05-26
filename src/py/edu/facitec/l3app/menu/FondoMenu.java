package py.edu.facitec.l3app.menu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class FondoMenu extends JPanel {

	ImageIcon imagen;
	
	
	public FondoMenu(String nombre) {
		super();
		imagen = new ImageIcon(getClass().getResource(nombre));
		setSize(imagen.getIconWidth(), imagen.getIconHeight());
		
	}
	protected void paintComponent(Graphics g){
		Dimension d = getSize();
		g.drawImage(imagen.getImage(),0,0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
		
		
	}

}
