package mission.cs.cs07;

public class MyThread extends Thread {

	@Override
	public void run() {
		int i = 0;
		while (true) {
			//todo do nothing
			i++;
			if (i % 300000000 == 0) {
				System.out.println(i);
			}
		}

	}
}
