package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// 자바 1.8 이상
// 일반 컨트롤러와 달리 ModelAndView로 반환하지 않음
// 단순문자열(String = text), json, xml 중 하나로 반환 

@RestController
public class MyAjaxController {

	// 단순 문자인 경우 문서의 타입은 contentType="text/html" 타입으로
	// 알아서 처리 한다.내용을 http://localhost:8090/XXXX.do로 볼수 있다.
	@RequestMapping("text.do")
	@ResponseBody
	public String Hello() {
		return "<h2> Hello World ICT CAMP </h2>";
	}

	@RequestMapping(value="xmltest.do", produces="text/xml; charset=utf-8")
	@ResponseBody
	public String XML_Test() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		sb.append("<product>");
		sb.append("<name>딸기우유</name>");
		sb.append("<price>1000</price>");
		sb.append("</product>");
		sb.append("<product>");
		sb.append("<name>초코우유</name>");
		sb.append("<price>1200</price>");
		sb.append("</product>");
		sb.append("<product>");
		sb.append("<name>커피우유</name>");
		sb.append("<price>1100</price>");
		sb.append("</product>");
		sb.append("<product>");
		sb.append("<name>흰우유</name>");
		sb.append("<price>950</price>");
		sb.append("</product>");
		sb.append("</products>");
		return sb.toString();
	}
	@RequestMapping(value="xmltest2.do", produces="text/xml; charset=utf-8")
	@ResponseBody
	public String XML_Test2() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		sb.append("<product name=\"흰우유\" price=\"950\"/>");
		sb.append("<product name=\"카페모카\" price=\"1500\"/>");
		sb.append("<product name=\"카페라떼\" price=\"1500\"/>");
		sb.append("<product name=\"탄산수\" price=\"1200\"/>");
		sb.append("</products>");
		return sb.toString();
	}
	@RequestMapping(value="xmltest3.do", produces="text/xml; charset=utf-8")
	@ResponseBody
	public String XML_Test3() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		sb.append("<product price=\"950\">이온음료</product>");
		sb.append("<product price=\"1500\">탄산음료</product>");
		sb.append("<product price=\"1500\">비타민음료</product>");
		sb.append("<product price=\"1200\">건강음료</product>");
		sb.append("</products>");
		return sb.toString();
	}
	// 외부로 부터 xml 파일을 읽어서 파싱하기
	// DOM 방식
	@RequestMapping(value="xmltest4.do", produces="text/html; charset=utf-8")
	@ResponseBody
	public String XML_Test4() {
		StringBuffer sb = new StringBuffer();
		sb.append("<table><thead><tr><th>지역</th><th>온도</th><th>상태</th><th>아이콘</th></thead>");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			URL url = new URL("http://www.kma.go.kr/XML/weather/sfc_web_map.xml");
			InputStream is = url.openStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			Document document = builder.parse(bis);
			
			NodeList local = document.getElementsByTagName("local");
			sb.append("<tbody>");
			for (int i = 0; i < local.getLength(); i++) {
				sb.append("<tr>");
				// 태그 글자 가져오기 
				sb.append("<td>"+local.item(i).getFirstChild().getNodeValue()+"</td>");
				// 태그 속성 가져오기 
				sb.append("<td>"+((Element)(local.item(i))).getAttribute("ta")+"</td>");
				sb.append("<td>"+((Element)(local.item(i))).getAttribute("desc")+"</td>");
				sb.append("<td> <img src='http://www.kma.go.kr/images/icon/NW/NB"
						+ ((Element)(local.item(i))).getAttribute("icon")+".png'>");
				sb.append("</tr>");
			}
			sb.append("</tbody></table>");
		} catch (Exception e) {
		}
		return sb.toString();
	}
	
	// 외부로 부터 xml 파일을 읽어서  전달하는 역할
	// Stram 방식
	@RequestMapping(value="xmltest5.do", produces="text/xml; charset=utf-8")
	@ResponseBody
	public String XML_Test5() {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL("http://www.kma.go.kr/XML/weather/sfc_web_map.xml");
			URLConnection con = url.openConnection();
			BufferedReader br = 
				new BufferedReader(
					new InputStreamReader(con.getInputStream(),"utf-8"));
			String msg = "";
			while((msg = br.readLine()) != null) {
				sb.append(msg);
			};
			
		} catch (Exception e) {
		}
		return sb.toString();
	}
	
	// 자동으로 json이 만들어진다.
	@RequestMapping(value="jsontest1.do", produces="text/html; charset=utf-8")
	@ResponseBody
	public String JSON_Test1() {
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("[");
			sb.append("{\"name\":\"호두우유\",\"price\":\"12000\"},");
			sb.append("{\"name\":\"딸기우유\",\"price\":\"10000\"},");
			sb.append("{\"name\":\"메론우유\",\"price\":\"11000\"},");
			sb.append("{\"name\":\"망고우유\",\"price\":\"12000\"}");
			sb.append("]");
		} catch (Exception e) {
		}
		return sb.toString();
	}
	@RequestMapping(value="jsontest2.do", produces="text/html; charset=utf-8")
	@ResponseBody
	public String JSON_Test2() {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst"); /*URL*/
		StringBuilder sb = new StringBuilder();
		try {
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=서비스키"); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
			urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
			urlBuilder.append("&" + URLEncoder.encode("stnId","UTF-8") + "=" + URLEncoder.encode("108", "UTF-8")); /*하단 참고자료 참조*/
			urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode("201310170600", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력-최근 24시간 자료만 제공*/
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			System.out.println(sb.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sb.toString();
	}
}
















