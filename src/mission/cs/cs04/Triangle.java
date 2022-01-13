package mission.cs.cs04;

import java.util.List;

public class Triangle implements Shape {

	private final List<Point> points;

	public Triangle(List<Point> points) {
		this.points = points;
	}

	@Override
	public double getResult() {
		return 0;
	}

	@Override
	public String getMessage() {
		return "삼각형 넓이";
	}
}
