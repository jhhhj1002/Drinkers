package com.web.drinkers.Dao;

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

}
