package mission.cs.cs04;

import java.util.List;

//todo Input Class 불러와서 Input 받아야 함
//
public class Menu {

	private Input input;
	public Menu() {
		input = new Input();
	}
	public void start() {
		List<Point> points = input.getPoints();

		//todo input에서 받은 points 를 통해서 팩토리 패턴 돌려야함
		// 인터페이스 만들고
		// 직선, 삼각형, 사각형, 다각형 구현해야 함
		// 구현한 거 기반으로 출력해야 함 -> 출력 클래스 생성해야 함
		for (Point point : points) {
			System.out.println(point.getX() + " " + point.getY());
		}

		Shape shape = new Line(points);
		System.out.println(shape.getResult());

	}

}
