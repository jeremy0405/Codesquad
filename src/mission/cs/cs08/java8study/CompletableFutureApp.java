package mission.cs.cs08.java8study;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureApp {

	public static void main(String[] args) {
		CompletableFuture<String> future1 = CompletableFuture
			.supplyAsync(() -> "Future1")
			.thenApply((s) -> {
				System.out.println("Starting future1");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return s + "!";
			});

		CompletableFuture<String> future2 = CompletableFuture
			.supplyAsync(() -> "Future2")
			.thenApply((s) -> {
				System.out.println("Starting future2");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return s + "!";
			});

		future1.thenCombine(future2, (s1, s2) -> s1 + " + " + s2)
			.thenAccept(System.out::println);
	}

}
