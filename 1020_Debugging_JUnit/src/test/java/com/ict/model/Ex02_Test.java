package com.ict.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// 테스트 클래스를 만들면 오류 발생 한다. 
// 해결) 프로젝트 - Build path - configure Build path - Add Lib
// 실행 방법) 마우스 오른쪽 - Run AS - JUnit Test 선택
// JUnit : 단위 테스트(메소드) 도구, 블랙 박스 테스트 종류 중 하나 이다.
//         블랙박스 테스트란 입력를 넣어서 예상값이 그대로 나오면 성공 
//         화이트박스 테스트란 과정을 로직및 처리방법에 중점을 둔 테스트       
// assertEquals :기본형 변수 또는 (객체의 값) 두개의 값이 같은지 검사
// assertSame : 두 객체가 같은 객체인지 검사 (주소가 같냐?)
// assertNull : 객체가 null 인지 검사
// assertNotNull : 객체가 null 아닌지 검사
// assertTrue(a) : a가 참인지 확인
// assertArrayEquals(a,b) : 배열a, 배열a가 일치하는지 확인

public class Ex02_Test {
	Ex02 t ; 
	// 테스트 전에 실행
	@Before
	public void testBefore() {
		System.out.println("테스트 이전");
		t = new Ex02();
	}
	
	@Test
	public void AddTest() {
		System.out.println("테스트 시작");
		// 미리 값을 넣어서 result의 값을 예상한다.
		int result = t.add(10,20);
		// 예상이 맞지 검사하는 것
		// assertEquals(예상값, 나온 결과값);
		assertEquals(30, result);
		System.out.println("테스트 끝");
	}
	@Test
	public void SubTest() {
		System.out.println("테스트 시작");
		// 미리 값을 넣어서 result의 값을 예상한다.
		int result = t.sub(10,20);
		// 예상이 맞지 검사하는 것
		// assertEquals(예상값, 나온 결과값);
		assertEquals(-10, result);
		System.out.println("테스트 끝");
	}
	// 테스트 후 실행
	@After
	public void testAfter() {
		System.out.println("테스트 이후");
	}

}
