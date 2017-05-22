package ejer1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormResultado extends JPanel{
	public FormResultado(String titulo, String encabezado,String parrafo,String imagen){	
		JTextField txtNombreArchivo;
		GridLayout gl = new GridLayout();
		gl.setHgap(1);
		gl.setVgap(1);
	    gl.setColumns(1);
	    gl.setRows(3);
		    
		this.setLayout(gl);
	    this.setVisible(true);
	    
	    String res = "<html>\n<head>\n<title>" + titulo +
	    		     "</title>\n<head>" + encabezado + 
	    		     "</head>\n<p>" + parrafo + 
	    		     "</p>\n<img src='" + imagen + "'/>\n</head>\n</html>" ;
	    
	    
	    JTextArea lblDescTitulo = new JTextArea(res);
		this.add(lblDescTitulo);
		
		txtNombreArchivo = new JTextField(12);
		this.add(txtNombreArchivo);
		
		JButton btnAceptar = new JButton("Guardar Archivo");
		btnAceptar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter f = new FileWriter("C:/Users/Ben/Documents/gitStuff/TSSI/Laboratorio 5/TPS/TP7/"+txtNombreArchivo.getText(), true);
					f.write(res);
					f.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		this.add(btnAceptar);
		
		mostrar();

	}
	public void mostrar(){
		this.setVisible(true);
	}
	
}
