package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class DataTablePanel extends JPanel{

	
	private JTextField[][] tabla;
	private JPanel panelTabla;
	private JLabel title;
	private JLabel lbInitialState;
	private JTextField txInitialState;
	
	public DataTablePanel () {
		
		setLayout( new BorderLayout(10,10) );
        //Establece el tamaño del layout  
		setPreferredSize( new Dimension( 0, 200) );
		 
	

		
	      
	      TitledBorder border = BorderFactory.createTitledBorder( "Tabla de estados automata" );
	      setBorder( border );
	        
	      lbInitialState = new JLabel("Ingrese el estado inicial");
	      txInitialState = new JTextField();
	      txInitialState.setMinimumSize(new Dimension(10,50));
	      
	      JPanel auxPanel = new JPanel();
	      auxPanel.setLayout(new GridLayout(1,2,10,10));
	      auxPanel.add(lbInitialState);
	      auxPanel.add(txInitialState);
	      
	      
	      add(auxPanel, BorderLayout.NORTH);
	}
	
	
	public String[] getInputs(boolean isMealy) {
		
		String[] inputs;
		if(isMealy) {
			inputs = new String[tabla[0].length-1];
			for(int i = 1; i< tabla[0].length; i++) {
				inputs[i-1] = tabla[0][i].getText();
			}
		}else {
			inputs = new String[tabla[0].length-2];
		for(int i = 1; i< tabla[0].length-1; i++) {
			inputs[i-1] = tabla[0][i].getText();
		}
		}
		return inputs;
	}
	
	public String[][] getTabla() throws EmptyFieldException, InitialStateException {
		
		String[][] matrixStrings = new String[tabla.length][tabla[0].length];
		
		//Se verifica que el estado inicial este en la matriz
		boolean found = false;
		for(int i = 0; i< matrixStrings.length && !found ; i++) {
			if(tabla[i][0].getText().equals(getInitialState())) {
				found = true;
			}
		}
		if(!found) {
			throw new InitialStateException("No se encuentra el estado inicial dentro de la matriz"); 			
		}
		
		//Ingresa los datos de la matriz de JTexField a una matrixz de Strings
		for(int i = 0; i< tabla.length; i++) {
			for(int j = 0; j < tabla[0].length; j++) {
				
				if(tabla[i][j].getText().length() == 0 && !(i == 0 && j == 0) && !(i==0 && j == tabla[0].length-1)) {
					throw new EmptyFieldException("No pueden haber campos vacios en la matriz ");
				}
				matrixStrings[i][j] = tabla[i][j].getText();
			}
		}
		
		return matrixStrings;
	}
	
	public String getInitialState() throws EmptyFieldException {
		
		String initialState = txInitialState.getText();
		
		if(!initialState.isEmpty() && !initialState.contains(" ")) {
			return initialState;
		}else {
			throw new EmptyFieldException("Hace falta indicar el estado inicial");
		}
		
	}
	
	public void createJTextFieldMatrix(int rows, int columns, String machineType) {
		
		if(panelTabla != null) {
			remove(panelTabla);
		}
		
		panelTabla = new JPanel();
		panelTabla.setLayout(new GridLayout(rows,columns,10 , 10));
		
		tabla = new JTextField[rows][columns];
		
		for(int i = 0; i< tabla.length; i++) {
			for(int j = 0; j < tabla[0].length; j++) {	
				tabla[i][j] = new JTextField();
				Font font = new Font("Segoe UI", Font.BOLD, 35 - (Math.max(tabla.length , tabla[0].length)));
				tabla[i][j].setFont(font);
				tabla[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				panelTabla.add(tabla[i][j]);					
			}
		}
		tabla[0][0].setEnabled(false);
		tabla[0][0].setVisible(false);
		
		if(machineType.equals(InitFrame.MOORE)) {
			tabla[0][tabla[0].length-1].setEnabled(false);
			tabla[0][tabla[0].length-1].setVisible(false);
		}
		
		add(panelTabla, BorderLayout.CENTER);
	}
}
