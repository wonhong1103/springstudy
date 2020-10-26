package com.ict.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DAO {
	// 오라클에게 접근할 수 있는 정보를 가지고 있는 클래스
	// 오라클 쿼리를 사용할 수 있는 클래스 
	private JdbcTemplate jdbcTemplate;
	public DAO() {}
	public DAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// jdbcTemplate를 사용해서 오라클에게 쿼리사용할 수 있다.
	// select만 문법이 틀리고 , insert, update, delete는 문법이 같다.
	
	// jdbcTemplate에서 select는 무조건 List<VO>를 반환한다.
	public List<VO> getList(){
		String sql = "select * from members order by idx";
		return jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// 결과는 rs가 가지고 있다.
				VO vo  = new VO();
				vo.setIdx(rs.getString("idx"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_pw(rs.getString("m_pw"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_age(rs.getString("m_age"));
				vo.setM_reg(rs.getString("m_reg"));
				return vo;
			}
		});
	}
	
	// 삽입
	public int getInsert(VO vo) {
		int result = 0 ;
		String sql = "insert into members "
				+ " values(members_seq.nextval,?,?,?,?,sysdate)";
		// insert, update, delete 는 jdbcTemplate.update()사용
		result = jdbcTemplate.update(sql,  vo.getM_id(), vo.getM_pw(),
				                        vo.getM_name(), vo.getM_age());
		return result; 
	}
	
}










