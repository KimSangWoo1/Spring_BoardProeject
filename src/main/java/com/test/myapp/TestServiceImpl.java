package com.test.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestServiceImpl implements TestService {
	@Autowired
	TestDAO testDAO;
	
	@Override
	public List<TestVO> getTestValue(TestVO testVo){
		return testDAO.getTestValue(testVo);
	}

}
