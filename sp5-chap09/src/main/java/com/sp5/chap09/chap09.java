package com.sp5.chap09;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class chap09 {
	
	@GetMapping("/hello")
	public ModelAndView chapControll(ModelAndView m , @RequestParam("name") String name) {
		m.addObject("name", name);
		m.setViewName("hello");
		return m;
	}
}
