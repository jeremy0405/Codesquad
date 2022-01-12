package mission.cs.cs03.custom;

public class Node<E> {
	private E data;
	private Node<E> nextNode;

	public Node() {}

	public Node(E data) {
		this.data = data;
	}

	public E getData() {
		return data;
	}

	public Node<E> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<E> nextNode) {
		this.nextNode = nextNode;
	}
}
