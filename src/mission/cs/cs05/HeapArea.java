package mission.cs.cs05;

import java.util.Random;

public class HeapArea {

	private final int size;
	private int[] heapMemory;
	private Random random;

	public HeapArea(int size) {
		this.size = size;
		heapMemory = new int[size];
		random = new Random();
	}

	public int allocateMemory(int memorySize) {
		int randomAddress = random.nextInt(size);

		for (int i = randomAddress; i < randomAddress + memorySize; i++) {
			if (heapMemory[i] == 1) {
				allocateMemory(memorySize);
			}
		}

		for (int i = randomAddress; i < randomAddress + memorySize; i++) {
			heapMemory[i] = 1;
		}

		return randomAddress;
	}

	public int getSize() {
		return size;
	}

}
