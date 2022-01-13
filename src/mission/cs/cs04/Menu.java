package mission.cs.cs04;

import java.util.List;

public class Menu {

	private final Input input;

	public Menu() {
		input = new Input();
	}

	public void start() {
		ShapeFactory factory = new ShapeFactory();
		List<Point> points = input.getPoints();
		Shape shape = factory.getShape(points);
		Print.print(shape);
	}

}
