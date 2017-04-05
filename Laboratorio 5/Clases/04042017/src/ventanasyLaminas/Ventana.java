package ventanasyLaminas;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	public Ventana(){
		setSize(400, 200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Lamina lam = new Lamina();
		add(lam);
		setVisible(true);
	}
}
