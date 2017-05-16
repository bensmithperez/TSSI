package ejer1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FormModificar extends JPanel{
	JTextField txtNombre;
	JTextField txtApellido;
	JTextField txtDNI;
	JList<Persona> lista;
	DefaultListModel<Persona> elementosLista;
	
	public FormModificar(JList<Persona> lista , DefaultListModel<Persona> elementosLista){
		
		this.lista = lista;
		this.elementosLista = elementosLista;
		
		this.setLayout(new BorderLayout());
		
		JLabel lblDescripcion = new JLabel("Seleccione la persona que desea modificar");
		this.add(lblDescripcion, BorderLayout.NORTH);

		lista.setPreferredSize(new java.awt.Dimension(130,130));
		lista.addListSelectionListener(new eCopy());
		this.add(lista, BorderLayout.CENTER);
		
		
		JPanel p2 = new JPanel();
		
		txtNombre = new JTextField(8);
		p2.add(txtNombre);
		
		txtApellido = new JTextField(8);
		p2.add(txtApellido);
		
		txtDNI = new JTextField(8);
		p2.add(txtDNI);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new eModificar());
		p2.add(btnModificar);
		
		this.add(p2, BorderLayout.SOUTH);
		
	}
	
	private class eCopy implements ListSelectionListener{

		public void valueChanged(ListSelectionEvent e) {
			
			Persona x = (Persona) lista.getSelectedValue() ;
			if(x != null)
			{
				txtNombre.setText(x.getNombre());
				txtApellido.setText(x.getApellido());
				txtDNI.setText(x.getDni()+"");
			}
		}	
	}

	
	private class eModificar implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			 Persona x = (Persona) lista.getSelectedValue() ;
			 x.setApellido(txtApellido.getText());
			 x.setDni(txtDNI.getText());
			 x.setNombre(txtNombre.getText());
			 lista.repaint();
		    
		}
	}
}
