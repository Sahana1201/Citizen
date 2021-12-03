package com.crm.userotpGenerate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
@Table(name = "otp")
public class Otp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "otp_id")
	private int otp_id;

	@Column(name = "mail")
	private String mail;

	@Column(name = "contact")
	private long contact;

	@Column(name = "mail_otp")
	private int mail_otp;

	@Column(name = "contact_otp")
	private int contact_otp;

	@Column(name = "counter")
	private int counter;

	@Column(name = "success")
	private int success;

	public Otp() {
		super();
	}

	
	public Otp( String mail, long contact, int mail_otp, int contact_otp, int counter, int success) {
		this.mail = mail;
		this.contact = contact;
		this.mail_otp = mail_otp;
		this.contact_otp = contact_otp;
		this.counter = counter;
		this.success = success;
	}

	public int getOtp_id() {
		return otp_id;
	}

	public void setOtp_id(int otp_id) {
		this.otp_id = otp_id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public int getMail_otp() {
		return mail_otp;
	}

	public void setMail_otp(int mail_otp) {
		this.mail_otp = mail_otp;
	}

	public int getContact_otp() {
		return contact_otp;
	}

	public void setContact_otp(int contact_otp) {
		this.contact_otp = contact_otp;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "OtpResponse [otp_id=" + otp_id + ", mail=" + mail + ", contact=" + contact + ", mail_otp=" + mail_otp
				+ ", contact_otp=" + contact_otp + ", counter=" + counter + ", success=" + success + "]";
	}

}
