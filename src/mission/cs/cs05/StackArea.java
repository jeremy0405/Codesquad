package mission.cs.cs05;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StackArea {

	private final int size;
	private int stackPointer;
	private final Stack<List<String>> stack;
	private final TypeStorage typeStorage;
	private HeapArea heapArea;

	public StackArea(int stackSize, HeapArea heapArea, TypeStorage typeStorage) {
		this.size = stackSize;
		this.stackPointer = size;
		this.typeStorage = typeStorage;
		this.stack = new Stack<>();
		this.heapArea = heapArea;
	}

	public void pushStack(String type, int count) {
		int abc = typeStorage.getTypeLength(type);
		stackPointer -= abc;
		int pointer = heapArea.allocateMemory(this.typeStorage.getTypeLength(type) * count);
		stack.push(List.of(type, String.valueOf(abc), String.valueOf(pointer)));
	}

	public int getStackPointer() {
		return stackPointer;
	}

	public int getSize() {
		return size;
	}

}
