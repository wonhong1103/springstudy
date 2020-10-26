package com.ict.db;

public class Q_CVO {
	private String q_c_idx, q_c_writer, q_c_content, q_c_pwd, q_c_write_date, q_idx, m_id;

	public Q_CVO(String q_c_idx, String q_c_writer, String q_c_content, String q_c_pwd, String q_c_write_date,
			String q_idx, String m_id) {
		super();
		this.q_c_idx = q_c_idx;
		this.q_c_writer = q_c_writer;
		this.q_c_content = q_c_content;
		this.q_c_pwd = q_c_pwd;
		this.q_c_write_date = q_c_write_date;
		this.q_idx = q_idx;
		this.m_id = m_id;
	}

	public String getQ_c_idx() {
		return q_c_idx;
	}

	public void setQ_c_idx(String q_c_idx) {
		this.q_c_idx = q_c_idx;
	}

	public String getQ_c_writer() {
		return q_c_writer;
	}

	public void setQ_c_writer(String q_c_writer) {
		this.q_c_writer = q_c_writer;
	}

	public String getQ_c_content() {
		return q_c_content;
	}

	public void setQ_c_content(String q_c_content) {
		this.q_c_content = q_c_content;
	}

	public String getQ_c_pwd() {
		return q_c_pwd;
	}

	public void setQ_c_pwd(String q_c_pwd) {
		this.q_c_pwd = q_c_pwd;
	}

	public String getQ_c_write_date() {
		return q_c_write_date;
	}

	public void setQ_c_write_date(String q_c_write_date) {
		this.q_c_write_date = q_c_write_date;
	}

	public String getQ_idx() {
		return q_idx;
	}

	public void setQ_idx(String q_idx) {
		this.q_idx = q_idx;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	
	
}
