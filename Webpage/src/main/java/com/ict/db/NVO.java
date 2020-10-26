package com.ict.db;

import org.springframework.web.multipart.MultipartFile;

public class NVO {
	private String n_idx, n_subject, n_writer, n_content, n_file_name, n_pwd, n_write_date, n_hit;
	private MultipartFile n_file;
	public NVO(String n_idx, String n_subject, String n_writer, String n_content, String n_file_name, String n_pwd,
			String n_write_date, String n_hit, MultipartFile n_file) {
		super();
		this.n_idx = n_idx;
		this.n_subject = n_subject;
		this.n_writer = n_writer;
		this.n_content = n_content;
		this.n_file_name = n_file_name;
		this.n_pwd = n_pwd;
		this.n_write_date = n_write_date;
		this.n_hit = n_hit;
		this.n_file = n_file;
	}
	public String getN_idx() {
		return n_idx;
	}
	public void setN_idx(String n_idx) {
		this.n_idx = n_idx;
	}
	public String getN_subject() {
		return n_subject;
	}
	public void setN_subject(String n_subject) {
		this.n_subject = n_subject;
	}
	public String getN_writer() {
		return n_writer;
	}
	public void setN_writer(String n_writer) {
		this.n_writer = n_writer;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public String getN_file_name() {
		return n_file_name;
	}
	public void setN_file_name(String n_file_name) {
		this.n_file_name = n_file_name;
	}
	public String getN_pwd() {
		return n_pwd;
	}
	public void setN_pwd(String n_pwd) {
		this.n_pwd = n_pwd;
	}
	public String getN_write_date() {
		return n_write_date;
	}
	public void setN_write_date(String n_write_date) {
		this.n_write_date = n_write_date;
	}
	public String getN_hit() {
		return n_hit;
	}
	public void setN_hit(String n_hit) {
		this.n_hit = n_hit;
	}
	public MultipartFile getN_file() {
		return n_file;
	}
	public void setN_file(MultipartFile n_file) {
		this.n_file = n_file;
	}
	
	
	
}
