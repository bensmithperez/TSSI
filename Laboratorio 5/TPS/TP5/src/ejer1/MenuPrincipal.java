package ejer1;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.BorderLayout;

import javax.swing.JMenu;

public class MenuPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuPrincipal() {
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuItemPersona = new JMenu("Persona");
		menuBar.add(menuItemPersona);
		
		JMenuItem menuPersonaAgregar = new JMenuItem("Agregar");
		menuItemPersona.add(menuPersonaAgregar);
		
		JMenuItem menuPersonaModificar = new JMenuItem("Modificar");
		menuItemPersona.add(menuPersonaModificar);
		
		JMenuItem menuPersonaEliminar = new JMenuItem("Eliminar");
		menuItemPersona.add(menuPersonaEliminar);
		
		JMenuItem menuPersonaListar = new JMenuItem("Listar");
		menuItemPersona.add(menuPersonaListar);

	}

}
