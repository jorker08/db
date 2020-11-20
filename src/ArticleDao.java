import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleDao {
	// 드라이버 정보
		String driver = "com.mysql.cj.jdbc.Driver";
		// dbms 주소
		String url = "jdbc:mysql://localhost:3306/t1?serverTimezone=UTC";

		// 사용자 계정
		String user = "sbsst";
		// 사용자 비밀번호
		String pass = "sbs123414";

		public ArrayList<Article> getArticles() {

			ArrayList<Article> articles = new ArrayList<>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				
				Class.forName(driver);
				
				conn = DriverManager.getConnection(url, user, pass);
				
				String sql = "SELECT * FROM article";
				pstmt = conn.prepareStatement(sql); // PreparedStatment 통해서 sql 세팅

				rs = pstmt.executeQuery(); // 조회 결과가 있는 경우
				// pstmt.executeUpdate(); // 조회 결과가 없는 경우


				
				while (rs.next()) {
					String title = rs.getString("title");
					int id = rs.getInt("id");
					String body = rs.getString("body");
					String nickname = rs.getString("nickname");
					int hit = rs.getInt("hit");
					
					Article article = new Article();
					article.setTitle(title);
					article.setBody(body);
					article.setNickname(nickname);
					article.setId(id);
					article.setHit(hit);
					
					articles.add(article);
					
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch(ClassNotFoundException e2) {
				// DBMS 선택 -> 담당자(Connection) 부여받음
				e2.printStackTrace();
			} finally {
				try {
					if(rs != null) {
						rs.close();					
					}
					if(pstmt != null) {					
						pstmt.close();
					}
					if(conn != null) {
						conn.close();					
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			return articles;
		}
}
