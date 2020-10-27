package com.ict.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// 테스트할 메소드의 인자를 여러개 넣어서 테스트 하는 방법
@RunWith(Parameterized.class)
public class Ex02_Test2 {
	Ex02 test ;
	private int result; // 예상값
	private int s1;     // 입력값1
	private int s2;     // 입력값2
	
	// 생성자
	public Ex02_Test2(int result, int s1, int s2) {
		this.result = result;
		this.s1 = s1;
		this.s2 = s2;
		System.out.println("생성자");
	}
	@Before
	public void testBefore() {
		System.out.println("테스트 이전");
		test = new Ex02();
	}
	// 테스트 케이스들을 배열에 넣어라
	@Parameters
	public static Collection<Integer[]> getTestParameters(){
		return Arrays.asList(new Integer[][] {
			{5,3,2},
			{1,3,-2},
			{-1,-3,2},
			{-5,-3,-2}
		});
	}
	@Test
	public void test() {
		assertEquals(result, test.add(s1, s2));
	}

}
