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
		//todo 등록된 type인지 확인
		// 등록된 type이면 length 8 이상인지 확인
		// 8 미만이면 패딩 추가
		// count만큼 반복해서 heap영역에 추가
		// 0번째 index의 힙 주소를 가지고 있어야 되고
		// malloc의

		return "";
	}



}
