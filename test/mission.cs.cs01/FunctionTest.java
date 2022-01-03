package mission.cs.cs01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FunctionTest {

	Function function = new Function();

	@Test
	@DisplayName("AND테스트")
	void andTest() {
		Assertions.assertEquals(function.and(true, true), true);
		Assertions.assertEquals(function.and(true, false), false);
		Assertions.assertEquals(function.and(false, true), false);
		Assertions.assertEquals(function.and(false, false), false);
	}

	@Test
	@DisplayName("OR테스트")
	void orTest() {
		Assertions.assertEquals(function.or(true, true), true);
		Assertions.assertEquals(function.or(true, false), true);
		Assertions.assertEquals(function.or(false, true), true);
		Assertions.assertEquals(function.or(false, false), false);
	}

	@Test
	@DisplayName("NAND테스트")
	void nandTest() {
		Assertions.assertEquals(function.nand(true, true), false);
		Assertions.assertEquals(function.nand(true, false), true);
		Assertions.assertEquals(function.nand(false, true), true);
		Assertions.assertEquals(function.nand(false, false), true);
	}

	@Test
	@DisplayName("XOR테스트")
	void xorTest() {
		Assertions.assertEquals(function.xor(true, true), false);
		Assertions.assertEquals(function.xor(true, false), true);
		Assertions.assertEquals(function.xor(false, true), true);
		Assertions.assertEquals(function.xor(false, false), false);
	}
}