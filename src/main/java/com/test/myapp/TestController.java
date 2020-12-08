package com.test.myapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
      
      @Autowired
      TestService TestService;
      
      @RequestMapping(value ="/test" , method = RequestMethod.POST)
      public String goTestPage(Model model, HttpServletRequest request){
            
            String testInput = (String)request.getParameter("testInput");
            TestVO testVO = new TestVO();
            testVO.setTestInput(Integer.parseInt(testInput));
            
            List<TestVO> list = TestService.getTestValue(testVO);
            
            if( list.size() > 0 ){
                  model.addAttribute("output", "Success_DB_Connection");
            }else{
                  model.addAttribute("output", "Fail_DB_Connection");
            }
            
            return "test";
      }
}

