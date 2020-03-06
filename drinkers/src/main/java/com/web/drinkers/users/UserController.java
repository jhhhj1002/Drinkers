package com.web.drinkers.users;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.drinkers.dao.userDao;
import com.web.drinkers.vo.userVo;

@Controller
public class UserController {
	
	private userDao userdao;
	private static final Logger logger = LogManager.getLogger(UserController.class.getName());
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView gologin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value = "/makeuser", method = RequestMethod.POST)
	public String gouser(userVo user) {
		System.out.println("llllllllllllllllllllllll");
		return "main";
	}


	
}
