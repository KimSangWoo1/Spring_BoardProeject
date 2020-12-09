package com.test.myapp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {

		return boardDAO.selectBoardList(map);
	}
	
}
