package mission.cs.cs07;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Scheduler {

	private Queue<Process> readyQueue;
	private List<Process> processList;

	public Scheduler(List<Process> processList) {
		this.readyQueue = new LinkedList<>(processList);
		this.processList = processList;
	}

	public void start() {
		//todo redayQueue에 있는 프로세스들을 관리해야 함.
		// 시간이 다 되면 cpu를 뻇고

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
				//todo interrupt 걸어야 함
				// interrupt 걸면 쓰레드 재사용이 불가능해서 suspend로 함.
				// deprecated 된 건데.. 어떻게할지 고민중
				tmp.getThreadList().get(0).suspend();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if ("waiting".equals(tmp.getState())) {
				readyQueue.add(tmp);
			}

		}

		statePrint();

	}

	private void statePrint() {
		Print.print(processList);
		System.out.println(".");
	}

}
