package ejer1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class FormEliminar extends JPanel implements ActionListener{
	JList<Persona> lista;
	DefaultListModel<Persona> elementosLista;
	
	public FormEliminar(JList<Persona> lista, DefaultListModel<Persona> elementosLista){
		this.setVisible(true);
  
		this.lista = lista;
		this.elementosLista = elementosLista;
			
		this.setLayout(new BorderLayout());
		JLabel lblDescripcion = new JLabel("Eliminar usuarios");
		this.add(lblDescripcion, BorderLayout.NORTH);
			  
		
		lista.setPreferredSize(new java.awt.Dimension(300,130));
		this.add(lista, BorderLayout.CENTER);
		  
		JButton btn = new JButton("Eliminar");
		btn.addActionListener(this);
		this.add(btn, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		   int i = lista.getSelectedIndex();
		   elementosLista.removeElementAt(i);
		}
}
