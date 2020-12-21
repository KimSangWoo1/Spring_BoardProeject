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
	public BoardVO boardUpateViewService(int idx) {

		 //게시글 정보 가져오기 
		 BoardVO boardVO = boardDAO.boardUpdateView(idx);
		 //조회수 올리기
		 boardAddHitCountService(boardVO);

		//DB에서 가져온 게시글 정보 컨트롤러로 보내기
		return boardVO;
	}
	
	//4. 조회수 올리기
	@Override
	public void boardAddHitCountService(BoardVO boardVO) {
	
		//조회수 가져오기
		int hit_count = boardVO.getHit_count();
		//조회수 +1 업데이트 하기
		boardVO.setHit_count(hit_count+1);
		boardDAO.boardAddHitCount(boardVO);
	}
	
	//5. 게시글 총 갯수 가져오기
	@Override
	public int boardListCnt() {
		return boardDAO.boardAllListCnt();
	}

	//6. 게시글 페이징으로 가져오기
	@Override
	public List<BoardVO> boardPagingService(Pagination pagination) {

		return boardDAO.boardPaging(pagination);
	}
	//7. 게시판 삭제
	@Override
	public void boardDeleteService(int idx) {
		boardDAO.boardDelete(idx);
	}
	
	

	/*
	//5.게시글 수정
	@Override
	public List<Map<String, Object>> boardUpdateService(Map<String, Object> map) {
		return (List<Map<String, Object>>) boardDAO.boardUpdateView(map);
	}
	*/
	
}
