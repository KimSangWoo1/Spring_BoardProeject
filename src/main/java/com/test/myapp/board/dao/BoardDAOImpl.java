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
	public void boardInsert(BoardVO boardVO) {
		//group_no 값 넣어주기
		boardVO.setGroup_no(selectLastBoardNo()+1);
		sqlSession.insert("board.boardInsert", boardVO);
	}

	//3.�Խñ� �� ����
	public BoardVO boardDetailView(int idx) {

		return sqlSession.selectOne("board.boardDetailView", idx);
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
	//9. 마지막 게시글 idx 가져오기
	@Override
	public int selectLastBoardNo() {
		return sqlSession.selectOne("board.lastBoardNO");
	}
	//10. 게시글 답글 준비 ( group_order , depth 값 져오기)
	@Override
	public BoardVO boardReplyReady(int idx) {
		return sqlSession.selectOne("board.boardReplyReady",idx);
	}
	//11.게시글 답글 달기 전  group_order의  마지막 값 조회 
	@Override
	public int boardLastGroupOrder(int idx) {
		return sqlSession.selectOne("board.boardLastGroupOrder",idx);
	}
	//12. 게시글 답글 달기
	@Override
	public void boardReply(BoardVO boardVO) {
		sqlSession.insert("board.boardReply",boardVO);
	}
	//13. 게시글 답 답글 달기전 다음 답글에 order 값을 찾는다.
	@Override
	public int boardNextGroupOrder(BoardVO boardVO) {
		return sqlSession.selectOne("board.boardNextGroupOrder", boardVO);
	}
	//14. 게시글 답 답글 작성시 order값 변동 될 것들 수정하기
	@Override
	public void boardAddGroupOrder(BoardVO boardVO) {
		sqlSession.update("board.boardAddGroupOrder",boardVO);
	}

	//15. 게시글 삭제 전 준비
	@Override
	public BoardVO boardDeleteReady(int idx) {
		return sqlSession.selectOne("board.boardDeleteReady",idx);
	}
	//16. 게시글 원글이 아닐 경우 order 값 수정
	@Override
	public void boardSubGroupOrder(BoardVO boardVO) {
		sqlSession.update("board.boardSubGroupOrder", boardVO);
	}

}
