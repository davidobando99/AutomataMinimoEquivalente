package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import Interfaz.InitFrame;
import collections.Graph;
import collections.NodeGraph;



public class Automata {
	  private Graph<State, Transition> graph;
	  private ArrayList<ArrayList<ArrayList<State>>> partitions ;
	  private ArrayList<State> newStates ;
	  private ArrayList<Transition> newEdges ;
	
	public Automata() {
		graph = new Graph<State, Transition>();
		 partitions = new ArrayList<ArrayList<ArrayList<State>>>();
		 newStates= new ArrayList<State>();
		 newEdges = new ArrayList<Transition>();
	}

	public Graph<State, Transition> getGraph() {
		return graph;
	}

	public void setGraph(Graph<State, Transition> graph) {
		this.graph = graph;
	}
	
	public ArrayList<State> getStates() {
	
		ArrayList<State> states = new ArrayList<State>();
		for (Map.Entry<String, NodeGraph<State>> entry : graph.getVertices().entrySet()) {
		states.add(entry.getValue().getValue());
			//System.out.println(entry.getValue().getValue().getName()+"   "+entry.getValue().getValue().getOutput());
		}
		return states;
	}
	
	public void getStatesVoid() {
		
		
		for (Map.Entry<String, NodeGraph<State>> entry : graph.getVertices().entrySet()) {
		
			System.out.println(entry.getValue().getValue().getName()+"   "+entry.getValue().getValue().getOutput());
		}
		
	}
	public void getEdges() {
		
		
		for(int i=0;i<graph.getEdges().size();i++) {
			System.out.println("origen  "+graph.getEdges().get(i).getValue().getOrigin().getName()+
					"destino  "+graph.getEdges().get(i).getValue().getDestination().getName()+
			"input  "+graph.getEdges().get(i).getValue().getInput()+
			"OUTPUT  "+graph.getEdges().get(i).getValue().getOutput());
			
			
		}
	}
	public void showAdjacents() {
		for (Map.Entry<String, NodeGraph<State>> entry : graph.getVertices().entrySet()) {
			for(int i=0;i<entry.getValue().getAdjList().size();i++) {
				System.out.println("origen  "+entry.getKey()+"   "+entry.getValue().getAdjList().get(i).getValue().getName());
			}
		}
		
	}
	
	public void deleteInaacesibleStates(String initialState) {
		
	String deletedState="";
	boolean aparece=false;
		for (Map.Entry<String, NodeGraph<State>> entry : graph.getVertices().entrySet()) {
			 aparece = false;
			for(int j=0;j<graph.BFS(initialState).size() && !aparece;j++) {
				
				if(graph.BFS(initialState).get(j).getValue().getName().equals(entry.getValue().getValue().getName())) {
					aparece = true;
					
				}
				
			}
			if(aparece==false) {
				graph.removeEdge(entry.getValue().getValue());
				graph.removeVertex(entry.getKey());
				
				break;
			}
			
		}

		
		
	}
	

	public void addState(String nameState, String output,String machine) {
		
		if(machine.equals(InitFrame.MOORE)) {
		graph.addVertex(nameState, new State(nameState,output));
		}else graph.addVertex(nameState, new State(nameState));
		
		
	}
	
	public void addTransition(String origin, String destination, String input, String output, String machine) {
		State from =  graph.searchVertex(origin).getValue();
		State to =  graph.searchVertex(destination).getValue();
		if(machine.equals(InitFrame.MEALY)) {
		graph.insertEdge(new Transition(input,output ,from,to), origin, destination, input);
		}else graph.insertEdge(new Transition(input ,from,to), origin, destination, input);
	}
	
//	public ArrayList<ArrayList<State>> firstPartitionMealy(String initialState) {
//		deleteInaacesibleStates( initialState);
//		ArrayList<String> outputs = new ArrayList<String>();
//		int countOuts =graph.getVertices().get(initialState).getAdjList().size();
//		String output="";
//		for (int i=0;i<graph.getEdges().size();i+=countOuts) {
//			output+=graph.getEdges().get(i).getValue().getOutput();
//			for(int j=i+1;j<i+countOuts;j++)
//				
//					output+=graph.getEdges().get(j).getValue().getOutput();
//				}
//			}
//		
//		
//		
//		ArrayList<ArrayList<State>> partition = new ArrayList<ArrayList<State>>();
//		String actual="";
//		String anterior="";
//	    LinkedList<String> dinamicOutputs = new LinkedList<String>();
//	    dinamicOutputs.add(outputs.get(0));
//	    while(!dinamicOutputs.isEmpty()) {
//	    	
//	    	ArrayList<State> list =new ArrayList<State>();
//	    	anterior=dinamicOutputs.getFirst();
//	    	int countOutputs=outputs.size();
//		for(int i=0;i<countOutputs;i++) {
//			
//			if(i==0) {
//				
//				list.add(getStates().get(i));
//			}else {
//				
//				actual=outputs.get(i);
//				if(actual.equals(anterior)) {
//					list.add(getStates().get(i));
//					outputs.remove(i);
//				}
//				
//			}
//		
//			
//		}
//		partition.add(list);
//		dinamicOutputs.poll();
//		dinamicOutputs.get(0);
//	    }
//	    return partition;
//	}
	public ArrayList<ArrayList<ArrayList<State>>> getPartitions(){
		return partitions;
	}
	public void firstPartitionMoore(String initialState) {
		deleteInaacesibleStates( initialState);
		ArrayList<State> states=getStates();
		ArrayList<ArrayList<State>>partition = new ArrayList<ArrayList<State>>();
		
		
		String actual="";
		String anterior="";
	    LinkedList<String> dinamicOutputs = new LinkedList<String>();
	    dinamicOutputs.add(states.get(0).getOutput());
	    while(!dinamicOutputs.isEmpty()) {
	    	
	    	ArrayList<State> list =new ArrayList<State>();
	    	anterior=dinamicOutputs.getFirst();
	    	int countOutputs=states.size();
		for(int i=0;i<countOutputs;i++) {
			
			if(i==0) {
				
				list.add(states.get(i));
				
			}else {
				
				actual=states.get(i).getOutput();
				if(actual.equals(anterior)) {
					list.add(states.get(i));
					
				}
				
			}
		
			
		}
		
		ArrayList<State> aux =(ArrayList<State>) states.clone();
		
		for(int z=0;z<aux.size();z++) {
			if(aux.get(z).getOutput().equals(list.get(0).getOutput())) {
				
				states.remove(aux.get(z));
			}
			
		}
		
		partition.add(list);
		partitions.add(partition);
		dinamicOutputs.poll();
		if(states.size()>0)
		dinamicOutputs.add(states.get(0).getOutput());
	    }
	   
	}
	
	public void partitionPK(String initialState){
		firstPartitionMoore( initialState);
		ArrayList<ArrayList<State>> partitionActual=null;
		ArrayList<ArrayList<State>> beforePartition=null;
		while(comparePartitions(partitionActual,beforePartition)==false) {
		partitionActual = new ArrayList<ArrayList<State>>();
		
		 beforePartition = partitions.get(partitions.size() - 1);
		partitions.add(partitionActual);
		
		for (int i = 0; i < beforePartition.size(); i++) {
	
			ArrayList<State> aux = new ArrayList<State>();
			ArrayList<State> listEquivalent = beforePartition.get(i);
			if (listEquivalent.size() > 1) {
				for (int j = 1; j < listEquivalent.size(); j++) {
					State firstState =listEquivalent.get(0) ;
					State anyOtherState = listEquivalent.get(j);
					NodeGraph<State>  nodeState1= graph.searchVertex(firstState.getName());
					NodeGraph<State>  nodeState2= graph.searchVertex(anyOtherState.getName());
					
					//Para ver si los sucesores de los estados anteriores y los mismos estados estan en el mismo bloque
					for (int k = 0; k < nodeState1.getAdjList().size(); k++) {
						State keyPair =  (nodeState1.getAdjList().get(k)).getValue();
						State keyPair1 = (nodeState2.getAdjList().get(k)).getValue();
						int noEsta = 0;
						
						for (int u = 0; u < beforePartition.size(); u++) {
							ArrayList<State> listStates = beforePartition.get(u);

							if (!(listStates.contains(keyPair) && listStates.contains(keyPair1))) {
								noEsta++;
							}

						}
						if (noEsta == beforePartition.size() && !(aux.contains( anyOtherState)))
							aux.add(anyOtherState);
					}

				}
				ArrayList<State> block = new ArrayList<>();
				for (int j1 = 0; j1 < listEquivalent.size(); j1++) {

					if (!(aux.contains(listEquivalent.get(j1)))) {
						block.add(listEquivalent.get(j1));
					}

				}
				partitionActual.add(block);
				if (aux.size() > 0)
					partitionActual.add(aux);
			} else {
				partitionActual.add(listEquivalent);
			}
		}
		}
	}
	
	public boolean comparePartitions(ArrayList<ArrayList<State>> part1,ArrayList<ArrayList<State>> part2) {
		boolean equalPartition;
		if(part1!=null&&part2!=null) {
			
		
		 if(part1.size()==part2.size()) {
			equalPartition=true;
			for(int i=0;i<part1.size()&&equalPartition;i++) {
				if(part1.get(i).size()==part2.get(i).size()) equalPartition=true;
				else equalPartition=false;
			}
			if(equalPartition) {
			for(int i=0;i<part1.size()&&equalPartition;i++) {
				for(int j=0;j<part1.get(i).size();j++)
				if(part1.get(i).get(j).getName().equals(part2.get(i).get(j).getName())) equalPartition=true;
				else equalPartition=false;
			}
			}
		}else equalPartition=false;}
		else equalPartition=false;
		
		
		return equalPartition;
	}
	
	public void getAutomataEquivalenteMoore(String initalState) {
		partitionPK(initalState);
		
		
		
			for(int j=0;j<partitions.get(partitions.size()-1).size();j++) {
				
				
				graph.addVertex("q"+(j+1), new State("q"+(j+1)));
				newStates.add(graph.searchVertex("q"+(j+1)).getValue());
				
				
			}
			ArrayList<State> first =	new		ArrayList<State>();
			for(int j=0;j<partitions.get(partitions.size()-1).size();j++) {
				first.add(partitions.get(partitions.size()-1).get(j).get(0));
				for(int z=0;z<partitions.get(partitions.size()-1).get(j).size();z++) {
					graph.insertEdge(new Transition("", graph.searchVertex("q"+(j+1)).getValue(),partitions.get(partitions.size()-1).get(j).get(z)), 
							"q"+(j+1), partitions.get(partitions.size()-1).get(j).get(z).getName(), "");
					
					
					
				}
			}
			
			for(int i=0;i<first.size();i++) {
				NodeGraph<State> actual = graph.searchVertex(first.get(i).getName());
				for(int j=0;j<actual.getAdjList().size();j++) {
					State origin= foundOrigin(first.get(i));
					State end= foundOrigin(actual.getAdjList().get(j).getValue());
					graph.insertEdge(new Transition("", origin,end), 
							origin.getName(), end.getName(), "");
					newEdges.add(foundTransition(origin,end));
				}
			}
		}
	
	public String automataEquivalente(String[] inputs, String initialState){
		getAutomataEquivalenteMoore(initialState);
		String table="   ";
		for(int i=0;i<inputs.length;i++) {
			table+=inputs[i]+"   ";
		}
		table+="\n";
		for(int i=0;i<newStates.size();i++) {
			table+=newStates.get(i).getName()+"   ";
			for(int j=0;j<newEdges.size();j++) {
				if(newEdges.get(j).getOrigin().getName().equals(newStates.get(i).getName())) {
					table+=newEdges.get(j).getDestination().getName()+"\n";
				}
				
			}
			table+="\n";
		}
		
		return table;
	}
	
	public String[][] automataaa(String[] inputs, String initialState){
		getAutomataEquivalenteMoore(initialState);
		String[][] table = new String[newStates.size()+1][inputs.length+2];
		
		for(int i=0;i<inputs.length;i++) {
			if(i<inputs.length)
			table[0][i+1]=inputs[i];
		}
		
		for(int i=0;i<newStates.size();i++) {
			if(i<newStates.size())
			table[i+1][0]=newStates.get(i).getName();
			
			
			
		}
		int i=1;
		int j=1;
		for(int z=0;z<newEdges.size();z++) {
			
				table[i][j]=newEdges.get(z).getDestination().getName();
				
				if(j==inputs.length) {
					j=1;
					i++;
				}else {
					j++;
				}
			}
		return table;
		}
		
		
	
//	public String[][] automataaa(String[] inputs, String initialState){
//		getAutomataEquivalenteMoore(initialState);
//		String[][] table = new String[newStates.size()][inputs.length+1];
//		System.out.println("inputs");
//		for(int i=0;i<inputs.length;i++) {
//			System.out.println(inputs[i]);
//		}
//		System.out.println("states");
//		for(int i=0;i<newStates.size();i++) {
//			
//			System.out.println("edges");
//			for(int j=0;j<newEdges.size()-1;j++) {
//				
//					System.out.println(newEdges.get(j).getOrigin().getName());
//					System.out.println(newEdges.get(j).getDestination().getName());
//				
//				
//			}
//			
//		}
//		
//		
//	}
	
	public State foundOrigin(State found) {
		State origin=null;
		for(int i=0;i<graph.getEdges().size();i++) {
			if(graph.getEdges().get(i).getEnd().getValue()==found && graph.getEdges().get(i).getOrigin().getValue().getName().startsWith("q")) {
				origin=graph.getEdges().get(i).getOrigin().getValue();
			}
		}return origin;
	}
	public Transition foundTransition(State origin, State destination) {
		Transition tra=null;
		for(int i=0;i<graph.getEdges().size();i++) {
			if(graph.getEdges().get(i).getEnd().getValue()==destination && graph.getEdges().get(i).getOrigin().getValue()==origin) {
				tra=graph.getEdges().get(i).getValue();
			}
		}return tra;
	}
	
	public State initialState(String initial) {
		State init =null;
		if(getStates().get(0).getName().equals(initial)) {
			init= getStates().get(0);
		}
		return init;
	}
	
	}
	
	


