package ejer2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
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
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		frame.getContentPane().add(panelInput, BorderLayout.NORTH);
		panelInput.setLayout(new BoxLayout(panelInput, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		//el ejercicio lo pide...
		textField.setEditable(false);
		textField.setEnabled(false);
		//---
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput.add(textField);
		textField.setColumns(10);
		
		JPanel panelBotones = new JPanel();
		frame.getContentPane().add(panelBotones, BorderLayout.CENTER);
		panelBotones.setLayout(new GridLayout(4, 4));
		
		//creo todos los botones...
		JButton btnNum1 = new JButton("1");
		JButton btnNum2 = new JButton("2");
		JButton btnNum3 = new JButton("3");
		JButton btnNum4 = new JButton("4");
		JButton btnNum5 = new JButton("5");
		JButton btnNum6 = new JButton("6");
		JButton btnNum7 = new JButton("7");
		JButton btnNum8 = new JButton("8");
		JButton btnNum9 = new JButton("9");
		JButton btnNum0 = new JButton("0");
		JButton btnCE = new JButton("CE");
		JButton btnIgual = new JButton("=");
		JButton btnSumar = new JButton("+");
		JButton btnRestar = new JButton("-");
		JButton btnDividir = new JButton("/");
		JButton btnMultiplicar = new JButton("*");

		//los agrego en el orden que los quiero...
		panelBotones.add(btnNum1);
		panelBotones.add(btnNum2);
		panelBotones.add(btnNum3);
		panelBotones.add(btnSumar);
		panelBotones.add(btnNum4);
		panelBotones.add(btnNum5);
		panelBotones.add(btnNum6);
		panelBotones.add(btnRestar);
		panelBotones.add(btnNum7);
		panelBotones.add(btnNum8);
		panelBotones.add(btnNum9);
		panelBotones.add(btnMultiplicar);
		panelBotones.add(btnNum0);
		panelBotones.add(btnCE);
		panelBotones.add(btnIgual);
		panelBotones.add(btnDividir);
		
		for 	
	}

}
