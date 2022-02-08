package mission.cs.cs08;

public class Cafe {

	public static void main(String[] args) {
		Manager manager = new Manager();
		Customer customer = new Customer();

		manager.startWork();

		sleep(1000);

		customer.order("아메리카노");

//		sleep(1000);

		customer.order("카페라떼", 3);

//		sleep(1000);

		customer.order("프라프치노");

//		sleep(1000);

		customer.order("아메리카노", 3);

		sleep(25000);

		manager.stopWork();

		System.out.println("메인문 종료");
		System.exit(1);

	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
