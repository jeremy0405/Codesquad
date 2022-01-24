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
			process.setState("waiting");
		}

		while (!readyQueue.isEmpty()) {
			Process tmp = readyQueue.poll();
			tmp.setState("running");
			tmp.start();

			statePrint();

			if (tmp.isTerminated()) {
				tmp.setState("terminated");
			} else {
				tmp.setState("waiting");
			}

			try {
				Thread.sleep(1000);
				for (MyThread myThread : tmp.getThreadList()) {
					myThread.suspend();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if ("waiting".equals(tmp.getState())) {
				readyQueue.add(tmp);
			} else {
				for (MyThread myThread : tmp.getThreadList()) {
					myThread.stop();
				}
			}
		}
		statePrint();
	}

	private void statePrint() {
		Print.print(processList);
		System.out.println(".");
	}

}
