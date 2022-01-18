package mission.cs.cs05;

import java.util.Stack;

public class StackArea {

	private final int size;
	private final static int REFERENCE_TYPE_MEMORY = 4;
	private int stackPointer;
	private final Stack<Pointer> stack; //call  malloc
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
		if (typeLength < 8) {
			typeLength = 8;
		}
		int pointer = heapArea.allocateMemory(typeLength * count);

		stack.push(new StackPoint(stackPointer, type, typeStorage.getTypeLength(type), pointer));
	}

	public int getStackPointer() {
		return stackPointer;
	}

	public Stack<Pointer> getStack() {
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
		stackPointer += REFERENCE_TYPE_MEMORY;
		stack.remove(i);
	}

	public void callMethod(String name, int paramCount) {

			stackPointer -= REFERENCE_TYPE_MEMORY * (paramCount + 1);

			stack.push(new CallPointer(stackPointer, name, paramCount));

	}
}
