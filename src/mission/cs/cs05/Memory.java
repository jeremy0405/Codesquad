package mission.cs.cs05;

import java.util.List;
import java.util.Stack;

public class Memory {

	private StackArea stackArea;
	private HeapArea heapArea;
	private int totalMemory;
	private TypeStorage typeStorage;

	private static final int INIT_HEAP_ADDRESS = 0;

	public Memory() {
		typeStorage = new TypeStorage();
	}

	public int init(int stackSize, int heapSize) {
		heapArea = new HeapArea(heapSize);
		stackArea = new StackArea(stackSize, heapArea, typeStorage);
		totalMemory = INIT_HEAP_ADDRESS + stackSize + heapSize;
		return totalMemory;
	}

	public void setSize(String type, int length) {

		this.typeStorage.putType(type, length);

	}

	public int malloc(String type, int count) {
		stackArea.pushStack(type, count);
		return stackArea.getStackPointer();
	}

	public void free(int pointer) {

		Stack<Pointer> stack = stackArea.getStack();
		for (int i = 0; i < stackArea.getStack().size(); i++) {
			if (stack.elementAt(i).getStackPointer() == pointer) {
				StackPoint tmp = (StackPoint) stack.elementAt(i);
				heapArea.freeMemory(tmp.getHeapPointer());
				stackArea.removeStack(i);
			}
		}
	}

	public List<Object> usage() {
		return List.of(stackArea, heapArea);
	}

	public String[] heapdump() {

		int totalVariable = stackArea.getStack().size() * 3;
		String[] headdumpArray = new String[totalVariable];
		int i = 0;
		for (Pointer strings : stackArea.getStack()) {

			if (strings instanceof CallPointer) {
				continue;
			} else {
				StackPoint tmp = (StackPoint) strings;
				headdumpArray[i] = tmp.getType();
				headdumpArray[i + 1] = String.valueOf(tmp.getLength());
				headdumpArray[i + 2] = String.valueOf(tmp.getHeapPointer());
				i += 3;
			}
		}
		return headdumpArray;
	}

	public void call(String name, int paramCount) {
		stackArea.callMethod(name, paramCount);
	}

	public StackArea getStackArea() {
		return stackArea;
	}

}
