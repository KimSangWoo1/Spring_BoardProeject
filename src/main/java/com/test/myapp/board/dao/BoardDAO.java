package com.test.myapp.board.dao;

import java.util.List;
import java.util.Map;

import com.test.myapp.board.util.Pagination;
import com.test.myapp.board.vo.BoardVO;

public interface BoardDAO {

	//1. �Խñ� ����Ʈ ����
	List<Map<String, Object>> selectBoardList(Map<String, Object> map);

	//2. �Խñ� �ۼ�
	void boardInsert(Map<String, Object> map);

	//3. �Խñ� �󼼺���
	BoardVO boardUpdateView(int idx);
	
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
	
}
