package ejer1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Inicio extends JPanel{
	JTextField txtUsuario;
	JComboBox<String> cbPermisos;
	
	public Inicio(){

	    
	    JLabel lblUsuario = new JLabel("Usuario:");
		this.add(lblUsuario);
		
		txtUsuario = new JTextField(12);
		this.add(txtUsuario);
		
		String[] permisos = {"Usuario","Admin"};
		JComboBox<String> cbPermisos = new JComboBox<String>(permisos);
		cbPermisos.setSelectedIndex(0);
		this.add(cbPermisos);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener( new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, txtUsuario.getText() + " " + cbPermisos.getSelectedItem(), "aceptar", JOptionPane.PLAIN_MESSAGE);
			}
		});
		this.add(btnAceptar);
	}
}
