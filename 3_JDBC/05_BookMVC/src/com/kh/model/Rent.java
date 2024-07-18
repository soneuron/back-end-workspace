package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Rent {

	private int rent_no;
	private int member_no;
	private int bk_no;
	private int rent_date;
	
}
