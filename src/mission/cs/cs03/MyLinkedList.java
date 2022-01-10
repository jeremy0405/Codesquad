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

	public void delete(VideoData inputData, int index) {

		if (size == 0) {
			System.out.println("데이터가 존재하지 않습니다. delete명령을 수행할 수 없습니다.");
			return;
		}
		if (index == 0) {
			this.head = inputData.getNextNode();
		} else {
			get(index - 1).setNextNode(inputData.getNextNode());
		}
		size--;
	}

	public void insert(VideoData inputData, int index) {
		if (index >= size) {
			add(inputData);
			return;
		} else {
			//todo insert 때 어떻게 할 건지 작성해야 함
			// 100 101 null
			// 0   1   2
			// 100 103 101 null

			get(index).getNextNode();
			size++;
		}
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
