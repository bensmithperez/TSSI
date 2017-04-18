package ejer1;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal window = new FormPrincipal();
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
	public FormPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(57, 46, 100, 14);
		frame.getContentPane().add(lblNombre);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(178, 40, 127, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(57, 74, 100, 14);
		frame.getContentPane().add(lblApellido);
		
		JTextField txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(178, 68, 127, 20);
		frame.getContentPane().add(txtApellido);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(57, 104, 100, 14);
		frame.getContentPane().add(lblNacionalidad);
		
		JComboBox<String> cbNacionalidad = new JComboBox<String>();
		cbNacionalidad.setBounds(178, 99, 127, 20);
		frame.getContentPane().add(cbNacionalidad);
		
		cbNacionalidad.addItem("Argentina");
		cbNacionalidad.addItem("Uruguay");
		cbNacionalidad.addItem("Chile");
		cbNacionalidad.addItem("Paraguay");
		
		JPanel panelEstadoCivil = new JPanel();
		panelEstadoCivil.setBounds(178, 162, 100, 100);
		frame.getContentPane().add(panelEstadoCivil);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		panelEstadoCivil.add(lblEstadoCivil);
		
		ButtonGroup bgEstadoCivil = new ButtonGroup();
		
		JRadioButton rbCasado = new JRadioButton("Casado");
		rbCasado.setActionCommand("Casado");
		bgEstadoCivil.add(rbCasado);
		
		JRadioButton rbSoltero = new JRadioButton("Soltero");
		rbSoltero.setActionCommand("Soltero");
		bgEstadoCivil.add(rbSoltero);
		
		panelEstadoCivil.add(rbCasado);
		panelEstadoCivil.add(rbSoltero);
		
		JPanel panelSexo = new JPanel();
		panelSexo.setBounds(57, 162, 100, 100);
		frame.getContentPane().add(panelSexo);
		
		JLabel lblSexo = new JLabel("Sexo");
		panelSexo.add(lblSexo);
		
		ButtonGroup bgSexo = new ButtonGroup();
		
		JRadioButton rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setActionCommand("Masculino");
		bgSexo.add(rbMasculino);
		
		JRadioButton rbFemenino = new JRadioButton("Femenino");
		rbFemenino.setActionCommand("Femenino");
		bgSexo.add(rbFemenino);
		
		panelSexo.add(rbMasculino);
		panelSexo.add(rbFemenino);		
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Nombre: " + txtNombre.getText() +
						" Apellido: " + txtApellido.getText() + 
						" Nacionalidad: " + cbNacionalidad.getSelectedItem() + 
						" Estado: " + bgEstadoCivil.getSelection().getActionCommand() +
						" Sexo: " + bgSexo.getSelection().getActionCommand());
			}
		});
		btnMostrar.setBounds(125, 327, 89, 23);
		frame.getContentPane().add(btnMostrar);
	}
}
