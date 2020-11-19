import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBexem {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ArticleDao articleDao = new ArticleDao();
		Scanner sc = new Scanner(System.in);

		

		while (true) {
			System.out.println("명령어를 입력해주세요 : ");
			String hdw = sc.nextLine();

			if (hdw.equals("add")) {
				System.out.println("제목 : ");
				String title = sc.nextLine();
				System.out.println("내용 : ");
				String body = sc.nextLine();
				System.out.println("작성자 : ");
				String nickname = sc.nextLine();
				System.out.println("등록날짜 : ");
				String date = sc.nextLine();

				String sql = "INSERT INTO article SET title = ?, `body` = ?, nickname = ?, `date` = ?, hit = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, title);
				pstmt.setString(2, body);
				pstmt.setString(3, nickname);
				pstmt.setString(4, date);

				pstmt.executeUpdate();

				System.out.println("등록했습니다.");
			} else if (hdw.equals("list")) {
				String sql2 = "SELECT*FROM article";

				PreparedStatement pstmt = conn.prepareStatement(sql2);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					String title = rs.getString("title");
					int id = rs.getInt("id");
					String body = rs.getString("body");
					String nickname = rs.getString("nickname");
					String date = rs.getString("date");
					int hit = rs.getInt("hit");
					System.out.println(id + " " + title + " " + body + " " + nickname + " " + date + " " + hit);
				}

			}else if(hdw.equals("read")) {
				System.out.print("게시물 번호를 입력해주세요 : ");
				int id = sc.nextInt();
				String sql3 = "SELECT*FROM article WHERE id = ? ";
				

				PreparedStatement pstmt = conn.prepareStatement(sql3);
				ResultSet rs = pstmt.executeQuery();
				
				pstmt.setInt(1, id);
				
				if (rs.next()) {
					String title = rs.getString("title");
					int id2 = rs.getInt("id");
					String body = rs.getString("body");
					String nickname = rs.getString("nickname");
					String date = rs.getString("date");
					int hit = rs.getInt("hit");
					System.out.println(id2 + " " + title + " " + body + " " + nickname + " " + date + " " + hit);
				}else {
					System.out.println("없는게시물 입니다.");
				}
			}
			else if(hdw.equals("update")) {
				System.out.println("번호 : ");
				int id = sc.nextInt();
				String sql4 = "UPDATE article SET title = ? WHERE id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql4);
				
				System.out.println("제목 : ");
				String title = sc.nextLine();
				System.out.println("내용 : ");
				String body = sc.nextLine();
				
				
				pstmt.setString(1, title);
				pstmt.setString(2, body);
				pstmt.setInt(3, id);
				
				pstmt.executeUpdate();
				

				
			}else if(hdw.equals("delete")) {
				System.out.println("삭제할 게시물을 선택해주세요");
				int id = sc.nextInt();
				
				String sql5 = "DELETE FROM article WHERE id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql5);
				pstmt.setInt(1, id);
				
				pstmt.executeUpdate();
				
			}
		}
	}

}
