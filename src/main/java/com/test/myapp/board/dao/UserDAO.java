package com.test.myapp.board.dao;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.test.myapp.board.vo.UserVO;

public interface UserDAO {

	//1.회원 아이디 비밀번호 조회
	UserVO CheckUser(UserVO userVO);

	//2. 회원 중복 확인
	boolean DuplicateUser(String userid);
	
	//3. 회원 가입
	int InsertUser(UserVO userVO);

	//4.로그아웃
	void Logout(HttpSession session);

}
