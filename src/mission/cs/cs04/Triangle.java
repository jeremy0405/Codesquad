package mission.cs.cs04;

import java.util.List;

public class Triangle implements Shape {

	private final List<Point> points;

	public Triangle(List<Point> points) {
		this.points = points;
	}

	@Override
	public double getResult() {
		Point pointA = points.get(0);
		Point pointB = points.get(1);
		Point pointC = points.get(2);

		int pointAX = pointA.getX();
		int pointAY = pointA.getY();
		int pointBX = pointB.getX();
		int pointBY = pointB.getY();
		int pointCX = pointC.getX();
		int pointCY = pointC.getY();

		return (double) Math.abs(
			pointAX * pointBY + pointBX * pointCY + pointCX * pointAY - pointBX * pointAY
				- pointCX * pointBY - pointAX * pointCY) / 2;
	}

	@Override
	public String getMessage() {
		return "삼각형 넓이";
	}

	@Override
	public List<Point> getPoints() {
		return points;
	}

}
