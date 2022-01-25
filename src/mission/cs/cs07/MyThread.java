package mission.cs.cs07;

public class MyThread implements Runnable {

	private volatile boolean suspended;
	private volatile boolean stopped;
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
				if (i % 400000000 == 0) {
					System.out.println(i);
				}
			} else {
				Thread.yield();
			}
		}
	}

	public void suspend() {
		suspended = true;
	}

	public void resume() {
		suspended = false;
	}

	public void stop() {
		stopped = true;
	}

	public void start() {
		thread.start();
	}
}