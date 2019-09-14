package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AutomataMinimumPanel extends JPanel{

	
	private JTextField[][] matrix;
	private JPanel panelMatrix;
	private JLabel title;
	
	public AutomataMinimumPanel () {
		
		setLayout( new BorderLayout(10,10) );
        //Establece el tamaño del layout  
		setPreferredSize( new Dimension( 0, 200) );
		 
	}
}
