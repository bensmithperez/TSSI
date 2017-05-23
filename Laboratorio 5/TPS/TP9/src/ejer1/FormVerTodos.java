package ejer1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.TreeSet;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class FormVerTodos extends JPanel{
	TreeSet<Usuario> listaUsuarios;
	
	public FormVerTodos(){
		
	}
	
	public FormVerTodos(TreeSet<Usuario> listaUsuarios){
		this.listaUsuarios = listaUsuarios;
		DefaultListModel<Usuario> lista = new DefaultListModel<Usuario>();
		JList<Usuario> lstUsuarios = new JList<Usuario>();
		for (Usuario u : listaUsuarios){
			lista.addElement(u);
		}
		lstUsuarios.setModel(lista);
		
		//lista.setPreferredSize(new java.awt.Dimension(300,130));

		lstUsuarios.setPreferredSize(new java.awt.Dimension(300,130));

	    this.add(lstUsuarios, BorderLayout.CENTER);
	}
}
