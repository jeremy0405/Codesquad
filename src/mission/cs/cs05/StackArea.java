package mission.cs.cs05;

public class StackArea {

	private int size;
	private HeapArea heapArea;

	public StackArea(int stackSize, HeapArea heapArea) {
		this.size = stackSize;
		this.heapArea = heapArea;
	}

	public int getSize() {
		return size;
	}

}
