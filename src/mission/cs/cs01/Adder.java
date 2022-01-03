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

	public static void main(String[] args) {
		Adder adder = new Adder();
		System.out.println(adder.halfadder(true, true)[0] + " " + adder.halfadder(true, true)[1]);
		System.out.println(adder.halfadder(false, true)[0] + " " + adder.halfadder(false, true)[1]);
		System.out.println(adder.halfadder(false, false)[0] + " " + adder.halfadder(false, false)[1]);

		System.out.println("");
		System.out.println(adder.fulladder(true, true, true)[0] + " " + adder.fulladder(true, true, true)[1]);
		System.out.println(adder.fulladder(true, false, true)[0] + " " + adder.fulladder(true, false, true)[1]);
		System.out.println(adder.fulladder(false, false, true)[0] + " " + adder.fulladder(false, false, true)[1]);

//		true false
//		false true
//		false false
//
//		true true
//		ture false
//		false true

	}

}
