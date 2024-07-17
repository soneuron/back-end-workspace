package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.Member;

import config.ServerInfo;

public class MemberController {
	
	Member m = new Member();
	
	// DB 연결
	public MemberController() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	///////////////////////////////////////////
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		closeAll(rs, ps, conn);
	}
	///////////////////////////////////////////
	
	
	// id 하나만 가져오기
	public void idCheck() throws SQLException {
		
		Connection conn = getConnect();
		
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, m.getId());
		
		ResultSet rs = ps.executeQuery();
		
	}
	
	public boolean signUp(String id, String password, String name) throws SQLException {

		// 회원가입 기능 구현! 	
			// -> member 테이블에 데이터 추가! 
			Connection conn = getConnect();
			
			String query = "INSERT INTO member(id, password, name) VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, m.getId());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());
	
			ps.executeUpdate();
			// -> 아이디가 기존에 있는지 체크 여부!
//			idCheck();
			return true;
			
			
			
//			int result = ps.executeUpdate(); // 1이면 등록 성공, 그 외 등록 실패 
//	
//			return result;
		
		

	}
	
	public void login() {

		
		// 로그인 기능 구현! 
		// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기!
		
	}
	
	public void changePassword() {

		
		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 member 테이블에서 id로 새로운 패스워드로 변경

	}
	
	public void changeName() {

		
		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경 
		
	}

	
}









