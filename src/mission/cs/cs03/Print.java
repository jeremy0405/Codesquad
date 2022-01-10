package mission.cs.cs03;

public class Print {

	public static void print(VideoData[] videoData) {

		int size = videoData.length;
		for (int i = 0; i < size; i++) {
			String output = videoData[i].getTitle() + " (" + videoData[i].getId() + ") : "
				+ videoData[i].getRunTime();
			System.out.println(output);
		}

	}

}
