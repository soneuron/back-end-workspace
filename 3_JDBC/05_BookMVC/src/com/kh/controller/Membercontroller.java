package com.kh.controller;

import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class Membercontroller {

	private MemberDAO member = new MemberDAO();
	
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
}
