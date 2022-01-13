package mission.cs.cs04;

import java.util.List;

public class Rectangle implements Shape {

	private final List<Point> points;

	public Rectangle(List<Point> points) {
		this.points = points;
	}

	@Override
	public double getResult() {
		return 0;
	}

	@Override
	public String getMessage() {
		return "사각형 넓이";
	}
}
