package com.test.myapp.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.board.service.BoardService;

@Controller
public class BoardController {
	Logger log = Logger.getLogger(this.getClass().toGenericString());

	//DB Servcie
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping("/boardList")
	   public ModelAndView openBoardList(Map<String, Object>map)throws Exception{
	      ModelAndView mv = new ModelAndView("/board/boardList");
	      
	      List<Map<String, Object>> list = boardService.selectBoardList(map);
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
									@RequestParam("content") String content,HttpServletRequest request) throws Exception {
		log.info("게시글 작성 완료");
		HttpSession session = request.getSession();
	
		String create_id = session.getAttribute("userid").toString();
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("title", title);
		map.put("content", content);
		map.put("create_id", create_id);
		
		log.info(title);
		log.info(content);
		boardService.boardInsert(map);
		
		ModelAndView mv= new ModelAndView("redirect:/boardList/");
		
		
		return mv;
	}
	
	@RequestMapping(value="/boardUpdateView", method = RequestMethod.GET)
	public ModelAndView boardUpdateView(@RequestParam("no") int no) {
		Map<String, Object> map = new HashMap<String,Object>();
		
	
		map.put("idx", no);
		ModelAndView mv = new ModelAndView("/board/boardUpdateView");
		
		Map<String,Object> rtnMap = boardService.boardUpateView(map);
		log.info(rtnMap.get("title").toString());
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
