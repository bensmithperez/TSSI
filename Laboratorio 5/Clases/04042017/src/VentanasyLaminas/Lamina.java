package VentanasyLaminas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Lamina extends JPanel{
	
	public Lamina(){
		setBackground(Color.blue);
		
		JButton bNegro = new JButton("Boton Negro");
		JButton bBlanco = new JButton("Boton Blanco");
		add(bNegro);
		add(bBlanco);
		
		ActionListener ebn = new eventoBNegro();
		
		bNegro.addActionListener(ebn);
		
	}
	
	class eventoBNegro implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("Boton negro presionado!");
			//setBackground(Color.white);
		}
	}

}