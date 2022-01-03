package mission.cs.cs01;

public class Main {

	public static void main(String[] args) {
		Adder adder = new Adder();
		Convertor convertor = new Convertor();

		boolean[] byteA = convertor.dec2bin(24);
		boolean[] byteB = convertor.dec2bin(40);
		boolean[] answer = adder.upgradeByteadder(byteA, byteB);

		for (int i = 0; i < byteA.length; i++) {
			System.out.print(byteA[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < byteB.length; i++) {
			System.out.print(byteB[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println();

		System.out.println(
			convertor.bin2dec(byteA) + " + " + convertor.bin2dec(byteB) + " = " + convertor.bin2dec(
				answer));

		for (boolean b : answer) {
			if (b) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}

	}

}