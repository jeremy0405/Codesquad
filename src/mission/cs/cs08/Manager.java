package mission.cs.cs08;

import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Manager {

	//todo
	// 음료를 확인하기 위해서 주문 대기표를 1초마다 확인
	// 주문이 있을 경우 바리스타에게 작업 이벤트 전달
	// 바리스타가 보낸 특정 고객의 음료 제작 완료 이벤트를 받으면 결과를 출력
	// 여기서 CompletableFuture 사용해야 할듯

	private final ScheduledExecutorService executorService;
	private final Barista barista;

	public Manager() {
		executorService = Executors.newSingleThreadScheduledExecutor();
		barista = new Barista();
	}

	public void startWork() {
		executorService.scheduleAtFixedRate(checkCoffeeOrders(), 1, 1, TimeUnit.SECONDS);
	}

	private Runnable checkCoffeeOrders() {
		return () -> {
			Queue<String> coffeeOrders = Cashier.getCoffeeOrders();
			while (!coffeeOrders.isEmpty()) {
				//todo 바리스타한테 넘겨야 함
				String coffee = coffeeOrders.poll();
				System.out.println("매니저가 바리스타한테 다음 메뉴 만들라고 넘김 " + coffee);
				barista.receiveOrder(coffee);
			}
			System.out.println("매니저가 바리스타한테 메뉴 만들라고 지시");
		};
	}

	public void stopWork() {
		executorService.shutdown();
	}

}
