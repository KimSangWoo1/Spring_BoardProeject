package com.test.myapp.board.service;

import java.util.List;
import java.util.Map;

import com.test.myapp.board.util.Pagination;
import com.test.myapp.board.vo.BoardVO;

public interface BoardService {
	//1. 게시글 리스트 보기
	List<Map<String,Object>> selectBoardListService (Map<String,Object> map);
	//2. 게시글 작성
	void boardInsertService(Map<String,Object>map)throws Exception;
	//3. 게시글 상세보기
	BoardVO boardUpateViewService(int idx);
	//4. 게시글 조회수 올리기
	void boardAddHitCountService(BoardVO boardVO);
	//5. 게시물 총 갯수 가져오기
	int boardListCnt();
	//6. 게시글 페이징으로 가져오기
	List<BoardVO> BoardPagingService(Pagination pagination);
	
	/*
	//5. 게시글 수정
	List<Map<String, Object>> boardUpdateService(Map<String, Object> map);
	*/
}
