package ejer1;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormResultado extends JPanel{
	public FormResultado(){	
		GridLayout gl = new GridLayout();
		gl.setHgap(1);
		gl.setVgap(10);
	    gl.setColumns(4);
	    gl.setRows(6);
		    
		this.setLayout(gl);
	    this.setVisible(true);
	    
	    JLabel lblDescTitulo = new JLabel("Titulo de la página:");
		this.add(lblDescTitulo);

	}
	public void mostrar(){
		this.setVisible(true);
	}
	
}
