package com.bnym.aal.poc.spring_jta;

import java.io.Serializable;

import org.hibernate.FlushMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class springJtaDaoClass implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private static SessionFactory oracleSessionFactory;
	private static SessionFactory mysqlSessionFactory;

	private HibernateTemplate oracleJdbcTemplateObject;
	private HibernateTemplate mysqlJdbcTemplateObject;

	private static Persons persons;

	public static SessionFactory getOracleSessionFactory() {
		return oracleSessionFactory;
	}

	public void setOracleSessionFactory(SessionFactory oracleSessionFactory) {
		springJtaDaoClass.oracleSessionFactory = oracleSessionFactory;
		this.oracleJdbcTemplateObject = new HibernateTemplate(oracleSessionFactory);
	}

	public static SessionFactory getMysqlSessionFactory() {
		return mysqlSessionFactory;
	}

	public void setMysqlSessionFactory(SessionFactory mysqlSessionFactory) {
		springJtaDaoClass.mysqlSessionFactory = mysqlSessionFactory;
		this.mysqlJdbcTemplateObject = new HibernateTemplate(mysqlSessionFactory);
	}

	public static PlatformTransactionManager atomikosTransactionManager;

	public static PlatformTransactionManager getAtomikosTransactionManager() {
		return atomikosTransactionManager;
	}

	public static void setAtomikosTransactionManager(PlatformTransactionManager atomikosTransactionManager) {
		springJtaDaoClass.atomikosTransactionManager = atomikosTransactionManager;
	}

	public static Persons getPersons() {
		return persons;
	}

	public static void setPersons(Persons persons) {
		springJtaDaoClass.persons = persons;
	}

	@Transactional()
	public void daoWrapper(Persons p1,Persons p2) throws Exception {
		atomikosTransactionManager = getAtomikosTransactionManager();
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = atomikosTransactionManager.getTransaction(def);
		try {
			getOracleSessionFactory().getCurrentSession().save(p1);
			getMysqlSessionFactory().getCurrentSession().save(p1);
			
			atomikosTransactionManager.commit(status);
		} catch (Exception e) {
			System.out.println("Error in creating record, rolling back");
			atomikosTransactionManager.rollback(status);
			e.printStackTrace();
		}

	}
}
