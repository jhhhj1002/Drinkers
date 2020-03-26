package com.web.drinkers.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.drinkers.Vo.foodVo;
import com.web.drinkers.Vo.fileVo;

@Service
public interface foodService {
	
	public void insertfoodrecipe(foodVo food,List<fileVo> fileList);// db에 food,file 정보 insert
	
	// 이미지 리스트 insert
	// 이미지 리스트 return 


}
