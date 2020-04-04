package com.web.drinkers.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.drinkers.Vo.foodVo;
import com.web.drinkers.Vo.userVo;

@Repository
public class foodDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// db 에 foodrecipe 정보 insert
	public int insertFoodRecipe(foodVo foodrecipe) {
		String query = "INSERT INTO FoodRecipe(title,id,url,exp,img) VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(query, foodrecipe.getTitle(),foodrecipe.getId(), foodrecipe.getUrl(),foodrecipe.getExp(),foodrecipe.getImg());
	}
	
	public List<Map<String, Object>> selectAllFoodRecipeInfo() {
		String query = "SELECT * From FoodRecipe";
		return jdbcTemplate.queryForList(query);
	}
	
	public List<Map<String, Object>> selectFoodRecipeInfo(String title) {
		String query = "SELECT * From FoodRecipe WHERE title = ?";
		return jdbcTemplate.queryForList(query, title);
	}
	

}
