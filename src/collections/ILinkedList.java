package collections;

public interface ILinkedList<T> {

	public void addItem(T newElement);
	public void deleteItem(T newElement);
	public boolean isThereElement(T newElement);
	public boolean isEmptyLinkedList();
	public int sizeLinkedList();
	public NodeDoubly<T> getFirst();
	public void setFirst(NodeDoubly<T> first);
	public NodeDoubly<T> getLast();
	public void setLast(NodeDoubly<T> last);
	public NodeDoubly<T> searchElement(T newElement);
}
