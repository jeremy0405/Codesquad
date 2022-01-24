package mission.cs.cs07;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Scheduler {

	private final Queue<Process> readyQueue;
	private final List<Process> processList;

	public Scheduler(List<Process> processList) {
		this.readyQueue = new LinkedList<>(processList);
		this.processList = processList;
	}

	public void start() {

		for (Process process : processList) {
			process.setWaitingState();
		}

		while (!readyQueue.isEmpty()) {
			Process runningProcess = readyQueue.poll();
			runningProcess.setRunningState();
			runningProcess.run();

			printState();

			try {
				Thread.sleep(1000);
				runningProcess.suspend();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (runningProcess.isTerminated()) {
				runningProcess.setTerminatedState();
				runningProcess.stop();
			} else {
				runningProcess.setWaitingState();
				readyQueue.add(runningProcess);
			}
		}
		printState();
	}

	private void printState() {
		System.out.println();
		Print.print(processList);
		System.out.println(".");
	}

}
