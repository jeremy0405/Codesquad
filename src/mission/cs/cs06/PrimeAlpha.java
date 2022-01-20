package mission.cs.cs06;

import java.util.function.Predicate;

public class PrimeAlpha extends NumberClassifier{

	public PrimeAlpha(int number) {
		super(number);
	}

	private static final Predicate<Integer> isPrime = number -> factor(number).size() == 2;

	public String getString() {
		return isPrime() ? "prime" : "";
	}

	public boolean isPrime() {
		return isPrime.test(number);
	}

}
