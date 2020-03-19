package com.web.drinkers.Controller;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.drinkers.Vo.foodrecipeVo;

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
	public boolean doFoodRecipeUpload(foodrecipeVo foodrecipe,HttpServletRequest request) throws Exception {
		logger.info("Food recipe 등록");
		logger.info("Food recipe 이미지 파일명" + foodrecipe.getImges());
		logger.info("Food recipe 이미지 파일명" + foodrecipe.getImges().get(0));
		logger.info("Food recipe 제목" + foodrecipe.getTitle());

	 	
        
		String recipeTitle = foodrecipe.getTitle();
		String originalfileName = foodrecipe.getImges().get(0).getOriginalFilename();
		
        String path = "/Users/ijihyeon/git/Drinkers/drinkers/src/main/resources/static/uploads/"+recipeTitle+"|"+originalfileName;
		File dest = new File(path);
	
		foodrecipe.getImges().get(0).transferTo(dest); 


		return false;
	}
}
