package mission.cs.cs06;

import java.util.function.Predicate;

public class ClassifierAlpha extends NumberClassifier{

	public ClassifierAlpha(int number) {
		super(number);
	}
	private final Predicate<Integer> isPerfect = n -> n - number == number;

	public boolean isPerfect() {
		return isPerfect.test(myCustomFunction.apply(number).stream().mapToInt(i -> i).sum());
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
			System.out.println(i + " : " + alpha1.isPerfect());
		}
	}
}