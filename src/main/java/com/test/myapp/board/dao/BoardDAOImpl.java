package com.test.myapp.board.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;

	//1.�Խñ� ����Ʈ ����
	public List<Map<String, Object>> SelectBoardList(Map<String, Object> map) {
		// sql ������ namespace : board , id: selectList
		return sqlSession.selectList("board.selectBoardList", map);
	}
	
	//2.�Խñ� �ۼ�
	public void BoardInsert(Map<String, Object> map) {
		sqlSession.insert("board.boardInsert", map);
	}

	//3.�Խñ� �� ����
	public Map<String, Object> BoardUpdateView(Map<String, Object> map) {

		return sqlSession.selectOne("board.boardUpdateView", map);
	}
	
	//4.�Խñ� ��ȸ�� �ø���
	@Override
	public void BoardAddHitCount(Map<String, Object> map) {
		sqlSession.selectOne("board.boardAddHitCount", map);
	}

	//5. �Խñ� �� ���� ��������
	@Override
	public int BoardAllListCnt() {	
		return sqlSession.selectOne("board.boardListSize");
	}
	
	
	/*
	//5.�Խñ� ����
	@Override
	public List<Map<String, Object>> boardUpdate(Map<String, Object> map) {
		return sqlSession.selectList("board.boardUpdate", map);
	}
	*/

}
