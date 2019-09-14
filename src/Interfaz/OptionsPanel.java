package Interfaz;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class OptionsPanel extends JPanel implements ActionListener{
	public static final String MEALY ="Maquina Mealy";
	public static final String MOORE ="Maquina Moore";
	public static final String REDUCED ="Generar Automata Minimo Equivalente Conexo";
	private InitFrame  initFrame;
	private JButton mealy;
	private JButton moore;
	private JButton reduced;
	
	public OptionsPanel(InitFrame frame) {
		initFrame = frame;
		setLayout( new GridLayout(3,1,5,5) );
		
		mealy = new JButton(MEALY);
		mealy.setActionCommand(MEALY);
		mealy.addActionListener(this);
		mealy.setBackground(Color.WHITE);
		add(mealy);
			
		moore = new JButton(MOORE);
		moore.setActionCommand(MOORE);
		moore.addActionListener(this);
		moore.setBackground(Color.WHITE);
		add(moore);
		
		reduced = new JButton(REDUCED);
		reduced.setActionCommand(REDUCED);
		reduced.addActionListener(this);
		reduced.setBackground(Color.WHITE);
		reduced.setEnabled(false);
		add(reduced);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		Icon icono = new ImageIcon("images/tablaMealy.jpg");
		

		if(comando.equals(MEALY)) {
			
			initFrame.createMealyMachine();
			reduced.setEnabled(true);
			JOptionPane.showMessageDialog(null,"Basese en el siguiente ejemplo para llenar la tabla ", "Ejemplo MEALY", JOptionPane.PLAIN_MESSAGE, icono);
			
		}else if(comando.equals(MOORE)) {
			
			initFrame.createMooreMachine();
			reduced.setEnabled(true);
			//falta cambiar imagen de moore
			JOptionPane.showMessageDialog(null,"Basese en el siguiente ejemplo para llenar la tabla ", "Ejemplo MEALY", JOptionPane.PLAIN_MESSAGE, icono);
			
		}else if(comando.equals(REDUCED)) {
			
			if(initFrame.getMachine().equals(InitFrame.MEALY)) {
				initFrame.showSetsSRMealy();
			}else initFrame.showSetsSRMoore();
			
			initFrame.addStates();
			
			initFrame.addTransitionsMealy();
		
			initFrame.states();
			//initFrame.matriz();
			//initFrame.edges();
			//initFrame.adjacents();
			initFrame.delete();
			initFrame.states();
			
		}
	}

}
