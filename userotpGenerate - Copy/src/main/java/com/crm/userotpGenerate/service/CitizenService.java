package com.crm.userotpGenerate.service;

import java.util.List;

import com.crm.userotpGenerate.bussinesslogic.OtpBusiness;
import com.crm.userotpGenerate.entity.CitizenEntity;
import com.crm.userotpGenerate.response.OtpResponse;


public interface CitizenService {

	boolean saveCitizenEntityService(CitizenEntity entity);

	boolean save(CitizenEntity entity);

	int saveCitizenWithNewCitizenTypeIdService(CitizenEntity entity, int id);

	CitizenEntity checkMobileNumber(CitizenEntity entity);
	
	List<CitizenEntity> userListService();

	public CitizenEntity checkLoginDataService(String username, String password);

	CitizenEntity fetchByCitizenIdService(int id);

	List<CitizenEntity> fetchCitizenEntityByTalulkIdService(int id);

	List<CitizenEntity> fetchCitizenEntityByCitizenTypeIdService(int id);

	CitizenEntity saveCitizenWithCitizenTypeIdAndTalukIdService(CitizenEntity entity, int citizenTypeId, int talukId);

	OtpResponse checkMobileNumberGetOtp(Long contact_number);
	

}
