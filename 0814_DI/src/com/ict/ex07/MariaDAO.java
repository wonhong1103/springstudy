package com.ict.ex07;

public class MariaDAO implements DAO{
	public MariaDAO() {
		System.out.println("MariaDAO 생성자");
	}
	
	@Override
	public void prn() {
		System.out.println("MariaDAO 실행 메소드");
	}
}
