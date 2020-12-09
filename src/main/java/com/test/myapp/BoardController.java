package com.test.myapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	Logger log = Logger.getLogger(this.getClass().toGenericString());

	//DB Servcie
	@Resource(name="boardService")
	private BoardService boardService;
	//게시판 리스트
	@RequestMapping("/boardList")
	public ModelAndView boardList(Map<String,Object>map) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardList");
		
		List<Map<String,Object>> list = boardService.selectBoardList(map);
		mv.addObject("list",list);
		return mv;
	}
	//게시판 jsp에 작성
	@RequestMapping("/boardWrite")
	public ModelAndView boardWrite(Map<String,Object> map) throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardWrite");
		return mv;
	}
	//게시판 DB에 삽입
	@RequestMapping(value="/boardInsert", method =RequestMethod.GET)
	public ModelAndView boardInsert(@RequestParam("title") String title,
									@RequestParam("contents") String contents) throws Exception {
		log.info("게시글 작성 완료");
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("title", title);
		map.put("contents", contents);
		
		ModelAndView mv= new ModelAndView("redirect:/boardList/");
		
		boardService.boardInsert(map);
		return mv;
	}
	
	@RequestMapping(value="/boardUpdateView", method = RequestMethod.POST)
	public ModelAndView boardUpdateView(HttpServletRequest httpServletRequest) {
		Map<String, Object> map = new HashMap<String,Object>();
		
		int boardNum = Integer.parseInt(httpServletRequest.getParameter("boardNum"));
		map.put("boardNum", boardNum);
		ModelAndView mv = new ModelAndView();
		
		Map<String,Object> rtnMap = boardService.boardUpateView(map);
		mv.addObject("rtnMap", rtnMap);
		return mv;
	}
	
	@RequestMapping(value="/boardUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(HttpServletRequest httpServletRequest) {
		Map<String, Object> map = new HashMap<String,Object>();
		
		int boardNum = Integer.parseInt(httpServletRequest.getParameter("boardNum"));
		String title = httpServletRequest.getParameter("title");
		String contents= httpServletRequest.getParameter("contents");
		
		map.put("boardNum", boardNum);
		map.put("title", title);
		map.put("contents", contents);
		
		boardService.boardUpdate(map);
		ModelAndView mv = new ModelAndView("redirect:/boardList/");
		
		return mv;
	}
	
}
