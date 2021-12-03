package com.crm.userotpGenerate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.crm.userotpGenerate.service.CitizenService;
import com.crm.userotpGenerate.service.CitizenServiceImpl;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "crm_taluk")
public class TalukEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "TALUK_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int taluk_id;

	@Column(name = "DISTRICT")
	String district;

	@Column(name = "TALUK")
	String taluk;
	
	@JsonBackReference
	@OneToMany(targetEntity = CitizenEntity.class, cascade = CascadeType.ALL, mappedBy = "taluk_id")
	@Fetch(value = FetchMode.SELECT)
	private List<CitizenEntity> citizen;

	public TalukEntity() {

	}

	public TalukEntity(int taluk_id, String district, String taluk) {
		super();
		this.taluk_id = taluk_id;
		this.district = district;
		this.taluk = taluk;
	}

	public int getTaluk_id() {
		return taluk_id;
	}

	public void setTaluk_id(int taluk_id) {
		this.taluk_id = taluk_id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public List<CitizenEntity> getCitizen() {
		return citizen;
	}

	public void setCitizen(List<CitizenEntity> citizen) {
		this.citizen = citizen;
	}

	@Override
	public String toString() {
		return "TalukEntity [taluk_id=" + taluk_id + ", district=" + district + ", taluk=" + taluk + "]";
	}

	public void add(CitizenEntity newCitizen) {
		CitizenService service = new CitizenServiceImpl();
		if (citizen == null) {
			citizen = new ArrayList<CitizenEntity>();

		}
		if (service.saveCitizenEntityService(newCitizen) == true) {

			citizen.add(newCitizen);

			newCitizen.setTaluk_id(this);
			
		}

	}

}
