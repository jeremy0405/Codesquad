package mission.cs.cs06;

import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;

public class NumberClassifier {

	protected int number;

	public NumberClassifier(int number) {
		this.number = number;
	}

	protected final IntFunction<Set<Integer>> myCustomFunction = num -> {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				set.add(i);
				set.add(num / i);
			}
		}
		return set;
	};

}
