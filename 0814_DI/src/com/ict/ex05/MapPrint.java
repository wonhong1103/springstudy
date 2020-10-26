package com.ict.ex05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapPrint {
	Map<String, String> map1 = new HashMap<String, String>();
	Map<Integer, String> map2 = new HashMap<Integer, String>();
	
	public void input() {
		map1.put("id", "hong12");
		map1.put("pw","h1234");
		map1.put("name", "홍두께");
		map1.put("age","27");
		map1.put("addr", "제주도");
		
		map2.put(100, "kang");
		map2.put(105,"k111");
		map2.put(110, "강두기");
		map2.put(116,"37");
		map2.put(118, "서울");
		
	}
	
	// 실행하고 싶은 메소드
	public void s_prn() {
		Iterator<String> it = map1.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(map1.get(key));
		}
	}
	// 실행하고 싶은 메소드	
	public void i_prn() {
		Iterator<Integer> it = map2.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			System.out.println(map2.get(key));
		}
	}
	
	public Map<String, String> getMap1() {
		return map1;
	}
	public void setMap1(Map<String, String> map1) {
		this.map1 = map1;
	}
	public Map<Integer, String> getMap2() {
		return map2;
	}
	public void setMap2(Map<Integer, String> map2) {
		this.map2 = map2;
	}
	
	
}