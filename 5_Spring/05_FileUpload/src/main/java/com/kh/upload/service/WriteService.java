package com.kh.upload.service;


import org.springframework.stereotype.Service;

import com.kh.upload.mapper.WriteMapper;
import com.kh.upload.model.vo.Board;

@Service
public class WriteService {
	

	private WriteMapper mapper;
	
	public void write(Board vo) {
		mapper.write(vo);
	}
}
