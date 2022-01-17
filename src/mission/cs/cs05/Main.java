package mission.cs.cs05;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Memory memory = new Memory();
		int stackMemoryAddress = memory.init(10000, 10000);
		memory.setSize("int", 4);
		memory.setSize("mouse", 32);
		memory.setSize("cat", 8);


		int arrayInt = memory.malloc("int", 2);
		System.out.print("stack 주소 값 : ");
		System.out.println(arrayInt);
		System.out.print("stack 상대주소 값 : ");
		System.out.println(stackMemoryAddress - arrayInt);
		System.out.print("heap 주소 값 : ");
		System.out.println(memory.getStackArea().getStack().peek().get(3));
		System.out.println("");


		int arrayMouse = memory.malloc("mouse", 3);
		System.out.print("stack 주소 값 : ");
		System.out.println(arrayMouse);
		System.out.print("stack 상대주소 값 : ");
		System.out.println(stackMemoryAddress - arrayMouse);
		System.out.print("heap 주소 값 : ");
		System.out.println(memory.getStackArea().getStack().peek().get(3));
		System.out.println("");


		int arrayCat = memory.malloc("cat", 2);
		System.out.print("stack 주소 값 : ");
		System.out.println(arrayCat);
		System.out.print("stack 상대주소 값 : ");
		System.out.println(stackMemoryAddress - arrayCat);
		System.out.print("heap 주소 값 : ");
		System.out.println(memory.getStackArea().getStack().peek().get(3));
		System.out.println("");

		List<Object> abc = memory.usage();

		Print.print((StackArea) abc.get(0), (HeapArea) abc.get(1));

		memory.free(arrayInt);
//		memory.free(arrayMouse);
		memory.free(arrayCat);

		abc = memory.usage();

		Print.print((StackArea) abc.get(0), (HeapArea) abc.get(1));

	}

}
