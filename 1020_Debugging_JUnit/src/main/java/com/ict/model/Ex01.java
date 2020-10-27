package com.ict.model;

// 디버깅 : 논리적인 오류를 잡기 위해서 실행하는 행위, 해당 변수값 조사, 수정은 안됨
// breakpoint(중단점) : 디버깅 실행 시 자동으로 실행이 중단되어 해당 변수값을 조사 
//                    할 수 있는 지점을 말한다.
//                    해당 줄 앞에서 마우스로 더블클릭으로 설정, 해제 할 수 있다.
// F11 : 디버그 모드 실행 (벌레모양)
// F8 : 중단점에서 다음 중단점으로 이동
// F5 : 한 줄씩 실행, 메소드를 만나면 안으로 진입 
// F6 : 한 줄씩 실행, 메소드를 만나면 안으로 진입하지 않고 건너뜀
public class Ex01 {
	public static void main(String[] args) {
		int total = 0 ;
		for(int i=1; i <11 ; i++) {
			total = total + i ;
			System.out.println("1부터 "+i+"까지의 합은 "+ total);
		}
		System.out.println("합 : " + total);
	}
}





