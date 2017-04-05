package ventanasyLaminas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Ejemplo1 {

	public static void main(String[] args) {
		JFrame ventana = new JFrame();
			
		//para ver dimensiones de pantalla (usando awt)
		Toolkit pantallaActual = Toolkit.getDefaultToolkit();
		Dimension tamanioPantalla = pantallaActual.getScreenSize();
		
		//ventana.setLocation(300,300);
		//ventana.setSize(200,200);
		
		//set bounds hace ambos
		//ventana.setBounds(tamanioPantalla.width/2-100,tamanioPantalla.height/2-100,200,200);
		ventana.setSize(200,200);
		//centrar (usando swing)
		ventana.setLocationRelativeTo(null);
		
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
