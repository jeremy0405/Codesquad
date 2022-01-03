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

}
