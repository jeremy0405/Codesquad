package mission.cs.cs09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/CS09";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private final String FAILURE = "드라이버 로딩 실패";
	private final String ERROR = "ERROR";

	public static void main(String[] args) throws Exception {
		Main main = new Main();

		System.out.println(main.getConnection());

	}

	public Connection getConnection() throws InterruptedException {

		Connection connection = null;

		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD)
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}