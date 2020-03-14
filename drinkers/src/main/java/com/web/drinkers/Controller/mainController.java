package com.web.drinkers.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mainController {
	
	private static final Logger logger = LogManager.getLogger(mainController.class.getName());
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		logger.info("로그인/회원가입 페이지 이동");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/index");
		return mv;
	}

}
