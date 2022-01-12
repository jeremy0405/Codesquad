package mission.cs.cs03.custom;

import mission.cs.cs03.VideoData;

public class Main {

	public static void main(String[] args) {
		CustomLinkedList<Integer> cLinkedList = new CustomLinkedList<>();

		cLinkedList.add(10);
		cLinkedList.add(30);
		cLinkedList.add(50);

		System.out.println(cLinkedList.get(0).getData());
		System.out.println(cLinkedList.get(1).getData());
		System.out.println(cLinkedList.get(2).getData());

		CustomLinkedList<VideoData> vLinkedList = new CustomLinkedList<>();

		vLinkedList.add(new VideoData("aaaa", "제목1",15));
		vLinkedList.add(new VideoData("bbbb", "제목2",10));
		vLinkedList.add(new VideoData("cccc", "제목3", 5));

		System.out.println(vLinkedList.get(0).getNextNode().getData().getId());
		System.out.println(vLinkedList.get(1).getData().getId());
		System.out.println(vLinkedList.get(2).getData().getId());

	}

}
