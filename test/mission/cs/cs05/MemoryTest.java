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
		memory.setSize("jerry", 32);

		int arrayInt = memory.malloc("int", 10);
		System.out.print("stack 주소 값 : ");
		System.out.println(arrayInt);
		System.out.print("stack 상대주소 값 : ");
		System.out.println(stackMemoryAddress - arrayInt);
		System.out.print("heap 주소 값 : ");
		System.out.println(memory.getStackArea().getStack().peek().get(3));


		int arrayJerry = memory.malloc("jerry", 5);
		System.out.print("stack 주소 값 : ");
		System.out.println(arrayJerry);
		System.out.print("stack 상대주소 값 : ");
		System.out.println(stackMemoryAddress - arrayJerry);
		System.out.print("heap 주소 값 : ");
		System.out.println(memory.getStackArea().getStack().peek().get(3));


		memory.free(arrayInt);
		memory.free(arrayJerry);


	}

}