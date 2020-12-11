package com.test.myapp.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.myapp.tutorial.vo.ProductVO;

@Controller
public class JsonController {
	
	@RequestMapping("/doJson")
	@ResponseBody
	public ProductVO doJson() {
		ProductVO productVO = new ProductVO("laptop",30000);
		return productVO;
	}
}
