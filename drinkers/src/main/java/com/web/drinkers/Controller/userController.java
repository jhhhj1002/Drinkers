package com.web.drinkers.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.drinkers.Service.userService;
import com.web.drinkers.Vo.userVo;

@Controller
public class userController {
	
	@Autowired
	private userService userservice;
	private userVo uservo = new userVo();
	private static final Logger logger = LogManager.getLogger(userController.class.getName());
	
	
	// 로그인시
	@RequestMapping(value = "/do_login", method = RequestMethod.POST)
	public ModelAndView doLogin(userVo user) throws Exception {
		logger.info("User 정보" + user);		
		
		String message="";
		ModelAndView mv = new ModelAndView();
		boolean is_member_id = userservice.selectUserId(user);
		boolean is_member_info = userservice.selectUserInfo(user);
		
		if(is_member_id == false) { 
			message = "존재하지 않는 아이디 입니다";
		}
		else if(is_member_info == false){ 
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
	
	// 회원가입시 아이디 중복 확인	
	@ResponseBody
	@RequestMapping(value = "/do_check_id", method = RequestMethod.GET)
	public boolean doCheckId(@RequestParam(value="userId") String userId) throws Exception {
		logger.info("ID 정보" + userId);
		
		uservo.setId(userId);
		boolean member_id = userservice.selectUserId(uservo);
		logger.info("ID 중복 정보" + member_id);
		
		return member_id;
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
