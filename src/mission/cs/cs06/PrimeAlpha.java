package mission.cs.cs06;

import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;

public class PrimeAlpha {
	private final int number;

	public PrimeAlpha(int number) {
		this.number = number;
	}

	public boolean isPrime() {
		if (number < 1) {
			return false;
		}
		return myCustomFunction.apply(number).size() == 2;
	}

	public boolean isSquared() {
		if (number < 1) {
			return false;
		}
		return myCustomFunction.apply(number).size() % 2 == 1;
	}

	IntFunction<Set<Integer>> myCustomFunction = num -> {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				set.add(i);
				set.add(num / i);
			}
		}
		return set;
	};

	public static void main(String[] args) {

		PrimeAlpha prime1;

		for (int i = 1; i < 30; i++) {
			prime1 = new PrimeAlpha(i);
			System.out.println(i + " : " + prime1.isPrime());
		}

		System.out.println();

		for (int i = 1; i < 30; i++) {
			prime1 = new PrimeAlpha(i);
			System.out.println(i + " : " + prime1.isSquared());
		}

	}
}
