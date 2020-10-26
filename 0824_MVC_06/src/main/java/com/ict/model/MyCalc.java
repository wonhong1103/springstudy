package com.ict.model;

import org.springframework.stereotype.Service;

// 실제처리하는 메소드를 가진 클래스 
@Service("myCalc")
public class MyCalc {
	
	public int add(int s1, int s2) {
		return s1 + s2 ;
	}
	public int sub(int s1, int s2) {
		return s1 - s2 ;
	}
	public int mul(int s1, int s2) {
		return s1 * s2 ;
	}
	public int div(int s1, int s2) {
		return s1 / s2 ;
	}
}
