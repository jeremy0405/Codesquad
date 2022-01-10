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

		boolean isWork = true;
		while (isWork) {
			String[] input = val.validateInput(UserInput.userInput(), videoData);
			isWork = classifyInput(input);
		}

	}

	private boolean classifyInput(String[] input) {
		switch (input[0]) {
			case "add":
				execAdd(input);
				return true;
			case "delete":
				execDelete(input);
				return true;
			case "insert":
				execInsert(input);
				return true;
			case "render":
				Print.print(linkedList.render(linkedList));
				return false;
			default:
				return true;
		}

	}

	private void execInsert(String[] input) {
		for (int i = 0; i < VIDEO_DATA_NUMBER; i++) {
			if (input[1].equals(videoData[i].getId())) {
				VideoData newData = new VideoData(videoData[i].getTitle(),
					videoData[i].getId(), videoData[i].getRunTime());
				linkedList.insert(newData, Integer.parseInt(input[2]));
				break;
			}
		}

	}

	private void execDelete(String[] input) {
		for (int i = 0; i < VIDEO_DATA_NUMBER; i++) {
			if (input[1].equals(videoData[i].getId())) {
				VideoData newData = new VideoData(videoData[i].getTitle(),
					videoData[i].getId(), videoData[i].getRunTime());
				linkedList.delete(newData);
				break;
			}
		}
		Print.print(linkedList);
	}

	private void execAdd(String[] input) {
		for (int i = 0; i < VIDEO_DATA_NUMBER; i++) {
			if (input[1].equals(videoData[i].getId())) {
				VideoData newData = new VideoData(videoData[i].getTitle(),
					videoData[i].getId(), videoData[i].getRunTime());
				linkedList.add(newData);
				break;
			}
		}
		Print.print(linkedList);
	}

	private void initVideoData() {
		for (int i = 0; i < 13; i++) {
			videoData[i] = new VideoData("제목" + (i + 1));
		}
	}

}
