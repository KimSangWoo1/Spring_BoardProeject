package com.test.myapp.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.board.interceptor.LoginInterceptor;
import com.test.myapp.board.service.BoardService;
import com.test.myapp.board.util.Pagination;
import com.test.myapp.board.vo.BoardVO;

@Controller
public class BoardController {
	Logger log = Logger.getLogger(this.getClass().toGenericString());

	//DB Servcie
	@Resource(name="boardService")
	private BoardService boardService;
	
	//1.�Խñ� ��� ������ �̵�
	@RequestMapping("board/boardList.do")
	   public ModelAndView boardList(Map<String, Object>map)throws Exception{
	      ModelAndView mv = new ModelAndView("/jsp/board/boardList");
	      
	      List<Map<String, Object>> list = boardService.selectBoardListService(map);
	      mv.addObject("list",list);
	      return mv;
	}
	
	//2.�Խñ� �ۼ� �������� �̵�
	@RequestMapping("board/boardWrite.do")
	public ModelAndView BoardWrite(Map<String,Object> map) throws Exception{
		ModelAndView mv = new ModelAndView("/jsp/board/boardWrite");
		return mv;
	}
	
	//3.�Խñ� �ۼ� ��ư Ŭ�� -> �Խ��� DB�� ����
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
			boardService.boardInsertService(map);

		}
		return mv;
	}
	//4.�Խñ� �� �������� �̵�
	@RequestMapping(value="board/boardDetailView.do", method = RequestMethod.GET)
	public ModelAndView boardDetailView(HttpServletRequest request, @RequestParam int idx ,@RequestParam(defaultValue = "1") int curPage ,@RequestParam(required = false ,defaultValue = "0")int hit_count) {

		//�ϱ� ���� ��������
		BoardVO boardVO = boardService.boardUpateViewService(idx);
		if(hit_count!=0) {
			boardService.boardAddHitCountService(boardVO);
		}
		

		//���ǿ� ����� ���̵��  �ϱ� �ۼ��� �񱳸� ����  ���� ���̵� ��������
		
		ModelAndView mv = new ModelAndView("/jsp/board/boardDetailView");
		mv.addObject("boardVO", boardVO);
		mv.addObject("curPage",curPage);
		
		HttpSession session = request.getSession();
		String session_id = (String) session.getAttribute("userid");
		String user_id = boardVO.getCreate_id();
		
		//���� �������� ��
		boolean edit;
		if(session_id.equals(user_id)) {
			edit = true;
		}else {
			edit = false;
		}
		
		mv.addObject("edit", edit);
		
		return mv;
	}
	
	
	//5.�Խñ� ������¡
	@RequestMapping(value = "board/boardPagingList.do", method = RequestMethod.GET)
	public ModelAndView boardPagingList(@RequestParam(defaultValue = "1") int curPage) throws Exception {
		ModelAndView mv = new ModelAndView("/jsp/board/boardViewPaging");

		// 1. �ѰԽù� �� ��������
		int listCnt = boardService.boardListCnt();
		// 2 ����¡ �����ϱ�
		Pagination pagination = new Pagination(listCnt, curPage);
		// 3. �Խñ� ����¡���� ��������
		List<BoardVO> boardList = boardService.boardPagingService(pagination);
		for (BoardVO board : boardList) {
			System.out.println(board.getTitle());
		}
		// 4. �� ���۰� �� �����ϱ�
		mv.addObject("boardList", boardList);
		mv.addObject("pagination", pagination);
		return mv;
	}
	
	//6. �Խ��� ����
	@RequestMapping(value = "board/boardDelete.do", method = RequestMethod.GET)
	public ModelAndView boardDelete(@RequestParam int idx, @RequestParam int curPage) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:boardPagingList.do?curpage="+curPage);
		boardService.boardDeleteService(idx);
		return mv;
	}
		
	//7. �Խñ� ����
	@RequestMapping(value="board/boardUpdateView.do", method = RequestMethod.GET)
	public ModelAndView boardUpdateView(@RequestParam int idx, @RequestParam int curPage) throws Exception {

		BoardVO boardVO = boardService.boardUpateViewService(idx);
		
		ModelAndView mv = new ModelAndView("/jsp/board/boardUpdateView");
		mv.addObject("curPage",curPage);
		mv.addObject("boardVO",boardVO);
		return mv;
	}
	//8. 게시글 수정 완료
	@RequestMapping(value="board/boardUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView boardUpdate(BoardVO boardVO, Pagination pagination) throws Exception {
		
		boardService.boardUpdateService(boardVO);
		
		int idx = boardVO.getIdx();
		int curPage = pagination.getCurPage();
		ModelAndView mv = new ModelAndView("redirect:boardDetailView.do?idx="+idx+"&curPage="+curPage);	
		return mv;
	}
	
}
