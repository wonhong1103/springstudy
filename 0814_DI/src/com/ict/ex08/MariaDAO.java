package com.ict.ex08;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class MariaDAO implements DAO{
	public MariaDAO() {
		System.out.println("MariaDAO 생성자");
	}
	
	@Override
	public void prn() {
		System.out.println("MariaDAO 실행 메소드");
	}
}
