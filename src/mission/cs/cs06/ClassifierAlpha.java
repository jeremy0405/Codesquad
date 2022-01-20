package mission.cs.cs06;

import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;

public class ClassifierAlpha {

	private final int number;

	public ClassifierAlpha(int number) {
		this.number = number;
	}

	IntFunction<Set<Integer>> myCustomFunction = num -> {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i < Math.sqrt(num); i++) {
			if (num % i == 0) {
				set.add(i);
				set.add(num / i);
			}
		}
		return set;
	};

	public boolean isPerfect() {
		return myCustomFunction.apply(number).stream().mapToInt(i -> i).sum() - number == number;
	}

	public boolean isAbundant() {
		return myCustomFunction.apply(number).stream().mapToInt(i -> i).sum() - number > number;
	}

	public boolean isDeficient() {
		return myCustomFunction.apply(number).stream().mapToInt(i -> i).sum() - number < number;
	}

	public static void main(String[] args) {

		ClassifierAlpha alpha1;

		for (int i = 1; i <= 28; i++) {
			alpha1 = new ClassifierAlpha(i);
			System.out.println(alpha1.isPerfect());
		}
	}
}