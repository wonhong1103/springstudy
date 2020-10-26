package com.ict.ex08;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("oracle")
public class OracleDAO implements DAO {
	public OracleDAO() {
		System.out.println("OracleDAO 생성자");
	}
	@Override
	public void prn() {
		System.out.println("OracleDAO 실행 메소드");
	}
}
