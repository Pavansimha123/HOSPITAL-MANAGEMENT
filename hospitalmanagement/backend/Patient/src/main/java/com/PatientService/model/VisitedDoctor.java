package com.PatientService.model;

public class VisitedDoctor {
	
	
	private Integer visdoc;
	private String docname;
	private String prescription;
	private java.util.Date date;
	public Integer getVisdoc() {
		return visdoc;
	}
	public void setVisdoc(Integer visdoc) {
		this.visdoc = visdoc;
	}
	public String getPrescription() {
		return prescription;
	}
	
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public VisitedDoctor(String docname, Integer visdoc, String prescription, java.util.Date date) {
		super();
		this.visdoc = visdoc;
		this.prescription = prescription;
		this.date = date;
		this.docname=docname;
	}
	public VisitedDoctor() {
		super();
	}
	
	
	
	
	
}
