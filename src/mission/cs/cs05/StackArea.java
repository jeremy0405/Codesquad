package mission.cs.cs05;

import java.util.List;
import java.util.Stack;

public class StackArea {

	private final int size;
	private final static int REFERENCE_TYPE_MEMORY = 4;
	private int stackPointer;
	private final Stack<List<String>> stack;
	private final TypeStorage typeStorage;
	private HeapArea heapArea;

	public StackArea(int stackSize, HeapArea heapArea, TypeStorage typeStorage) {
		this.size = stackSize;
		this.stackPointer = heapArea.getSize() + size;
		this.typeStorage = typeStorage;
		this.stack = new Stack<>();
		this.heapArea = heapArea;
	}

	public void pushStack(String type, int count) {
		int typeLength = typeStorage.getTypeLength(type);
		stackPointer -= REFERENCE_TYPE_MEMORY;
//		stackPointer -= typeLength;
		if (typeLength < 8) {
			typeLength = 8;
		}
		int pointer = heapArea.allocateMemory(typeLength * count);

		// todo 0 : stackpointer     1 : type    2 : length    3 : heapPointer
		// todo 0 : stackpointer     1 : name    2 : paramCount
		stack.push(List.of(String.valueOf(stackPointer), type, String.valueOf(typeStorage.getTypeLength(type)), String.valueOf(pointer)));
	}

	public int getStackPointer() {
		return stackPointer;
	}

	public Stack<List<String>> getStack() {
		return stack;
	}

	@Override
	public String toString() {
		return "StackArea{" +
			"스택 영역 전체 크기 = " + size +
			", 사용중인 용량 = " + (size - stackPointer + heapArea.getSize()) +
			", 남은 용량 = " + (stackPointer - heapArea.getSize()) +
			'}';
	}



	public void removeStack(int i) {
//		stackPointer += Integer.parseInt(stack.elementAt(i).get(2));
		stackPointer += REFERENCE_TYPE_MEMORY;
		stack.remove(i);
	}

	public void callMethod(String name, int paramCount) {

			stackPointer -= REFERENCE_TYPE_MEMORY * paramCount;

			// todo 0 : stackpointer     1 : type    2 : length    3 : heapPointer
			// todo 0 : stackpointer     1 : name    2 : paramCount
			stack.push(List.of(String.valueOf(stackPointer), name, String.valueOf(REFERENCE_TYPE_MEMORY * paramCount)));

	}
}
