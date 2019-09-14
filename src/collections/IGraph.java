package collections;

import java.util.ArrayList;
import java.util.HashMap;

public interface IGraph<V, E>  {

	public ArrayList<NodeGraph<V>> getNodes();

	public void setNodes(ArrayList<NodeGraph<V>> nodes);

	public int[][] getAdjacentsMatrix();

	public void setAdjacentsMatrix(int[][] adjacentsMatrix);

	public String[][] getWeightMatrix();

	public void setWeightMatrix(String[][] weightMatrix);

	public HashMap<String, NodeGraph<V>> getVertices();

	public void setVertices(HashMap<String, NodeGraph<V>> vertices);

	public ArrayList<Edge<V, E>> getEdges();

	public void setEdges(ArrayList<Edge<V, E>> edges);

	public NodeGraph<V> searchVertex(String key);

	public void addVertex(String key, V newVertex);

	public void removeVertex(String key);

	public void insertEdge(E edge, String vertex1, String vertex2, String weight);

	//public String foundKey(int pos);

	//public void inicializeMatrix();

	public boolean areAdjacents(String vertex1, String vertex2);

//	public Double adjacentsWeight(NodeGraph<V> origin, NodeGraph<V> end);
//
//	public void addToMatrix(int i, int j);
//
//	public void removeFromMatrix(int i, int j);
//
//	public double[] dijkstra(String key);
//
//	public int[] dijkstraNodes(String key);

	//public void print(int[] previo, int posEnd);
//
//	public int foundPos(String key);
//
//	public V foundNode(int pos);
//
//	public void fillWeightMatrix();
//
//	public double[][] floydWarshall();
//
//	public Edge<V, E> minEdge();
//
//	public int minWeight(double key[], boolean[] visits);
//
//	public int[] primMTS();

	//public void makeSet(int parent[], int n);

	public int find(int parent[], int x);

	public boolean sameRoot(int parent[], int x, int y);

	public void union(int parent[], int x, int y);

//	public ArrayList<Edge<V, E>> sortEdges(ArrayList<Edge<V, E>> edges);
//
//	public Double[] kruskal();
//
//	public void dfs(boolean visited[], NodeGraph<V> origin, NodeGraph<V> end);

	public void displayVertex(NodeGraph<V> a);

	public NodeGraph<V> getAdjUnvisitedVertex(NodeGraph<V> as);

	public void assignVisit(ArrayList<NodeGraph<V>> a, NodeGraph<V> ae);

	public ArrayList<V> bfsGraph();

	public void dfsGraph(NodeGraph<V> node);

	//public Edge<V, E> searchEdge(double weight);

}
