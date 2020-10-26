package com.ict.ex01;

public class TestMain {
	public static void main(String[] args) {
		// service.biz() 안에 dao는 인터페이스 이므로 
		// 객체 생성안됨 오류발생 
		// Service service = new Service();
		// service.biz();
		
		// 생성자를 이용해서 dao 인터페이스를 상속받는 클래스를 
		// 넣을 수 있다.
		//  DAO dao = new OracleDAO();
		//  DAO dao = new MariaDAO();
		//  Service service = new Service(dao);
		//  service.biz();
		
		// setter를 이용해서 dao 인터페이스를 상속받은 클래스를 
		// 넣을 수 있다.
		// DAO dao = new OracleDAO();
		DAO dao = new MariaDAO();
		Service service = new Service();
		service.setDao(dao);
		service.biz();
	}
}
