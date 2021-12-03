package com.crm.userotpGenerate.response;

import java.io.Serializable;

public class MailResponse implements Serializable {

	private int otp;
	private String toaddress;

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public String getToadress() {
		return toaddress;
	}

	public void setToadress(String toadress) {
		this.toaddress = toadress;
	}

	public MailResponse(String toadress, int otp) {
		super();
		this.otp = otp;
		this.toaddress = toadress;
	}

	public MailResponse() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "MailResponse [otp=" + otp + ", toadress=" + toaddress + "]";
	}

}
