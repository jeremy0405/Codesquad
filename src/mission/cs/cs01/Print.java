package mission.cs.cs01;

public class Print {

	public void printArr(boolean[] arr) {
		for (Object o : arr) {
			System.out.print(o + " ");
		}
		System.out.println();
	}

	public void printToDec(boolean[] a, boolean[] b, boolean[] ab) {
		Convertor convertor = new Convertor();
		System.out.println(
			convertor.bin2dec(a) + " + " + convertor.bin2dec(b) + " = " + convertor.bin2dec(
				ab));
	}

	public void printBin(boolean[] bin) {
		for (boolean b : bin) {
			if (b) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}
	}

	public void printDecToHex(String dec2hex) {
		System.out.println(dec2hex);
	}

}
