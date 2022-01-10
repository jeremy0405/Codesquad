package mission.cs.cs03;

import java.util.Scanner;

public class UserInput {

	public static String[] userInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine().toLowerCase().split(" ");
	}

}
