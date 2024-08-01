package com.semi.youtube.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Channel {
	private int channelCode;
	private String channelImg;
	private String channelName;
	private String id; // member 테이블과 연결
}
