package Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TXCommitTest {

	public static void main(String[] args) {

		
		// 1. 드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. DB연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
					
			// 3. PreparedStatement + 쿼리문
			String query1 = "INSTERT INTO member VALUES(?, ?, ?)";
			String query2 = "SELECT * FROM member WHERE id=?";
			
			// 트렌잭션 시작 명시
			conn.setAutoCommit(false);
			
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, "test4");
			ps1.setString(2, "pass4");
			ps1.setString(3, "테스트3");
			
			ps1.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setString(1, "test4");
			ResultSet rs = ps2.executeQuery();
			
			if(rs.next()) {
				conn.commit();
				System.out.println("회훤이 존재하여 회원 추가 취소");
			} else {
				conn.commit();
				System.out.println("회훤이 존재하지 않으므로 추가");
			}
			
			
			
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
