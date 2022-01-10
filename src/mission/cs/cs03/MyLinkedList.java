package mission.cs.cs03;

public class MyLinkedList {

	private VideoData head;
	private VideoData tail;
	private int size;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void add(VideoData inputData) {
		if (this.head == null) {
			this.head = inputData;
			this.tail = inputData;
			size++;
		} else {
			VideoData tmpData = this.head;
			while (tmpData.getNextNode() != null) {
				tmpData = tmpData.getNextNode();
			}
			tmpData.setNextNode(inputData);
			this.tail = inputData;
			size++;
		}
	}

	public void delete(String id) {

	}

	public void insert(String id, int index) {

	}

	public void render() {

	}

	public VideoData get(int index) {
		if (index + 1 > size) {
			System.out.println("잘못된 Index 값입니다.");
			return null;
		} else {
			VideoData tmpData = this.head;
			for (int i = 0; i < index; i++) {
				tmpData = tmpData.getNextNode();
			}
			return tmpData;
		}

	}

	public int size() {
		return size;
	}

}
