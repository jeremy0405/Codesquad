package mission.cs.cs03;

import java.util.Random;

public class VideoData {

	private final String id;
	private String title;
	private int runTime;
	private int nextNode;
	private Random random = new Random();

	public VideoData(String title) {
		this.id = IdCreator.getId();
		this.title = title;
		this.runTime = random.nextInt(15) + 1;
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

}
