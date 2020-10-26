package com.ict.model;

import java.util.Calendar;

import org.springframework.stereotype.Service;

// 컨트롤러에서 사용하는 클래스의 애노테이션은 
// root-context.xml에서 미리 애노테이션 처리를 하고 난 후 
// 해당 클래스에서 애노테이션 한다.
@Service("myProcess")
public class MyProcess {
	public MyProcess() {
		 System.out.println("MyProcess 생성자");
	}
	
	// 실행하고자 하는 메소드 
	public String getGreeting() {
		String result = "";
		// 현재 시간을 구하자
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hour>=7 && hour<=10) {
			result = "좋은 아침 입니다.";
		}else if(hour>=12 && hour<=14) {
			result = "점심식사 하셨나요?";
		}else if(hour>=22 && hour<=24) {
			result = "안녕히 주무세요";
		}else {
			result = "Hi~~~~~";
		}
		
		return result;
	}
	
}
