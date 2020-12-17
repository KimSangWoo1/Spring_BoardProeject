package com.test.myapp.tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	private static final Logger logger = LoggerFactory.getLogger(RedirectController.class);
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes redirectAttributes) {
		logger.info("/doE Called");
		redirectAttributes.addAttribute("msg","this is the messge with redirected");
		
		return "redirect:/doF";
	}
	
	@RequestMapping("/doF")
	public void doF(@ModelAttribute String msg) {
		logger.info("/doF Called"+msg);
	}
	
}
