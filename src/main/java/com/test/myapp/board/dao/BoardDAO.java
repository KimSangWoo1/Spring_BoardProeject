package com.test.myapp.board.dao;

import java.util.List;
import java.util.Map;

public interface BoardDAO {

	//1. 게시글 리스트 보기
	List<Map<String, Object>> selectBoardList(Map<String, Object> map);

	//2. 게시글 작성
	void boardInsert(Map<String, Object> map);

	//3. 게시글 상세보기
	Map<String, Object> boardUpdateView(Map<String, Object> map);
	
	//4.게시글 조회수 올리기
	void boardAddHitCount(Map<String, Object> map);

}
