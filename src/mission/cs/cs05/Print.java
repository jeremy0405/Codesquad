package mission.cs.cs05;

import java.util.List;

public class Print {

	private Print() {}

	public static void print(List<Object> stackAndHeap) {
		System.out.println(stackAndHeap.get(0));
		System.out.println(stackAndHeap.get(1));
	}

}
