package com.test.myapp.board.dao;

import java.util.List;
import java.util.Map;

import com.test.myapp.board.util.Pagination;
import com.test.myapp.board.vo.BoardVO;

public interface BoardDAO {

	//1. �Խñ� ����Ʈ ����
	List<Map<String, Object>> selectBoardList(Map<String, Object> map);

	//2. �Խñ� �ۼ�
	void boardInsert(BoardVO boardVO);

	//3. �Խñ� �󼼺���
	BoardVO boardDetailView(int idx);
	
	//4.�Խñ� ��ȸ�� �ø���
	void boardAddHitCount(BoardVO boardVO);
	
	//5. �Խñ�  �� ���� ��������
	int boardAllListCnt();
	
	//6. �Խñ� ����¡���� ��������
	List<BoardVO> boardPaging(Pagination pagination);
	
	//7. �Խñ� ����
	void boardDelete(int idx);
	
	//8. �Խù� ����
	void boardUpdate(BoardVO boardVO);
	
	//9. 마지막 게시글 idx 가져오기
	int selectLastBoardNo();
	
}
