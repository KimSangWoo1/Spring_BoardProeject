package com.test.myapp;

import java.util.List;
import java.util.Map;

public interface BoardService {
	List<Map<String,Object>> selectBoardList (Map<String,Object> map);
	
	void boardInsert(Map<String,Object>map)throws Exception;

	Map<String, Object> boardUpateView(Map<String, Object> map);

	List<String, Object> boardUpdate(Map<String, Object> map);
}
