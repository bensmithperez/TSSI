package ejer2;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Inicio extends JPanel{
	Color negro = new Color(0,0,0);
	
	public Inicio(){
		
		this.setLayout(null);
		
		//armo el primer panel...
		JPanel panelSO = new JPanel();
		panelSO.setBorder(new LineBorder(negro));
		panelSO.setBounds(0,0,350,40);
		
		JLabel lblDescSO = new JLabel("Elije un sistema operativo");
		
		JRadioButton rbWindows = new JRadioButton("Windows");
		JRadioButton rbMac = new JRadioButton("Mac");
		JRadioButton rbLinux = new JRadioButton("Linux");
		
		ButtonGroup bgSO = new ButtonGroup();
		bgSO.add(rbWindows);
		bgSO.add(rbMac);
		bgSO.add(rbLinux);
		rbWindows.setSelected(true);
		
		panelSO.add(lblDescSO);
		panelSO.add(rbWindows);
		panelSO.add(rbMac);
		panelSO.add(rbLinux);
		
		//armo el panel de especialidades...
		JPanel panelEspecialidad = new JPanel();
		panelEspecialidad.setBorder(new LineBorder(negro));
		panelEspecialidad.setBounds(0,60,350,100);
		
		JLabel lblDescEspecialidad = new JLabel("Elije una especialidad");
		
		JCheckBox cbProg = new JCheckBox("Programación");
		JCheckBox cbAdmin = new JCheckBox("Administración");
		JCheckBox cbDisenio = new JCheckBox("Diseño Gráfico");
		
		panelEspecialidad.add(lblDescEspecialidad);
		panelEspecialidad.add(cbProg);
		panelEspecialidad.add(cbAdmin);
		panelEspecialidad.add(cbDisenio);
		
		JLabel lblDescCantHoras = new JLabel("Cantidad de horas en el computador");
		lblDescCantHoras.setBounds(0,170,250,20);
		JTextField txtCantHoras = new JTextField();
		txtCantHoras.setBounds(260,170,100,20);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(300,210,100,20);
		btnAceptar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//validaciones...
					//por lo menos una caja seleccionada?
					if (cbProg.isSelected()==false&&cbAdmin.isSelected()==false&&cbDisenio.isSelected()==false){
						JOptionPane.showMessageDialog(null, "Elegir por lo menos un checkBox", "aceptar", JOptionPane.PLAIN_MESSAGE);
						return;
					} else {
						try{
						    int num = Integer.parseInt(txtCantHoras.getText());
						}catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Ingresar un numero...", "aceptar", JOptionPane.PLAIN_MESSAGE);
							return;
						}
					}
					JOptionPane.showMessageDialog(null, "SO: " + bgSO.getSelection() + 
														" Esp: " + verEspActivos(panelEspecialidad) +
														txtCantHoras.getText() + " Hs" 
														, "aceptar", JOptionPane.PLAIN_MESSAGE);
				}
		});
		
		this.add(panelSO);
		this.add(panelEspecialidad);
		this.add(lblDescCantHoras);
		this.add(txtCantHoras);
		this.add(btnAceptar);
	}
	
	public void limpiarCampos(){
		
	}
	
	public String verEspActivos(JPanel p){
		String resultado = "";
		for(Component c : p.getComponents()){
			if (c.getClass().equals(JCheckBox.class)){
				JCheckBox cb = (JCheckBox) c;
				if (cb.isSelected()){
					resultado += cb.getText() + " ";
				}
			}
		}
		return resultado;
	} 
}
