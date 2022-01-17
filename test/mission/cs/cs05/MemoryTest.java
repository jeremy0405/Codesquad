package mission.cs.cs05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemoryTest {

	@Test
	@DisplayName("나중에 정하자.. 뭔테스트냐 이게")
	void test() {
		Memory memory = new Memory();

		int stackMemoryAddress = memory.init(10000, 10000);

		System.out.println(stackMemoryAddress);

		memory.setSize("int", 4);


	}

}