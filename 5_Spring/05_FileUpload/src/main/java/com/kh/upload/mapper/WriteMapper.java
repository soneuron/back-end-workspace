package com.kh.upload.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.vo.Board;

@Mapper
public interface WriteMapper {

	void write(Board vo);

}
