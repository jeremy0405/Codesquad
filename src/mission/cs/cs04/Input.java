package mission.cs.cs04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Input {

	private List<Point> points = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	private List<String> getUserInput() {
		List<String> stringPointList = new ArrayList<>();
		try {
			StringTokenizer st = new StringTokenizer(sc.nextLine(), "-");
			while (st.hasMoreTokens()) {
				String tmp = st.nextToken();
				stringPointList.add(tmp.substring(1, tmp.length() - 1));
			}
		} catch (Exception e) {
			return getUserInput();
		}
		return stringPointList;
	}

	public List<Point> getPoints() {
		InputValidation val = new InputValidation();
		List<String> stringPointList = getUserInput();
		try {
			for (String s : stringPointList) {
				String[] xy = s.split(",");
				points.add(new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
			}
			points = val.validateInput(points);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resetInput();
		}

		return points;
	}

	private void resetInput() {
		points.clear();
		getPoints();
	}

}
