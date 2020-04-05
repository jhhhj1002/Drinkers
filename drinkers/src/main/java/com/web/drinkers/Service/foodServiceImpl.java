package com.web.drinkers.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.drinkers.Dao.fileDao;
import com.web.drinkers.Dao.foodDao;
import com.web.drinkers.Vo.fileVo;
import com.web.drinkers.Vo.foodVo;

@Service
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
	
	@Override
	public List<Map<String, Object>> selectAllFoodRecipeInfo(){
		
		return fooddao.selectAllFoodRecipeInfo(); 
	}
	
	@Override
	public List<Map<String, Object>> selectFoodRecipeInfo(String title){
		
		List<Map<String, Object>> Info = new ArrayList<Map<String, Object>>();
		Info.add( fooddao.selectFoodRecipeInfo(title));
		Info.addAll(filedao.selectFoodRecipeImgs(title));	
		
		return Info;
		
	}

}
