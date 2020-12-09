package com.test.myapp;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO {
	Logger log = Logger.getLogger(this.getClass().toString());
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
			
		return sqlSession.selectList("board.selectBoardList",map);
	}

}
