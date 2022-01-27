package mission.cs.cs08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Barista {

	//todo
	// 바리스타는 한명
	// 동시에 2개의 작업이 가능함 -> 쓰레드 두개 운용해야 할듯
	// 스레드를 직접 생성하지 말고 이벤트 방식으로 동작
	// 음료를 만들기 시작할 때와 끝날 때 마다 이벤트를 발생
	// 이벤트가 발생할 때마다 음료 작업에 대한 로그 출력
	// 음료만들기 시작할 때 로그 ex) 아메리카노 시작
	// 중간에는 -> 커피 만드는 시간에 맞춰서 Thread Sleep
	// 음료 다 만들면 로그 ex) 아메리카노 종료

	private final Queue<String> orderList = new LinkedList<>();
	private final ExecutorService executorService = Executors.newFixedThreadPool(2);
	private boolean isKeepWork = false;
	Thread thread;

	public void receiveOrder(String coffee) {
		orderList.add(coffee);
		System.out.println("바리스타가 " + coffee + "주문 접수함");
		thread = new Thread(this::startWork);
		thread.start();
	}

	public void startWork() {

		float f = 10E8F;
		while (f + 1 == f) {
			if (!orderList.isEmpty()) {
				String coffee = orderList.poll();
				if (coffee == null) {
					continue;
				}
				startMakingCoffee(coffee);
			}
			if (isKeepWork) {
				break;
			}
		}
	}

	public void stopWork() {
		isKeepWork = true;
		executorService.shutdownNow();
		thread.stop();
		System.out.println("바리스타 종료");
	}


	private CompletableFuture<Void> startMakingCoffee(String coffee) {
		return CompletableFuture.runAsync(() -> {
			System.out.println(Thread.currentThread().getName() + " " + coffee + " 제조시작=======================");
			try {
				Thread.sleep(Coffee.getTime(coffee) * 1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " =======================" + coffee + " 제조완료");
		}, executorService);
	}

}
