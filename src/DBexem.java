import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DBexem {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ArticleDao articleDao = new ArticleDao();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();

			if (cmd.equals("list")) {

				ArrayList<Article> articles = articleDao.getArticles();

				for(int i = 0; i < articles.size(); i++) {
					System.out.println("제목 : " + articles.get(i).getTitle());
				}

				/* 리팩토링 전
				
				String sql = "SELECT * FROM article";
				PreparedStatement pstmt = conn.prepareStatement(sql); // PreparedStatment 통해서 sql 세팅
				ResultSet rs = pstmt.executeQuery(); // 조회 결과가 있는 경우
				// pstmt.executeUpdate(); // 조회 결과가 없는 경우
				while (rs.next()) {
					String title = rs.getString("title");
					int id = rs.getInt("id");
					String body = rs.getString("body");
					String nickname = rs.getString("nickname");
					int hit = rs.getInt("hit");
					System.out.println(id + " " + title + " " + body + " " + nickname + " " + hit);
				}
				*/
			//} else if (cmd.equals("add")) {
//				System.out.print("제목 : ");
//				String title = sc.nextLine();
//				System.out.print("내용 : ");
//				String body = sc.nextLine();
//
//				String sql2 = " INSERT INTO article SET title = ?, `body` = ?, nickname = '홍길동', hit = 10";
//				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
//
//				pstmt2.setString(1, title);
//				pstmt2.setString(2, body);
//				pstmt2.executeUpdate();
//			} else if (cmd.equals("update")) {
//				System.out.print("번호 : ");
//				int id = Integer.parseInt(sc.nextLine());
//
//				String sql2 = "select * from article where id = ?";
//				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
//				pstmt2.setInt(1, id);
//
//				ResultSet rs = pstmt2.executeQuery();
//
//				if (rs.next()) {
//
//					String sql = "UPDATE article SET title = ?, `body` = ? WHERE id = ?";
//					PreparedStatement pstmt = conn.prepareStatement(sql);
//					System.out.print("제목 : ");
//					String title = sc.nextLine();
//					System.out.print("내용 : ");
//					String body = sc.nextLine();
//
//					pstmt.setString(1, title);
//					pstmt.setString(2, body);
//					pstmt.setInt(3, id);
//
//					pstmt.executeUpdate();
//				} else {
//					System.out.println("없는 게시물입니다.");
//				}
//			} else if (cmd.equals("delete")) {
//				System.out.print("번호 : ");
//				int id = Integer.parseInt(sc.nextLine());
//
//				String sql2 = "select * from article where id = ?";
//				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
//				pstmt2.setInt(1, id);
//
//				ResultSet rs = pstmt2.executeQuery();
//
//				if (rs.next()) {
//					String sql = "delete from article WHERE id = ?";
//					PreparedStatement pstmt = conn.prepareStatement(sql);
//
//					pstmt.setInt(1, id);
//
//					pstmt.executeUpdate();
//				} else {
//					System.out.println("없는 게시물입니다.");
//				}
//			}
//			else if(cmd.equals("read")){
//				System.out.print("번호 : ");
//				int id = Integer.parseInt(sc.nextLine());
//
//				String sql2 = "select * from article where id = ?";
//				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
//				pstmt2.setInt(1, id);
//
//				ResultSet rs = pstmt2.executeQuery();
//
//				if (rs.next()) {
//					int id2 = rs.getInt("id");
//					String title = rs.getString("title");
//					String body = rs.getString("body");
//					
//					System.out.println("번호 : " + id2);
//					System.out.println("제목 : " + title);
//					System.out.println("내용 : " + body);
//					
//				} else {
//					System.out.println("없는 게시물입니다.");
//				}
			}
		}
	}
}
