package com.crm.userotpGenerate.bussinesslogic;

import java.util.Random;

public class OtpBusiness {

	long mobilenumberofBusinessclass;
	private String otpofBusinessclass;
	private MailBusiness mail=null;
	String email;

	public OtpBusiness() {
		
		
	}

	public OtpBusiness(long mobilenumberofBusinessclass, String email) {
		mail=new MailBusiness(email);
		this.mobilenumberofBusinessclass = mobilenumberofBusinessclass;
		this.email = email;
	}

	public long getMobilenumberofBusinessclass() {
		return mobilenumberofBusinessclass;
	}

	public void setMobilenumberofBusinessclass(long mobilenumberofBusinessclass) {
		this.mobilenumberofBusinessclass = mobilenumberofBusinessclass;
	}

	public String getOtpofBusinessclass() {
		return otpofBusinessclass;
	}

	public void setOtpofBusinessclass(String otpofBusinessclass) {
		this.otpofBusinessclass = otpofBusinessclass ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String generateOtpinbussinessClass() {
	
		return this.otpofBusinessclass = generateOTP(5);

	}
	public String sendOtpMail() {
		
		return this.otpofBusinessclass = generateOTP(5);

	}

	public String generateOTP(int otpLength) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < otpLength; i++) {
			sb.append(random.nextInt(10));
		}
		String otp = sb.toString();
		return otp;
	}

	public void sendOtp() {
		if(mail ==null) {
			
			mail=new MailBusiness(this.email);
		}
		mail.mailOtp(otpofBusinessclass);
		
	}

}
