package com.ict.db;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class DAO {
	
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// DB 처리하는 메소드들
	public List<VO> getList(){
		List<VO> list = null;
		list = sqlSessionTemplate.selectList("list");
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
	
	public int getDelete(String idx) {
		int result = 0 ;
		result = sqlSessionTemplate.delete("delete", idx);
		return result;
	}
	
	public int getUpdate(VO vo) {
		int result = 0 ;
		result = sqlSessionTemplate.update("update", vo);
		return result;
	}
}









