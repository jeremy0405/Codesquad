package mission.cs.cs06;

import java.util.function.Predicate;

public class SquaredAlpha extends NumberClassifier {

	public SquaredAlpha(int number) {
		super(number);
	}

	private static final Predicate<Integer> isSquared = number -> factor(number).size() % 2 == 1;
	@Override
	public boolean isSquared() {
		return isSquared.test(number);
	}

}
