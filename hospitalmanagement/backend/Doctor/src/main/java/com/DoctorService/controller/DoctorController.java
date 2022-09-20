package com.DoctorService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DoctorService.Service.DoctorInterface;
import com.DoctorService.model.Doctor;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class DoctorController {
	
	
	@Autowired
	private DoctorInterface docservice;
	
	
	@GetMapping("/doctor")
	public List<Doctor> getAllDoctor(){
		return docservice.getAllDoctors();
	
	}
	

	@GetMapping("/doctor/{id}")
	public  Doctor getDoctor(@PathVariable Integer id) {
		return docservice.getDoctor(id);
	}
	
	
	
	@PostMapping("/doctor")
	public Doctor addDoctor(@RequestBody Doctor doc) 
	{
		return docservice.addDoctor(doc);
	}
	
	
/*	@PutMapping("/doctor/{id}")
	public void updateDoctor(@RequestBody Doctor doc, @PathVariable Integer id) {
		docservice.updateDoctor(doc);
	}
	
	
	@DeleteMapping("/doctor/{id}")
	public void deleteDoctor(@PathVariable Integer id) {
		docservice.deleteDoctor(id);
	}*/
}
