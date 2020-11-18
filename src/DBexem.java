import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBexem {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// db 접속 정보
		
		//드라이버 정보
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//dbms 정보
		String url = "jdbc:mysql://localhost:3306/t1?serverTimeZone=UTC";
		
		//사용자 계정
		String user = "sbsst";
		
		//사용자 비밀번호
		String pass = "sbs123414";
		
		Class.forName(driver);// Driver 세팅
		Connection conn = DriverManager.getConnection(url, user, pass); // DBMS 선택 -> 담당자(Connection);
		String sql = "SELECT * FROM article";
		PreparedStatement pstmt = conn.prepareStatement(sql); // preparedStatment 통해서 sql 세팅
		
		ResultSet rs = pstmt.executeQuery(); // 조회 결과가 있는경우
//		pstmt.executeUpdate();// 조회 결과가 없는경우
		rs.next(); // 데이터가 있으면 true, 없으면 flase
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String body = rs.getString("body");
			String nickname = rs.getString("nickname");
			int hit = rs.getInt("hit");
			System.out.println(id+ " " + title + " " + body + " " + nickname + " " + hit);
		}
		
		String sql2 = "INSERT INTO article SET title = 'bbb', `body` = 'ccc', nickname = '홍길동', hit = 10;";
		
		pstmt.executeUpdate(sql2);
		
	}

}
