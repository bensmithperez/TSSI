package ejer1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormAgregar extends JPanel{
	JTextField txtNombre;
	JTextField txtApellido;
	JTextField txtDNI;
	DefaultListModel<Persona> elementosLista;
	
	public FormAgregar(DefaultListModel<Persona> elementosLista){
		this.elementosLista = elementosLista;
		
		GridLayout gl = new GridLayout();
		gl.setHgap(1);
		gl.setVgap(10);
	    gl.setColumns(2);
	    gl.setRows(6);
		    
		this.setLayout(gl);
	    this.setVisible(true);
	    
	    JLabel lblNombre = new JLabel("Nombre:");
		this.add(lblNombre);
		
		txtNombre = new JTextField(12);
		this.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		this.add(lblApellido);
		
		txtApellido = new JTextField(12);
		this.add(txtApellido);
		
		JLabel lblDNI = new JLabel("DNI:");
		this.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(12);
		this.add(txtDNI);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			 Persona p = new Persona(txtNombre.getText() , txtApellido.getText() , txtDNI.getText());
			 elementosLista.addElement(p);
			 System.out.println(elementosLista);
			 txtNombre.setText("");
			 txtApellido.setText("");
			 txtDNI.setText("");
			}
		});
		this.add(btnAceptar);
	}
	
}
