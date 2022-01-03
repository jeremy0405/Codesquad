package mission.cs.cs01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AdderTest {

	Adder adder = new Adder();

	@Test
	@DisplayName("반쪽덧셈테스트")
	void halfadder() {

		Assertions.assertEquals(adder.halfadder(true, true)[0], true);
		Assertions.assertEquals(adder.halfadder(true, true)[1], false);

		Assertions.assertEquals(adder.halfadder(false, true)[0], false);
		Assertions.assertEquals(adder.halfadder(false, true)[1], true);

		Assertions.assertEquals(adder.halfadder(false, false)[0], false);
		Assertions.assertEquals(adder.halfadder(false, false)[1], false);

	}

	@Test
	@DisplayName("전체덧셈테스트")
	void fulladder() {

		Assertions.assertEquals(adder.fulladder(true, true, true)[0], true);
		Assertions.assertEquals(adder.fulladder(true, true, true)[1], true);

		Assertions.assertEquals(adder.fulladder(true, false, true)[0], true);
		Assertions.assertEquals(adder.fulladder(true, false, true)[1], false);

		Assertions.assertEquals(adder.fulladder(false, false, true)[0], false);
		Assertions.assertEquals(adder.fulladder(false, false, true)[1], true);

	}
}