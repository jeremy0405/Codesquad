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

		print.printArr(byteA);
		print.printArr(byteB);
		print.printArr(answer);

		print.printBin(answer);

	}

}