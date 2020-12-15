package com.test.myapp.board.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.myapp.board.dao.UserDAO;
import com.test.myapp.board.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name = "userDAO")
	private UserDAO userDAO;

	// 1. Repository에 데이터 전달 ( 전달 전에 암호화 및 데이터 조작할게 있으면 조작하고 주어야함) ex: 암호화
	@Override
	public boolean CheckUserService(Map<String, Object> map) {
		// 결과값
		boolean result = false;

		UserVO userVO = new UserVO();
		String userid = map.get("id").toString();
		String userpw = map.get("pw").toString();
		userVO.setUserid(userid);
		userVO.setUserpw(userpw);

		userVO = userDAO.CheckUser(userVO);
		if(userVO!=null) {
			int no = userVO.getUserno();
			System.out.println("결과 : " + no);
			if (no != 0) {
				result = true;
			}	
		}
		return result;
	}

	@Override
	public boolean InsertUserService(Map<String, Object> map) {
		boolean result = false;
		
		UserVO userVO = new UserVO();
		String userid = map.get("id").toString();
		String userpw = map.get("pw").toString();
		userVO.setUserid(userid);
		userVO.setUserpw(userpw);
		
		int insertResult = userDAO.InsertUser(userVO);
		
		if(insertResult>0) {
			result= true;
		}else {
			result = false;
		}
		return result;
	}


}
