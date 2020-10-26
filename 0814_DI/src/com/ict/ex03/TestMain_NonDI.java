package com.ict.ex03;

public class TestMain_NonDI {
	public static void main(String[] args) {
		MyProcess process = new MyProcess("둘리",8);
		process.prn();
		
		MyProcess2 process2 = new MyProcess2();
		process2.setName("태권브이");
		process2.setAge(15);
		
		process2.prn();
	}
}
