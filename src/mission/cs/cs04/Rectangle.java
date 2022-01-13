package mission.cs.cs04;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Polygon {

	private final List<Point> points;

	public Rectangle(List<Point> points) {
		super(points);
		this.points = super.getPoints();
	}

	public Rectangle(int width, int height) {
		points = new ArrayList<>();
		points.add(new Point(0, 0));
		points.add(new Point(0, height));
		points.add(new Point(width, 0));
		points.add(new Point(width, height));
	}

	@Override
	public String getMessage() {
		return "사각형 넓이";
	}

}
