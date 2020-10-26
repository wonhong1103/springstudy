package com.ict.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

// DB처리하는 클래스
public class DAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// 전체 게시물의 수
	public int getTotalCount() throws Exception{
		int result = 0 ;
		result = sqlSessionTemplate.selectOne("count");
		return result;
	}
	
	// 리스트
	public List<VO> getList(int begin, int end) throws Exception{
	
		List<VO> list = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		list = sqlSessionTemplate.selectList("list", map);
		return list;
	}
	
	// 원글삽입
	public int getInsert(VO vo) throws Exception{
		int result = 0 ;
		result = sqlSessionTemplate.insert("insert", vo);
		return result;
	}
	
	// hit 업데이트
	public void getHitUpdate(String idx) throws Exception {
		sqlSessionTemplate.update("hitup", idx);
	}
	// 상세보기 
	public VO getOneList(String idx) throws Exception{
		VO vo = null;
		vo = sqlSessionTemplate.selectOne("onelist", idx);
		return vo;
	}
	
	// levUp
	public void getLevUp(Map<String, Integer> map) throws Exception{
		sqlSessionTemplate.update("levup", map);
	}
	
	// ans_insert
	public int getAnsInsert(VO vo) throws Exception{
		int result = 0 ;
		result = sqlSessionTemplate.insert("ans_insert", vo);
		return result;
	}
}








