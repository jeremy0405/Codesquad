package mission.cs.cs06;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public abstract class NumberClassifier {

	protected final int number;

	public NumberClassifier(int number) {
		this.number = number;
	}

	protected static HashSet<Integer> factor(int number) {
		return IntStream.rangeClosed(1, (int) Math.sqrt(number))
			.filter(i -> number % i == 0)
			.mapToObj(i -> List.of(i, number / i))
			.collect(HashSet::new, HashSet::addAll, HashSet::addAll);
	}

	abstract String getString();

}
