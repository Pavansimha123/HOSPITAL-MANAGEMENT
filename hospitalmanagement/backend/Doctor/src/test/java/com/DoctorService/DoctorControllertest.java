package com.DoctorService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.DoctorService.Service.DoctorInterface;
import com.DoctorService.controller.DoctorController;
import com.DoctorService.model.Doctor;

@SpringBootTest(classes= {DoctorControllertest.class})
public class DoctorControllertest {

	@Mock
	private DoctorInterface docservice;
	
	@InjectMocks
	DoctorController controller;
	
	List<Doctor> doctors;
	Doctor doc;
	
	@Test
	public void testgetAllDoctor() 
	{
		doctors = new ArrayList<Doctor>();
		doctors.add(new Doctor(1,"Pavan",23,"Male","Heart"));
		doctors.add(new Doctor(2,"Manish",23,"Male","Brain"));
		when(docservice.getAllDoctors()).thenReturn(doctors);
		
		List<Doctor> lst=controller.getAllDoctor();
		
		
		assertThat(lst.size()).isEqualTo(2);
	}
	
	
	@Test
	public void testgetDoctor() 
	{
		doc = new Doctor(1,"Pavan",23,"Male","Heart");
		int doctorid=1;
		when(docservice.getDoctor(doctorid)).thenReturn(doc);
		    Doctor res=controller.getDoctor(doctorid);
		assertThat(res.getDoctorid()).isEqualTo(1);
	}
	
	@Test
	public void testaddDoctor()
	{
		doc = new Doctor(6,"Pavan",23,"Male","Heart");
	
		when(docservice.addDoctor(doc)).thenReturn(doc);
		 Doctor res= controller.addDoctor(doc);
		 assertThat(res.getDoctorid()).isEqualTo(6);
		 
	}
	

	
}
