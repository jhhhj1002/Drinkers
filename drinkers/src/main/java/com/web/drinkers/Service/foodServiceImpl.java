package com.web.drinkers.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.drinkers.Dao.foodDao;
import com.web.drinkers.Vo.foodVo;

public class foodServiceImpl implements foodService{
	
	@Autowired
	private foodDao fooddao;

	@Override
	public void inserfood(foodVo food) { // 이미지 리스트 db에 insert 추가
		// TODO Auto-generated method stub
		fooddao.insertFoodRecipe(food);
	}

}
