package com.PatientService.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PatientService.model.PatientInformation;
import com.PatientService.model.Patient;

@Service
public interface PatientInterface {
	
	public List<Patient> getAllPatient();
	public Patient getPatient(Integer id);
	public PatientInformation getVisitDetails(Integer id);
	public Patient createPatient(Patient p);
	
}
