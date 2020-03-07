package com.web.drinkers.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.drinkers.Vo.userVo;

public interface userService {

//	public int selectUserListCnt(HttpServletRequest request, userVo uservo) throws Exception;
//
//	public List<userVo> selectUserList(HttpServletRequest request, userVo uservo) throws Exception;
	
	public void insertUser(userVo vo);
}
