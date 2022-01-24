package mission.cs.cs07;

import java.util.ArrayList;
import java.util.List;

public class Process {

	private final List<MyThread> threadList;
	private int totalTime;
	private int usedTime;
	private String state;

	public Process(int totalTime) {
		threadList = new ArrayList<>();
		threadList.add(new MyThread());
		this.totalTime = totalTime;
		this.usedTime = 0;
		this.state = "ready";
	}




}
