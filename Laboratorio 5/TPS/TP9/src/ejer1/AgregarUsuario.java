package ejer1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AgregarUsuario extends JPanel{
	Marco framePrincipal = new Marco();
	JTextField txtNombre;
	JTextField txtApellido;
	JTextField txtDNI;
	
	FormVerTodos fvt;
	
	public AgregarUsuario(){
		GridLayout gl = new GridLayout();
		gl.setHgap(1);
		gl.setVgap(10);
	    gl.setColumns(4);
	    gl.setRows(6);
		    
		this.setLayout(gl);
	    this.setVisible(true);
	    
	    JLabel lblNombre= new JLabel("Nombre:");
		this.add(lblNombre);
		
		txtNombre = new JTextField(12);
		this.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		this.add(lblApellido);
		
		txtApellido= new JTextField(12);
		this.add(txtApellido);
		
		JLabel lblDNI= new JLabel("DNI:");
		this.add(lblDNI);
		
		txtDNI = new JTextField(12);
		this.add(txtDNI);

		JRadioButton rbFemenino = new JRadioButton("Femenino");

		JRadioButton rbMasculino = new JRadioButton("Masculino");

		ButtonGroup bgSexo = new ButtonGroup();

		bgSexo.add(rbFemenino);

		bgSexo.add(rbMasculino);

		rbFemenino.setSelected(true);

		

		this.add(rbFemenino);

		this.add(rbMasculino);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}	
		});
		this.add(btnGuardar);
		
		JButton btnVerTodos= new JButton("Ver Todos");
		btnVerTodos.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePrincipal = new Marco();
				fvt = new FormVerTodos();
				framePrincipal.add(fvt);
				framePrincipal.setVisible(true);
			}	
		});
		this.add(btnVerTodos);
	}
}