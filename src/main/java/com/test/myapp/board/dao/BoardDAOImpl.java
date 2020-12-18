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

	//1.게시글 리스트 보기
	public List<Map<String, Object>> SelectBoardList(Map<String, Object> map) {
		// sql 폴더에 namespace : board , id: selectList
		return sqlSession.selectList("board.selectBoardList", map);
	}
	
	//2.게시글 작성
	public void BoardInsert(Map<String, Object> map) {
		sqlSession.insert("board.boardInsert", map);
	}

	//3.게시글 상세 보기
	public Map<String, Object> BoardUpdateView(Map<String, Object> map) {

		return sqlSession.selectOne("board.boardUpdateView", map);
	}
	
	//4.게시글 조회수 올리기
	@Override
	public void BoardAddHitCount(Map<String, Object> map) {
		sqlSession.selectOne("board.boardAddHitCount", map);
	}

	//5. 게시글 총 갯수 가져오기
	@Override
	public int BoardAllListCnt() {	
		return sqlSession.selectOne("board.boardListSize");
	}
	
	
	/*
	//5.게시글 수정
	@Override
	public List<Map<String, Object>> boardUpdate(Map<String, Object> map) {
		return sqlSession.selectList("board.boardUpdate", map);
	}
	*/

}
