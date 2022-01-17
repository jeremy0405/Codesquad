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

		Stack<List<String>> stack = stackArea.getStack();
		for (int i = 0; i < stackArea.getStack().size(); i++) {
			if (Integer.parseInt(stack.elementAt(i).get(0)) == pointer) {
				heapArea.freeMemory(Integer.parseInt(stack.elementAt(i).get(3)));
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
		for (List<String> strings : stackArea.getStack()) {
			if (strings.size() != 4) {
				continue;
			}
			headdumpArray[i] = strings.get(2);
			headdumpArray[i + 1] = strings.get(1);
			headdumpArray[i + 2] = strings.get(3);
			i += 3;
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
