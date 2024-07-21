package com.kh.model.vo;

/*
 * VO(Value Object)
 * - 한개 또는 그 이상의 속성들을 묶어서 특정 값을 나타내는 객체
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {

	private int bkNo;
	private String bkTitle;
	private String bkAuthor;
	private int price;
	private Publisher publisher;
	
}
