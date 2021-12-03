package com.crm.userotpGenerate.dao;

import java.util.List;

import com.crm.userotpGenerate.bussinesslogic.OtpBusiness;
import com.crm.userotpGenerate.entity.CitizenEntity;
import com.crm.userotpGenerate.entity.Otp;
import com.crm.userotpGenerate.response.OtpResponse;


public interface CitizenDao {

	int saveCitizenEntity(CitizenEntity entity);

	int saveCitizenWithNewCitizenTypeId(CitizenEntity entity, int id);

	CitizenEntity checkMobileNumber(CitizenEntity entity);

	CitizenEntity saveCitizenWithCitizenTypeIdAndTalukId(CitizenEntity entity, int citizenTypeId, int talukId);

	List<CitizenEntity> userList();

	CitizenEntity checkLoginData(String username);

	CitizenEntity fetchByCitizenId(int id);

	List<CitizenEntity> fetchCitizenEntityByTalulkId(int id);

	List<CitizenEntity> fetchCitizenEntityByCitizenTypeId(int id);
	

	

}
