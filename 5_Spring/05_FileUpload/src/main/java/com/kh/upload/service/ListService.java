package com.kh.upload.service;

import org.springframework.stereotype.Service;

import com.kh.upload.mapper.ListMapper;
import com.kh.upload.model.vo.Board;

@Service
public class ListService {
	
	
	private ListMapper mapper;
	
	public Board list(Board vo) {
		return mapper.list(vo);
	}
}
