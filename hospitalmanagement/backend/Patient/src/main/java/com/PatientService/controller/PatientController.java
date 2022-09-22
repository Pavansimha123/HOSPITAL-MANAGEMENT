package com.PatientService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PatientService.Service.PatientInterface;
import com.PatientService.model.PatientInformation;
import com.PatientService.model.Patient;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PatientController {
	
	
	@Autowired
	private PatientInterface patient;
	
	
	@GetMapping("/patient")
	public List<Patient> getAllPatient() {
		return patient.getAllPatient();
	}
	
	
	
	@GetMapping("/patient/{id}")
	public Patient getPatient(@PathVariable Integer id) {
		return patient.getPatient(id);
				
	}
	
	@PostMapping("/patient")
	public Patient createPatient(@RequestBody Patient pat ) {
		return patient.createPatient(pat);
		
	}
	

	@GetMapping("/patient/{id}/visit")
	public PatientInformation VisitedDetails(@PathVariable Integer id){
		return patient.getVisitDetails(id);
	}
	
}
