package Interfaz;

import java.awt.*;
import javax.swing.*;
public class InitFrame extends JFrame{
	

	public static final String MOORE ="MOORE";
	public static final String MEALY ="MEALY";
	private String machine;
	public JLabel lbImage;
	
	public ImageIcon icon;
	public OptionsPanel optionsPanel;
	public DataTablePanel dataTablePanel;
	public AutomataMinimumPanel automataPanel;

	public InitFrame() {
		setTitle( "Automata Minimo Equivalente" );
	    setSize( new Dimension(1100, 720 ));
	   
	    

	    setResizable( false);
	    setDefaultCloseOperation( EXIT_ON_CLOSE );
	    setLayout( new BorderLayout(20,20 ) );

        lbImage = new JLabel( );
        icon = new ImageIcon( "images/BANNER.jpg" );
        lbImage.setIcon( icon );
        add( lbImage, BorderLayout.NORTH );
        optionsPanel= new OptionsPanel(this);
        dataTablePanel = new DataTablePanel();
        automataPanel = new AutomataMinimumPanel();
        JPanel auxPanel1 = new JPanel();
        auxPanel1.setLayout(new BorderLayout());
       auxPanel1.add(optionsPanel, BorderLayout.NORTH);
        auxPanel1.add(dataTablePanel, BorderLayout.CENTER);
       
       JPanel auxPanel2 = new JPanel();
       auxPanel2.setLayout(new GridLayout(1,2));
       auxPanel2.add(auxPanel1);
       auxPanel2.add(automataPanel);
       
       add(auxPanel2, BorderLayout.CENTER);
	}
	
public void createMealyMachine() {
		
		try {
		int rows = Integer.parseInt(JOptionPane.showInputDialog
		(null, "Digite el numero de estados", "Numero de estados", JOptionPane.INFORMATION_MESSAGE));
		
		int columns = Integer.parseInt(JOptionPane.showInputDialog
		(null, "Digite el numero de simbolos del alfabeto de entrada", "Numero de entradas", JOptionPane.INFORMATION_MESSAGE));
		
		if (rows > 15 || columns > 15 ) {
			JOptionPane.showMessageDialog(null, "El maximo de estados y simbolos del alfabeto es 15 ", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			dataTablePanel.createJTextFieldMatrix(rows+1, columns+1, MEALY);
		validate();
		machine = MEALY;
		}
		
		} catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Debe pasar un numero entero ", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void createMooreMachine() {
		
		try {
		int rows = Integer.parseInt(JOptionPane.showInputDialog
		(null, "Digite el numero de estados", "Numero de estados", JOptionPane.INFORMATION_MESSAGE));
		
		int columns = Integer.parseInt(JOptionPane.showInputDialog
		(null, "Digite el numero de simbolos del alfabeto de entrada", "Numero de entradas", JOptionPane.INFORMATION_MESSAGE));
		
		if (rows > 15 || columns > 15 ) {
			JOptionPane.showMessageDialog(null, "El maximo de estados y simbolos del alfabeto es 15 ", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			dataTablePanel.createJTextFieldMatrix(rows + 1, columns + 2, MOORE);
		validate(); 
		machine = MOORE;
		}
		
		} catch(NumberFormatException e){
		     JOptionPane.showMessageDialog(null, "Debe pasar un numero entero ", "Error", JOptionPane.ERROR_MESSAGE);
	}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame ventanaInicial = new InitFrame();
		ventanaInicial.setVisible(true);
	}
	
	

}
