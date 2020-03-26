package com.web.drinkers.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.drinkers.Dao.fileDao;
import com.web.drinkers.Dao.foodDao;
import com.web.drinkers.Vo.fileVo;
import com.web.drinkers.Vo.foodVo;

public class foodServiceImpl implements foodService{
	
	@Autowired
	private foodDao fooddao;
	@Autowired
	private fileDao filedao;

	@Override
	public void insertfoodrecipe(foodVo food,List<fileVo> fileList) { // db에 food,file 정보 insert
		// TODO Auto-generated method stub
		fooddao.insertFoodRecipe(food);
		
		for(fileVo file : fileList) {
			filedao.insertFile(file);
		}
	}

}
