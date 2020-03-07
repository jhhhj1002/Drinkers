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
	
	@RequestMapping(value = "/do_regist", method = RequestMethod.POST)
	public String doRegist(userVo uservo) throws Exception {	
		logger.info("User 정보" + uservo);
		userservice.insertUser(uservo);
		return "redirect:/";
	}
	
	@RequestMapping("/go_main")
	public ModelAndView goMain(userVo uservo) throws Exception {
		ModelAndView mv = new ModelAndView();		
		logger.info("User 정보" + uservo);
		mv.setViewName("main");
		return mv;
	}
	
}
