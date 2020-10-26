package com.ict.db;

import org.springframework.web.multipart.MultipartFile;

public class QVO {
	private String q_idx, q_subject, q_writer, q_content, q_file_name, 
	q_pwd, q_write_date, q_hit, m_id;
	private MultipartFile q_file;
	
	public String getQ_idx() {
		return q_idx;
	}
	public void setQ_idx(String q_idx) {
		this.q_idx = q_idx;
	}
	public String getQ_subject() {
		return q_subject;
	}
	public void setQ_subject(String q_subject) {
		this.q_subject = q_subject;
	}
	public String getQ_writer() {
		return q_writer;
	}
	public void setQ_writer(String q_writer) {
		this.q_writer = q_writer;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getQ_file_name() {
		return q_file_name;
	}
	public void setQ_file_name(String q_file_name) {
		this.q_file_name = q_file_name;
	}
	public String getQ_pwd() {
		return q_pwd;
	}
	public void setQ_pwd(String q_pwd) {
		this.q_pwd = q_pwd;
	}
	public String getQ_write_date() {
		return q_write_date;
	}
	public void setQ_write_date(String q_write_date) {
		this.q_write_date = q_write_date;
	}
	public String getQ_hit() {
		return q_hit;
	}
	public void setQ_hit(String q_hit) {
		this.q_hit = q_hit;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public MultipartFile getQ_file() {
		return q_file;
	}
	public void setQ_file(MultipartFile q_file) {
		this.q_file = q_file;
	}
	
	
	
	
}