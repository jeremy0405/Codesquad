package mission.cs.cs03.custom;

public class CustomLinkedList<E> {

	private Node<E> head;
	private int size = 0;

	public void add(E data) {
		if (head == null) {
			head = new Node<>(data);
			size++;
			return;
		}

		Node<E> tmpNode = head;
		while (tmpNode.getNextNode() != null) {
			tmpNode = tmpNode.getNextNode();
		}
		tmpNode.setNextNode(new Node<>(data));
		size++;
	}

	public Node<E> get(int index) {
		Node<E> answer = head;
		for (int i = 0; i < index; i++) {
			answer = answer.getNextNode();
		}
		return answer;
	}

}
