package mission.cs.cs04;

import java.util.List;

//todo Input Class 불러와서 Input 받아야 함
//
public class Menu {

	private final Input input;

	public Menu() {
		input = new Input();
	}

	public void start() {
		ShapeFactory factory = new ShapeFactory();
		List<Point> points = input.getPoints();
		Shape shape = factory.getShape(points);

		System.out.println(shape.getResult());
	}

}
