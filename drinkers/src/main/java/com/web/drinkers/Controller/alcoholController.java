package com.web.drinkers.Controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class alcoholController {
	
	private static final Logger logger = LogManager.getLogger(foodController.class.getName());
	
	@RequestMapping(value = "/go_alcohol_recipe", method = RequestMethod.GET)
	public ModelAndView goAlcoholRecipe() {
		logger.info("Alcohol Recipe 페이지 이동");
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alcohol/alcohol_recipe");
		return mv;
	}

}
