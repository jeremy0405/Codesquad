package mission.cs.cs06;

public class PrimeAlpha extends NumberClassifier{

	public PrimeAlpha(int number) {
		super(number);
	}

	public boolean isPrime() {
		if (number < 1) {
			return false;
		}
		return myCustomFunction.apply(number).size() == 2;
	}

	public static void main(String[] args) {

		PrimeAlpha prime1;

		for (int i = 1; i < 30; i++) {
			prime1 = new PrimeAlpha(i);
			System.out.println(i + " : " + prime1.isPrime());
		}

	}
}
