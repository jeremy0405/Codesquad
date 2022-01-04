package mission.cs.cs01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AdderTest {

	Adder adder = new Adder();

	@Test
	@DisplayName("8비트덧셈기테스트")
	void byteadder() {

		boolean[] byteA = {true, true, false, true, true, false, true, false};
		boolean[] byteB = {true, false, true, true, false, false, true, true};

		boolean[] answer = adder.byteadder(byteA, byteB);

		StringBuilder answerToInteger = new StringBuilder();

		for (boolean b : answer) {
			if(b) {
				answerToInteger.append("1");
			} else {
				answerToInteger.append("0");
			}
		}

		Assertions.assertEquals(answerToInteger.toString(), "000101001");
	}

	@Test
	@DisplayName("서로다른비트수덧셈테스트")
	void upgradeByteadder() {

		boolean[] byteA = {true, true, false, true, true, false, true, true}; // 11011011    219
		boolean[] byteB = {true, false, true, true}; // 1101    13

		// 11101000

		boolean[] answer = adder.upgradeByteadder(byteA, byteB);

		StringBuilder answerToInteger = new StringBuilder();

		for (boolean b : answer) {
			if(b) {
				answerToInteger.append("1");
			} else {
				answerToInteger.append("0");
			}
		}

		Assertions.assertEquals(answerToInteger.toString(), "000101110");
	}

}