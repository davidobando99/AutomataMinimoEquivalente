package Interfaz;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import modelo.Automata;
public class InitFrame extends JFrame{
	

	public static final String MOORE ="MOORE";
	public static final String MEALY ="MEALY";
	private String machine;
	public JLabel lbImage;
	
	private Automata automata;
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
	    automata = new Automata();
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
	
	
	public String getMachine() {
		return machine;
	}


	public void setMachine(String machine) {
		this.machine = machine;
	}


	public String toString(String[] symbols) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		
		for (String symbol : symbols) {
			sb.append(symbol);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("}");
		return sb.toString();
	}
	
	
	public void showSetsSRMealy() {
		
		automataPanel.getTitle().setText("S =  "+toString(dataTablePanel.getInputs(MEALY))+"\n R =  "+toString(dataTablePanel.getStates())+"\n");
		
		
	}
	public void showSetsSRMoore() {
		

		automataPanel.getTitle().setText("S =  "+toString(dataTablePanel.getInputs(MOORE))+"\n R =  "+toString(dataTablePanel.getStates())+"\n");
		
	}
	
	public void states() {
		automata.getStatesVoid();
	}
	public void edges() {
		automata.getEdges();
	}
	public void delete() {
		try {
			automata.deleteInaacesibleStates(dataTablePanel.getInitialState());
		} catch (EmptyFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void adjacents() {
		automata.showAdjacents();
	}
	
	
	
	public void addStates() {
		
		for(int i=0; i<dataTablePanel.getStates().length;i++) {
			if(machine.equals(MOORE)) {
				String[] outputsMoore=dataTablePanel.getOutputsMoore();
				automata.addState(dataTablePanel.getStates()[i],outputsMoore[i],machine);
			}else
			automata.addState(dataTablePanel.getStates()[i],"",machine);
		}
		
	}
	
	public void matriz() {
		try {
			for(int i=0; i<dataTablePanel.getTransitions().length;i++) {
				
					for(int j=0; j<dataTablePanel.getTransitions()[0].length;j++) {
						System.out.println(dataTablePanel.getTransitions()[i][j]);
						
						}
					}
		} catch (EmptyFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InitialStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}
	public void automata() throws EmptyFieldException {
		
		automataPanel.showTableState(automata.automataaa(dataTablePanel.getInputs(MOORE),dataTablePanel.getInitialState()),true);
		//automata.automataaa(dataTablePanel.getInputs(MOORE),dataTablePanel.getInitialState());
	//automataPanel.getTitle().setText(automata.automataEquivalente(dataTablePanel.getInputs(MOORE),dataTablePanel.getInitialState()));
	}
	public void firstP() throws EmptyFieldException {
		automata.partitionPK(dataTablePanel.getInitialState());
		for(int i=0;i<automata.getPartitions().size();i++) {
			System.out.println("partition "+i);
			for(int j=0;j<automata.getPartitions().get(i).size();j++) {
				System.out.println("conjunto  "+j);
				for(int z=0;z<automata.getPartitions().get(i).get(j).size();z++) {
					System.out.println(automata.getPartitions().get(i).get(j).get(z).getName());
					
				}
			}
		}
	}
	public void addTransitionsMealy() {
		String[] states =dataTablePanel.getStates();
		String[] inputs =dataTablePanel.getInputs(machine);
		ArrayList<String> outputs = new ArrayList<String>();
		
		int countStates=-1;
		int countInputs=0;
		try {
			if(machine.equals(MEALY)) {
			for(int i=0; i<dataTablePanel.getTransitions().length;i++) {
				countStates++;
				countInputs=0;
				
					for(int j=0; j<dataTablePanel.getTransitions()[0].length;j++) {
						
						String transition = dataTablePanel.getTransitions()[i][j];
						String[] line = transition.split(",");
						//Concatena las salidas en un arreglo
						
						
						automata.addTransition(states[countStates], line[0], inputs[countInputs],line[1], machine);
						countInputs++;
					}
				}
			}else {
				for(int i=0; i<dataTablePanel.getTransitions().length;i++) {
					countStates++;
					countInputs=0;
						for(int j=0; j<dataTablePanel.getTransitions()[0].length-1;j++) {
							
							String transition = dataTablePanel.getTransitions()[i][j];
//							System.out.println("destino "+transition);
//							System.out.println("origen "+states[countStates]);
//							System.out.println("input "+inputs[countInputs]);
//							System.out.println(machine);
							
							automata.addTransition(states[countStates], transition, inputs[countInputs],"",machine);
							countInputs++;
						}
					}
			}
		} catch (EmptyFieldException | InitialStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
