package mission.cs.cs08;

public class Cafe {

	public static void main(String[] args) {
		Manager manager = new Manager();
		Customer customer = new Customer();

		manager.startWork();

		customer.order("아메리카노");

		customer.order("카페라떼", 3);

		sleep(2000);

		customer.order("프라프치노");

		customer.order("아메리카노", 3);

		sleep(5000);

		manager.stopWork();

	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
