package mission.cs.cs03;


public class VideoEditor {

	private VideoData[] videoData;

	public void init() {
		videoData = new VideoData[13];
		for (int i = 0; i < 13; i++) {
			videoData[i] = new VideoData("제목" + (i + 1));
		}
	}

	public void start() {
		Print.print(videoData);
	}

}
