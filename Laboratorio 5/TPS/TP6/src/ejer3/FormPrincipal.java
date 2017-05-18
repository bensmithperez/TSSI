package ejer3;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FormPrincipal {	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				Marco framePrincipal = new Marco();
				MenuPrincipal mp = new MenuPrincipal();
				framePrincipal.add(mp);
				framePrincipal.mostrar();
			}
		});
	}
}

class Marco extends JFrame{
	public Marco(){
		setVisible(false);
		setBounds(100,100,450,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("TP5");
	}
	
	public void mostrar(){
		setVisible(true);
	}
}
