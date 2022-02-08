package mission.cs.cs09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectApp {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// 1. connector (드라이버) 로딩
			// ClassNotFoundException 발생 가능 - try-catch 로 예외처리 필요.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. DB(MySQL)와 연결
			// SQLException 발생 가능 - try-catch 로 예외처리 필요.
			String url = "jdbc:mysql://localhost:3306/test";
			connection = DriverManager.getConnection(url, "root", "");

			// 3. 쿼리 수행을 위한 Statement 객체 생성
			// (Statement 객체 : 쿼리를 실행할 수 있는 객체)
			// *정적인 쿼리문은 Statement statement = conn.createStatement();
			// *동적인 쿼리문은 PreparedStatement preparedstatement = conn.prepareStatement();
			// (동적인 쿼리문 = 파라미터를 입력받는 쿼리문)
			statement = connection.createStatement();

			// 4. SQL 쿼리 작성
			// 주의 1. JDBC에서 쿼리 작성시 ;를 빼고 작성함.
			// 주의 2. SELECT 할 때 *로 가져오는 것보다, 가져올 컬럼을 지정하는 것이 좋음.
			// 주의 3. 쿼리로 결과값만 가져오고, java코드로 후작업하는 것은 좋지 않음.
			// 주의 4. 쿼리는 가급적 한 줄로 작성. 줄을 나눌 시, 띄어쓰기에 유의.
			String sql = "SELECT name, money FROM users";

			// 5. SQL 쿼리 수행
			// 작성한 SQL 쿼리를 Statement.executeQuery()의 인자로 전달해 호출하면 쿼리가 실행됨.
			// 리턴타입 : ResultSet 객체 - 쿼리 결과의 레코드들이 담겨 있다.
			// DB의 레코드들은 ResultSet 객체에 추가된다.
			resultSet = statement.executeQuery(sql);

			// 6. 실행 결과 출력
			// (일반적으로 결과 조회를 위해서는 VO객체를 사용함(키워드 - DAO, VO)
			while (resultSet.next()) {
				// 주의 - DB 레코드들의 칼럼은 0이 아닌 1부터 시작한다.
				// resultSet.next()는 boolean을 리턴함 - 다음 레코드가 존재하면 true 리턴

				String nickname = resultSet.getString(1);
				int money = resultSet.getInt(2);
				// DB에서 가져오는 데이터 타입에 맞게 getString() 또는 getInt() 등을 호출한다.

				System.out.println(nickname + " : " + money);
			}
			// 결과 : MySQL의 user 데이터베이스, user_log 테이블에서 nickname(String)과 money(int)를 가져와 출력함.
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러 " + e);
		}
		finally {
			// Connection, Statement, ResultSet 객체를 닫는 코드.
			// isClosed(), close()는 SQLException 발생 가능 - try-catch로 예외처리.
			try {
				if (connection != null && !connection.isClosed()) {
					// Connection이 존재하고, 닫혀있지 않다면
					connection.close();
				}
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}