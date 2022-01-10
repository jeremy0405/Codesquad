package mission.cs.cs03;

public class ValidationInput {

	public String[] validateInput(String[] input, VideoData[] videoData) {

		switch (input[0]) {
			case "add":
			case "delete":
				return validateAddOrDeleteInput(input, videoData);
			case "insert":
				return validateInsertInput(input, videoData);
			case "render":
				return validateRenderInput(input, videoData);
			default:
				System.out.println("잘못된 명령입니다. 다시입력해주세요.");
				return validateInput(UserInput.userInput(), videoData);
		}
	}

	private String[] validateInsertInput(String[] input, VideoData[] videoData) {
		try {
			Integer.parseInt(input[2]);
		} catch (NumberFormatException e) {
			System.out.println("Insert의 마지막 입력값은 숫자여야 합니다.");
			return validateInput(UserInput.userInput(), videoData);
		}

		if (input.length == 3) {
			for (VideoData data : videoData) {
				if (input[1].equals(data.getId())) {
					return input;
				}
			}
			System.out.println("유효하지 않는 Id입니다.");
		} else {
			System.out.println("유효하지 않는 명령입니다.");
		}
		return validateInput(UserInput.userInput(), videoData);
	}

	private String[] validateAddOrDeleteInput(String[] input, VideoData[] videoData) {
		if (input.length == 2) {
			for (VideoData data : videoData) {
				if (input[1].equals(data.getId())) {
					return input;
				}
			}
			System.out.println("유효하지 않은 Id입니다.");
		} else {
			System.out.println("유효하지 않은 명령입니다.");
		}
		return validateInput(UserInput.userInput(), videoData);
	}

	private String[] validateRenderInput(String[] input, VideoData[] videoData) {
		if (input.length == 1) {
			return input;
		} else {
			System.out.println("render 명령은 뒤에 인자를 받을 수 없습니다.");
			return validateInput(UserInput.userInput(), videoData);
		}
	}

}
