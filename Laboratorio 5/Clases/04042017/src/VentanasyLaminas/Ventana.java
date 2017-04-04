package VentanasyLaminas;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	public Ventana(){
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public Ventana(int ancho, int alto){
		setSize(ancho, alto);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
