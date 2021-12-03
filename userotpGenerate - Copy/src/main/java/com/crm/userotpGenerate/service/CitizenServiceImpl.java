package com.crm.userotpGenerate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.userotpGenerate.bussinesslogic.MailBusiness;
import com.crm.userotpGenerate.bussinesslogic.OtpBusiness;
import com.crm.userotpGenerate.dao.CitizenDao;
import com.crm.userotpGenerate.dao.CitizenDaoImpl;
import com.crm.userotpGenerate.dao.OtpDao;
import com.crm.userotpGenerate.entity.CitizenEntity;
import com.crm.userotpGenerate.entity.Otp;
import com.crm.userotpGenerate.response.MailResponse;
import com.crm.userotpGenerate.response.OtpResponse;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenDao dao;

	@Autowired
	private OtpDao otpDao;

	boolean usernamevalid = false;
	boolean emailvalid = false;
	boolean contactvalid = false;
	boolean landlinevalid = false;
	boolean dataValid = false;

	@Transactional
	@Override
	public boolean saveCitizenEntityService(CitizenEntity entity) {

		try {
			if (entity != null) {
				System.out.println("Entity is not null, Can Validate the Data");

				// name validating
				String name = entity.getName();

				// String namevalid = "^[a-zA-Z0-9_.]{8,20}$";
				if (name.length() >= 5 && name.length() <= 20) {
					System.out.println("Name is Valid");

					usernamevalid = true;
				} else {

					usernamevalid = false;
					throw new HibernateException("Name is Not Valid");
				}

				// contactnumber validation
				long contactnumber = entity.getContact_number();
				if (contactnumber > 10) {
					System.out.println("ContactNumber is valid");
					contactvalid = true;
				} else {

					contactvalid = false;
					throw new HibernateException("ContactNumber is Not Valid");
				}

				// email validation
				String serviceemail = entity.getEmail();
				String valid = "^(.+)@(.+)$";
				if (serviceemail.matches(valid)) {
					System.out.println("Email is valid");
					emailvalid = true;
				} else {

					emailvalid = false;
					throw new HibernateException("Email Not Valid");

				}

				// landline validation
				int landline = entity.getLandline();
				if (landline >= 1 && landline >= 10) {
					System.out.println("Landline is valid");
					landlinevalid = true;
				} else {

					landlinevalid = false;
					throw new HibernateException("landline is Not Valid");
				}

				if (usernamevalid && emailvalid && contactvalid && landlinevalid) {
					dataValid = true;
					dao.saveCitizenEntity(entity);
					System.out.println(entity);
					return dataValid;

				} else {
					return dataValid;
				}

			}

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException("Data is Not Valid");
		}

		return false;
	}

	@Transactional
	@Override
	public boolean save(CitizenEntity entity) {
		dao.saveCitizenEntity(entity);
		return true;
	}

	@Override
	public int saveCitizenWithNewCitizenTypeIdService(CitizenEntity entity, int id) {
		return dao.saveCitizenWithNewCitizenTypeId(entity, id);
	}

	@Override
	public CitizenEntity checkMobileNumber(CitizenEntity entity) {
		return dao.checkMobileNumber(entity);
	}

	@Override
	@Transactional
	public OtpResponse checkMobileNumberGetOtp(Long contact_number) {
		Otp otp = null;
		try {
			if (otpDao.sendOtpdao(contact_number) == null) {

				// OtpBusiness Class
				OtpBusiness response = new OtpBusiness();
				response.setEmail(response.getEmail());
				response.generateOtpinbussinessClass();
				String theOtp = response.getOtpofBusinessclass();

				// Otp Entity
				otp = new Otp(response.getEmail(), contact_number, Integer.parseInt(theOtp), Integer.parseInt(theOtp),
						0, 0);

				// saves OTP in Otp entity
				otpDao.saveOtp(otp);

				// send OTP for Mail and mobile Number
				response.sendOtp();

				// Otp Response
				OtpResponse otpresponse = new OtpResponse(otp.getContact(), otp.getContact_otp());

				// Mail Response
				MailResponse mailResponse = new MailResponse(otp.getMail(), otp.getContact_otp());

				
				System.out.println(mailResponse);

				return otpresponse;

			} else if(otpDao.sendOtpdao(contact_number) != null){

				// OtpBusiness Class
				OtpBusiness response = new OtpBusiness();
				response.setEmail(response.getEmail());
				response.generateOtpinbussinessClass();
				String theOtp1 = response.getOtpofBusinessclass();

				// Otp Entity
				otp = new Otp(response.getEmail(), contact_number, Integer.parseInt(theOtp1), Integer.parseInt(theOtp1),
						0, 0);

				// updates Otp in otp entity
				otpDao.updateOtp(otp);

				// send OTP for Mail and mobile Number
				response.sendOtp();

				// Otp Response
				OtpResponse otpresponse = new OtpResponse(otp.getContact(), otp.getContact_otp());

				// Mail Response
				MailResponse mailResponse = new MailResponse(otp.getMail(), otp.getContact_otp());

				System.out.println(mailResponse);

				return otpresponse;

			}else {
				throw new HibernateException("Number Already Exist");
			}
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<CitizenEntity> userListService() {
		return dao.userList();
	}

	@Override
	public CitizenEntity checkLoginDataService(String username, String password) {
		CitizenEntity entity = dao.checkLoginData(username);
		String name = entity.getName();
		String newpassword = entity.getNewpassword().getPassword();
		boolean nameCheck = equalIgnoreCase(name, username);
		boolean passwordcheck = equalIgnoreCase(newpassword, password);
		if (nameCheck == true && passwordcheck == true) {
			System.out.println(entity);
			return entity;
		} else {
			System.out.println("Data not Found");
			return null;
		}

	}

	@Override
	public CitizenEntity fetchByCitizenIdService(int id) {
		return dao.fetchByCitizenId(id);
	}

	@Override
	public List<CitizenEntity> fetchCitizenEntityByTalulkIdService(int id) {
		return dao.fetchCitizenEntityByTalulkId(id);
	}

	@Override
	public List<CitizenEntity> fetchCitizenEntityByCitizenTypeIdService(int id) {
		return dao.fetchCitizenEntityByCitizenTypeId(id);
	}

	@Transactional
	@Override
	public CitizenEntity saveCitizenWithCitizenTypeIdAndTalukIdService(CitizenEntity entity, int citizenTypeId,
			int talukId) {
		return dao.saveCitizenWithCitizenTypeIdAndTalukId(entity, citizenTypeId, talukId);
	}

	static boolean equalIgnoreCase(String str1, String str2) {
		int i = 0;
		int len1 = str1.length();
		int len2 = str2.length();

		if (len1 != len2)
			return false;

		while (i < len1) {
			if (str1.charAt(i) == str2.charAt(i)) {
				i++;
			} else if (!((str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z')
					|| (str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z'))) {
				return false;
			} else if (!((str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z')
					|| (str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z'))) {
				return false;
			} else {

				if (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z') {
					if (str1.charAt(i) - 32 != str2.charAt(i))
						return false;
				} else if (str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z') {
					if (str1.charAt(i) + 32 != str2.charAt(i))
						return false;
				}
				i++;

			}

		}

		return true;

	}

}
