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
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		return boardDAO.selectBoardList(map);
	}

	@Override
	public void boardInsert(Map<String, Object> map) throws Exception {
		boardDAO.boardInsert(map);
	}

	@Override
	public Map<String, Object> boardUpateView(Map<String, Object> map) {
		return boardDAO.boardUpdateView(map);
	}

	@Override
	public List<Map<String, Object>> boardUpdate(Map<String, Object> map) {
		return (List<Map<String, Object>>) boardDAO.boardUpdateView(map);
	}
	
}
