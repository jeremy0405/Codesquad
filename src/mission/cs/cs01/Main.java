package mission.cs.cs01;

public class Main {

	public static void main(String[] args) {
		Adder adder = new Adder();

		boolean[] byteA = {true, true, false, true, true, false, true, false};
		boolean[] byteB = {true, false, true, true, false, false, true, true};

		boolean[] answer = adder.byteadder(byteA, byteB);
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}

		System.out.println();

		for (boolean b : answer) {
			if(b) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}

	}

}
