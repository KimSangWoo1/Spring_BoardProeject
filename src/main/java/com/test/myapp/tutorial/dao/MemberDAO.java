package com.test.myapp.tutorial.dao;

import com.test.myapp.tutorial.vo.MemberVO;

public interface MemberDAO {

	//현재시간체크
		public String getTime();
		//회원 입력
		public void insertMember(MemberVO memberVO);
		//회원 아이디로 조회
		public MemberVO readMember(String userid) throws Exception;
		//회원아이디, 비밀번호 조회
		public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
