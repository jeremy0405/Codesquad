package mission.cs.cs06;

public class SquaredAlpha extends NumberClassifier {

	public SquaredAlpha(int number) {
		super(number);
	}

	public boolean isSquared() {
		if (number < 1) {
			return false;
		}
		return myCustomFunction.apply(number).size() % 2 == 1;
	}

	public static void main(String[] args) {

		SquaredAlpha squaredAlpha;

		for (int i = 1; i < 101; i++) {
			squaredAlpha = new SquaredAlpha(i);
			System.out.println(i + " : " + squaredAlpha.isSquared());
		}

	}

}
