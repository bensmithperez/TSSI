package ejer1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuPrincipal extends JPanel{
	JPanel p;
	JMenuItem miAgregar;
	JMenuItem miModificar;
	JMenuItem miEliminar;
	JMenuItem miListar;
	JList<Persona> lista;
	DefaultListModel<Persona> elementosLista;
	
	public MenuPrincipal(){
		this.setLayout(new BorderLayout());
		crearMenu();
		elementosLista = new DefaultListModel<Persona>();
		lista = new JList<Persona>(elementosLista);
	}
	
	public void crearMenu(){
		JMenuBar menuBar = new JMenuBar();
		JMenu itemPersona = new JMenu("Persona");
		
		//creo items menu...
		miAgregar = new JMenuItem("Agregar");
		miModificar = new JMenuItem("Modificar");
		miEliminar = new JMenuItem("Eliminar");
		miListar = new JMenuItem("Listar");
		
		//agrego acciones...
		miAgregar.addActionListener(new procesarEvento());
		miModificar.addActionListener(new procesarEvento());
		miEliminar.addActionListener(new procesarEvento());
		miListar.addActionListener(new procesarEvento());
		
		//agrego los items al menu...
		itemPersona.add(miAgregar);
		itemPersona.add(miModificar);
		itemPersona.add(miEliminar);
		itemPersona.add(miListar);
		
		menuBar.add(itemPersona);
		this.add(menuBar, BorderLayout.NORTH);
		
		p = new JPanel();
		this.add(p, BorderLayout.CENTER);
	}
	
	class procesarEvento implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == miAgregar){
				System.out.println("agregar");
				p.removeAll();
				FormAgregar fa = new FormAgregar(elementosLista);
				p.add(fa);
				p.repaint();
				p.revalidate();
			}
			if(e.getSource() == miModificar){
				System.out.println("modificar");
				p.removeAll();
				FormModificar fa = new FormModificar(lista,elementosLista);
				p.add(fa);
				p.repaint();
				p.revalidate();
			}
			if(e.getSource() == miEliminar){
				System.out.println("eliminar");
				p.removeAll();
				FormEliminar fe = new FormEliminar(lista,elementosLista);
				p.add(fe);
				p.repaint();
				p.revalidate();
			}
			if(e.getSource() == miListar){
				System.out.println("listar");
				p.removeAll();
				FormListar fl = new FormListar(lista);
				p.add(fl);
				p.repaint();
				p.revalidate();
			}
		}
	}
}
