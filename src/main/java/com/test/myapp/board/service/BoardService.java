package com.test.myapp.board.service;

import java.util.List;
import java.util.Map;

import com.test.myapp.board.util.Pagination;
import com.test.myapp.board.vo.BoardVO;

public interface BoardService {
	//1. �Խñ� ����Ʈ ����
	List<Map<String,Object>> selectBoardListService (Map<String,Object> map);
	//2. �Խñ� �ۼ�
	void boardInsertService(Map<String,Object>map)throws Exception;
	//3. �Խñ� �󼼺���
	BoardVO boardUpateViewService(int idx);
	//4. �Խñ� ��ȸ�� �ø���
	void boardAddHitCountService(BoardVO boardVO);
	//5. �Խù� �� ���� ��������
	int boardListCnt();
	//6. �Խñ� ����¡���� ��������
	List<BoardVO> BoardPagingService(Pagination pagination);
	
	/*
	//5. �Խñ� ����
	List<Map<String, Object>> boardUpdateService(Map<String, Object> map);
	*/
}
