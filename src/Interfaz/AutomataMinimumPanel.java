package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AutomataMinimumPanel extends JPanel{

	
	private JTextField[][] matrix;
	private JPanel panelMatrix;
	private JLabel title;
	
	public AutomataMinimumPanel () {
		
		setLayout( new BorderLayout(10,10) );
        //Establece el tamaño del layout  
		setPreferredSize( new Dimension( 0, 200) );
		
		    title = new JLabel("Automata Equivalente");
			
			add(title, BorderLayout.NORTH);
			
	}

	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}
    public void showTableState(String[][] tableState, boolean isMoore) {
		
		if(panelMatrix != null) {
			remove(panelMatrix);
		}
		panelMatrix = new JPanel();
		
		
		panelMatrix.setLayout(new GridLayout(tableState.length, tableState[0].length, 10, 10));
		
		matrix = new JTextField[tableState.length][tableState[0].length];
		
		for(int i = 0; i< matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {	
				matrix[i][j] = new JTextField();
				Font font = new Font("Segoe UI", Font.BOLD, 35 - (Math.max(matrix.length , matrix[0].length)));
				matrix[i][j].setFont(font);
				matrix[i][j].setText(tableState[i][j]);
				matrix[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				panelMatrix.add(matrix[i][j]);					
			}
		}
		
		matrix[0][0].setEnabled(false);
		matrix[0][0].setVisible(false);
		
		if(isMoore) {
			matrix[0][matrix[0].length-1].setEnabled(false);
			matrix[0][matrix[0].length-1].setVisible(false);
		}
		add(panelMatrix, BorderLayout.CENTER);
		validate();
		Font font = new Font("Segoe UI", Font.PLAIN, 35 - (Math.max(matrix.length , matrix[0].length)));
		title.setFont(font);
	
	
}}
