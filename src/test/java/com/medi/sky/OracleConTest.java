package com.medi.sky;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class OracleConTest {
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "medical";
	private static final String pw = "1234";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		try(Connection con = DriverManager.getConnection(URL, USER, pw)) {
			log.info(con);
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
