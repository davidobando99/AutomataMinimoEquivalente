package collections;
import java.io.Serializable;
import java.util.*;



public class Graph<V, E> implements IGraph<V,E>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int SIZE = 10001; // maximo numero de vértices
	public static final double INFINITY = 1 << 30;
	public static final int AMOUNT = 100;
	public static final int AMOUNT1 = 22;
	private int[][] adjacentsMatrix;
	private String[][] weightMatrix;
	private HashMap<String, NodeGraph<V>> vertices;
	private ArrayList<Edge<V, E>> edges;
	private ArrayList<NodeGraph<V>> nodes;

	public Graph() {
		vertices = new HashMap<String, NodeGraph<V>>();
		nodes= new ArrayList<NodeGraph<V>>();
		edges = new ArrayList<Edge<V, E>>();
		adjacentsMatrix = new int[AMOUNT][AMOUNT];
		weightMatrix = new String[AMOUNT][AMOUNT];

		//inicializeMatrix();
	}
	@Override
	public ArrayList<NodeGraph<V>> getNodes() {
		return nodes;
	}
	@Override
	public void setNodes(ArrayList<NodeGraph<V>> nodes) {
		this.nodes = nodes;
	}

	@Override
	public int[][] getAdjacentsMatrix() {
		return adjacentsMatrix;
	}

	@Override
	public void setAdjacentsMatrix(int[][] adjacentsMatrix) {
		this.adjacentsMatrix = adjacentsMatrix;
	}

	@Override
	public String[][] getWeightMatrix() {
		return weightMatrix;
	}

	@Override
	public void setWeightMatrix(String[][] weightMatrix) {
		this.weightMatrix = weightMatrix;
	}

	@Override
	public HashMap<String, NodeGraph<V>> getVertices() {
		return vertices;
	}
	@Override
	public void setVertices(HashMap<String, NodeGraph<V>> vertices) {
		this.vertices = vertices;
	}
	@Override
	public ArrayList<Edge<V, E>> getEdges() {
		return edges;
	}
	@Override
	public void setEdges(ArrayList<Edge<V, E>> edges) {
		this.edges = edges;
	}
	@Override
	public NodeGraph<V> searchVertex(String key) {
		return vertices.get(key);
	}
	
	@Override
	public void addVertex(String key, V newVertex) {
		if (vertices.isEmpty()) { // Si la tabla esta vacia que la posicion en la matriz sea (0,0)
			NodeGraph<V> vertex = new NodeGraph<V>(newVertex, 0);
			vertices.put(key, vertex);
		} else {
			NodeGraph<V> vertex = new NodeGraph<V>(newVertex, vertices.size()); // si esta con al menos
																				// 1 que sea el
																				// (size,size)
			vertices.put(key, vertex);
		}

	}
	@Override
	public void removeVertex(String key) {
		vertices.remove(key);

	}
	@Override
	public void insertEdge(E edge,String vertex1, String vertex2, String weight) {
		NodeGraph<V> origin = searchVertex(vertex1);
		NodeGraph<V> end = searchVertex(vertex2);
		Edge<V, E> edge1 = new Edge<V, E>(edge, weight, origin, end);

		edges.add(edge1);
		//addToMatrix(origin.getPos(), end.getPos());

//		int x = edge1.getOrigin().getPos();
//		int y = edge1.getEnd().getPos();
//
//		weightMatrix[x][y] = edge1.getWeight();
//		weightMatrix[y][x] = edge1.getWeight();
		origin.addAdjacent(end);
		//end.addAdjacent(origin);

	}
//	@Override
//	public String foundKey(int pos){
//		String found =null;
//	
//		for (Map.Entry<String, NodeGraph<V>> entry : vertices.entrySet()) {
//			if (entry.getValue().getPos()==pos) {
//				found =entry.getKey();
//			}
//	}
//		return found;
//}
	//
	// public Edge<V, E> searchEdge(String key) {
	// return edges.get(key);
	// }

	public void removeEdge(V value) {
	for(int i=0;i<edges.size();i++) {
		if(edges.get(i).getOrigin().getValue()==value) {
			edges.remove(i);
		}
		
	}
	 

	}
//	@Override
//	public void inicializeMatrix() {
//		for (int i = 0; i < adjacentsMatrix.length; i++) {
//			for (int j = 0; j < adjacentsMatrix[i].length; j++) {
//				adjacentsMatrix[i][j] = 0;
//			}
//		}
//		fillWeightMatrix();
//
//	}
	@Override
	public boolean areAdjacents(String vertex1, String vertex2) {
		NodeGraph<V> origin = searchVertex(vertex1);
		NodeGraph<V> end = searchVertex(vertex2);
		if (adjacentsMatrix[origin.getPos()][end.getPos()] > 0) {
			return true;
		} else
			return false;
	}
//	@Override
//	public Double adjacentsWeight(NodeGraph<V> origin, NodeGraph<V> end) {
//		if (weightMatrix[origin.getPos()][end.getPos()] > 0) {
//			return weightMatrix[origin.getPos()][end.getPos()];
//		} else
//			return 0.0;
//	}
//	@Override
//	public void addToMatrix(int i, int j) {
//		adjacentsMatrix[i][j] += 1;
//		adjacentsMatrix[j][i] += 1;
//	}
//	@Override
//	public void removeFromMatrix(int i, int j) {
//		if (adjacentsMatrix[i][j] > 0)
//			adjacentsMatrix[i][j] -= 1;
//	}
//	@Override
//	public double[] dijkstra(String key) {
//		NodeGraph<V> node = searchVertex(key);
//		// System.out.println(node.getValue()+ "value node");
//		Queue<NodeGraph<V>> queue = new LinkedList<NodeGraph<V>>();
//		double[] distance = new double[vertices.size()];
//		boolean[] visited = new boolean[vertices.size()];
//
//		
//		for (int i=0;i<vertices.size();i++) {
//			if (foundKey(i).equals(key)) {
//				distance[i] = 0.0;
//				visited[i] = false;
//			} else {
//				distance[i] = INFINITY;
//				visited[i] = false;
//			}
//			
//		}
//
//		queue.offer(node);
//
//		while (!queue.isEmpty()) {
//			NodeGraph<V> actual = queue.peek();
//			queue.poll();
//			int posActual = actual.getPos();
//
//			visited[posActual] = true;
//			for (int j = 0; j < actual.getAdjList().size(); j++) {
//				NodeGraph<V> adyacent = actual.getAdjList().get(j);
//				double peso = adjacentsWeight(actual, adyacent);
//				int posAdj = adyacent.getPos();
//
//				if (distance[posActual] + peso < distance[posAdj]) {
//					distance[posAdj] = distance[posActual] + peso;
//					queue.offer(adyacent);
//
//				}
//
//			}
//
//		}
//		return distance;
//
//	}
//	
//	
//	@Override
//	public int[] dijkstraNodes(String key) {
//		NodeGraph<V> node = searchVertex(key);
//		// System.out.println(node.getValue()+ "value node");
//		Queue<NodeGraph<V>> queue = new LinkedList<NodeGraph<V>>();
//		double[] distance = new double[vertices.size()];
//		boolean[] visited = new boolean[vertices.size()];
//		int[] previo = new int[ vertices.size() ]; 
//		ArrayList<ArrayList<Integer>> nodes= new ArrayList<ArrayList<Integer>>();
//
//		for (int i=0;i<vertices.size();i++) {
//			if (foundKey(i).equals(key)) {
//				distance[i] = 0.0;
//				visited[i] = false;
//			} else {
//				distance[i] = INFINITY;
//				visited[i] = false;
//			}
//			nodes.add(new ArrayList<Integer>());
//			previo[i]=-1;
//			
//		}
//		
//
//		queue.offer(node);
//
//		while (!queue.isEmpty()) {
//			NodeGraph<V> actual = queue.peek();
//			queue.poll();
//			int posActual = actual.getPos();
//
//			visited[posActual] = true;
//			for (int j = 0; j < actual.getAdjList().size(); j++) {
//				NodeGraph<V> adyacent = actual.getAdjList().get(j);
//				double peso = adjacentsWeight(actual, adyacent);
//				int posAdj = adyacent.getPos();
//
//				if (distance[posActual] + peso < distance[posAdj]) {
//					distance[posAdj] = distance[posActual] + peso;
//					nodes.get(posAdj).add(posActual);
//					previo[ posAdj ] = posActual; 
//					queue.offer(adyacent);
//
//				}
//
//			}
//
//		}
//		return previo;
//		
//		
//	}
////	@Override
////	public void print(int[] previo, int posEnd) {
////        if( previo[ posEnd ] != -1 ) {  
////        	print(previo, previo[ posEnd ] ); 
////            
////        }
////        nodes.add(foundNode(posEnd));
////            
////       
////    }
////	
//	@Override
//	public int foundPos(String key) {
//		NodeGraph<V> end = searchVertex(key);
//		int posEnd = end.getPos();
//		return posEnd;
//	}
//	@Override
//	public V foundNode(int pos) {
//		NodeGraph<V> node =null;
//		for (Map.Entry<String, NodeGraph<V>> entry : vertices.entrySet()) {
//			if (entry.getValue().getPos()==pos) {
//			 node= entry.getValue();
//			}
//			
//		}return node.getValue();
//	}
//	
//	@Override
//	public void fillWeightMatrix() {
//
//		for (int i = 0; i < adjacentsMatrix.length; i++) {
//			for (int j = 0; j < adjacentsMatrix.length; j++) {
//
//				if (i == j)
//					weightMatrix[i][j] = 0.0;
//
//				else if (adjacentsMatrix[i][j] == 0) {
//					weightMatrix[i][j] = INFINITY;
//
//				}
//			}
//		}
//
//	}
//	@Override
//	public double[][] floydWarshall() {
//
//		double[][] matrix = weightMatrix;
//
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix.length; j++) {
//				for (int k = 0; k < matrix.length; k++) {
//
//					if (matrix[i][k] + matrix[j][i] < matrix[j][k]) {
//						matrix[j][k] = matrix[i][k] + matrix[j][i];
//					}
//				}
//			}
//		}
//		return matrix;
//
//	}
//	@Override
//	public Edge<V, E> minEdge() {
//
//		Edge<V, E> min = edges.get(0);
//
//		for (int i = 0; i < edges.size(); i++) {
//
//			if (edges.get(i).getWeight() < min.getWeight()) {
//				min = edges.get(i);
//			}
//		}
//
//		return min;
//
//	}
//	@Override
//	public int minWeight(double key[], boolean[] visits) {
//
//		double min = INFINITY;
//		int val = -1;
//
//		for (int i = 0; i < key.length; i++) {
//
//			if (key[i] < min && !visits[i]) {
////				System.out.println(key[i]+"ME BITCH");
//				min = key[i];
//
//				val = i;
//			}
//		}
//		return val;
//
//	}
//	@Override
//	public int[] primMTS() {
//
//		NodeGraph<V> node = minEdge().getOrigin();
////		System.out.println(node.getValue() + "PRIM");
//		int key = node.getPos();
//
//		double dist[] = new double[vertices.size()];
//		int order[] = new int[vertices.size()];
//		String parent[] = new String[vertices.size()];
//		boolean[] visits = new boolean[vertices.size()];
//		for (int i = 0; i < visits.length; i++) {
//			dist[i] = INFINITY;
//			visits[i] = false;
//		}
//		
//
//		dist[key] = 0.0;
//		parent[key] = key + "";
//
//		for (int i = 0; i < visits.length; i++) {
//
//			int u = minWeight(dist, visits);
//			visits[u] = true;
//			order[i] = u;
//
//			for (int j = 0; j < visits.length; j++) {
//
//				if (weightMatrix[u][j] != 0 && !visits[j] && weightMatrix[u][j] < dist[j]) {
//					parent[j] = u + " --> " + j;
//
//					dist[j] = weightMatrix[u][j];
//
//				}
//			}
//
//		}
//
//		return order;
//
//	}
//	@Override
//	public void makeSet(int parent[], int n) {
//		for (int i = 0; i < n; i++) {
//			parent[i] = i;
//		}
//	}
	@Override
	public int find(int parent[], int x) {

		if (x == parent[x]) {
			return x;
		} else
			return find(parent, parent[x]);
	}
	@Override

	public boolean sameRoot(int parent[], int x, int y) {
		if (find(parent, x) == find(parent, y)) {
			return true;
		} else
			return false;
	}
	@Override
	public void union(int parent[], int x, int y) {
		int xRoot = find(parent, x);
		int yRoot = find(parent, y);
		parent[xRoot] = yRoot;
	}
//	@Override
//	public ArrayList<Edge<V, E>> sortEdges(ArrayList<Edge<V, E>> edges) {
//
//		for (int i = 1; i < edges.size(); i++) {
//			for (int j = i; j > 0 && edges.get(j - 1).compareTo(edges.get(j)) > 0; j--) {
//
//				Edge<V, E> tmp = edges.get(j);
//				edges.set(j, edges.get(j - 1));
//				edges.set(j - 1, tmp);
//
//			}
//		}
//		return edges;
//	}
//	@Override
//	public Double[] kruskal() {
//		int total = 0;
//		int numEdges = 0;
//		Double[] minimunTree = new Double[vertices.size() - 1];
//		int[] parent = new int[vertices.size()];
//		makeSet(parent, vertices.size());
//		ArrayList<Edge<V, E>> edgesSorted = sortEdges(edges);
//		for (int i = 0; i < edgesSorted.size(); i++) {
//			int origin = edgesSorted.get(i).getOrigin().getPos();
//			int end = edgesSorted.get(i).getEnd().getPos();
//			double weight = edgesSorted.get(i).getWeight();
//
//			if (!sameRoot(parent, origin, end)) {
//				total += weight;
//				minimunTree[numEdges++] = edgesSorted.get(i).getWeight();
//				union(parent, origin, end);
//			}
//		}
//
//		return minimunTree;
////	}
//	@Override
//	public void dfs(boolean visited[], NodeGraph<V> origin, NodeGraph<V> end) {
//		ArrayList<NodeGraph<V>> vertices = new ArrayList<NodeGraph<V>>();
//		visited[origin.getPos()] = true;
//		for (int i = 0; i < origin.getAdjList().size(); i++) {
//			if (!visited[origin.getAdjList().get(i).getPos()] && origin.getAdjList().get(i) != end) {
//				dfs(visited, origin.getAdjList().get(i), end);
//				vertices.add(origin.getAdjList().get(i));
//			}
//		}
//	}

	public void displayVertex(NodeGraph<V> a) {
		System.out.println(a.getValue().toString());
	}
	@Override
	public NodeGraph<V> getAdjUnvisitedVertex(NodeGraph<V> as) {
		for (int j = 0; j < as.getAdjList().size(); j++) {
			if (!as.getAdjList().get(j).isWasVisited()) {
				return as.getAdjList().get(j);
			}
		}

		return null;
	}
	@Override
	public void assignVisit(ArrayList<NodeGraph<V>> a, NodeGraph<V> ae) {
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == ae) {
				a.get(i).setWasVisited(true);
			}

		}
	}
	public void setVisitedAllNodes() {
		for (Map.Entry<String, NodeGraph<V>> entry : vertices.entrySet()) {
			entry.getValue().setWasVisited(false);
		}
	}
	
	public ArrayList<NodeGraph<V>> BFS(String k) {

		setVisitedAllNodes();
		NodeGraph<V> n =searchVertex(k);
		if (n!=null) {

			LinkedList<NodeGraph<V>> cola = new LinkedList<NodeGraph<V>>();
			cola.add(n);
			n.setWasVisited(true);
			ArrayList<NodeGraph<V>> array = new ArrayList<NodeGraph<V>>();
			while (!cola.isEmpty()) {
				NodeGraph<V> actual = cola.poll();
				
				array.add(actual);
				ArrayList<NodeGraph<V>> aux = actual.getAdjList();
				for (int i = 0; i < aux.size(); i++) {
					NodeGraph<V> sig = aux.get(i);
					if (sig.isWasVisited() == false) {
						sig.setWasVisited(true);
						cola.add(sig);
						
					}
				}

			}

			return array;
		} else {
			return null;
		}
	}

	@Override
	public ArrayList<V> bfsGraph() {
		Iterator<Map.Entry<String, NodeGraph<V>>> entries = vertices.entrySet().iterator();
		ArrayList<NodeGraph<V>> vertexList = new ArrayList<NodeGraph<V>>();
		Queue<NodeGraph<V>> queue = new LinkedList<NodeGraph<V>>();
		ArrayList<V> all = new ArrayList<V>();
		
		while (entries.hasNext()) {
			Map.Entry<String, NodeGraph<V>> entry = entries.next();
			vertexList.add(entry.getValue());
		}

		vertexList.get(0).setWasVisited(true);
		queue.add(vertexList.get(0));
		displayVertex(vertexList.get(0));
		all.add(vertexList.get(0).getValue());
		NodeGraph<V> aux2;

		for (; !queue.isEmpty();) {
			NodeGraph<V> aux = queue.remove();
			while ((aux2 = getAdjUnvisitedVertex(aux)) != null) {
				assignVisit(vertexList, aux2);
				displayVertex(aux2);
				all.add(aux2.getValue());
				queue.add(aux2);
			}

		}
         return all;
	}
	@Override
	public void dfsGraph(NodeGraph<V> node) {
		Stack<NodeGraph<V>> stack = new Stack<NodeGraph<V>>();
		stack.add(node);
		node.setWasVisited(true);
		while (!stack.isEmpty()) {
			NodeGraph<V> element = stack.pop();
			System.out.print(element.getValue() + " ");

			List<NodeGraph<V>> neighbours = element.getAdjList();
			for (int i = 0; i < neighbours.size(); i++) {
				NodeGraph<V> n = neighbours.get(i);
				if (n != null && !n.isWasVisited()) {
					stack.add(n);
					n.setWasVisited(true);
				}
			}
		}
	}
//	@Override
//	public Edge<V, E> searchEdge(double weight){
//		boolean wasFound = false;
//		Edge<V,E> aux = null;
//		for(int i = 0; i < edges.size() && !wasFound; i++) {
//			if(weight == edges.get(i).getWeight()) {
//				aux = edges.get(i);
//				wasFound = true;
//			}
//		}
//		
//		return aux;
//	}
//	

	public static void main(String[] args) {
		// Graph<String, Double> grafo= new Graph<String, Double>();
		// String S ="S";
		// String C="C";
		// String N="N";
		// String D="D";
		// String A="A";
		//
		// Double edge1=12.0;
		// Double edge2=9.0;
		// Double edge3=13.0;
		// Double edge4=14.0;
		// Double edge5=7.0;
		// Double edge6=10.0;
		// Double edge7=8.0;
		//
		// grafo.addVertex("S", S);
		// grafo.addVertex("C", C);
		// grafo.addVertex("N", N);
		// grafo.addVertex("D", D);
		// grafo.addVertex("A", A);
		//
		// grafo.insertEdge(edge1, "0", "S", "C", edge1);
		// grafo.insertEdge(edge2, "1", "S", "D", edge2);
		// grafo.insertEdge(edge3, "2", "D", "C", edge3);
		// grafo.insertEdge(edge4, "3", "D", "A", edge4);
		// grafo.insertEdge(edge5, "4", "A", "C", edge5);
		// grafo.insertEdge(edge6, "5", "C", "N", edge6);
		// grafo.insertEdge(edge7, "6", "N", "A", edge7);
		//
		//
		// int[] lista=grafo.primMTS();
		//
		// for (int i = 0; i < lista.length; i++) {
		//
		// System.out.println(i+ " VERTICE SIGUIENTE " + lista[i]);
		//
		// }

//		 Graph<Building, Double> grafo = new Graph<Building, Double>();
//		 Building A = new Building("A");
//		 Building B = new Building("B");
//		 Building C = new Building("C");
//		 Building D = new Building("D");
//		 Building E = new Building("E");
//		 Building Z = new Building("Z");
//		
//		
//		
//		 grafo.addVertex("C",C);
//		 grafo.addVertex("B",B);
//		 grafo.addVertex("D",D);
//		 grafo.addVertex("E",E);
//		 grafo.addVertex("Z",Z);
//		 grafo.addVertex("A",A);
//		 Double edge1 = 4.0;
//		 Double edge2 = 2.0;
//		 Double edge3 = 1.0;
//		 Double edge4 = 5.0;
//		 Double edge5 = 8.0;
//		 Double edge6 = 10.0;
//		 Double edge7 = 2.0;
//		 Double edge8 = 6.0;
//		 Double edge9 = 3.0;
//		 grafo.insertEdge(edge7,  "E","D", edge7);
//		 grafo.insertEdge(edge3,  "C","B", edge3);
//		 grafo.insertEdge(edge9,  "E","Z", edge9);
//		 grafo.insertEdge(edge1, "A","B", edge1);
//		 grafo.insertEdge(edge2, "A","C", edge2);
//		
//		 grafo.insertEdge(edge4, "B","D", edge4);
//		 grafo.insertEdge(edge5,  "C","D", edge5);
//		 grafo.insertEdge(edge6,  "C","E", edge6);
//		 
//		 grafo.insertEdge(edge8,  "D","Z", edge8);
//		
		
		 
		// for(int i=0;i<grafo.getWeightMatrix().length;i++) {
		// for(int j=0;j<grafo.getWeightMatrix().length;j++) {
		// System.out.println(grafo.getWeightMatrix()[i][j]);
		// }
		// }
		//
		
		// for(int i=0;i<grafo.getVertices().get(2).getAdjList().size();i++){
		//
		// System.out.println(grafo.getVertices().get(2).getAdjList().get(i).getValue().getName());
		// }
//		 for(int i=0;i<grafo.dijkstraNodes("A").size();i++) {
//			 System.out.println("nodo "+i);
//			 for(int j=0;j<grafo.dijkstraNodes("A").get(i).size();j++) {
//			     
//				 System.out.println(grafo.dijkstraNodes("A").get(i).get(j));
//			 }
//		 
//		 }
//		 grafo.print(grafo.dijkstraNodes("Z"),grafo.foundPos("A"));
//		 for(int i=0;i<grafo.getNodes().size();i++) {
//			 System.out.println(grafo.getNodes().get(i).getName());
//		 }
//		 System.out.println("DISTANCIAS");
//		 for(int i=0;i<grafo.dijkstra("A").length;i++) {
//			 System.out.println(grafo.dijkstra("A")[i]);
//		 }
		

//		 for (Map.Entry<String, NodeGraph<Building>> entry : grafo.getVertices().entrySet()) {
//				System.out.println(entry.getValue().getPos());
//				System.out.println(entry.getKey());
//		 }
		 
		 
		//
		
		
		
	}
	//
	

}
