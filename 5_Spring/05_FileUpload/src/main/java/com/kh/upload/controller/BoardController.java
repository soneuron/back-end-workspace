package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.vo.Board;
import com.kh.upload.service.ListService;
import com.kh.upload.service.WriteService;

@Controller
public class BoardController {
	
	@Autowired
	private WriteService ws;
	
	@Autowired
	private ListService ls;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	public void fileUpload(MultipartFile file) throws IllegalStateException, IOException {
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		
		File copyFile = new File("D:\\upload\\" + fileName);
		file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println("upload!");
		System.out.println("파일 이름 : " + file.getOriginalFilename());
		System.out.println("파일 사이즈 : " + file.getSize());
		System.out.println("파일 파라미터 명 : " + file.getName());
		
		fileUpload(file);
		
		return "redirect:/";
	}
	
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
		
		for(MultipartFile file : files) {
			fileUpload(file);
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/write")
	public String write(MultipartFile file, Board vo) throws IllegalStateException, IOException {
		
		fileUpload(file);
		
		ws.write(vo);
		
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Board vo) {
		
		ls.list(vo);
		
		return "list";
	}
}























