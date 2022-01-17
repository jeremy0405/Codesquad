package mission.cs.cs05;

import java.util.HashMap;
import java.util.Map;

public class Memory {

	private StackArea stackArea;
	private HeapArea heapArea;
	private int totalMemory;
	private Map<String, Integer> typeStorage;

	private static final int INIT_HEAP_ADDRESS = 0;

	public Memory() {
		typeStorage = new HashMap<>();
	}

	public String init(int stackSize, int heapSize) {
		heapArea = new HeapArea(heapSize);
		stackArea = new StackArea(stackSize, heapArea);
		totalMemory = INIT_HEAP_ADDRESS + stackSize + heapSize;
		return Integer.toHexString(totalMemory);
	}

	public void setSize(String type, int length) {


		this.typeStorage.put(type, length);

		//todo type을 저장, 사이즈도 저장
		// 한번 저장한 type은 다시 사이즈 변경 불가능
		// 사이즈는 1, 2, 4, 8, 16, 32 byte만 가능

	}

	public String malloc(String type, int count) {
		//todo 등록된 type인지 확인
		// 등록된 type이면 length 8 이상인지 확인
		// 8 미만이면 패딩 추가
		// count만큼 반복해서 heap영역에 추가
		// 0번째 index의 힙 주소를 가지고 있어야 되고
		// malloc의

		return "";
	}



}
