package com.test.myapp.board.service;

import java.util.List;
import java.util.Map;

import com.test.myapp.board.util.Pagination;
import com.test.myapp.board.vo.BoardVO;

public interface BoardService {
	//1. �Խñ� ����Ʈ ����
	List<Map<String,Object>> selectBoardListService (Map<String,Object> map);
	//2. �Խñ� �ۼ�
	void boardInsertService(BoardVO boardVO)throws Exception;
	//3. �Խñ� �󼼺���
	BoardVO boardDetailViewService(int idx);
	//4. �Խñ� ��ȸ�� �ø���
	void boardAddHitCountService(BoardVO boardVO);
	//5. �Խù� �� ���� ��������
	int boardListCnt();
	//6. �Խñ� ����¡���� ��������
	List<BoardVO> boardPagingService(Pagination pagination);
	//7. �Խ��� ����
	void boardDeleteService(int idx);
	//8. �Խñ� ����
	void boardUpdateService(BoardVO boardVO);
	//9. 게시글 답글 준비 ( group_order , depth 값 져오기)
	BoardVO boardReplyReadyService(int idx);
	//10. 게시글 답글 달기 전  group_order의  마지막 값 조회 
	int boardLastGroupOrderService(int idx);
	//11. 게시글 답글 달기
	void boardReplyService(BoardVO boardVO);
	//12. 게시글 답 답글 달기전 depth 기준으로 group_order 마지막 값 조회
	int boardNextGroupOrderService(BoardVO boardVO);
	//13. 게시글 답 답글 작성시 order값 변동 될 것들 수정하기
	void boardAddGroupOrderService(BoardVO boardVO);
	//14. 게시글 삭제 전 준비
	BoardVO boardDeleteReadyService(int idx);
	//15. 게시글 원글이 아닐 경우 order 값 수정
	void boardSubGroupOrderService(BoardVO boardVO);
}
