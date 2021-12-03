package com.crm.userotpGenerate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "crm_password")
public class PasswordEntity implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PASSWORD_ID")
	int passwordId;

	@Column(name = "PSSWORD")
	String password;

	
	public PasswordEntity() {
		super();
	}

	public PasswordEntity(String password) {
		super();
		this.password = password;
	}

	public int getPasswordid() {
		return passwordId;
	}

	public void setPasswordid(int passwordid) {
		this.passwordId = passwordid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PasswordEntity [passwordid=" + passwordId + ", password=" + password + "]";
	}

}
