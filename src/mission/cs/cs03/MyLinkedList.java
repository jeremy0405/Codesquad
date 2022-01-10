package mission.cs.cs03;

public class MyLinkedList {

	private VideoData head;
	private int size;

	public MyLinkedList() {
		this.head = null;
		this.size = 0;
	}

	public void add(VideoData inputData) {
		if (this.head == null) {
			this.head = inputData;
			size++;
		} else {
			VideoData tmpData = this.head;
			while (tmpData.getNextNode() != null) {
				tmpData = tmpData.getNextNode();
			}
			tmpData.setNextNode(inputData);
			size++;
		}
	}

	public void delete(VideoData inputData) {
		size--;

	}

	public void insert(VideoData inputData, int index) {
		size++;
	}

	public int[] render(MyLinkedList linkedList) {

		int time = 0;
		for (int i = 0; i < size; i++) {
			time += linkedList.get(i).getRunTime();
		}

		return new int[]{size, time};

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
