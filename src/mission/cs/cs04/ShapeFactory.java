package mission.cs.cs04;

import java.util.List;

public class ShapeFactory {

	public Shape getShape(List<Point> points) {
		switch (points.size()) {
			case 2:
				return new Line(points);
			case 3:
				return new Triangle(points);
			case 4:
				return new Rectangle(points);
			default:
				return new Polygon(points);
		}
	}
}
