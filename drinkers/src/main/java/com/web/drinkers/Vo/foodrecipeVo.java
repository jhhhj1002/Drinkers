package com.web.drinkers.Vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class foodrecipeVo {
	
	private String title;
	private List<MultipartFile> imges;
//	private String imges;
	private String url;
	private String desc;
	
}
