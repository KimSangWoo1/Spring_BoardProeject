package com.test.myapp;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.myapp.tutorial.dao.MemberDAO;
import com.test.myapp.tutorial.vo.MemberVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOTest {

	@Autowired
	private MemberDAO memberDAO;
	
	//����ð� ��� �׽�Ʈ
	@Test
	public void testTime() throws Exception{
		System.out.println(memberDAO.getTime());
	}
	
	//ȸ�� ���� �׽�Ʈ
	@Test
	public void testInsertMember() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setUserid("user00");
		memberVO.setUserpw("user00");
		memberVO.setUsername("user00");
		memberVO.setEmail("user00@mail.com");
		
		memberDAO.insertMember(memberVO);
	}
	
	//ȸ�� ��ȸ �׽�Ʈ 1: ���̵�
	@Test
	public void testReadMember() throws Exception{
		memberDAO.readMember("user00");
	}
	
	//ȸ����ȸ �׽�Ʈ 2: ���̵� + ��й�ȣ
	@Test
	public void testReadWithPW() throws Exception{
		memberDAO.readWithPW("user00", "user00");
	}
}
