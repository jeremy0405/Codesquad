package mission.cs.cs08;

import java.util.LinkedList;
import java.util.Queue;

public class Cashier {

	private static final Queue<String> coffeeOrders = new LinkedList<>();
	private static Cashier cashier;

	private Cashier() {}

	public static Cashier getInstance() {
		if (Cashier.cashier == null) {
			Cashier.cashier = new Cashier();
		}
		return Cashier.cashier;
	}

	//todo
	// 주문 대기표도 이벤트를 받아서 처리하는 별도 객체로 분리해서 구현 -> 어케함? 그냥 안할래 (못함)

	public void getOrder(String coffee, int number) {
		for (int i = 0; i < number; i++) {
			coffeeOrders.add(coffee);
		}
	}

	public static Queue<String> getCoffeeOrders() {
		return coffeeOrders;
	}

}
