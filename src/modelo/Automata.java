package modelo;

import collections.Graph;

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
	
	public void addState(String nameState) {
		
		graph.addVertex(nameState, new State(nameState));
		
	}
	
	public void addTransition(String origin, String destination, String symbol) {
		State from =  graph.searchVertex(origin).getValue();
		State to =  graph.searchVertex(destination).getValue();
		graph.insertEdge(new Transition(symbol, from,to), origin, destination, symbol);
	}
	

}
