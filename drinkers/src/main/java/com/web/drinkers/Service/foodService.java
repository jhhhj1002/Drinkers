package com.web.drinkers.Service;

import org.springframework.stereotype.Service;

import com.web.drinkers.Vo.foodVo;

@Service
public interface foodService {
	
	public void inserfood(foodVo food); // db 에 food 정보 insert
	
	// 이미지 리스트 insert
	// 이미지 리스트 return 


}
