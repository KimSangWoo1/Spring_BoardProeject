package com.test.myapp.board.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;

	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		// sql Æú´õ¿¡ namespace : board , id: selectList
		return sqlSession.selectList("board.selectBoardList", map);
	}

	public void boardInsert(Map<String, Object> map) {
		sqlSession.insert("board.boardInsert", map);
	}

	public List<Map<String, Object>> boardUpdate(Map<String, Object> map) {

		return sqlSession.selectList("board.boardUpdate", map);

	}

	public Map<String, Object> boardUpdateView(Map<String, Object> map) {

		return sqlSession.selectOne("board.boardUpdateView", map);
	}

}
