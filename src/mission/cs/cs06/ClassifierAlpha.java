package mission.cs.cs06;

import java.util.function.BiPredicate;

public class ClassifierAlpha extends NumberClassifier{

	public ClassifierAlpha(int number) {
		super(number);
	}

	private static final BiPredicate<Integer, Integer> isPerfect = (sum, number) -> sum - number == number;

	private static final BiPredicate<Integer, Integer> isAbundant = (sum, number) -> sum - number > number;

	private static final BiPredicate<Integer, Integer> isDeficient = (sum, number) -> sum - number < number;

	@Override
	public boolean isPerfect() {
		return isPerfect.test(factor(number).stream().mapToInt(i -> i).sum(), number);
	}
	@Override
	public boolean isAbundant() {
		return isAbundant.test(factor(number).stream().mapToInt(i -> i).sum(), number);
	}
	@Override
	public boolean isDeficient() {
		return isDeficient.test(factor(number).stream().mapToInt(i -> i).sum(), number);
	}

}