package mission.cs.cs03;

public class VideoEditor {

	private VideoData[] videoData;
	private ValidationInput val;
	private MyLinkedList linkedList;
	private static final int VIDEO_DATA_NUMBER = 13;

	public void init() {
		videoData = new VideoData[VIDEO_DATA_NUMBER];
		val = new ValidationInput();
		initVideoData();
	}

	public void start() {
		Print.print(videoData);
		linkedList = new MyLinkedList();

		while (true) {
			String[] input = val.validateInput(UserInput.userInput(), videoData);
			classifyInput(input);
			Print.print(linkedList);
		}

	}

	private void classifyInput(String[] input) {
		switch (input[0]) {
			case "add":
				for (int i = 0; i < VIDEO_DATA_NUMBER; i++) {
					if (input[1].equals(videoData[i].getId())) {
						VideoData newData = new VideoData(videoData[i].getTitle(),
							videoData[i].getId(), videoData[i].getRunTime());
						linkedList.add(newData);
						break;
					}
				}
				break;
			case "delete":
			case "insert":
			case "render":
		}

	}

	private void initVideoData() {
		for (int i = 0; i < 13; i++) {
			videoData[i] = new VideoData("제목" + (i + 1));
		}
	}

}
