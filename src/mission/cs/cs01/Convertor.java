package mission.cs.cs01;

public class Convertor {

	public int bin2dec(boolean[] bin) {
		int answer = 0;
		int size = bin.length;
		for (int i = 0; i < size; i++) {
			if(bin[i]) {
				answer += Math.pow(2, i);
			}
		}
		return answer;
	}

}
