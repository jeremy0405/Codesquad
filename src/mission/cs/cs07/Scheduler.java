package mission.cs.cs07;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Scheduler {

	private Queue<Process> readyQueue;

	public Scheduler(List<Process> processList) {
		this.readyQueue = new LinkedList<>(processList);
	}

	public void start() {

	}

}
