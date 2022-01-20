package mission.cs.cs05;

import java.util.HashMap;
import java.util.Map;

public class TypeStorage {

	private final Map<String, Integer> typeMap;

	public TypeStorage() {
		typeMap = new HashMap<>();
	}

	public void putType(String type, int length) {

		if (this.typeMap.containsKey(type)) {
			throw new IllegalArgumentException("이미 정의된 type입니다.");
		}
		validateLength(length);

		this.typeMap.put(type, length);

	}

	private void validateLength(int length) {
		if (length == 1 || length == 2 || length == 4 ||
			length == 8 || length == 16 || length == 32) {
			return;
		}
		throw new IllegalArgumentException("잘못된 length값을 입력했습니다.");
	}

	public int getTypeLength(String type) {
		for (String s : typeMap.keySet()) {
			if (s.equals(type)) {
				return typeMap.get(type);
			}
		}
		throw new IllegalArgumentException("정의되지 않은 type입니다.");
	}

}
