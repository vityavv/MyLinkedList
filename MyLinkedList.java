public class MyLinkedList {
	private int size;
	private Node start, end;

	public MyLinkedList() {
		size = 0;
	}

	public int size() {return size;}
	public boolean add(String value) {
		if (size == 0) {
			start = new Node(value);
			end = start;
			start.setNext(end);
			end.setPrev(start);
		} else
		if (size == 1) {
			end = new Node(value);
			start.setNext(end);
			end.setPrev(start);
		} else {
			Node oldEnd = end;
			end = new Node(value);
			oldEnd.setNext(end);
			end.setPrev(oldEnd);
		}
		size++;
		return true;
	}

	private Node getNodeAt(int index) {
		int i = 0;
		Node current = start;
		while (i < index) {
			current = current.getNext();
			i++;
		}
		return current;
	}
	public void add(int index, String value) {
		if (index > size()) throw new IndexOutOfBoundsException("Index out of bounds");
		if (index == size()) {
			add(value);
			return;
		}
		if (index == 0) {
			Node oldStart = start;
			start = new Node(value);
			start.setNext(oldStart);
			oldStart.setPrev(start);
		} else {
			Node current = getNodeAt(index);
			Node newNode = new Node(value);
			newNode.setNext(current);
			newNode.setPrev(current.getPrev());
			current.getPrev().setNext(newNode);
			current.setPrev(newNode);
		}
		size++;
	}
	public String get(int index) {
		if (index < 0 || index >= size()) throw new IndexOutOfBoundsException("Index out of bounds");
		return getNodeAt(index).getData();
	}
	public String set(int index, String value) {
		if (index < 0 || index >= size()) throw new IndexOutOfBoundsException("Index out of bounds");
		Node current = getNodeAt(index);
		String old = current.getData();
		current.setData(value);
		return old;
	}

	public String toString() {
		if (size == 0) return "[]";
		Node current = start;
		String output = "[";
		//TODO this sucks make it better
		boolean lastOne = false; //because reasons, see commit history too lazy to explain
		while (true) {
			output += current.getData();
			if (lastOne) break;
			if (current.getNext() != null) {
				output += ", ";
			}
			current = current.getNext();
			if (current.getNext() == null) lastOne = true;
		}
		output += "]";
		return output;
	}
}
