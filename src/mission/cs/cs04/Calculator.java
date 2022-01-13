package mission.cs.cs04;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	private Calculator() {
	}

	public static double calculateArea(List<Point> points) {
		return calculatePolygonArea(points);
	}

	private static double calculateTriangleArea(List<Point> points) {
		Point pointA = points.get(0);
		Point pointB = points.get(1);
		Point pointC = points.get(2);

		int pointAX = pointA.getX();
		int pointAY = pointA.getY();
		int pointBX = pointB.getX();
		int pointBY = pointB.getY();
		int pointCX = pointC.getX();
		int pointCY = pointC.getY();

		return (double) Math.abs(
			pointAX * pointBY + pointBX * pointCY + pointCX * pointAY - pointBX * pointAY
				- pointCX * pointBY - pointAX * pointCY) / 2;
	}

	private static double calculatePolygonArea(List<Point> points) {
		int totalTriangles = points.size() - 2;
		double result = 0;

		for (int i = 0; i < totalTriangles; i++) {
			List<Point> tmpPoint = new ArrayList<>();
			tmpPoint.add(points.get(0));
			tmpPoint.add(points.get(1 + i));
			tmpPoint.add(points.get(2 + i));
			result += calculateTriangleArea(tmpPoint);
		}
		return result;
	}

}
