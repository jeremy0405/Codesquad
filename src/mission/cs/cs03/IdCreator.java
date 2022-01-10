package mission.cs.cs03;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IdCreator {

	private static final Set<String> idSet = new HashSet<String>();
	private static IdCreator idCreator;
	private static final int ID_LENGTH = 4;

	private IdCreator() {}

	public String getId() {

		Random random = new Random();
		char[] id = new char[ID_LENGTH];
		for (int i = 0; i < ID_LENGTH; i++) {
			id[i] = (char) (random.nextInt(6) + 97);
		}
		String output = String.valueOf(id);

		output = validate(output);

		return output;
	}

	private String validate(String output) {
		int beforeAdd = idSet.size();
		idSet.add(output);
		int afterAdd = idSet.size();
		if (beforeAdd == afterAdd) {
			return getId();
		}
		return output;
	}

	public static IdCreator getInstance() {
		if (IdCreator.idCreator == null) {
			IdCreator.idCreator = new IdCreator();
		}
		return idCreator;
	}

}
