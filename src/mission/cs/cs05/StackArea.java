package mission.cs.cs05;

import java.util.Stack;

public class StackArea {

	private final int size;
	private int stackPointer;
	private final Stack<TypeStorage> stack;
	private final TypeStorage typeStorage;
	private HeapArea heapArea;

	public StackArea(int stackSize, HeapArea heapArea, TypeStorage typeStorage) {
		this.size = stackSize;
		this.stackPointer = size;
		this.typeStorage = typeStorage;
		this.stack = new Stack<>();
		this.heapArea = heapArea;
	}

	public int getStackPointer() {
		return stackPointer;
	}

	public int getSize() {
		return size;
	}

}
