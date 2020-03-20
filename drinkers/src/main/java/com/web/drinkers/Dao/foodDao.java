package com.web.drinkers.Dao;

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
		String query = "INSERT INTO FoodRecipe(title,id,url,exp) VALUES(?,?,?,?)";
		return jdbcTemplate.update(query, foodrecipe.getTitle(),foodrecipe.getId(), foodrecipe.getUrl(),foodrecipe.getExp());
	}

}
