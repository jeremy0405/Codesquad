package mission.cs.cs05;

public class HeapArea {

	private final int size;
	private int[] heapMemory;

	public HeapArea(int size) {
		this.size = size;
		heapMemory = new int[size];
	}

	public int getSize() {
		return size;
	}

}
