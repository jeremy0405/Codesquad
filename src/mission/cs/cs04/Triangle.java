package mission.cs.cs04;

import java.util.List;

public class Triangle extends Polygon {

	public Triangle(List<Point> points) {
		super(points);
	}

	@Override
	public String getMessage() {
		return "삼각형 넓이";
	}

}
