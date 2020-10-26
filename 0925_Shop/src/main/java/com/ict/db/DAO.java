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
	
	public List<VO> getList(String category) throws Exception{
		List<VO> list = null;
		list = sqlSessionTemplate.selectList("list", category);
		return list;
	}
	
	public MVO getLogIn(MVO m_vo) throws Exception {
		MVO mvo = null;
		mvo = sqlSessionTemplate.selectOne("login", m_vo);
        return mvo;				
	}
	
	public VO getOneList(String idx) throws Exception{
		VO vo = null;
		vo = sqlSessionTemplate.selectOne("onelist", idx);
		return vo;
	}
	public List<CVO> getCartList(String m_id)throws Exception{
		List<CVO> clist= null;
		clist = sqlSessionTemplate.selectList("cartall", m_id);
		return clist;
	}
	
	public CVO getCartList(String id, String p_num) throws Exception{
		CVO cvo = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("p_num", p_num);
		cvo = sqlSessionTemplate.selectOne("p_cartlist", map);
		return cvo;
	}
	public void getCartInsert(CVO cvo) throws Exception{
		sqlSessionTemplate.insert("cartInsert", cvo);
	}
	public void getCartUpdate(CVO cvo) throws Exception{
		sqlSessionTemplate.update("cartUpdate", cvo);
	}
	public void getCartDel(CVO cvo) throws Exception{
		sqlSessionTemplate.delete("cartDel", cvo);
	}
	public void getCartEdit(CVO cvo) throws Exception{
		sqlSessionTemplate.update("cartEdit", cvo);
	}
	public int getProduct_Insert(VO vo) throws Exception{
		int result = 0 ;
		sqlSessionTemplate.insert("p_insert", vo);
		return result;
	}
	
}








