package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import Interfaz.InitFrame;
import collections.Graph;
import collections.NodeGraph;

public class Automata {
	  private Graph<State, Transition> graph;
	
	public Automata() {
		graph = new Graph<State, Transition>();
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
	
	public ArrayList<ArrayList<State>> firstPartitionMealy(String initialState) {
		deleteInaacesibleStates( initialState);
		ArrayList<String> outputs = new ArrayList<String>();
		int countOuts =graph.getVertices().get(initialState).getAdjList().size();
		String output="";
		for (int i=0;i<graph.getEdges().size();i+=countOuts) {
			output+=graph.getEdges().get(i).getValue().getOutput();
			for(int j=i+1;j<i+countOuts;j++)
				
					output+=graph.getEdges().get(j).getValue().getOutput();
				}
			}
		
		
		
		ArrayList<ArrayList<State>> partition = new ArrayList<ArrayList<State>>();
		String actual="";
		String anterior="";
	    LinkedList<String> dinamicOutputs = new LinkedList<String>();
	    dinamicOutputs.add(outputs.get(0));
	    while(!dinamicOutputs.isEmpty()) {
	    	
	    	ArrayList<State> list =new ArrayList<State>();
	    	anterior=dinamicOutputs.getFirst();
	    	int countOutputs=outputs.size();
		for(int i=0;i<countOutputs;i++) {
			
			if(i==0) {
				
				list.add(getStates().get(i));
			}else {
				
				actual=outputs.get(i);
				if(actual.equals(anterior)) {
					list.add(getStates().get(i));
					outputs.remove(i);
				}
				
			}
		
			
		}
		partition.add(list);
		dinamicOutputs.poll();
		dinamicOutputs.get(0);
	    }
	    return partition;
	}
	
	public ArrayList<ArrayList<State>> firstPartitionMoore(String initialState) {
		deleteInaacesibleStates( initialState);
		ArrayList<State> states=getStates();
		
		
		ArrayList<ArrayList<State>> partition = new ArrayList<ArrayList<State>>();
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
		dinamicOutputs.poll();
		if(states.size()>0)
		dinamicOutputs.add(states.get(0).getOutput());
	    }
	    return partition;
	}
	
	

}
