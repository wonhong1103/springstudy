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
	public MVO getLogIn(MVO mvo) {
		MVO res = null;
		res = sqlSessionTemplate.selectOne("login", mvo);
		return res;
	}
	
	public int getTotalCount() {
		int result = 0 ;
		result = sqlSessionTemplate.selectOne("count");
		return result;
	}
	
	public List<BVO> getList(int begin, int end){
		List<BVO> list = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		list = sqlSessionTemplate.selectList("list", map);
		return list;
	}
	
	public int getInsert(BVO bvo) {
		int result = 0;
		result = sqlSessionTemplate.insert("insert", bvo);
		return result;
	}
	
	public void getHit(String b_idx) {
		sqlSessionTemplate.update("hit", b_idx);
	}
	public BVO getOneList(String b_idx) {
		BVO bvo = null;
		bvo = sqlSessionTemplate.selectOne("onelist", b_idx);
		return bvo ;
	}
	public void getDelete(String b_idx) {
		sqlSessionTemplate.delete("delete", b_idx);
	}
	
	public int getUpdate(BVO bvo) {
		int result = 0 ;
		result = sqlSessionTemplate.update("update", bvo);
		return result;
	}
	
	public List<CVO> getCommList(String b_idx){
		List<CVO> c_list = null;
		c_list = sqlSessionTemplate.selectList("c_list", b_idx);
		return c_list;
	}
	
	public void getCommWrite(CVO cvo) {
		sqlSessionTemplate.insert("c_insert", cvo);
	}
	
	public void getCommDelete(CVO cvo) {
		sqlSessionTemplate.delete("c_delete", cvo);
	}
}










