package com.test.myapp;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	Logger log = Logger.getLogger(this.getClass().toGenericString());

	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping("/board/boardList/")
	public ModelAndView boardList(Map<String,Object>map) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardList");
		
		List<Map<String,Object>> list = boardService.selectBoardList(map);
		return mv;
	}
	
}
