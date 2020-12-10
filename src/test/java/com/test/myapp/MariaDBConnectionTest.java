package com.test.myapp;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MariaDBConnectionTest {
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3306/spring";
	private static String USER = "ksw" ;
	private static String PASSWORD = "1234";

	@Test
	public void TestConnection() throws Exception{
		Class.forName(DRIVER);
		try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)){
			System.out.println(connection); // java Application ���� �� �ܼ� ��� ex) org.mariadb.jdbc.MariaDbConnection@1dd92fe2
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

/*  # JUnit �⺻����
 	@Test : �׽�Ʈ�� ������ �޼��� �ȿ� �ۼ��ϰ� @Test ������̼��� �߰��ϸ� �׽�Ʈ�� �ڵ�� �����ϰ� �׽�Ʈ�� ����
 	@Before : ��� �׽�Ʈ �۾��� �ռ� �غ�Ǿ�� �ϴ� ������ �ۼ��ؼ� �޼��忡 �߰��ϴ� ������̼�
 	@After : �׽�Ʈ �۾��� ���� �� �ڵ����� ����Ǵ� �޼ҵ忡 �߰��ϴ� ������̼�
 	org.junit.Assert.assertxxx : �׽�Ʈ �߿� �߻��Ǵ� ���� Ȯ���ϴ� �뵵��  �׽�Ʈ �߰��� Ư�� ���̳� ���¸� �����ϰ�, üũ�ϴ� �뵵 
 */
