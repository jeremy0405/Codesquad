package mission.cs.cs06;

import java.util.function.BiPredicate;

public class ClassifierAlpha extends NumberClassifier{

	public ClassifierAlpha(int number) {
		super(number);
	}
	private static final BiPredicate<Integer, Integer> isPerfect = (sum, number) -> sum - number == number;

	private static final BiPredicate<Integer, Integer> isAbundant = (sum, number) -> sum - number > number;

	private static final BiPredicate<Integer, Integer> isDeficient = (sum, number) -> sum - number < number;

	public boolean isPerfect() {
		return isPerfect.test(factor(number).stream().mapToInt(i -> i).sum(), number);
	}

	public boolean isAbundant() {
		return isAbundant.test(factor(number).stream().mapToInt(i -> i).sum(), number);
	}

	public boolean isDeficient() {
		return isDeficient.test(factor(number).stream().mapToInt(i -> i).sum(), number);
	}

	public static void main(String[] args) {

		ClassifierAlpha alpha1;

		for (int i = 1; i <= 28; i++) {
			alpha1 = new ClassifierAlpha(i);
			System.out.println(i + " : " + alpha1.isPerfect());
		}
	}
}