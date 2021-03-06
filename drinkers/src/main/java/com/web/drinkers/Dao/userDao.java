package com.web.drinkers.Dao;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.drinkers.Vo.userVo;

@Repository
public class userDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// db 에 User 정보 insert
	public int insertUser(userVo user) {
		String query = "INSERT INTO USER(id,passwd,birth) VALUES(?,?,?)";
		return jdbcTemplate.update(query,user.getId(),user.getPasswd(),user.getBirth());
	}
	
	// db 에서 User id 유무 확인
	public List<Map<String, Object>> selectUserId(userVo user) {
		String query = "SELECT * From USER WHERE id = ? ";
		return jdbcTemplate.queryForList(query,user.getId());
	}
	
	// db 에서 User id 와 passwd 일치여부 확인 
	public List<Map<String, Object>> selectUserInfo(userVo user) {
		String query = "SELECT * From USER WHERE id = ? AND passwd = ?";
		return jdbcTemplate.queryForList(query, user.getId(),user.getPasswd());
	}

}
