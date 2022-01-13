package mission.cs.cs04;

import java.util.List;

public class Print {

	private static final StringBuilder sb = new StringBuilder();
	private static final int MAX_PLANE_SIZE = 25;

	private Print() {
	}

	public static void print(Shape shape) {

		printPoint(shape);
		printResult(shape);

	}

	private static void printPoint(Shape shape) {

		for (int i = MAX_PLANE_SIZE; i >= 0; i--) {
			setYLine(i);
			for (int j = 0; j < MAX_PLANE_SIZE; j++) {
				if(isPoint(shape.getPoints(), j, i)) {
					sb.append(" ⚬");
				} else {
					sb.append("  ");
				}
			}
			sb.append("\n");
		}

		setXLine();

		System.out.println(sb);
		sb.setLength(0);
	}

	private static void setXLine() {
		sb.append("  +");
		for (int i = 0; i < MAX_PLANE_SIZE; i++) {
			sb.append("--");
		}
		sb.append("\n   ");
		for (int i = 0; i < MAX_PLANE_SIZE; i++) {
			if(i % 2 == 0) {
				if(i >= 10) {
					sb.append(i);
				} else {
					sb.append(" ").append(i);
				}
			} else {
				sb.append("  ");
			}
		}
	}

	private static void setYLine(int i) {
		if (i % 2 == 0) {
			if (i / 10 != 0) {
				sb.append(i).append("|");
			} else {
				sb.append(" ").append(i).append("|");
			}
		} else {
			sb.append("  |");
		}
	}

	private static boolean isPoint(List<Point> points, int x, int y) {

		for (Point point : points) {
			if(point.getX() == x && point.getY() == y) {
				return true;
			}
		}
		return false;
	}

	private static void printResult(Shape shape) {
		sb.append(shape.getMessage()).append("는 ")
				.append(shape.getResult()).append("입니다.");
		System.out.println(sb);
		sb.setLength(0);
	}

}
