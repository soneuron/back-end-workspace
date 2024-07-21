package com.kh.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.config.Serverinfo;
import com.kh.model.dao.BookDAO;
import com.kh.model.dao.MemberDAO;
import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;

public class BookController {

	private BookDAO book = new BookDAO();
	private RentDAO rent = new RentDAO();
	private MemberDAO member = new MemberDAO();
	// 전체 책 조회
	public ArrayList<Book> printBookAll() {
		try {
			return book.printBookAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 책 등록
	public boolean registerBook(String title, String author) {
	
		try {
			// 기존 제목, 저자 있으면 등록 안되게
			if(!book.checkBook(title, author)) {
				book.registerBook(title, author);
				return true;
			}
		} catch (SQLException e) {

		}
		return false;
	}
	
	// 책 삭제
	public boolean sellBook(int no) {
		try {
			if(rent.checkRentBook(no)) {
				return false;
			} 
			// 없는 번호 삭제하려고 하면 실패
			// --> 기존 책들 중에 해당 no가 없는 경우
			// --> 기존 책들 중에 해당 no가 있는 경우 삭제
			for(Book b : book.printBookAll()) {
				if(b.getBkNo() == no) {
					book.sellBook(no);
					return true;
				}
			}
			// 빌려있는 책 삭제 못하게
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
//	Member m = new Member();
//	Book b = new Book();
//	
//	public void bookController() {
//		
//		try {
//			
//
//			Class.forName(Serverinfo.DRIVER_NAME);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public Connection connect() throws SQLException {
//		return DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
//	}
//	
//	public void close(PreparedStatement ps, Connection conn) throws SQLException {
//		ps.close();
//		conn.close();
//	}
//	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
//		rs.close();
//		close(ps, conn);
//	}
//	
//	public boolean printBookAll() throws SQLException {
//		
//		Connection conn = connect();
//		String query = "SELECT * FROM book";
//		PreparedStatement ps = conn.prepareStatement(query);
//
//		ResultSet rs = ps.executeQuery();
//		
//		while(rs.next()) {
//			int bkNo = rs.getInt("bk_no");
//			String bkTitle = rs.getString("bk_title");
//			String bkAuthor = rs.getString("bk_author");
//			int bkPrice = rs.getInt("bk_price");
//			int bkPubNo = rs.getInt("bk_pubNo");
//			
//			System.out.println(bkNo + "." + " 책 제목 : " + bkTitle + " 글쓴이 : " + bkAuthor + " 가격 : " + price);
//		}
//		close(rs, ps, conn);
//		return false;
//		
//
//		
//	}
//	
//	public void registerBook() throws SQLException {
//		
//		Connection conn = connect();
//		String query = "INSERT INTO book VALUES (?, ?)";
//		PreparedStatement ps = conn.prepareStatement(query);
//		
//		ps.setString(1, b.getBkTitle());
//		ps.setString(2, b.getBkAuthor());
//		
//		
//	}
}








