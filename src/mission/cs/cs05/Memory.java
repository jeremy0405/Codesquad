package mission.cs.cs05;

import java.util.Iterator;
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
//		return stackArea.getStack().peek().get(2); // 힙영역 주소
		return stackArea.getStackPointer(); // 스택영역 주소
	}

	public void free(int pointer) {
		for (List<String> a : stackArea.getStack()) {
			if (Integer.parseInt(a.get(0)) == pointer) {
				heapArea.freeMemory(Integer.parseInt(a.get(3)));
			}
		}
	}

	public List<Object> usage() {
		return List.of(stackArea, heapArea);
	}

	public String[] heapdump() {

		int totalVariable = stackArea.getStack().size();
		String[] headdump = new String[totalVariable];
		int i = 0;
		for (List<String> strings : stackArea.getStack()) {
			headdump[i] = strings.get(2);
			headdump[i + 1] = strings.get(1);
			headdump[i + 2] = strings.get(3);
			i += 3;
		}
		return headdump;
	}

	public StackArea getStackArea() {
		return stackArea;
	}

}
