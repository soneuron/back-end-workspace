package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.model.vo.Member;
import com.kh.ajax.service.MemberService;

@Controller
public class AjaxController {

	private int count = 0;

	@Autowired
	private MemberService service;
	
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		System.out.println("요청");
		return ++count;
	}
	
	@ResponseBody
	@GetMapping("/encoding")
	public String encoding(String nickname) {
		System.out.println("nickname : " + nickname);
		return nickname;
	}
	
	@ResponseBody
	@PostMapping("/check") // post로 보내서 온것임으로 @PostMapping
	public boolean check(String id) {
		 // 확인 2
		Member member = service.idCheck(id);
		if(member!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	@ResponseBody
	@PostMapping("/serial")
	public Member serial(Member member) {
		System.out.println(member);
		service.register(member);
		return member;
	}
//	public void serial(String id, String password, String name) {
//		System.out.println(id);
//		System.out.println(password);
//		System.out.println(name);
//		service.register(new Member(id, password, name));
//	}
	
//	@ResponseBody
//	@PostMapping("/serial")
//	public void seial(String id, String password, String name) {
//		
//		Member member = new Member();
//		
//		member = service.serialize(id, password, name);
//		
//		System.out.println(member);
//		return member;
//	}
}










