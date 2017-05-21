package com.cwd.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping(value="/weclome",method=RequestMethod.GET)   
    public ModelAndView getFirstPage() {  
        //welcom就是视图的名称（welcome.ftl）  
        ModelAndView mv = new ModelAndView(); 
        mv.setViewName("weclome"); 
        mv.addObject("name", "this is freemaker test!!!");  
        return mv;  
    }  
}
