package com.crm.userotpGenerate.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;


public class OtpResponse implements Serializable {

	
	private long contact;
	private int otp;

	

	public OtpResponse(long contact, int otp) {
		this.contact = contact;
		this.otp = otp;
	}


	public long getContact() {
		return contact;
	}


	public void setContact(long contact) {
		this.contact = contact;
	}


	public int getOtp() {
		return otp;
	}


	public void setOtp(int otp) {
		this.otp = otp;
	}

	

}
