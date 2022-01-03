package mission.cs.cs01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertorTest {

	Convertor convertor = new Convertor();

	@Test
	@DisplayName("dec2bin테스트")
	void dec2binTest() {
		boolean[] answer = {false, true, false, true};
		Assertions.assertEquals(Arrays.equals(convertor.dec2bin(10), answer), true);
	}

	@Test
	@DisplayName("bin2dec테스트")
	void bin2decTest() {
		boolean[] test = {true, true, true, false, true};
		Assertions.assertEquals(convertor.bin2dec(test), 23);
	}
}