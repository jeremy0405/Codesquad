package mission.cs.cs09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApp {
	public static void main(String[] args) {
		insert("데이브", 5000);
		insert("샤인", 299999);
	}

	public static void insert(String name, int money) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// 1. connector(드라이버) 로딩.
			// ClassNotFoundException 발생 가능 - 예외처리 필요.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. DB와 연결하기 -  connection = DriverManager.getConnection()
			// SQLException 발생 가능 - 예외처리 필요.
			String url = "jdbc:mysql://localhost:3306/test";
			connection = DriverManager.getConnection(url, "root", "");

			// 3. 쿼리 수행을 위한 PreparedStatement 객체 생성
			// INSERT로 추가하는 데이터 값은 보통 파라미터를 통해 동적 할당되는 값이므로,
			// Statement.createStatement()가 아닌 PreparedStatement.prepareStatement()를 사용함.
			// (쿼리를 준비하는 statement라는 의미)
			// prepareStatement()는 PreparedStatement 객체를 반환하며,
			// 이 객체에는 PreparedStatement.setString()으로 동적으로 값을 할당할 수 있음.
			// PreparedStatement 메소드들은 SQLException 발생 가능 - 예외처리 필요.
			String sql = "INSERT INTO users VALUES (?,?)";
			preparedStatement = connection.prepareStatement(sql);

			// 4. 데이터 binding - sql문의 각 요소에 파라미터 값을 할당해줌
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, money);

			// 5. 쿼리 실행 및 결과 처리
			// SELECT와 달리 INSERT는 반환 데이터가 없으므로 ResultSet 객체가 필요 없음.
			// 따라서 바로 PreparedStatement.executeUpdate()메서드를 호출함.
			// INSERT, UPDATE, DELETE 쿼리 : PreparedStatement.executeUpdate()를 사용하며,
			//   (쿼리의 결과, 즉 리턴값이 없는 경우)
			// SELECT 쿼리 : Statement.executeQuery()를 사용함.
			//   (쿼리의 결과, 즉 리턴값이 있는 경우)
			// 리턴타입 : int (몇 개의 row에 영향을 미쳤는지를 반환함)
			int count = preparedStatement.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러 " + e);
		}
		finally {
			// Connection, PreparedStatement 객체를 닫는 코드.
			// isClosed(), close()는 SQLException 발생 가능 - try-catch로 예외처리.
			try {
				if (connection != null && !connection.isClosed()) {
					// Connection이 존재하고, 닫혀있지 않다면
					connection.close();
				}
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}