package com.test.myapp.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.myapp.board.vo.UserVO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	//1.회원 아이디 비밀번호 조회 DB에서 데이터 가져오기
	@Override
	public UserVO CheckUser(UserVO userVO) {		
	
		return sqlSession.selectOne("login.CheckUser", userVO);
	}

	@Override
	public int InsertUser(UserVO userVO) {
	
		return sqlSession.insert("login.InsertUser", userVO);
	}

}
