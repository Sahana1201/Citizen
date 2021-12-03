package com.crm.userotpGenerate.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crm.userotpGenerate.bussinesslogic.OtpBusiness;
import com.crm.userotpGenerate.entity.CitizenEntity;
import com.crm.userotpGenerate.entity.CitizenTypeEntity;
import com.crm.userotpGenerate.entity.PasswordEntity;
import com.crm.userotpGenerate.entity.TalukEntity;
import com.crm.userotpGenerate.response.OtpResponse;
import com.crm.userotpGenerate.service.CitizenService;

@RestController
@RequestMapping("/home")
public class CitizenNewRest {

	@Autowired
	private CitizenService citizenService;

	@PostMapping("/save")
	public CitizenEntity save() {

		CitizenEntity entity = new CitizenEntity();

		CitizenTypeEntity typeEntity = new CitizenTypeEntity();
		typeEntity.setName("Sumaa");
		entity.setCitizenTypeId(typeEntity);

		TalukEntity taluk = new TalukEntity();
		taluk.setDistrict("Tumkur");
		taluk.setTaluk("Sira");
		entity.setTaluk_id(taluk);

		PasswordEntity password = new PasswordEntity("Pink");
		entity.setNewpassword(password);

		entity.setName("James.bon");
		entity.setLandline(1234555345);
		entity.setAddress("Banglore");
		entity.setContact_number(9066456164l);
		entity.setEmail("preethi@gmail.com");

		CitizenEntity enti = new CitizenEntity();
		enti = citizenService.saveCitizenWithCitizenTypeIdAndTalukIdService(entity, 12, 1);
		System.out.println(enti);

		return (enti);

	}

	@PostMapping("/checkmobilenumberandsave")
	public CitizenEntity CheckMobileNumberAnsdSave(@RequestBody CitizenEntity entity) {

		return citizenService.checkMobileNumber(entity);
	}

	@GetMapping("/checkmobilenumberandgetOtp/{contact_number}")
	public OtpResponse CheckMobileNumberGetOtp(@PathVariable long contact_number) {

		return citizenService.checkMobileNumberGetOtp(contact_number);
	}

	@GetMapping("/citizen")
	List<CitizenEntity> all() {
		return citizenService.userListService();
	}

	@GetMapping("/citizentaluk/{id}")
	public List<CitizenEntity> fetchCitizenEntityByTalulkIdTester(@PathVariable int id) {
		return citizenService.fetchCitizenEntityByTalulkIdService(id);
	}

	@GetMapping("/citizentype/{cirtizenid}")
	public List<CitizenEntity> fetchCitizenEntityByCitizenTypeId(@PathVariable int cirtizenid) {
		return citizenService.fetchCitizenEntityByCitizenTypeIdService(cirtizenid);
	}

	@PostMapping("/getcitizen")
	public boolean citizen(@RequestBody CitizenEntity entity) {

		CitizenEntity entity1 = new CitizenEntity();

		entity1.setName(entity.getName());
		entity1.setAddress(entity.getAddress());
		entity1.setContact_number(entity.getContact_number());
		entity1.setCitizenTypeId(entity.getCitizenTypeId());
		entity1.setNewpassword(entity.getNewpassword());
		entity1.setEmail(entity.getEmail());
		entity1.setLandline(entity.getLandline());
		entity1.setTaluk_id(entity.getTaluk_id());
		entity1.setCitizen_id(entity.getCitizen_id());
		if (entity1 != null) {

			return citizenService.saveCitizenEntityService(entity1);
		}

		return false;
	}

}
