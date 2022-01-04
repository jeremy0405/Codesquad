package mission.cs.cs01;

public class Adder {

	static final int CARRY = 0;
	static final int SUM = 1;

	Function function = new Function();

	private boolean[] halfadder(boolean bitA, boolean bitB) {
		boolean[] answer = new boolean[2];

		boolean carry = function.and(bitA, bitB);
		boolean sum = function.xor(bitA, bitB);

		answer[CARRY] = carry;
		answer[SUM] = sum;

		return answer;
	}

	private boolean[] fulladder(boolean bitA, boolean bitB, boolean inputCarry) {
		boolean[] answer = new boolean[2];

		boolean tmpCarry = halfadder(bitA, bitB)[CARRY];
		boolean tmpSum = halfadder(bitA, bitB)[SUM];

		boolean carry = function.or(halfadder(tmpSum, inputCarry)[CARRY], tmpCarry);
		boolean sum = halfadder(tmpSum, inputCarry)[SUM];

		answer[CARRY] = carry;
		answer[SUM] = sum;

		return answer;
	}

	public boolean[] byteadder(boolean[] byteA, boolean[] byteB) {
		boolean[] answer = new boolean[9];

		boolean carry = false;

		for (int i = 0; i < byteA.length; i++) {
			boolean[] tmp = fulladder(byteA[i], byteB[i], carry);
			answer[i] = tmp[SUM];
			carry = tmp[CARRY];
		}
		answer[8] = carry;

		return answer;
	}

	public boolean[] upgradeByteadder(boolean[] byteA, boolean[] byteB) {

		int maxSize = Math.max(byteA.length, byteB.length);
		boolean[] answer = new boolean[maxSize + 1];

		if (maxSize == byteA.length) {
			byteB = setSameArraySize(byteB, maxSize);
		} else {
			byteA = setSameArraySize(byteA, maxSize);
		}

		boolean carry = false;

		for (int i = 0; i < byteA.length; i++) {
			boolean[] tmp = fulladder(byteA[i], byteB[i], carry);
			answer[i] = tmp[SUM];
			carry = tmp[CARRY];
		}
		answer[maxSize] = carry;

		return answer;
	}

	private boolean[] setSameArraySize(boolean[] byteB, int maxSize) {
		boolean[] tmp = new boolean[maxSize];
		System.arraycopy(byteB, 0, tmp, 0, byteB.length);
		byteB = tmp;
		return byteB;
	}

}
