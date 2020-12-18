package com.test.myapp.board.dao;

import java.util.List;
import java.util.Map;

public interface BoardDAO {

	//1. �Խñ� ����Ʈ ����
	List<Map<String, Object>> SelectBoardList(Map<String, Object> map);

	//2. �Խñ� �ۼ�
	void BoardInsert(Map<String, Object> map);

	//3. �Խñ� �󼼺���
	Map<String, Object> BoardUpdateView(Map<String, Object> map);
	
	//4.�Խñ� ��ȸ�� �ø���
	void BoardAddHitCount(Map<String, Object> map);
	
	
	//5. �Խñ�  �� ���� ��������
	int BoardAllListCnt();
	/*
	//5. �Խù� ����
	List<Map<String, Object>> boardUpdate(Map<String, Object> map);
	*/
}
