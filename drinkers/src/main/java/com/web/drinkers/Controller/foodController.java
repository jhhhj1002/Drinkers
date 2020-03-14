package com.web.drinkers.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class foodController {

	private static final Logger logger = LogManager.getLogger(foodController.class.getName());

	@RequestMapping(value = "/go_food_recipe", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		logger.info("Food Recipe 페이지 이동");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("food/food_recipe");
		return mv;
	}

	// food recipe 등록시
	@ResponseBody
	@RequestMapping(value = "/do_food_recipe_regist", method = RequestMethod.POST)
	public boolean doFoodRecipeUpload() throws Exception {
		logger.info("Food recipe 등록");

		return false;
	}
}
