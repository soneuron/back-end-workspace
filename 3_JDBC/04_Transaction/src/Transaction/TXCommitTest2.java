package Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TXCommitTest2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
			
			String query1 = "UPDATE bank SET balance=balance-? WHERE name=?"; // 동엽 3만원 이체 후 잔액
			String query2 = "UPDATE bank SET balance=balance+? WHERE name=?"; // 동호 3만원 입금 후 잔액
			String query3 = "SELECT balance FROM bank WHERE name=?"; // 잔액
			
			conn.setAutoCommit(false);
			
			/*
			 * 동엽 -> 동호 : 3만원씩 이체
			 * 동엽님의 잔액이 마이너스가 되면 이체 취소 되어야 함
			 * 
			 * 쿼리 3개 필요
			 * UPDATE 2개 -> SELECT 1개 필요
			 * 
			 * 잔액이 없으므로 이체 취소
			 * 잔액이 있으므로 이체 성공
			 * */
			//UPDATE member SET password=? WHERE id=?

			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setInt(1, 30000);
			ps1.setString(2, "동엽");
			
			ps1.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setInt(1, 30000);
			ps2.setString(2, "동호");
			
			ps2.executeUpdate();
			
			PreparedStatement ps3 = conn.prepareStatement(query3);
			ps3.setString(1, "동엽");
			ResultSet rs3 = ps3.executeQuery();
			
			if(rs3.next()) {
				if(rs3.getInt("balance")<0) {
					System.out.println("이체 실패");
					conn.rollback();
				} else {
					System.out.println("이체 성공");
					conn.commit();
				}
			} 
			
			conn.setAutoCommit(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
