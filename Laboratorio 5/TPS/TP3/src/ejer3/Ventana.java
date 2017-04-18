package ejer3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class Ventana {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(54, 34, 116, 14);
		frame.getContentPane().add(lblNombre);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(176, 31, 86, 20);
		frame.getContentPane().add(txtNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(54, 60, 116, 14);
		frame.getContentPane().add(lblPrecio);
		
		JTextField txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(176, 57, 86, 20);
		frame.getContentPane().add(txtPrecio);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(54, 86, 116, 14);
		frame.getContentPane().add(lblStock);
		
		JTextField txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(176, 83, 86, 20);
		frame.getContentPane().add(txtStock);
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa:");
		lblCategoria.setBounds(54, 112, 116, 14);
		frame.getContentPane().add(lblCategoria);
		
		JComboBox<String> cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(176, 109, 28, 20);
		frame.getContentPane().add(cbCategoria);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(176, 160, 86, 23);
		frame.getContentPane().add(btnGuardar);
		
		JTextPane tpDatos = new JTextPane();
		tpDatos.setBounds(40, 214, 250, 200);
		frame.getContentPane().add(tpDatos);
	}
}
