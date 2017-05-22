package ejer1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Inicio extends JPanel{
	Marco framePrincipal = new Marco();
	JTextField txtTitulo;
	JTextField txtEncabezado;
	JTextArea txtParrafo;
	JTextField txtImagen;
	FormResultado fr;
	
	public Inicio(){
		GridLayout gl = new GridLayout();
		gl.setHgap(1);
		gl.setVgap(10);
	    gl.setColumns(4);
	    gl.setRows(6);
		    
		this.setLayout(gl);
	    this.setVisible(true);
	    
	    JLabel lblDescTitulo = new JLabel("Titulo de la página:");
		this.add(lblDescTitulo);
		
		txtTitulo= new JTextField(12);
		this.add(txtTitulo);
		
		JLabel lblDescEncabezado = new JLabel("Agregar encabezado:");
		this.add(lblDescEncabezado);
		
		txtEncabezado = new JTextField(12);
		this.add(txtEncabezado);
		
		JLabel lblDescParrafo = new JLabel("Texto del parrafo:");
		this.add(lblDescParrafo);
		
		txtParrafo = new JTextArea(12,2);
		this.add(txtParrafo);
		
		JLabel lblDescImagen = new JLabel("URL imagen:");
		this.add(lblDescImagen);
		
		txtImagen = new JTextField(12);
		this.add(txtImagen);

		JButton btnAceptar = new JButton("Generar HTML");
		btnAceptar.addActionListener( new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
			framePrincipal = new Marco();
			fr = new FormResultado(txtTitulo.getText(), txtEncabezado.getText(), txtParrafo.getText(), txtImagen.getText());
			framePrincipal.add(fr);
			framePrincipal.setVisible(true);
			}
		});
		this.add(btnAceptar);
	}
}
