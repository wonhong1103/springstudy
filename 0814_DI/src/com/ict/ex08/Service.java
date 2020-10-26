package com.ict.ex08;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service("myservice")
public class Service {
	
	@Autowired
	private DAO dao ;
	
	public Service() {
		System.out.println("Service 생성자");
	}

	public Service(DAO dao) {
		super();
		this.dao = dao;
		System.out.println("Service 생성자");
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	// 실행하고자 하는 메소드
	public void biz() {
		dao.prn();
	}
	
}
