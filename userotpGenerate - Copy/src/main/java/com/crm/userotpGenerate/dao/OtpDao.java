package com.crm.userotpGenerate.dao;

import com.crm.userotpGenerate.entity.Otp;

public interface OtpDao {

    Otp sendOtpdao(long mobileNumber);
    
    Otp updateOtp(Otp responseentity);
	
	Otp saveOtp(Otp responseentity);
	
}
