package ejer1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frame;
	private JTextField tbNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 329, 203);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Ingrese su nombre:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescripcion.setBounds(21, 24, 117, 14);
		frame.getContentPane().add(lblDescripcion);
		
		tbNombre = new JTextField();
		tbNombre.setBounds(158, 22, 128, 20);
		tbNombre.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                tbNombre.setText("");
                Color c = new Color(255,255,255);
				tbNombre.setBackground(c);
            }
        });
		frame.getContentPane().add(tbNombre);
		tbNombre.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new AccionAceptar());		
		btnAceptar.setBounds(104, 90, 89, 23);
		frame.getContentPane().add(btnAceptar);
	}
	
	private class AccionAceptar implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			//System.out.println("Click en aceptar. Nombre: " + tbNombre.getText());
			if (tbNombre.getText().isEmpty()){
				Color c = new Color(255,0,0);
				tbNombre.setBackground(c);
			} else {
				VentanaSaludo vs1 = new VentanaSaludo(tbNombre.getText());
				vs1.setVisible(true);
			}
		}
	}
}
