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
		boolean carry = function.or(halfadder(halfadder(bitA, bitB)[1], inputCarry)[0], halfadder(bitA, bitB)[0]);

		answer[0] = carry;
		answer[1] = sum;

		return answer;
	}

}
