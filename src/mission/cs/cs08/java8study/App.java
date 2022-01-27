package mission.cs.cs08.java8study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();


		executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
		executorService.shutdown();

//		executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//		executorService.shutdown();

		ExecutorService executorService2 = Executors.newFixedThreadPool(2);
		executorService2.submit(getRunnable());

		executorService2.shutdown();


	}

	private static Runnable getRunnable() {
		return () -> {
			System.out.println("Thread : " + Thread.currentThread().getName());
		};
	}

}
