package com.test.myapp;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO {
	Logger log = Logger.getLogger(this.getClass().toString());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		//sql Æú´õ¿¡ namespace : board , id: 	 selectList
		return sqlSession.selectList("board.selectBoardList",map);
	}

	public void boardInsert(Map<String, Object> map) {
		sqlSession.insert("board.boardInsert",map);
	}

	public List<String, Object> boardUpdate(Map<String, Object> map) {

		return sqlSession.selectList("board.boardUpdate",map);
			
	}

	public Map<String, Object> boardUpdateView(Map<String, Object> map) {

		return sqlSession.selectMap("board.boardUpdateView", (String) map.get("boardNum"));
	}

}
