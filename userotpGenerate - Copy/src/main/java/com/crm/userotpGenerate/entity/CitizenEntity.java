package com.crm.userotpGenerate.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;


@Entity
@Validated
@Table(name = "crm_citizen")
public class CitizenEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "CITIZEN_ID", unique = true, nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int citizen_id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CITYZEN_TYPE_ID")
	private CitizenTypeEntity citizenTypeId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TALUK_ID")
	private TalukEntity taluk_id;

	@Column(name = "NAME")
	@Size(min = 2, max = 10)
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CONTACT")
	private long contact_number;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PASSWORD_ID")
	private PasswordEntity newpassword;

	@Column(name = "Landline")
//	@Pattern(message = "Invalid LandlineNumber ", regexp = "^[1-9][0-9]{7}$")
	private int landline;

	@Column(name = "ADDRESS")
	private String address;



	public CitizenEntity() {
		super();
	}

	

	public CitizenEntity(int citizen_id, CitizenTypeEntity citizenTypeId, TalukEntity taluk_id,
			@Size(min = 2, max = 10) String name,  String email,
		long contact_number, PasswordEntity newpassword, int landline,
			String address) {
	
		this.citizen_id = citizen_id;
		this.citizenTypeId = citizenTypeId;
		this.taluk_id = taluk_id;
		this.name = name;
		this.email = email;
		this.contact_number = contact_number;
		this.newpassword = newpassword;
		this.landline = landline;
		this.address = address;
	}



	public TalukEntity getTaluk_id() {
		return taluk_id;
	}

	public void setTaluk_id(TalukEntity taluk_id) {
		this.taluk_id = taluk_id;
	}

	public void setCitizen_id(int citizen_id) {
		this.citizen_id = citizen_id;
	}

	public CitizenTypeEntity getCitizenTypeId() {
		return citizenTypeId;
	}

	public void setCitizenTypeId(CitizenTypeEntity citizenTypeEntity) {
		this.citizenTypeId = citizenTypeEntity;
	}

	public void setNewpassword(PasswordEntity newpassword) {
		this.newpassword = newpassword;
	}

	public int getCitizen_id() {
		return citizen_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact_number() {
		return contact_number;
	}

	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}

	public int getLandline() {
		return landline;
	}

	public void setLandline(int landline) {
		this.landline = landline;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PasswordEntity getNewpassword() {
		return newpassword;
	}

	@Override
	public String toString() {
		return "CitizenEntity [citizen_id=" + citizen_id + ", citizenTypeId=" + citizenTypeId + ", taluk_id=" + taluk_id
				+ ", name=" + name + ", email=" + email + ", contact_number=" + contact_number + ", landline="
				+ landline + ", address=" + address + "]";
	}

}
