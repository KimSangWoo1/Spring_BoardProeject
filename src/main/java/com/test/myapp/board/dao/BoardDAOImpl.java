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

	//1.�Խñ� ����Ʈ ����
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		// sql ������ namespace : board , id: selectList
		return sqlSession.selectList("board.selectBoardList", map);
	}
	
	//2.�Խñ� �ۼ�
	public void boardInsert(Map<String, Object> map) {
		sqlSession.insert("board.boardInsert", map);
	}

	//3.�Խñ� �� ����
	public BoardVO boardUpdateView(int idx) {

		return sqlSession.selectOne("board.boardUpdateView", idx);
	}
	
	//4.�Խñ� ��ȸ�� �ø���
	@Override
	public void boardAddHitCount(BoardVO boardVO) {
		sqlSession.selectOne("board.boardAddHitCount", boardVO);
	}

	//5. �Խñ� �� ���� ��������
	@Override
	public int boardAllListCnt() {	
		return sqlSession.selectOne("board.boardListSize");
	}

	@Override
	public List<BoardVO> boardPaging(Pagination pagination) {
		System.out.println("�Խñ� ù ��ȣ :"+pagination.getStartIndex());
		System.out.println("������ Size :"+pagination.getPageSize());
		System.out.println("������ ��ȣ :"+pagination.getCurPage());
		return sqlSession.selectList("board.boardPagingList",pagination);
	}

	@Override
	public void boardDelete(int idx) {
		sqlSession.delete("board.boardDelete",idx);
	}
	
	//8.�Խñ� ����
	@Override
	public void boardUpdate(BoardVO boardVO) {
		sqlSession.update("board.boardUpdate", boardVO);
	}
	

}
