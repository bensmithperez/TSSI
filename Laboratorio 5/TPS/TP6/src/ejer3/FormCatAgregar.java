package ejer3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormCatAgregar extends JPanel{
	JTextField txtId;
	JTextField txtNombre;
	DefaultListModel<Categoria> elementosListaCat;
	
	public FormCatAgregar(DefaultListModel<Categoria> elementosListaCat){
		this.elementosListaCat = elementosListaCat;
		
		GridLayout gl = new GridLayout();
		gl.setHgap(1);
		gl.setVgap(10);
	    gl.setColumns(2);
	    gl.setRows(6);
		    
		this.setLayout(gl);
	    this.setVisible(true);
	    
	    JLabel lblId = new JLabel("ID categoría:");
		this.add(lblId);
		
		txtId = new JTextField(12);
		this.add(txtId);
		
		JLabel lblNombre = new JLabel("Nombre categoría:");
		this.add(lblNombre);
		
		txtNombre = new JTextField(12);
		this.add(txtNombre);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			 Categoria p = new Categoria(txtId.getText(), txtNombre.getText());
			 elementosListaCat.addElement(p);
			 //System.out.println(elementosListaCat);
			 txtId.setText("");
			 txtNombre.setText("");
			}
		});
		this.add(btnAceptar);
	}
}
