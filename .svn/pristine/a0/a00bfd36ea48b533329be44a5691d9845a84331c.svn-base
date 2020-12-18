package com.test.myapp.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.myapp.board.dao.BoardDAO;


@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	//1.게시글 리스트 보기
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		return boardDAO.selectBoardList(map);
	}

	//2. 게시글 작성
	@Override
	public void boardInsert(Map<String, Object> map) throws Exception {
		 boardDAO.boardInsert(map);
	}

	//3. 게시글 상세보기
	@Override
	public Map<String, Object> boardUpateView(Map<String, Object> map) {

		//게시글 정보 가져오기 
		 Map<String, Object> map2 = boardDAO.boardUpdateView(map);
		 
		//조회수 올리기
		int hit_count = (int) map2.get("hit_count");
		System.out.println("조회수 : "+hit_count);
		
		map.put("hit_count", hit_count+1);
		boardDAO.boardAddHitCount(map);
		
		//DB에서 가져온 게시글 정보 컨트롤러로 보내기
		return boardDAO.boardUpdateView(map);
	}

	//4.게시글 수정
	@Override
	public List<Map<String, Object>> boardUpdate(Map<String, Object> map) {
		return (List<Map<String, Object>>) boardDAO.boardUpdateView(map);
	}
	
}
