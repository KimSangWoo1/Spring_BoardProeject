package com.test.myapp.tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.myapp.tutorial.vo.ProductVO;

@Controller
public class DomainController {
	private static final Logger logger = LoggerFactory.getLogger(DomainController.class);
	
	@RequestMapping("/doD")
	public String doD(Model model) {
		
		ProductVO product = new ProductVO("desktop",1000);
		logger.info("/doD called");
		model.addAttribute(product);
		return "/tutorial/product_detail";
	}
}
