package mission.cs.cs07;

import java.util.List;

public class Print {

	private Print() {}

	public static void print(Process process, String name) {
		System.out.println(name + process);
	}

	public static void print(List<Process> processList) {

		for (int i = 0; i < processList.size(); i++) {
			Process process = processList.get(i);
			System.out.println("process" + (char)('A' + i) + process);
		}
	}

}
