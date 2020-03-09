package com.web.drinkers.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.drinkers.Service.userService;
import com.web.drinkers.Vo.userVo;

@Controller
public class userController {
	
	@Autowired
	private userService userservice;
	private static final Logger logger = LogManager.getLogger(userController.class.getName());
	
	
	// 로그인시
	@RequestMapping(value = "/do_login", method = RequestMethod.POST)
	public ModelAndView doLogin(userVo user) throws Exception {
		logger.info("User 정보" + user);		
		
		String message="";
		ModelAndView mv = new ModelAndView();
		boolean member_id = userservice.selectUserId(user);
		boolean member_info = userservice.selectUserInfo(user);
		
		if(member_id == false) { 
			message = "존재하지 않는 아이디 입니다";
		}
		else if(member_info == false){ 
			message = "아이디와 패스워드가 일치하지 않습니다";				
		}
		
		mv.addObject("msg", message);
		mv.setViewName("alert_login");
		return mv;
	}

	// 회원가입시
	@RequestMapping(value = "/do_regist", method = RequestMethod.POST)
	public String doRegist(userVo user) throws Exception { // + 아이디가 중복됨	
		logger.info("User 정보" + user);
		
		userservice.insertUser(user);
		return "redirect:/";
	}
	
	// 로그인 성공시 메인페이지 이동
	@RequestMapping("/go_main")
	public ModelAndView goMain(userVo user) throws Exception {
		logger.info("User 정보" + user);
		
		ModelAndView mv = new ModelAndView();	
		mv.setViewName("main");
		return mv;
	}
	
}
