package mission.cs.cs03;

public class Print {

	private static final StringBuilder output = new StringBuilder();

	private Print(){}
	public static void print(VideoData[] videoData) {

		for (VideoData videoDatum : videoData) {
			output.append(videoDatum.getTitle())
				.append(" (").append(videoDatum.getId()).append(") : ")
				.append(videoDatum.getRunTime()).append("\n");
		}

		System.out.println("-----영상클립-----");
		System.out.println(output);

		output.setLength(0);

	}

	public static void print(MyLinkedList linkedList) {
		output.append("|---");
		for (int i = 0; i < linkedList.size(); i++) {
			VideoData data = linkedList.get(i);
			output.append("[").append(data.getId()).append(", ")
				.append(data.getRunTime()).append("sec").append("]---");
		}
		output.append("[end]");
		System.out.println(output);

		output.setLength(0);

	}

	public static void print(int[] render) {
		output.append("영상클립: ").append(render[0]).append("개\n")
			.append("전체길이: ").append(render[1]).append("sec");
		System.out.println(output);

		output.setLength(0);
	}
}
