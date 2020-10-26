package com.ict.ex02;

public class MariaDAO implements DAO{
	public MariaDAO() {
		System.out.println("마리아 생성자");
	}
	@Override
	public void prn() {
		System.out.println("마리아 메소드");
	}
}
