package mission.cs.cs01;

public class Convertor {

	public boolean[] dec2bin(int decimal) {

		boolean[] tmp = new boolean[8];
		int i = 0;
		while(decimal != 0) {
			if(decimal % 2 == 0) {
				tmp[i] = false;
			} else {
				tmp[i] = true;
			}
			decimal = decimal / 2;
			i++;
		}
		boolean[] answer = new boolean[i];

		System.arraycopy(tmp, 0, answer, 0, answer.length);

		return answer;
	}

	public int bin2dec(boolean[] bin) {
		int answer = 0;
		int tmp = 1;
		int size = bin.length;
		for (int i = 0; i < size; i++) {
			if(bin[i]) {
				answer += tmp;
			}
			tmp = tmp * 2;
		}
		return answer;
	}

	public String dec2hex(int decimal) {
		boolean[] bin = dec2bin(decimal);
		String answer = "";

		boolean[] tmp;
		for (int i = 0; i < bin.length; i += 4) {
			if(i + 1 == bin.length) {
				tmp = new boolean[]{bin[i], false, false, false};
			} else if (i + 2 == bin.length) {
				tmp = new boolean[]{bin[i], bin[i + 1], false, false};
			} else if (i + 3 == bin.length) {
				tmp = new boolean[]{bin[i], bin[i + 1], bin[i + 2], false};
			} else {
				tmp = new boolean[]{bin[i], bin[i + 1], bin[i + 2], bin[i + 3]};
			}
			switch (bin2dec(tmp)) {
				case 10:
					answer += "A";
					break;
				case 11:
					answer += "B";
					break;
				case 12:
					answer += "C";
					break;
				case 13:
					answer += "D";
					break;
				case 14:
					answer += "E";
					break;
				case 15:
					answer += "F";
					break;
				default: answer += bin2dec(tmp);
			}
		}
		return answer;

	}

}
