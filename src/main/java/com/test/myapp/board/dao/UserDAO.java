package com.test.myapp.board.dao;

import java.util.Map;

import com.test.myapp.board.vo.UserVO;

public interface UserDAO {

	//1.ȸ�� ���̵� ��й�ȣ ��ȸ
	UserVO CheckUser(UserVO userVO);

	//2. ȸ�� ����
	int InsertUser(UserVO userVO);
}
