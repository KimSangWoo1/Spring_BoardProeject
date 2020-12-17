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
			System.out.println(connection); // java Application 실행 시 콘솔 출력 ex) org.mariadb.jdbc.MariaDbConnection@1dd92fe2
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

/*  # JUnit 기본사항
 	@Test : 테스트할 내용을 메서드 안에 작성하고 @Test 어노테이션을 추가하면 테스트용 코드로 간주하고 테스트를 진행
 	@Before : 모든 테스트 작업에 앞서 준비되어야 하는 내용을 작성해서 메서드에 추가하는 어노테이션
 	@After : 테스트 작업이 끝난 후 자동으로 실행되는 메소드에 추가하는 어노테이션
 	org.junit.Assert.assertxxx : 테스트 중에 발생되는 값을 확신하는 용도로  테스트 중강네 특정 값이나 상태를 예상하고, 체크하는 용도 
 */
