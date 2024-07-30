package com.kh.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.sevice.MemberService;

@Controller
public class MemberController {
	
	private MemberService service;
	
	public MemberController(MemberService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "mypage/register";
	}
	
	@PostMapping("/register")
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/";
	}
}
