package mission.cs.cs07;

import java.util.ArrayList;
import java.util.List;

public class Process {

	private final List<MyThread> threadList;
	private final int totalTime;
	private int usedTime;
	private String state;

	//todo 멀티쓰레드 프로세스를 만드는 생성자도 추가해야 할듯
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void start() {

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

	public boolean isTerminated() {
		return usedTime >= totalTime;
	}

	public List<MyThread> getThreadList() {
		return threadList;
	}

	@Override
	public String toString() {
		return '(' + state + "), " +
			+ usedTime + " / " +
			+ totalTime + "sec";
	}

}
