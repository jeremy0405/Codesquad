package mission.cs.cs03;


public class VideoEditor {

	private VideoData[] videoData;
	private static final int VIDEO_DATA_NUMBER = 13;

	public void init() {
		videoData = new VideoData[VIDEO_DATA_NUMBER];
		initVideoData();
	}

	public void start() {
		Print.print(videoData);
	}

	private void initVideoData() {
		for (int i = 0; i < 13; i++) {
			videoData[i] = new VideoData("제목" + (i + 1));
		}
	}

}
