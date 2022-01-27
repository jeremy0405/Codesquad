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
			giveCPUToProcess(runningProcess);

			printState();

			try {
				Thread.sleep(1000);
				runningProcess.suspend();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (runningProcess.isTerminated()) {
				terminateProcess(runningProcess);
			} else {
				takeCPUFromProcess(runningProcess);
			}
		}
		printState();
		System.out.println("프로그램이 종료되었습니다.");
	}

	private void giveCPUToProcess(Process runningProcess) {
		runningProcess.setRunningState();
		runningProcess.run();
	}

	private void takeCPUFromProcess(Process runningProcess) {
		runningProcess.setWaitingState();
		readyQueue.add(runningProcess);
	}

	private void terminateProcess(Process runningProcess) {
		runningProcess.setTerminatedState();
		runningProcess.stop();
	}

	private void printState() {
		System.out.println();
		Print.print(processList);
		System.out.println(".");
	}

}
