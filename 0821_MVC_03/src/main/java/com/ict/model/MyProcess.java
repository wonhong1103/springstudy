package com.ict.model;

import java.util.Calendar;

public class MyProcess {
	public MyProcess() {
		System.out.println("MyProcess  생성자");
	}
	// 실행 하고자 하는 메소드
	public String getGreeting() {
		String msg = null;
		//  현재 시간 구하자 
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

		if(hour >=7 && hour <=10) {
			msg = "좋은 아침 입니다.";
		}else if(hour >=12 && hour <=14) {
			msg = "점심식사 하셨나요?";
		}else if(hour >=22 && hour <=24) {
			msg = "좋은 꿈 꾸세요";
		}else {
			msg ="Hi~~~~~";
		}
		return msg ;
	}
}
