package com.test.myapp.tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VoidController {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(VoidController.class);
	
	//사실상 404라 실행이 안됨.. 로그도 안뜸
	
	@RequestMapping("/doA")
	public void doA() {
		logger.info("/doA called...");
	}
	
	@RequestMapping("/doB")
	public void doB() {
		logger.info("/doB called...");
	}
}
