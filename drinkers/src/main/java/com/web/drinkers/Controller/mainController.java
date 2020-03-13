package com.web.drinkers.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/index");
		return mv;
	}

}
