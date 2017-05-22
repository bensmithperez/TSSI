package ejer1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FormPrincipal {	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				Marco framePrincipal = new Marco();
				Inicio inicio = new Inicio();
				FormResultado fr = new FormResultado();
				framePrincipal.add(fr);
				framePrincipal.add(inicio);
				framePrincipal.mostrar();
				
				
			}
		});
	}
}

class Marco extends JFrame{
	public Marco(){
		setVisible(false);
		setBounds(100,100,600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Creando página HTML");
	}
	
	public void mostrar(){
		setVisible(true);
	}
}
