package com.test.myapp.board.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface UserService {
	
	//1. 회원 조회
	boolean CheckUserService(Map<String, Object> map);	
	//2. 회원 로그인
	boolean LoginUserService(Map<String, Object> map, HttpSession session);
	
	//3 회원 중복 확인
	boolean DuplicateUserService(String userid);
	
	//4. 회원 가입
	boolean InsertUserService(Map<String, Object> map);
	
	//5. 로그아웃
	void LogoutService(HttpSession session);
}
