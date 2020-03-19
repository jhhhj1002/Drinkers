package com.web.drinkers.Controller;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		ServletContext context = request.getServletContext();

        String appPath = context.getRealPath("/");

        System.out.println(appPath);
        
		
		String path = "src/main/resources/static/upload/foodrecipe/";
		String imagePath = request.getServletContext().getRealPath("resources/static/upload/foodrecipe");
		String title = foodrecipe.getTitle();
		String originalfileName = foodrecipe.getImges().get(0).getOriginalFilename();
		
		String sPath = request.getSession().getServletContext().getRealPath("/filepathInContext");
		System.out.println(sPath);

		
		String fileName = "upload";

		
		URL url = this.getClass().getResource("/");
		
		System.out.println(url);
		
		File files = new File(".");
        String rootPath = files.getAbsolutePath();
        System.out.println("현재 프로젝트의 경로 : "+rootPath );


    	String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
    	 System.out.println("현재 프로젝트의 경로 : "+contextRoot );

        String pathsss = "/Users/ijihyeon/git/Drinkers/drinkers/target/classes/static/upload/"+originalfileName;
		
//		File dest = new File("/Users/ijihyeon/git/Drinkers/drinkers/src/main/resources/static/upload/foodrecipe/" + originalfileName);
		File dest = new File(pathsss);
//		foodrecipe.getImges().get(0).transferTo(dest);
	
		foodrecipe.getImges().get(0).transferTo(dest); 
	
		

//		/drinkers/src/main/java/com/web/drinkers/Controller/userController
//		/drinkers/src/main/resources/static/upload/foodrecipe

		return false;
	}
}
