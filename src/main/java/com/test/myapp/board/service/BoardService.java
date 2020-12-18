package com.test.myapp.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	//1. 게시글 리스트 보기
	List<Map<String,Object>> SelectBoardListService (Map<String,Object> map);
	//2. 게시글 작성
	void BoardInsertService(Map<String,Object>map)throws Exception;
	//3. 게시글 상세보기
	Map<String, Object> BoardUpateViewService(Map<String, Object> map);
	//4. 게시글 조회수 올리기
	void BoardAddHitCountService(Map<String, Object> map);
	
	//5. 게시물 총 갯수 가져오기
	int BoardListCnt();
	/*
	//5. 게시글 수정
	List<Map<String, Object>> boardUpdateService(Map<String, Object> map);
	*/
}
