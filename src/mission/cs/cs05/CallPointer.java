package mission.cs.cs05;

public class CallPointer implements Pointer {

	private final int stackPointer;
	private final String name;
	private final int paramCount;

	public CallPointer(int stackPointer, String name, int paramCount) {
		this.stackPointer = stackPointer;
		this.name = name;
		this.paramCount = paramCount;
	}

	@Override
	public int getStackPointer() {
		return this.stackPointer;
	}

	public String getName() {
		return name;
	}

	public int getParamCount() {
		return paramCount;
	}
}
