package mission.cs.cs07;

public class MyThread implements Runnable {

	volatile boolean suspended; //volatile -> '쉽게 바뀌는 변수'선언해야 쓰레드종료
	volatile boolean stopped;
	private final Thread thread;

	public MyThread() {
		this.suspended = false;
		this.stopped = false;
		this.thread = new Thread(this);
	}

	@Override
	public void run() {
		int i = 0;
		while (!stopped) {
			if (!suspended) {
				i++;
				if (i % 300000000 == 0) {
					System.out.println(i);
				}
			} else {
				Thread.yield();
			}
		}
	}

	public void suspend() {
		suspended = true;
//		thread.interrupt();
	}

	public void resume() {
		suspended = false;
	}

	public void stop() {
		stopped = true;
//		thread.interrupt();
	}

	public void start() {
		thread.start();
	}
}