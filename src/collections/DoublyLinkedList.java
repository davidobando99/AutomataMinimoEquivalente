package collections;

public class DoublyLinkedList<T> implements ILinkedList<T> {

	// ***********************
	// Relations
	// ***********************
	private NodeDoubly<T> first;
	private NodeDoubly<T> last;

	/**
	 * Builder method of this class.
	 */
	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	@Override
	public void addItem(T newElement) {

		NodeDoubly<T> elementNew = new NodeDoubly<T>(newElement);

		if (first == null) {
			first = elementNew;
			last = elementNew;
			first.setPrevious(null);
		} else {
			NodeDoubly<T> actual = first;

			for (;actual.getNext() != null;) {
				actual = actual.getNext();
			}

			actual.setNext(elementNew);
			actual.getNext().setPrevious(actual);
			last = elementNew;
		}
	}

	@Override
	public void deleteItem(T newElement) {

		if (first != null) {
			NodeDoubly<T> firstAux = first;
			NodeDoubly<T> previousAux = null;

			while (firstAux != null) {
				if (firstAux.getElement() == newElement) {
					if (firstAux.getPrevious() == null) {
						first = first.getNext();
						firstAux.setNext(null);
						firstAux = first;
					} else {
						previousAux = firstAux.getPrevious();
						previousAux.setNext(firstAux.getNext());
						firstAux = previousAux.getNext();
					}

				} else {

					firstAux = firstAux.getNext();

				}
			}
		}

	}

	@Override
	public boolean isThereElement(T newElement) {
		NodeDoubly<T> aux = first;
		boolean exists = false;

		while (aux != null && !exists) {
			if (aux.getElement() == newElement) {
				exists = true;
			} else {
				aux = aux.getNext();
			}
		}

		return exists;
	}

	@Override
	public NodeDoubly<T> searchElement(T newElement) {
		NodeDoubly<T> aux = first;
		NodeDoubly<T> searched = null;
		boolean exists = false;

		while (aux != null && !exists) {
			if (aux.getElement() == newElement) {
				searched=aux;
				exists = true;
			} else {
				aux = aux.getNext();
			}
		}

		return searched;
	}

	@Override
	public boolean isEmptyLinkedList() {
		return (first == null) ? true : false;
	}

	@Override
	public int sizeLinkedList() {
		int accountant = 0;

		if (first != null) {
			NodeDoubly<T> aux = first;
			while (aux != null) {
				accountant++;
				aux = aux.getNext();
			}
		}

		return accountant;
	}

	// ***************************
	// METHODS GETTS AND SETTERS
	// ***************************

	@Override
	public NodeDoubly<T> getFirst() {
		return first;
	}

	@Override
	public void setFirst(NodeDoubly<T> first) {
		this.first = first;
	}

	@Override
	public NodeDoubly<T> getLast() {
		return last;
	}

	@Override
	public void setLast(NodeDoubly<T> last) {
		this.last = last;
	}

}
