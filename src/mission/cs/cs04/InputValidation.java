package mission.cs.cs04;

import java.util.List;

public class InputValidation {

	public List<Point> validateInput(List<Point> points) throws Exception {
		for (Point point : points) {
			if (point.getX() < 0 || point.getX() >= 25 || point.getY() < 0 || point.getY() >= 25) {
				throw new Exception("유효하지 않은 값 범위입니다.");
			}
		}
		return points;
	}

}
