package ejer1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FormPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				Marco framePrincipal = new Marco();
				Inicio fi = new Inicio();
				framePrincipal.add(fi);
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
		setTitle("TP6");
	}
	
	public void mostrar(){
		setVisible(true);
	}
}