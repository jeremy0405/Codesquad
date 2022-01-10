package mission.cs.cs03;

public class Print {
	private static final StringBuilder output = new StringBuilder();
	public static void print(VideoData[] videoData) {

		for (VideoData videoDatum : videoData) {
			output.append(videoDatum.getTitle())
				.append(" (")
				.append(videoDatum.getId())
				.append(") : ")
				.append(videoDatum.getRunTime())
				.append("\n");
		}

		System.out.println("-----영상클립-----");
		System.out.println(output);

		output.setLength(0);

	}

}
