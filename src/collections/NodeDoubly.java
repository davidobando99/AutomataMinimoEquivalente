package collections;

public class NodeDoubly<T> {

	// ********************
	// Relations
	// ********************
	private NodeDoubly<T> next;
	private NodeDoubly<T> previous;
	private T element;

	/**
	 * Builder methods of this class.
	 */
	public NodeDoubly(T element) {
		next = null;
		previous = null;
		this.element = element;	
	}
	
	//************************
	// GETTS AND SETTERS
	//************************
	
	public NodeDoubly<T> getNext() {
		return next;
	}

	public void setNext(NodeDoubly<T> next) {
		this.next = next;
	}

	public NodeDoubly<T> getPrevious() {
		return previous;
	}

	public void setPrevious(NodeDoubly<T> previous) {
		this.previous = previous;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	
}
