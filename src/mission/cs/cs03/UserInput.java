package mission.cs.cs03;

import java.util.Scanner;

public class UserInput {

	private UserInput(){}

	public static String[] userInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine().toLowerCase().split("\\s");
	}

}
