package com.test.myapp.board.dao;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.test.myapp.board.vo.UserVO;

public interface UserDAO {

	//1.ȸ�� ���̵� ��й�ȣ ��ȸ
	UserVO CheckUser(UserVO userVO);

	//2. ȸ�� �ߺ� Ȯ��
	boolean DuplicateUser(String userid);
	
	//3. ȸ�� ����
	int InsertUser(UserVO userVO);

	//4.�α׾ƿ�
	void Logout(HttpSession session);

}
