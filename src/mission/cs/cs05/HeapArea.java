package mission.cs.cs05;

import java.util.Random;

public class HeapArea {

	private final int size;
	private final int[] heapMemory;
	private final Random random;
	private int remainMemory;

	public HeapArea(int size) {
		this.size = size;
		this.remainMemory = size;
		heapMemory = new int[size];
		random = new Random();
	}

	public int allocateMemory(int memorySize) {
		int randomAddress = random.nextInt(size);

		if (randomAddress + memorySize + 1 >= size) {
			allocateMemory(memorySize);
		}

		for (int i = randomAddress; i < randomAddress + memorySize + 1; i++) {
			if (heapMemory[i] == 1) {
				allocateMemory(memorySize);
			}
		}

		for (int i = randomAddress; i < randomAddress + memorySize; i++) {
			heapMemory[i] = 1;
		}

		heapMemory[randomAddress + memorySize] = 127;

		remainMemory -= memorySize;
		return randomAddress;
	}

	public void freeMemory(int pointer) {
		int i = 0;
		while (heapMemory[pointer + i] != 127) {
			heapMemory[pointer + i++] = 0;
		}
		heapMemory[pointer + i] = 0;
		remainMemory += i;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "HeapArea{" +
			"스택 영역 전체 크기 = " + size +
			", 사용중인 용량 = " + (size - remainMemory) +
			", 남은 용량 = " + remainMemory +
			'}';
	}
}
