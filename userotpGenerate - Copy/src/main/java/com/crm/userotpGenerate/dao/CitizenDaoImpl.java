package com.crm.userotpGenerate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.userotpGenerate.bussinesslogic.OtpBusiness;
import com.crm.userotpGenerate.entity.CitizenEntity;
import com.crm.userotpGenerate.entity.CitizenTypeEntity;
import com.crm.userotpGenerate.entity.Otp;
import com.crm.userotpGenerate.entity.TalukEntity;
import com.crm.userotpGenerate.response.OtpResponse;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CitizenDaoImpl implements CitizenDao {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	public CitizenDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public CitizenDaoImpl() {
		super();
	}

	@Override
	public int saveCitizenEntity(CitizenEntity entity) {
		int pk = 0;
		Session session = entityManager.unwrap(Session.class);
		CitizenTypeEntity citizentype = session.get(CitizenTypeEntity.class, 12);
		TalukEntity taluk = session.get(TalukEntity.class, 1);
		entity.setCitizenTypeId(citizentype);
		entity.setTaluk_id(taluk);
		citizentype.add(entity);
		session.save(citizentype);
		return pk;

	}


	@Override
	public CitizenEntity checkMobileNumber(CitizenEntity entity) {
		Session session = entityManager.unwrap(Session.class);
		Query<CitizenEntity> query = session.createQuery(
				"from CitizenEntity where  contact_number= '" + entity.getContact_number() + "' ", CitizenEntity.class);
		CitizenEntity entity1 = query.uniqueResult();
		if (entity1 != null) {
			System.out.println(entity1);
			throw new HibernateException("Citizen Exist");
		} else {
			CitizenTypeEntity citizentype = session.get(CitizenTypeEntity.class, 12);
			TalukEntity taluk = session.get(TalukEntity.class, 1);
			entity.setCitizenTypeId(citizentype);
			entity.setTaluk_id(taluk);
			citizentype.add(entity);
			session.save(citizentype);
			return entity1;
		}
	}



	@Override
	public int saveCitizenWithNewCitizenTypeId(CitizenEntity entity, int id) {
		int pk = 0;
		Session session = entityManager.unwrap(Session.class);
		CitizenTypeEntity citizentype = session.get(CitizenTypeEntity.class, id);
		TalukEntity taluk = session.get(TalukEntity.class, 1);
		entity.setCitizenTypeId(citizentype);
		entity.setTaluk_id(taluk);
		citizentype.add(entity);
		session.save(citizentype);
		return pk;
	}

	@Override
	public CitizenEntity saveCitizenWithCitizenTypeIdAndTalukId(CitizenEntity entity, int citizenTypeId, int talukId) {

		Session session = entityManager.unwrap(Session.class);
		CitizenTypeEntity citizentype = session.get(CitizenTypeEntity.class, citizenTypeId);
		TalukEntity taluk = session.get(TalukEntity.class, talukId);
		entity.setCitizenTypeId(citizentype);
		entity.setTaluk_id(taluk);
		citizentype.add(entity);
		session.save(citizentype);
		return entity;

	}

	@Override
	public CitizenEntity fetchByCitizenId(int id) {
		CitizenEntity entity = new CitizenEntity();
		Session session = entityManager.unwrap(Session.class);
		entity = session.find(CitizenEntity.class, id);
		System.out.println(entity);
		return entity;

	}

	@Override
	public CitizenEntity checkLoginData(String username) {
		Session session = entityManager.unwrap(Session.class);
		Query<CitizenEntity> query = session.createQuery("from CitizenEntity where  name= '" + username + "' ",
				CitizenEntity.class);
		CitizenEntity uniqueEntity = query.getSingleResult();
		if (uniqueEntity.getName().equalsIgnoreCase(username)) {
			System.out.println(username);
		}
		return uniqueEntity;

	}

	@Override
	public List<CitizenEntity> fetchCitizenEntityByCitizenTypeId(int id) {
		Session session = entityManager.unwrap(Session.class);

		Query<CitizenEntity> query = session.createQuery("from CitizenEntity where  citizenTypeId= '" + id + "' ",
				CitizenEntity.class);
		List<CitizenEntity> list = query.list();
		if (list.isEmpty()) {
			throw new HibernateException("CitizenTypeId Doest Exist");
		} else {
			System.out.println(list);
			System.out.println(list.size());
			return list;
		}

	}

	@Override
	public List<CitizenEntity> userList() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from CitizenEntity");
		List<CitizenEntity> list = query.list();
		System.out.println(list);
		System.out.println(list.size());
		return list;

	}

	@Override
	public List<CitizenEntity> fetchCitizenEntityByTalulkId(int id) {
		Session session = entityManager.unwrap(Session.class);

		Query<CitizenEntity> query = session.createQuery("from CitizenEntity where  taluk_id= '" + id + "' ",
				CitizenEntity.class);
		List<CitizenEntity> list = query.list();
		if (list.isEmpty()) {
			throw new HibernateException("Taluk-Id Doest Exist");
		} else {
			System.out.println(list);
			System.out.println(list.size());
			return list;
		}

	}

}
