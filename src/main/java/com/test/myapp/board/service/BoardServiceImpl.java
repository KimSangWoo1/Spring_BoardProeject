package com.test.myapp.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.myapp.board.dao.BoardDAO;
import com.test.myapp.board.util.Pagination;
import com.test.myapp.board.vo.BoardVO;


@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	//1.�Խñ� ����Ʈ ����
	@Override
	public List<Map<String, Object>> selectBoardListService(Map<String, Object> map) {
		return boardDAO.selectBoardList(map);
	}

	//2. �Խñ� �ۼ�
	@Override
	public void boardInsertService(BoardVO boardVO) throws Exception {
		 boardDAO.boardInsert(boardVO);
	}

	//3. �Խñ� �󼼺���
	@Override
	public BoardVO boardDetailViewService(int idx) {
		 //�Խñ� ���� �������� 
		 BoardVO boardVO = boardDAO.boardDetailView(idx);

		//DB���� ������ �Խñ� ���� ��Ʈ�ѷ��� ������
		return boardVO;
	}
	
	//4. ��ȸ�� �ø���
	@Override
	public void boardAddHitCountService(BoardVO boardVO) {
	
		//��ȸ�� ��������
		int hit_count = boardVO.getHit_count();
		//��ȸ�� +1 ������Ʈ �ϱ�
		boardVO.setHit_count(hit_count+1);
		boardDAO.boardAddHitCount(boardVO);
	}
	
	//5. �Խñ� �� ���� ��������
	@Override
	public int boardListCnt() {
		return boardDAO.boardAllListCnt();
	}

	//6. �Խñ� ����¡���� ��������
	@Override
	public List<BoardVO> boardPagingService(Pagination pagination) {

		return boardDAO.boardPaging(pagination);
	}
	//7. �Խ��� ����
	@Override
	public void boardDeleteService(int idx) {
		boardDAO.boardDelete(idx);
	}	
	//8.�Խñ� ����
	@Override
	public void boardUpdateService(BoardVO boardVO) {
		boardDAO.boardUpdate(boardVO);
	}
	//9. 게시글 답글 준비 ( group_order , depth 값 져오기)
	@Override
	public BoardVO boardReplyReadyService(int idx) {
		return boardDAO.boardReplyReady(idx);
	}
	//10. 게시글 답글 달기 전  group_order의  마지막 값 조회 
	@Override
	public int boardLastGroupOrderService(int idx) {
		return boardDAO.boardLastGroupOrder(idx);
	}
	//11. 게시글 답글 달기
	@Override
	public void boardReplyService(BoardVO boardVO) {
		boardDAO.boardReply(boardVO);
	}
	//12. 게시글 답 답글 달기전 다음 답글에 order 값을 찾는다.
	@Override
	public int boardNextGroupOrderService(BoardVO boardVO) {	
		return boardDAO.boardNextGroupOrder(boardVO);
	}
	//13. 게시글 답 답글 작성시 order값 변동 될 것들 수정하기
	@Override
	public void boardAddGroupOrderService(BoardVO boardVO) {
		boardDAO.boardAddGroupOrder(boardVO);
	}
	//14. 게시글 삭제 전 준비
	@Override
	public BoardVO boardDeleteReadyService(int idx) {
		return boardDAO.boardDeleteReady(idx);
	}
	//15. 게시글 원글이 아닐 경우 order 값 수정
	@Override
	public void boardSubGroupOrderService(BoardVO boardVO) {
		boardDAO.boardSubGroupOrder(boardVO);
	}
	
}
