package com.ict.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class DAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// DB처리 
	public int getTotalCount() {
		int result = 0 ;
		result = sqlSessionTemplate.selectOne("count");
		return result;
	}
	/*
	public List<VO> getList(){
		List<VO> list = null;
		list = sqlSessionTemplate.selectList("list");
		return list;
	}
	*/

	public List<VO> getList(int begin, int end){
		List<VO> list = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		list = sqlSessionTemplate.selectList("list",map);
		return list;
	}
	
	public int getInsert(VO vo) {
		int result = 0 ;
		result = sqlSessionTemplate.insert("insert", vo);
		return result;
	}
	public VO getOneList(String idx) {
		VO vo = null;
		vo = sqlSessionTemplate.selectOne("onelist", idx);
		return vo;
	}
	
	public void getDelete(String idx) {
		sqlSessionTemplate.delete("delete", idx);
	}
	
	public int getUpdate(VO vo) {
		int result = 0 ;
		result = sqlSessionTemplate.update("update", vo);
		return result;
	}
}








