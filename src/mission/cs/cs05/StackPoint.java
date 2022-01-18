package mission.cs.cs05;

public class StackPoint implements Pointer{

	private final int stackPointer;
	private final String type;
	private final int length;
	private final int heapPointer;


	public StackPoint(int stackPointer, String type, int length, int heapPointer) {
		this.stackPointer = stackPointer;
		this.type = type;
		this.length = length;
		this.heapPointer = heapPointer;
	}

	@Override
	public int getStackPointer() {
		return this.stackPointer;
	}

	public String getType() {
		return type;
	}

	public int getLength() {
		return length;
	}

	public int getHeapPointer() {
		return heapPointer;
	}
}
