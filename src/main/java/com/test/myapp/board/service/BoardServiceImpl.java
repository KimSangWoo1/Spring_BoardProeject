package com.test.myapp.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.myapp.board.dao.BoardDAO;
import com.test.myapp.board.util.Pagination;
import com.test.myapp.board.vo.BoardVO;


@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	//1.게시글 리스트 보기
	@Override
	public List<Map<String, Object>> selectBoardListService(Map<String, Object> map) {
		return boardDAO.selectBoardList(map);
	}

	//2. 게시글 작성
	@Override
	public void boardInsertService(Map<String, Object> map) throws Exception {
		 boardDAO.boardInsert(map);
	}

	//3. 게시글 상세보기
	@Override
	public Map<String, Object> boardUpateViewService(Map<String, Object> map) {

		//게시글 정보 가져오기 
		 Map<String, Object> resultMap = boardDAO.boardUpdateView(map);
		 //조회수 올리기
		 boardAddHitCountService(resultMap);

		//DB에서 가져온 게시글 정보 컨트롤러로 보내기
		return resultMap;
	}
	
	//4. 조회수 올리기
	@Override
	public void boardAddHitCountService(Map<String, Object> map) {
	
		//조회수 가져오기
		int hit_count = (int) map.get("hit_count");
		//조회수 +1 업데이트 하기
		map.put("hit_count", hit_count+1);
		boardDAO.boardAddHitCount(map);
	}
	
	//5. 게시글 총 갯수 가져오기
	@Override
	public int boardListCnt() {
		return boardDAO.boardAllListCnt();
	}

	//6. 게시글 페이징으로 가져오기
	@Override
	public List<BoardVO> BoardPagingService(Pagination pagination) {

		return boardDAO.boardPaging(pagination);
	}
	
	//6. 게시글 페이징으로 가져오기
	

	

	/*
	//5.게시글 수정
	@Override
	public List<Map<String, Object>> boardUpdateService(Map<String, Object> map) {
		return (List<Map<String, Object>>) boardDAO.boardUpdateView(map);
	}
	*/
	
}
