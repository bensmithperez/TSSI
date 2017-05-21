package ejer3;

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
	
	JMenuItem miCatAgregar;
	JMenuItem miProdAgregar;
	JMenuItem miProdListar;
	
	JList<Categoria> listaCat;
	JList<Producto> listaProd;
	DefaultListModel<Categoria> elementosListaCat;
	DefaultListModel<Producto> elementosListaProd;
	
	public MenuPrincipal(){
		this.setLayout(new BorderLayout());
		crearMenu();
		elementosListaCat = new DefaultListModel<Categoria>();
		elementosListaProd = new DefaultListModel<Producto>();
		listaCat = new JList<Categoria>(elementosListaCat);
		listaProd = new JList<Producto>(elementosListaProd);
	}
	
	public void crearMenu(){
		JMenuBar menuBar = new JMenuBar();
		JMenu itemCategorias = new JMenu("Categorías");
		JMenu itemProductos = new JMenu("Productos");
		
		//creo items menu...(categorias y prods)
		miCatAgregar = new JMenuItem("Agregar");
		miProdAgregar = new JMenuItem("Agregar");
		miProdListar = new JMenuItem("Listar");
		
		//agrego acciones...	
		miCatAgregar.addActionListener(new procesarEvento());
		miProdAgregar.addActionListener(new procesarEvento());
		miProdListar.addActionListener(new procesarEvento());
		
		//agrego los items al menu...
		itemCategorias.add(miCatAgregar);
		itemProductos.add(miProdAgregar);
		itemProductos.add(miProdListar);
		
		menuBar.add(itemCategorias);
		menuBar.add(itemProductos);
		this.add(menuBar, BorderLayout.NORTH);
		
		p = new JPanel();
		this.add(p, BorderLayout.CENTER);
	}
	
	class procesarEvento implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == miCatAgregar){
				System.out.println("categoria agregar");
				p.removeAll();
				FormCatAgregar fca = new FormCatAgregar(elementosListaCat);
				p.add(fca);
				p.repaint();
				p.revalidate();
			}
			if(e.getSource() == miProdAgregar){
				System.out.println("producto agregar");
				/*p.removeAll();
				FormProdAgregar fpa = new FormProdAgregar(elementosListaProd);
				p.add(fpa);
				p.repaint();
				p.revalidate();*/
			}
			if(e.getSource() == miProdListar){
				System.out.println("producto listar");
				/*p.removeAll();
				FormProdListar fpl = new FormProdListar(listaProd);
				p.add(fpl);
				p.repaint();
				p.revalidate();*/
			}
		}
	}
}