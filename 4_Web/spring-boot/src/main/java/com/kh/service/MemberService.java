package com.kh.service;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public void register(Member vo) throws SQLException {
		dao.register(vo);
	}
	
	public Member login(Member vo) throws SQLException {
		return dao.login(vo.getId(), vo.getPassword());
	}

	public Member search(String id) throws SQLException {
		return dao.searchMember(id);
	}
	
	public ArrayList<Member> allMember() throws SQLException {
		return dao.allMember();
	}
}
