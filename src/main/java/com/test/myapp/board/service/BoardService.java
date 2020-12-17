package com.test.myapp.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	//1. 게시글 리스트 보기
	List<Map<String,Object>> selectBoardList (Map<String,Object> map);
	//2. 게시글 작성
	void boardInsert(Map<String,Object>map)throws Exception;
	//3. 게시글 상세보기
	Map<String, Object> boardUpateView(Map<String, Object> map);
	//4. 게시글 수정
	List<Map<String, Object>> boardUpdate(Map<String, Object> map);
}
