package mission.cs.cs04;

import java.util.List;

public class ShapeFactory {

	Shape shape;

	public Shape getShape(List<Point> points) {
		switch (points.size()) {
			case 2:
				shape = new Line(points);
				return shape;
			case 3:
				shape = new Triangle(points);
				return shape;
			case 4:
				shape = new Rectangle(points);
				return shape;
			default:
				shape = new Polygon(points);
				return shape;
		}
	}
}
