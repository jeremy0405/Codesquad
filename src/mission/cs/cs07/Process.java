package mission.cs.cs07;

import java.util.ArrayList;
import java.util.List;

public class Process {

	private final List<MyThread> threadList;
	private int totalTime;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void start() {

		usedTime += threadList.size();

		//todo 멀티 쓰레드일 떄 생각해야 함
		threadList.get(0).run();

	}


	public boolean isTerminated() {
		return usedTime >= totalTime;
	}

	@Override
	public String toString() {
		return '(' + state + "), " +
			+ usedTime + " / " +
			+ totalTime + "sec";
	}

}
