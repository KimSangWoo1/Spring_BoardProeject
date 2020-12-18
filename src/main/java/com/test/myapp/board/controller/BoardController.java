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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.board.service.BoardService;
import com.test.myapp.board.util.Pagination;

@Controller
public class BoardController {
	Logger log = Logger.getLogger(this.getClass().toGenericString());

	//DB Servcie
	@Resource(name="boardService")
	private BoardService boardService;
	
	//1.게시글 목록 페이지 이동
	@RequestMapping("board/boardList.do")
	   public ModelAndView BoardList(Map<String, Object>map)throws Exception{
	      ModelAndView mv = new ModelAndView("/jsp/board/boardList");
	      
	      List<Map<String, Object>> list = boardService.SelectBoardListService(map);
	      mv.addObject("list",list);
	      return mv;
	}
	
	//2.게시글 작성 페이지로 이동
	@RequestMapping("board/boardWrite.do")
	public ModelAndView BoardWrite(Map<String,Object> map) throws Exception{
		ModelAndView mv = new ModelAndView("/jsp/board/boardWrite");
		return mv;
	}
	
	//3.게시글 작성 버튼 클릭 -> 게시판 DB에 삽입
	@RequestMapping(value="board/boardInsert.do", method =RequestMethod.POST)
	@ResponseBody
	public ModelAndView BoardInsert(HttpServletRequest request) throws Exception {
		log.info("게시글 작성 완료");
					
		HttpSession session = request.getSession();
		String create_id = session.getAttribute("userid").toString();
		
		ModelAndView mv;
		//세션 만료
		if(create_id==null) {
			mv= new ModelAndView("redirect:login.do/");	
		}
		//게시글 작성 진행
		else {
			mv= new ModelAndView("redirect:boardList.do/");	
			Map<String,Object> map = new HashMap<String,Object>();
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			map.put("title", title);
			map.put("content", content);
			map.put("create_id", create_id);
			
			log.info(title);
			log.info(content);
			boardService.BoardInsertService(map);

		}
		return mv;
	}
	//4.게시글 상세 페이지로 이동
	@RequestMapping(value="board/boardDetailView.do", method = RequestMethod.GET)
	public ModelAndView boardDetailView(@RequestParam("idx") int idx) {
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("idx", idx);
		ModelAndView mv = new ModelAndView("/jsp/board/boardDetailView");

		Map<String,Object> rtnMap = boardService.BoardUpateViewService(map);
		mv.addObject("rtnMap", rtnMap);
		return mv;
	}
	
	
	//5.게시글 뷰페이징
		@RequestMapping(value="board/boardPagingList.do", method = RequestMethod.GET)
		   public ModelAndView BoardPagingList(@RequestParam(defaultValue="1") int curPage)throws Exception{
		      ModelAndView mv = new ModelAndView("/jsp/board/boardViewPaging");
		      
		      
		      //1. 총게시물 수 가져오기
		      int listCnt = boardService.BoardListCnt();
		      //2 페이징 셋팅하기
		      Pagination pagination = new Pagination(20,curPage);
		      
		      
		      //3. 모델 전송과 뷰 선택하기
	
		      return mv;
		}
	/*
	//게시글 수정
	@RequestMapping(value="board/boardUpdate.do", method = RequestMethod.POST)
	public ModelAndView boardUpdate(HttpServletRequest httpServletRequest) {
		Map<String, Object> map = new HashMap<String,Object>();
		
		int idx = Integer.parseInt(httpServletRequest.getParameter("idx"));
		String title = httpServletRequest.getParameter("title");
		String content= httpServletRequest.getParameter("content");
		
		map.put("idx", idx);
		map.put("title", title);
		map.put("content", content);
		
		boardService.BoardUpdate(map);
		ModelAndView mv = new ModelAndView("redirect:board/boardList.do/");
		
		return mv;
	}
	*/
		
	
}
