package mission.cs.cs01;

public class Main {

	public static void main(String[] args) {
		Adder adder = new Adder();
		Convertor convertor = new Convertor();
		Print print = new Print();

		boolean[] byteA = convertor.dec2bin(24);
		boolean[] byteB = convertor.dec2bin(40);
		boolean[] answer = adder.upgradeByteadder(byteA, byteB);

		print.printToDec(byteA, byteB, answer);

		print.printBin(byteA);
		print.printBin(byteB);
		print.printBin(answer);

		print.printArr(byteA);
		print.printArr(byteB);
		print.printArr(answer);

		print.printDecToHex(convertor.dec2hex(31));

		//console 출력
		//24 + 40 = 64
		//00011
		//000101
		//0000001
		//false false false true true
		//false false false true false true
		//false false false false false false true
		//F1

	}

}
