package mission.cs.cs03;

public class MyLinkedList {

	private VideoData head;
	private VideoData tail;

	public MyLinkedList() {
		head = null;
		tail = null;
	}

	public void add(VideoData inputData) {
		if (head == null) {
			head = inputData;
		} else {
			VideoData tmpData = head;
			while (tmpData.getNextNode() != null) {
				tmpData = tmpData.getNextNode();
			}
			tmpData.setNextNode(inputData);
		}
	}

	public void delete(String id) {

	}

	public void insert(String id, int index) {

	}

	public void render() {

	}

}
