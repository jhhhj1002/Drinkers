package com.web.drinkers.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.web.drinkers.Service.foodService;
import com.web.drinkers.Service.userService;
import com.web.drinkers.Vo.fileVo;
import com.web.drinkers.Vo.foodVo;

@Controller
public class foodController {
	
	@Autowired 
	private foodService foodservice;
	private static final Logger logger = LogManager.getLogger(foodController.class.getName());
	
	
	@RequestMapping(value = "/go_food_recipe", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		logger.info("Food Recipe 페이지 이동");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("food/food_recipe");
		return mv;
	}
	

	// food recipe 등록시
//	@ResponseBody //ajax 쓸지말지 결정
	@RequestMapping(value = "/do_food_recipe_regist", method = RequestMethod.POST)
	public String doFoodRecipeUpload(foodVo food, MultipartHttpServletRequest request,HttpSession sessionStorage,
            @RequestParam("imges") MultipartFile[] file ) throws Exception {
		
		logger.info("Food recipe 등록");
		logger.info("Food recipe 제목" + food.getTitle());
		
		List<fileVo> files = new ArrayList<fileVo>();
		String recipeTitle = food.getTitle();
		String id = (String) sessionStorage.getAttribute("my_id");
		String path = "/Users/ijihyeon/git/Drinkers/drinkers/src/main/resources/static/uploads/";
		
		food.setId(id);
		
		for(MultipartFile f : file) {
			fileVo temp = new fileVo();
			String originalfileName = f.getOriginalFilename();
			
			temp.setTitle(recipeTitle);
			temp.setName(originalfileName);
			files.add(temp);
			
			String my_path = path + recipeTitle+"|"+originalfileName;
			File dest = new File(my_path);
			f.transferTo(dest);
		}

		//service 에 전송
		foodservice.insertfoodrecipe(food, files);	
		
		// ResponseBody 쓸 시 리턴값 재설정
		return "redirect:/go_food_recipe";
	}
}
