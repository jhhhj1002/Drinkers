package com.web.drinkers.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.drinkers.Vo.fileVo;

@Repository
public class fileDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// db 에 file 정보 insert
	public int insertFile(fileVo file) {
		String query = "INSERT INTO File(title,name) VALUES(?,?)";
		return jdbcTemplate.update(query, file.getTitle(),file.getName());
	}
	
	public List<Map<String, Object>> selectFoodRecipeImgs(String title) {
		String query = "SELECT name From File WHERE title = ?";
		return jdbcTemplate.queryForList(query, title);
	}

}
