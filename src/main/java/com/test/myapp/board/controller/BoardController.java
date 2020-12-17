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

@Controller
public class BoardController {
	Logger log = Logger.getLogger(this.getClass().toGenericString());

	//DB Servcie
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping("board/boardList.do")
	   public ModelAndView openBoardList(Map<String, Object>map)throws Exception{
	      ModelAndView mv = new ModelAndView("/jsp/board/boardList");
	      
	      List<Map<String, Object>> list = boardService.selectBoardList(map);
	      mv.addObject("list",list);
	      return mv;
	   }
	
	//�Խñ� �ۼ� �������� �̵�
	@RequestMapping("board/boardWrite.do")
	public ModelAndView boardWrite(Map<String,Object> map) throws Exception{
		ModelAndView mv = new ModelAndView("/jsp/board/boardWrite");
		return mv;
	}
	
	//�Խñ� �ۼ� ��ư Ŭ�� -> �Խ��� DB�� ����
	@RequestMapping(value="board/boardInsert.do", method =RequestMethod.POST)
	@ResponseBody
	public ModelAndView boardInsert(HttpServletRequest request) throws Exception {
		log.info("�Խñ� �ۼ� �Ϸ�");
					
		HttpSession session = request.getSession();
		String create_id = session.getAttribute("userid").toString();
		
		ModelAndView mv;
		//���� ����
		if(create_id==null) {
			mv= new ModelAndView("redirect:login.do/");	
		}
		//�Խñ� �ۼ� ����
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
			boardService.boardInsert(map);

		}
		return mv;
	}
	//�Խñ� �� �������� �̵�
	@RequestMapping(value="board/boardUpdateView.do", method = RequestMethod.GET)
	public ModelAndView boardUpdateView(@RequestParam("no") int no) {
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("idx", no);
		ModelAndView mv = new ModelAndView("/jsp/board/boardUpdateView");
		
		Map<String,Object> rtnMap = boardService.boardUpateView(map);
		log.info(rtnMap.get("title").toString());
		mv.addObject("rtnMap", rtnMap);
		return mv;
	}
	//�Խñ� ����
	@RequestMapping(value="board/boardUpdate.do", method = RequestMethod.POST)
	public ModelAndView boardUpdate(HttpServletRequest httpServletRequest) {
		Map<String, Object> map = new HashMap<String,Object>();
		
		int idx = Integer.parseInt(httpServletRequest.getParameter("idx"));
		String title = httpServletRequest.getParameter("title");
		String content= httpServletRequest.getParameter("content");
		
		map.put("idx", idx);
		map.put("title", title);
		map.put("content", content);
		
		boardService.boardUpdate(map);
		ModelAndView mv = new ModelAndView("redirect:board/boardList.do/");
		
		return mv;
	}
	
}
