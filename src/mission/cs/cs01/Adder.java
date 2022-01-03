package mission.cs.cs01;

public class Adder {

	Function function = new Function();

	public boolean[] halfadder(boolean bitA, boolean bitB) {
		boolean[] answer = new boolean[2];

		boolean carry = function.and(bitA, bitB);
		boolean sum = function.xor(bitA, bitB);

		answer[0] = carry;
		answer[1] = sum;

		return answer;
	}

	public boolean[] fulladder(boolean bitA, boolean bitB, boolean inputCarry) {
		boolean[] answer = new boolean[2];

		boolean sum = halfadder(halfadder(bitA, bitB)[1], inputCarry)[1];
		boolean carry = function.or(halfadder(halfadder(bitA, bitB)[1], inputCarry)[0],
			halfadder(bitA, bitB)[0]);

		answer[0] = carry;
		answer[1] = sum;

		return answer;
	}

	public boolean[] byteadder(boolean[] byteA, boolean[] byteB) {
		boolean[] answer = new boolean[9];

		boolean carry = false;

		for (int i = 0; i < byteA.length; i++) {
			boolean[] tmp = fulladder(byteA[i], byteB[i], carry);
			answer[i] = tmp[1];
			carry = tmp[0];
		}
		answer[8] = carry;

		return answer;
	}

	public boolean[] upgradeByteadder(boolean[] byteA, boolean[] byteB) {

		int maxSize = Math.max(byteA.length, byteB.length);
		boolean[] answer = new boolean[maxSize + 1];

		if(maxSize == byteA.length) {
			boolean[] tmp = new boolean[maxSize];
			System.arraycopy(byteB, 0, tmp, 0, byteB.length);
			byteB = tmp;
		} else {
			boolean[] tmp = new boolean[maxSize];
			System.arraycopy(byteA, 0, tmp, 0, byteA.length);
			byteA = tmp;
		}

		boolean carry = false;

		for (int i = 0; i < byteA.length; i++) {
			boolean[] tmp = fulladder(byteA[i], byteB[i], carry);
			answer[i] = tmp[1];
			carry = tmp[0];
		}
		answer[maxSize] = carry;

		return answer;
	}

}
