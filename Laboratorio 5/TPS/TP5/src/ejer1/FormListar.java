package ejer1;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class FormListar extends JPanel{
	JList<Persona> lista;
	
	public FormListar(JList<Persona> lista){
		this.lista = lista;
		
		this.setVisible(true);
		  
		JLabel lblDescripcion = new JLabel("Usuarios ingresados");
		this.add(lblDescripcion, BorderLayout.NORTH);
		  
		lista.setPreferredSize(new java.awt.Dimension(300,130));
	    this.add(lista, BorderLayout.CENTER);
	}
}
