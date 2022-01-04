package mission.cs.cs01;

public class Print {

	public void printArr(boolean[] arr) {
		for (boolean b : arr) {
			System.out.print(b + " ");
		}
		System.out.println();
	}

	public void printToDec(boolean[] a, boolean[] b, boolean[] ab) {
		Convertor convertor = new Convertor();
		String description = convertor.bin2dec(a) + " + " + convertor.bin2dec(b) + " = " + convertor.bin2dec(ab);
		System.out.println(description);
	}

	public void printBin(boolean[] bin) {
		for (boolean b : bin) {
			if (b) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}
		System.out.println();
	}

	public void printDecToHex(String dec2hex) {
		System.out.println(dec2hex);
	}

}
