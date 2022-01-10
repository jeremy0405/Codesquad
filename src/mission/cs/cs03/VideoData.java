package mission.cs.cs03;

import java.util.Random;

public class VideoData {

	IdCreator idCreator;
	private final String id;
	private String title;
	private int runTime;
	private VideoData nextNode;
	private Random random = new Random();

	public VideoData(String title) {
		idCreator = IdCreator.getInstance();
		this.id = idCreator.getId();
		this.title = title;
		this.runTime = random.nextInt(15) + 1;
		this.nextNode = null;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getRunTime() {
		return runTime;
	}

	public VideoData getNextNode() {
		return nextNode;
	}

	public void setNextNode(VideoData videoData) {
		this.nextNode = videoData;
	}

}
