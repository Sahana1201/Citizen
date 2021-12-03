package com.crm.userotpGenerate.dao;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.crm.userotpGenerate.entity.Otp;

@Repository
public class OtpDaoImpl implements OtpDao {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	public OtpDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Otp sendOtpdao(long mobileNumber) {
		Session session = entityManager.unwrap(Session.class);
		Query<Otp> query = session.createQuery("from Otp where  contact= '" + mobileNumber + "' ", Otp.class);
		Otp entity1 = query.uniqueResult();
		return entity1;
	}

	@Override
	public Otp updateOtp(Otp responseentity) {
		Session session = entityManager.unwrap(Session.class);
		session.update(responseentity);		
		System.out.println(responseentity);
		return responseentity;
	}

	@Transactional
	@Override
	public Otp saveOtp(Otp responseentity) {
		Session session = entityManager.unwrap(Session.class);
		session.save(responseentity);		
		System.out.println(responseentity);
		return responseentity;
	}

}
