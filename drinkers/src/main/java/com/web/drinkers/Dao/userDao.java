package com.web.drinkers.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.drinkers.Vo.userVo;

@Repository
public class userDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insertUser(userVo user) {
		String query = "INSERT INTO USER(id,passwd) VALUES(?,?)";
		return jdbcTemplate.update(query,user.getId(),user.getPasswd());
	}

}
