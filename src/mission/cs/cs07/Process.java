package mission.cs.cs07;

import java.util.ArrayList;
import java.util.List;

public class Process {

	private final List<MyThread> threadList;
	private final int totalTime;
	private int usedTime;
	private String state;

	public Process(int totalTime) {
		threadList = new ArrayList<>();
		threadList.add(new MyThread());
		this.totalTime = totalTime;
		this.usedTime = 0;
		this.state = "ready";
	}

	public Process(int totalTime, int threadNumber) {
		threadList = new ArrayList<>();

		for (int i = 0; i < threadNumber; i++) {
			threadList.add(new MyThread());
		}

		this.totalTime = totalTime;
		this.usedTime = 0;
		this.state = "ready";
	}

	public void run() {
		usedTime += threadList.size();
		usedTime = isTerminated() ? totalTime : usedTime;

		try {
			for (MyThread myThread : threadList) {
				myThread.start();
			}
		} catch (Exception e) {
			for (MyThread myThread : threadList) {
				myThread.resume();
			}
		}

	}

	public void stop() {
		for (MyThread myThread : threadList) {
			myThread.stop();
		}
	}

	public void suspend() {
		for (MyThread myThread : threadList) {
			myThread.suspend();
		}
	}

	public boolean isTerminated() {
		return usedTime >= totalTime;
	}

	public void setWaitingState() {
		this.state = "waiting";
	}

	public void setRunningState() {
		this.state = "running";
	}

	public void setTerminatedState() {
		this.state = "terminated";
	}

	@Override
	public String toString() {
		return '(' + state + "), " +
			+ usedTime + " / " +
			+ totalTime + "sec";
	}

}
