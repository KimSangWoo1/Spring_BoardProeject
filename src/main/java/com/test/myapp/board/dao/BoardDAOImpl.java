package com.test.myapp.board.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.myapp.board.util.Pagination;
import com.test.myapp.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;

	//1.게시글 리스트 보기
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		// sql 폴더에 namespace : board , id: selectList
		return sqlSession.selectList("board.selectBoardList", map);
	}
	
	//2.게시글 작성
	public void boardInsert(Map<String, Object> map) {
		sqlSession.insert("board.boardInsert", map);
	}

	//3.게시글 상세 보기
	public BoardVO boardUpdateView(int idx) {

		return sqlSession.selectOne("board.boardUpdateView", idx);
	}
	
	//4.게시글 조회수 올리기
	@Override
	public void boardAddHitCount(BoardVO boardVO) {
		sqlSession.selectOne("board.boardAddHitCount", boardVO);
	}

	//5. 게시글 총 갯수 가져오기
	@Override
	public int boardAllListCnt() {	
		return sqlSession.selectOne("board.boardListSize");
	}

	@Override
	public List<BoardVO> boardPaging(Pagination pagination) {
		System.out.println("게시글 첫 번호 :"+pagination.getStartIndex());
		System.out.println("페이지 Size :"+pagination.getPageSize());
		System.out.println("페이지 번호 :"+pagination.getCurPage());
		return sqlSession.selectList("board.boardPagingList",pagination);
	}

	@Override
	public void boardDelete(int idx) {
		sqlSession.delete("board.boardDelete",idx);
	}
	
	/*
	//5.게시글 수정
	@Override
	public List<Map<String, Object>> boardUpdate(Map<String, Object> map) {
		return sqlSession.selectList("board.boardUpdate", map);
	}
	*/

}
