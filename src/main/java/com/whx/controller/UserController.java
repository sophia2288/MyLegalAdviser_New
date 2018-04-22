package com.whx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value = "/test")
	public ModelAndView testMVC() {
		System.out.println("testMVC()");
		ModelAndView modelAndView = new ModelAndView("test");
		modelAndView.addObject("info", "whx");
		return modelAndView;
	}
	
	@RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}