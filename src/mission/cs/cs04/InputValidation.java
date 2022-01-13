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
		if (points.size() == 4) {
			checkRect(points);
		}
	}

	private void checkRect(List<Point> points) throws Exception {
		Point point1 = points.get(0);
		Point point2 = points.get(1);
		Point point3 = points.get(2);
		Point point4 = points.get(3);

		checkParallel(point1, point2, point3, point4);
		checkParallel(point1, point4, point2, point3);
		checkAngle(point1, point2, point3, point4);
	}

	private void checkAngle(Point pointA, Point pointB, Point pointC, Point pointD)
		throws Exception {
		Point vector1 = new Point(pointA.getX() - pointB.getX(), pointA.getY() - pointB.getY());
		Point vector2 = new Point(pointA.getX() - pointD.getX(), pointA.getY() - pointD.getY());

		if (vector1.getX() * vector2.getX() + vector1.getY() * vector2.getY() != 0) {
			throw new Exception("평행사변형입니다. 직사각형을 입력해 주세요.");
		}

	}

	private void checkParallel(Point pointA, Point pointB, Point pointC, Point pointD)
		throws Exception {
		Point vector1 = new Point(pointA.getX() - pointB.getX(), pointA.getY() - pointB.getY());
		Point vector2 = new Point(pointC.getX() - pointD.getX(), pointC.getY() - pointD.getY());

		if (!(Math.abs(vector1.getX()) == Math.abs(vector2.getX())
			&& Math.abs(vector1.getY()) == Math.abs(vector2.getY()))) {
			throw new Exception("직사각형이 아닙니다. 다시 입력해 주세요");
		}
	}

}
