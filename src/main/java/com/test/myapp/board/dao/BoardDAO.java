package com.test.myapp.board.dao;

import java.util.List;
import java.util.Map;

import com.test.myapp.board.util.Pagination;
import com.test.myapp.board.vo.BoardVO;

public interface BoardDAO {

	//1. 게시글 리스트 보기
	List<Map<String, Object>> selectBoardList(Map<String, Object> map);

	//2. 게시글 작성
	void boardInsert(Map<String, Object> map);

	//3. 게시글 상세보기
	Map<String, Object> boardUpdateView(Map<String, Object> map);
	
	//4.게시글 조회수 올리기
	void boardAddHitCount(Map<String, Object> map);
	
	//5. 게시글  총 갯수 가져오기
	int boardAllListCnt();
	
	//6. 게시글 페이징으로 가져오기
	List<BoardVO> boardPaging(Pagination pagination);
	
	/*
	//5. 게시물 수정
	List<Map<String, Object>> boardUpdate(Map<String, Object> map);
	*/
}
