package com.ict.db;

import org.springframework.web.multipart.MultipartFile;

public class RVO {
	private String r_idx, r_subject, r_writer, r_content, r_file_name, 
	r_pwd, r_write_date, r_hit, m_id;
	private MultipartFile r_file;	
	public RVO(String r_idx, String r_subject, String r_writer, String r_content, String r_file_name, String r_pwd,
			String r_write_date, String r_hit, String m_id, MultipartFile r_file) {
		super();
		this.r_idx = r_idx;
		this.r_subject = r_subject;
		this.r_writer = r_writer;
		this.r_content = r_content;
		this.r_file_name = r_file_name;
		this.r_pwd = r_pwd;
		this.r_write_date = r_write_date;
		this.r_hit = r_hit;
		this.m_id = m_id;
		this.r_file = r_file;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	public String getR_idx() {
		return r_idx;
	}
	public void setR_idx(String r_idx) {
		this.r_idx = r_idx;
	}
	public String getR_subject() {
		return r_subject;
	}
	public void setR_subject(String r_subject) {
		this.r_subject = r_subject;
	}
	public String getR_writer() {
		return r_writer;
	}
	public void setR_writer(String r_writer) {
		this.r_writer = r_writer;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getR_file_name() {
		return r_file_name;
	}
	public void setR_file_name(String r_file_name) {
		this.r_file_name = r_file_name;
	}
	public String getR_pwd() {
		return r_pwd;
	}
	public void setR_pwd(String r_pwd) {
		this.r_pwd = r_pwd;
	}
	public String getR_write_date() {
		return r_write_date;
	}
	public void setR_write_date(String r_write_date) {
		this.r_write_date = r_write_date;
	}
	public String getR_hit() {
		return r_hit;
	}
	public void setR_hit(String r_hit) {
		this.r_hit = r_hit;
	}
	public MultipartFile getR_file() {
		return r_file;
	}
	public void setR_file(MultipartFile r_file) {
		this.r_file = r_file;
	}
	
	
}