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
import com.kh.model.Book;

public class BookController<book> {

	Properties p = new Properties();
	
	public void bookController() {
		
		try {
			p.load(new FileInputStream("src/com.kh/config/jdbc.properties"));

			Class.forName(Serverinfo.DRIVER_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps, conn);
	}
	
	public ArrayList<Book> printBookAll() throws SQLException {
		
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("printBookAll"));

		ResultSet rs = ps.executeQuery();
		ArrayList<Book> list = new ArrayList<>();
		
		while(rs.next()) {
			Book book = new Book();
			book.setBk_title(rs.getString("bk_title"));
			book.setBk_author(rs.getString("bk_author"));
			book.setPrice(rs.getInt("bk_price"));
			
		}
		close(rs, ps, conn);
		
		return list;
		
	}
}








