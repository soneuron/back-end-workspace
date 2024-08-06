package com.semi.youtube.model.vo;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Video {
	private int videoCode;
	private String videoUrl;
	private String videoImg;
	private String videoTitle;
	private int videoCount;
	private LocalDateTime videoDate;
	private String videoDesc;
//	private int channelCode; // channel 테이블과 연결
	private Channel channel;
}
