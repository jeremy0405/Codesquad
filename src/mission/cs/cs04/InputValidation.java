package mission.cs.cs04;

import java.util.List;

public class InputValidation {

	public List<Point> validateInput(List<Point> points) throws Exception {

		checkInputPair(points);
		checkInputRange(points);

		return points;
	}

	private void checkInputRange(List<Point> points) throws Exception {
		for (Point point : points) {
			if (point.getX() < 0 || point.getX() >= 25 || point.getY() < 0 || point.getY() >= 25) {
				throw new Exception("유효하지 않은 값 범위입니다.");
			}
		}
	}

	private void checkInputPair(List<Point> points) throws Exception {
		if (points.size() <= 1) {
			throw new Exception("입력값은 2쌍 이상이여야 합니다.");
		}
	}

}
