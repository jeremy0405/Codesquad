package mission.cs.cs08.java8study;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ModernJava {

	private static Integer work_1() throws Exception{
		TimeUnit.SECONDS.sleep(1);
		return 1;
	}

	private static Integer work_2() throws Exception{
		TimeUnit.SECONDS.sleep(2);
		return 2;
	}

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		CompletableFuture<Integer> value_1 = new CompletableFuture<>();
		CompletableFuture<Integer> value_2 = new CompletableFuture<>();
		CompletableFuture<Integer> value_3 = value_1.thenCombine(value_2, Integer::sum);

		executorService.submit(() -> value_1.complete(work_1()));
		executorService.submit(() -> value_2.complete(work_2()));
		executorService.submit(() -> {
			try {
				System.out.println("sum = " + (value_3.get()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		executorService.shutdown();

	}

}
