package com.test.myapp.board.service;

import java.util.Map;

import com.test.myapp.tutorial.vo.MemberVO;

public interface UserService {
	
	//1. ȸ�� �α��� ��ȸ
	boolean CheckUserService(Map<String, Object> map);

	//2. ȸ�� ����
	boolean InsertUserService(Map<String, Object> map);
}
