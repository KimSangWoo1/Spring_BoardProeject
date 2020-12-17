package com.test.myapp.tutorial.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.myapp.tutorial.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public String getTime() {
		return sqlSession.selectOne("tutorial.getTime");
	}

	@Override
	public void insertMember(MemberVO memberVO) {
		sqlSession.insert("tutorial.insertMember",memberVO);
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		return sqlSession.selectOne("tutorial.selectMember",userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		Map<String,Object> paraMap = new HashMap<>();
		paraMap.put("userid", userid);
		paraMap.put("userpw", userpw);
		return sqlSession.selectOne("tutorial.readWithPW");
	}
}
