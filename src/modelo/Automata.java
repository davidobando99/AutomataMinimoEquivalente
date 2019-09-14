package modelo;

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
	
	public void getStates() {
	
	
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
	

}
