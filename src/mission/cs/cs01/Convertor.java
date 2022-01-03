package mission.cs.cs01;

public class Convertor {

//	public boolean[] dec2bin(int decimal) {
//
//		boolean[] answer = new boolean[100];
//
//		return answer;
//	}

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
