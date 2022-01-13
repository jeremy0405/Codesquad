package mission.cs.cs04;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {

	private final List<Point> points;

	public Rectangle(List<Point> points) {
		this.points = points;
	}

	public Rectangle(int width, int height) {
		points = new ArrayList<>();
		points.add(new Point(0, 0));
		points.add(new Point(0, height));
		points.add(new Point(width, 0));
		points.add(new Point(width, height));
	}

	@Override
	public double getResult() {
		return Calculator.calculateArea(points);
	}

	@Override
	public String getMessage() {
		return "사각형 넓이";
	}

	@Override
	public List<Point> getPoints() {
		return points;
	}

}
