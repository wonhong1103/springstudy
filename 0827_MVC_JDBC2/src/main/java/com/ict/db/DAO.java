package com.ict.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DAO {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// 원하는 메소드
	// 전체 정보 보기 
	// JdbcTemplate는 JDBC와 insert,update,delete는 처리방법이 같으나 
	// select문은 처리방법이 다르다.
	public List<VO> getList(){
		String sql = "select * from guestbook2 order by idx";
		return jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				VO vo = new VO();
				vo.setIdx(rs.getString("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContent(rs.getString("content"));
				vo.setEmail(rs.getString("email"));
				vo.setPwd(rs.getString("pwd"));
				vo.setFile_name(rs.getString("file_name"));
				vo.setRegdate(rs.getString("regdate"));
				return vo;
			}
		});
	}
	
	public int getInsert(VO vo) {
		int result = 0 ;
		String sql = "insert into guestbook2 values(guestbook2_seq.nextval,?,?,?,?,?,?,sysdate)";
		result = jdbcTemplate.update(sql,vo.getName(), vo.getSubject(), vo.getContent(),
				vo.getEmail(), vo.getPwd(), vo.getFile_name());
		return result;
	}
	public List<VO> getOneList(String idx){
		String sql = "select * from guestbook2 where idx = ?";
		return jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				VO vo = new VO();
				vo.setIdx(rs.getString("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContent(rs.getString("content"));
				vo.setEmail(rs.getString("email"));
				vo.setPwd(rs.getString("pwd"));
				vo.setFile_name(rs.getString("file_name"));
				vo.setRegdate(rs.getString("regdate"));
				return vo;
			}
		},idx);
	}
	public int getDelete(String idx) {
		int result = 0 ;
		String sql = "delete from guestbook2 where idx = ?";
		result = jdbcTemplate.update(sql, idx);
		return result;
	}
	public int getUpdate(VO vo) {
		int result = 0 ;
		String sql = "update guestbook2 "
			+ " set name=?, subject=?, email=?, file_name=?, content=? where idx=?";
		result = jdbcTemplate.update(sql, vo.getName(), vo.getSubject(), vo.getEmail(),
					vo.getFile_name(), vo.getContent(), vo.getIdx());
		return result;
	}
}









