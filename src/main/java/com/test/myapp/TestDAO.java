package com.test.myapp;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
      
      @Autowired
      private SqlSessionTemplate sqlSession;
      
      public List<TestVO> getTestValue(TestVO testVO){
            return sqlSession.selectList("com.hee.heechart.getTestValue", testVO);
      }
}


