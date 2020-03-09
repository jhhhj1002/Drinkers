package com.web.drinkers.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.drinkers.Vo.userVo;

@Service
public interface userService {
	
	public void insertUser(userVo user); // db 에 User 정보 insert
	public boolean selectUserId(userVo user); // db 에서 User id 유무 확인 
	public boolean selectUserInfo(userVo user); // db 에서 User id 와 passwd 일치 여부 확인
	
//	public int selectUserListCnt(HttpServletRequest request, userVo uservo) throws Exception;
//
//	public List<userVo> selectUserList(HttpServletRequest request, userVo uservo) throws Exception;
	
}
