package com.PatientService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import com.PatientService.Service.PatientInterface;
import com.PatientService.controller.PatientController;
import com.PatientService.model.Patient;

@SpringBootTest(classes= {PatientControllertest.class})
public class PatientControllertest {

	@Mock
	PatientInterface service;
	
	@InjectMocks
	PatientController con;
	
	List<Patient> patients;
	Patient pat;
	
	@Test
	public void testgetAllPatient() 
	{
		patients = new ArrayList<Patient>();
		patients.add(new Patient(1, new Date(2022,9,90),"pavan",1,"simha",23));
		
		when(service.getAllPatient()).thenReturn(patients);
		
		List<Patient> lst= con.getAllPatient();

		assertThat(lst.size()).isEqualTo(1);
		
	}
	
	@Test
	public void testcreatePatient() 
	{
		pat= new Patient(1, new Date(2022,9,90),"pavan",1,"simha",23);
		when(service.createPatient(pat)).thenReturn(pat);
		Patient p= con.createPatient(pat);
		assertThat(p.getPatientid()).isEqualTo(1);
		
	}
	
	@Test
	public void testgetPatient() 
	{
		pat= new Patient(1, new Date(2022,9,90),"pavan",1,"simha",23);
		int patientid=1;
		when(service.getPatient(patientid)).thenReturn(pat);
		Patient p= con.getPatient(patientid);
		
		assertThat(p.getPatientid()).isEqualTo(1);
	}

}
