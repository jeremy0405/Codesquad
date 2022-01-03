package mission.cs.cs01;

public class Function {

	public boolean and(boolean a, boolean b) {
		return a && b;
	}

	public boolean or(boolean a, boolean b) {
		return a || b;
	}

	public boolean nand(boolean a, boolean b) {
		return !and(a, b);
	}

	public boolean xor(boolean a, boolean b) {
		return a != b;
	}

}
