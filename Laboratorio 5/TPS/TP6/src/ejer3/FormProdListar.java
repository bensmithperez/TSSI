package ejer3;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class FormProdListar extends JPanel{
	JList<Producto> lista;
	
	public FormProdListar(JList<Producto> lista){
		this.lista = lista;
		
		this.setVisible(true);
		  
		JLabel lblDescripcion = new JLabel("Listado de articulos");
		this.add(lblDescripcion, BorderLayout.NORTH);
		  
		lista.setPreferredSize(new java.awt.Dimension(300,130));
	    this.add(lista, BorderLayout.CENTER);
	}
}
