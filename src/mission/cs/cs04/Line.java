package mission.cs.cs04;

import static java.lang.Math.*;

import java.util.List;

public class Line implements Shape {

	private final List<Point> points;

	Line(List<Point> points) {
		this.points = points;
	}

	@Override
	public double getResult() {
		Point pointA = points.get(0);
		Point pointB = points.get(1);

		int pointAX = pointA.getX();
		int pointAY = pointA.getY();
		int pointBX = pointB.getX();
		int pointBY = pointB.getY();

		return sqrt(pow(pointAX - pointBX, 2) + pow(pointAY - pointBY, 2));
	}

	@Override
	public String getMessage() {
		return "두 점 사이의 거리";
	}

	@Override
	public List<Point> getPoints() {
		return points;
	}

}
