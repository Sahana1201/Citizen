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

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import com.crm.userotpGenerate.service.CitizenService;
import com.crm.userotpGenerate.service.CitizenServiceImpl;
import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "crm_citizen_type")
public class CitizenTypeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "TYPE_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int citizenType_id;

	@Column(name = "NAME")
	String name;

	@JsonBackReference
	@OneToMany(targetEntity = CitizenEntity.class, cascade = CascadeType.ALL, mappedBy = "citizenTypeId")
	@Fetch(value =org.hibernate.annotations.FetchMode.SELECT)
	private List<CitizenEntity> citizen;

	public CitizenTypeEntity() {
		super();
	}

	public List<CitizenEntity> getCitizen() {
		return citizen;
	}

	public void setCitizen(List<CitizenEntity> citizen) {
		this.citizen = citizen;
	}

	public int getCitizenType_id() {
		return citizenType_id;
	}

	public void setCitizenType_id(int citizenType_id) {
		this.citizenType_id = citizenType_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CitizenTypeEntity [citizenType_id=" + citizenType_id + ", name=" + name + "]";
	}

	public void add(CitizenEntity newCitizen) {

		if (citizen == null) {
			citizen = new ArrayList<CitizenEntity>();

		}
		citizen.add(newCitizen);
		

	}

}
