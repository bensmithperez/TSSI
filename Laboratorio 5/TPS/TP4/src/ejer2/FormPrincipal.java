package ejer2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPrincipal {

	private JFrame frame;
	private JTextField txtLegajo;
	private JTextField txtEmpleado;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Experiencia Laboral");
		lblTitulo.setBounds(170, 11, 112, 14);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblLegajo = new JLabel("Legajo:");
		lblLegajo.setBounds(10, 40, 46, 14);
		frame.getContentPane().add(lblLegajo);
		
		txtLegajo = new JTextField();
		txtLegajo.setBounds(82, 37, 125, 20);
		frame.getContentPane().add(txtLegajo);
		txtLegajo.setColumns(10);
		
		JLabel lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setBounds(10, 68, 62, 14);
		frame.getContentPane().add(lblEmpleado);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setColumns(10);
		txtEmpleado.setBounds(82, 65, 125, 20);
		frame.getContentPane().add(txtEmpleado);
				
		JPanel panelOpciones = new JPanel();
		panelOpciones.setBounds(229, 36, 182, 137);
		panelOpciones.setBorder(BorderFactory.createTitledBorder("Opciones"));
		frame.getContentPane().add(panelOpciones);
		
		JCheckBox cbProgramador = new JCheckBox("Programador");
		panelOpciones.add(cbProgramador);
		
		JCheckBox cbTester = new JCheckBox("Tester");
		panelOpciones.add(cbTester);
		
		JCheckBox cbDataEntry= new JCheckBox("Data Entry");
		panelOpciones.add(cbDataEntry);
		
		JCheckBox cbAnalista = new JCheckBox("Analista Funcional");
		panelOpciones.add(cbAnalista);
		
		JCheckBox cbDBA = new JCheckBox("DBA");
		panelOpciones.add(cbDBA);
		
		JTextPane tpResultado = new JTextPane();
		tpResultado.setEditable(false);
		tpResultado.setBounds(10, 179, 414, 71);
		frame.getContentPane().add(tpResultado);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resultado = "";
				resultado += "Legajo: " + txtLegajo.getText() + 
						"\nEmpleado: " + txtEmpleado.getText() +
						"\nOpciones: ";
				
				for(int i=0; i<panelOpciones.getComponentCount();i++){
					JCheckBox cb = (JCheckBox) panelOpciones.getComponent(i);
					if (cb.isSelected()){
						resultado += " " + cb.getText();
					}
				}
				
				tpResultado.setText(resultado);
			}
		});
		btnGuardar.setBounds(63, 115, 89, 23);
		frame.getContentPane().add(btnGuardar);
	}
}
