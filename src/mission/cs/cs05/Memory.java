package mission.cs.cs05;

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

	public String malloc(String type, int count) {
		stackArea.pushStack(type, count);

		return "";
	}



}
