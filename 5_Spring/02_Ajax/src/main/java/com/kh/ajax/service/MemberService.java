package com.kh.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.MemberMapper;
import com.kh.ajax.model.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mp;
	
	public Member idCheck(String id) {
		return mp.idCheck(id);
	}
}
