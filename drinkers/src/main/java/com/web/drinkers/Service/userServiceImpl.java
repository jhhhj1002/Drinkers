package com.web.drinkers.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.drinkers.Dao.userDao;
import com.web.drinkers.Vo.userVo;

@Service
public class userServiceImpl implements userService  {
	
//	@Autowired
//	private userMapper usermapper;
	
	@Autowired
	private userDao userdao;
	
	public void insertUser(userVo vo) {
		userdao.insertUser(vo);
	}
	
//	public int selectUserListCnt(HttpServletRequest request, userVo uservo) throws Exception {
//		return usermapper.selectUserListCnt();
//	}
//
//	public List<userVo> selectUserList(HttpServletRequest request, userVo uservo) throws Exception {
//		return usermapper.selectUserList();
//	}
	

}
