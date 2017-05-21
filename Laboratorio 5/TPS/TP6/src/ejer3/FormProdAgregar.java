package ejer3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormProdAgregar extends JPanel{
	JTextField txtNombre;
	JTextField txtCant;
	DefaultListModel<Producto> elementosListaProd;
	DefaultListModel<Categoria> elementosListaCat;
	JComboBox<Categoria> cbCategorias;
	
	public FormProdAgregar(DefaultListModel<Producto> elementosListaProd, DefaultListModel<Categoria> elementosListaCat){
		this.elementosListaProd = elementosListaProd;
		this.elementosListaCat = elementosListaCat;
		
		GridLayout gl = new GridLayout();
		gl.setHgap(1);
		gl.setVgap(10);
	    gl.setColumns(2);
	    gl.setRows(6);
		    
		this.setLayout(gl);
	    this.setVisible(true);
		
		JLabel lblNombre = new JLabel("Nombre producto:");
		this.add(lblNombre);
		
		txtNombre = new JTextField(12);
		this.add(txtNombre);
		
		cbCategorias = new JComboBox(elementosListaCat.toArray());
		this.add(cbCategorias);
		
		JLabel lblCant = new JLabel("Cantidad:");
		this.add(lblCant);
		
		txtCant = new JTextField(12);
		this.add(txtCant);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			 Producto p = new Producto(txtNombre.getText(),cbCategorias.getSelectedItem().toString(),Integer.parseInt(txtCant.getText()));
			 elementosListaProd.addElement(p);
			 //System.out.println(elementosListaCat);
			 txtNombre.setText("");
			 cbCategorias.setSelectedIndex(0);
			 txtCant.setText("");
			}
		});
		this.add(btnAceptar);
	}
}
