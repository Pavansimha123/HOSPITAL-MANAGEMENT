package com.PatientService.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientid;
	private Date date;
	private String patientname;
	private Integer docvisited;
	private String prescription;
	private Integer age;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(Date date, String patientname, Integer docvisited, String prescription, Integer age) {
		super();
		this.date = date;
		this.patientname = patientname;
		this.docvisited = docvisited;
		this.prescription = prescription;
		this.age = age;
	}
	
	public Patient(Integer patientid, Date date, String patientname, Integer docvisited, String prescription,
			Integer age) {
		super();
		this.patientid = patientid;
		this.date = date;
		this.patientname = patientname;
		this.docvisited = docvisited;
		this.prescription = prescription;
		this.age = age;
	}
	public Integer getPatientid() {
		return patientid;
	}
	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public Integer getDocvisited() {
		return docvisited;
	}
	public void setDocvisited(Integer docvisited) {
		this.docvisited = docvisited;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	}
