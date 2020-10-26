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

	public MVO getLogin(MVO m_vo) throws Exception {
		MVO mvo = null;
		mvo = sqlSessionTemplate.selectOne("login", m_vo);
        return mvo;				
	}
	//회원가입
	public int getJoin(MVO mvo, String member) {
		int result = 0;
		
		switch (member) {
			case "Join": result = sqlSessionTemplate.insert("member_join", mvo); break;
			case "Find": result = sqlSessionTemplate.delete("member_find", mvo); break;
		}
	
		return result;
	}
	public String getCheckID(String m_id) {
		String checkid = null;
		checkid = sqlSessionTemplate.selectOne("checkid", m_id);
		return checkid;
	}
	/*
	 * 아이디 체크 (쿼리)
	 * public MVO idCheck(String m_id) throws Exception { MVO mvo = null; mvo =
	 * sqlSessionTemplate.selectOne(m_id); return }
	 */
	
	
	
	
	
	
	
	
	
	public PVO productGetOneList(String p_idx) throws Exception{
		PVO pvo = null;
		pvo = sqlSessionTemplate.selectOne("onelist", p_idx);
		return pvo;
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
	
	
	
	
	//qna
			// 전체 게시물의 수
			public int qnaGetTotalCount() throws Exception{
				int result = 0 ;
				result = sqlSessionTemplate.selectOne("qna_count");
				return result;
			}
					
			// 리스트
			public List<QVO> qnaGetList(int begin, int end) throws Exception{
					
				List<QVO> list = null;
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("begin", begin);
				map.put("end", end);
				list = sqlSessionTemplate.selectList("qna_list", map);
				return list;
			}
					
			// 원글삽입
			public int qnaGetInsert(QVO qvo) throws Exception{
				int result = 0 ;
				result = sqlSessionTemplate.insert("qna_insert", qvo);
				return result;
			}
					
			// hit 업데이트
			public void qnaGetHit(String q_idx) throws Exception {
				sqlSessionTemplate.update("qna_hit", q_idx);
			}
			// 상세보기 
			public QVO qnaGetOneList(String q_idx) throws Exception{
				QVO qvo = null;
				qvo = sqlSessionTemplate.selectOne("qna_onelist", q_idx);
				return qvo;
			}
					
			public int qnaGetUpdate(QVO qvo) throws Exception {
				int result = 0;
				result = sqlSessionTemplate.update("qna_update", qvo);
				return result;
			}

			public void qnaGetDelete(String q_idx) throws Exception {
				sqlSessionTemplate.delete("qna_delete", q_idx);
			}	
					
			//bbs
			public List<Q_CVO> qnaGetCommentList(String q_idx){
				List<Q_CVO> q_c_list = null;
				q_c_list = sqlSessionTemplate.selectList("q_c_list", q_idx);
				return q_c_list;
			}
			public void qnaGetCommentWrite(Q_CVO q_cvo) {
				sqlSessionTemplate.insert("q_c_insert", q_cvo);
			}		
			public void qnaGetCommentDelete(Q_CVO q_cvo) {
				sqlSessionTemplate.delete("q_c_delete", q_cvo);
			}		
			
	
	
	
	
	
	
	
	
		// 리뷰
		// 전체 게시물의 수
		public int reviewGetTotalCount() throws Exception{
			int result = 0 ;
			result = sqlSessionTemplate.selectOne("review_count");
			return result;
		}
		
		// 리스트
		public List<RVO> reviewGetList(int begin, int end) throws Exception{
		
			List<RVO> list = null;
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("begin", begin);
			map.put("end", end);
			list = sqlSessionTemplate.selectList("review_list", map);
			return list;
		}
		
		// 원글삽입
		public int reviewGetInsert(RVO rvo) throws Exception{
			int result = 0 ;
			result = sqlSessionTemplate.insert("review_insert", rvo);
			return result;
		}
		
		// hit 업데이트
		public void reviewGetHit(String r_idx) throws Exception {
			sqlSessionTemplate.update("review_hit", r_idx);
		}
		// 상세보기 
		public RVO reviewGetOneList(String r_idx) throws Exception{
			RVO rvo = null;
			rvo = sqlSessionTemplate.selectOne("review_onelist", r_idx);
			return rvo;
		}
		
		public int reviewGetUpdate(RVO rvo) throws Exception {
			int result = 0;
			result = sqlSessionTemplate.update("review_update", rvo);
			return result;
		}

		public void reviewGetDelete(String r_idx) throws Exception {
			sqlSessionTemplate.delete("review_delete", r_idx);
		}	
		
		//bbs
		public List<R_CVO> reviewGetCommentList(String r_idx){
			List<R_CVO> r_c_list = null;
			r_c_list = sqlSessionTemplate.selectList("r_c_list", r_idx);
			return r_c_list;
		}
		public void reviewGetCommentWrite(R_CVO r_cvo) {
			sqlSessionTemplate.insert("r_c_insert", r_cvo);
		}		
		public void reviewGetCommentDelete(R_CVO r_cvo) {
			sqlSessionTemplate.delete("r_c_delete", r_cvo);
		}
	
	
		
		
		
		
		
		// 공지사항
		// 전체 게시물의 수
				public int noticeGetTotalCount() throws Exception{
					int result = 0 ;
					result = sqlSessionTemplate.selectOne("notice_count");
					return result;
				}
				
				// 리스트
				public List<NVO> noticeGetList(int begin, int end) throws Exception{
				
					List<NVO> list = null;
					Map<String, Integer> map = new HashMap<String, Integer>();
					map.put("begin", begin);
					map.put("end", end);
					list = sqlSessionTemplate.selectList("notice_list", map);
					return list;
				}
				
				// 원글삽입
				public int noticeGetInsert(NVO nvo) throws Exception{
					int result = 0 ;
					result = sqlSessionTemplate.insert("notice_insert", nvo);
					return result;
				}
				
				// hit 업데이트
				public void noticeGetHit(String n_idx) throws Exception {
					sqlSessionTemplate.update("notice_hit", n_idx);
				}
				// 상세보기 
				public NVO noticeGetOneList(String n_idx) throws Exception{
					NVO nvo = null;
					nvo = sqlSessionTemplate.selectOne("notice_onelist", n_idx);
					return nvo;
				}
				
				public int noticeGetUpdate(NVO nvo) throws Exception {
					int result = 0;
					result = sqlSessionTemplate.update("notice_update", nvo);
					return result;
				}

				public void noticeGetDelete(String n_idx) throws Exception {
					sqlSessionTemplate.delete("notice_delete", n_idx);
				}
	
	
	
	
	
	
	
	
}
