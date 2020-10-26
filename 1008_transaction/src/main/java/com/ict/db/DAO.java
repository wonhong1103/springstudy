package com.ict.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

// DB처리하는 클래스
public class DAO {
	private SqlSessionTemplate sqlSessionTemplate;
	private DataSourceTransactionManager transactionManager;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	
	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}


	public int getInsert(VO vo) throws Exception {
		int result = 0;
		TransactionDefinition def = null;
		TransactionStatus status = null;
		try {
			// 트랜잭션 이전			
			//result += sqlSessionTemplate.insert("cardInsert", vo);			
			//result += sqlSessionTemplate.insert("ticketInsert", vo);
			
			// 트랜잭션 : 데이터베이스를 처리할 때 여러 개의 작업을 하나의 작업단위로 묶어서 처리하는 것을 말한다.
			// 트랜잭션은 전체가 수행되거나, 전체가 수행되지 않아야 한다.(all or nothing)
			// 즉, 여러작업이 하나의 묶음일때 일부라도 오류가 발생하면 전체가 다 롤백을 해야 된다.
		
			def = new DefaultTransactionDefinition();
			status = transactionManager.getTransaction(def);
			result += sqlSessionTemplate.insert("cardInsert", vo);			
			result += sqlSessionTemplate.insert("ticketInsert", vo);
			transactionManager.commit(status);
			
			System.out.println("결제성공, 발권성공");
		} catch (Exception e) {
			transactionManager.rollback(status);		
			System.out.println("오류발생, 결제취소, 발권취소");
		}
		return result;
	}
	
	
	
}








