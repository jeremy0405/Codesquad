package mission.cs.cs08;

public class Customer {

	private final Cashier cashier;

	public Customer() {
		this.cashier = Cashier.getInstance();
	}

	public void order(String coffee, int number) {
		cashier.getOrder(coffee, number);
	}

	public void order(String coffee) {
		cashier.getOrder(coffee, 1);
	}

}
