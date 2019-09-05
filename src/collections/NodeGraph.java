package collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeGraph<V>implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private V value;
	private int posX;
	private ArrayList<NodeGraph<V>> adjList;
	private boolean wasVisited;
	
	
	public NodeGraph(V value) {
		this.value =value;
		adjList= new ArrayList<NodeGraph<V>>();
		wasVisited = false;
	}
	
	//Constructor para matriz de adyacencia
	public NodeGraph(V value, int posX) {
		this.value =value;
		this.posX=posX;
		adjList= new ArrayList<NodeGraph<V>>();
		wasVisited = false;
	}
	
	public NodeGraph(V value, ArrayList<NodeGraph<V>> adjList) {
		this.value =value;
		this.adjList= adjList;
		wasVisited = false;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public  ArrayList<NodeGraph<V>> getAdjList() {
		return adjList;
	}

	public void setAdjList( ArrayList<NodeGraph<V>> adjList) {
		this.adjList = adjList;
	}
	
	
	
	public void addAdjacent(NodeGraph<V> adjacent) {
		adjList.add(adjacent);
	}
	
	public void removeAdjacent(NodeGraph<V> adjacent) {
		adjList.remove(adjacent);
	}
	
	public int getPos() {
		return posX;
	}

	public void setPos(int posX) {
		this.posX = posX;
	}

	public boolean isWasVisited() {
		return wasVisited;
	}

	public void setWasVisited(boolean wasVisited) {
		this.wasVisited = wasVisited;
	}

	public String toString() {
		return value +"";
	}
	
	
	

}
