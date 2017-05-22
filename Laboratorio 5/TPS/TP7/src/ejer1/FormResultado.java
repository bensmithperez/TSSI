package ejer1;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormResultado extends JPanel{
	public FormResultado(){	
		GridLayout gl = new GridLayout();
		gl.setHgap(1);
		gl.setVgap(10);
	    gl.setColumns(4);
	    gl.setRows(0);
		    
		this.setLayout(gl);
	    this.setVisible(true);
	    
	    JLabel lblDescTitulo = new JLabel("Titulo de la página:");
		this.add(lblDescTitulo);
		mostrar();

	}
	
	public FormResultado(String titulo, String encabezado,String parrafo,String imagen){	
		GridLayout gl = new GridLayout();
		gl.setHgap(1);
		gl.setVgap(10);
	    gl.setColumns(4);
	    gl.setRows(6);
		    
		this.setLayout(gl);
	    this.setVisible(true);
	    
	    String res = "<html>\n<head>\n<title>" + titulo +
	    		     "</title>\n<head>" + encabezado + 
	    		     "</head>\n<p>" + parrafo + 
	    		     "</p>\n</img src='" + imagen + "'>" ;
	    
	    
	    JTextArea lblDescTitulo = new JTextArea(res);
		this.add(lblDescTitulo);
		mostrar();

	}
	public void mostrar(){
		this.setVisible(true);
	}
	
}
