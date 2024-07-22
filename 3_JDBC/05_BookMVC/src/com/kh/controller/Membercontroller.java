package com.kh.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.MemberDAO;
import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Member;
import com.kh.model.vo.Rent;

public class Membercontroller {

	private MemberDAO member = new MemberDAO();
	private RentDAO rent = new RentDAO();
	
	// 회원가입
	public boolean registerMember(String id, String password, String name) {
		try {
			member.registerMember(id, password, name);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Member login(String id, String password) {
		try {
			Member m = member.login(id, password);
			if(m.getStatus() == 'N') {
				return m;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	// 4. 회원탈퇴
	public boolean deleteMember(int memberNo) {
		try {
			// 대여중인 책 존재하여 탈퇴 불가
			ArrayList<Rent> bookList = rent.printRentBook(memberNo);
			if(bookList.size() > 0) {
				return false;
			}
			
			if(member.deleteMember(memberNo)==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}







