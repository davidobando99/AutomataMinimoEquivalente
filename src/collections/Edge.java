package collections;

import java.io.Serializable;

public class Edge<V,E> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private E value;
	private NodeGraph<V> origin;
	private NodeGraph<V> end;
	private String weight;
	
	public Edge(E value, String weight, NodeGraph<V> origin, NodeGraph<V> end){
		this.value=value;
		this.weight=weight;
		this.origin=origin;
		this.end=end;
		
		
		
	}
	
	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public NodeGraph<V> getOrigin() {
		return origin;
	}

	public void setOrigin(NodeGraph<V> origin) {
		this.origin = origin;
	}

	public NodeGraph<V> getEnd() {
		return end;
	}

	public void setEnd(NodeGraph<V> end) {
		this.end = end;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
//	@Override
//	public int compareTo(Edge<V,E> edge) {
//		
//		int ret = 0;		
//		if(this.weight> edge.getWeight()) {
//			ret = 1;
//		}else {
//			ret = -1;
//		}
//		return ret;
//	}
//	
	
	
	

}
