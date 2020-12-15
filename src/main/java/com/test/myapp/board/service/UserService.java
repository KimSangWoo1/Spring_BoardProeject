package com.test.myapp.board.service;

import java.util.Map;

import com.test.myapp.tutorial.vo.MemberVO;

public interface UserService {
	
	//1. 회원 로그인 조회
	boolean CheckUserService(Map<String, Object> map);

	//2. 회원 가입
	boolean InsertUserService(Map<String, Object> map);
}
