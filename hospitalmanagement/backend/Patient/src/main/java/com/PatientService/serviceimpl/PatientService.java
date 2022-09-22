package com.PatientService.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.PatientService.Service.PatientInterface;
import com.PatientService.Vo.Doctor;
import com.PatientService.model.PatientInformation;
import com.PatientService.model.Patient;

import com.PatientService.model.VisitedDoctor;
import com.PatientService.repo.PatientRepository;


@Service
public class PatientService implements PatientInterface {
	
	@Autowired
	private PatientRepository patientrepository;
	
	@Autowired
	private RestTemplate resttemplate;
	
	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return patientrepository.findAll();
	}

	@Override
	public Patient getPatient(Integer id) {
		// TODO Auto-generated method stub
		List<Patient> s = patientrepository.findByPatientid(id);
		return s.get(0);
	}
	@Override
	public Patient createPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientrepository.save(patient);
	}


	@Override
	public PatientInformation getVisitDetails(Integer id)
	{
		List<VisitedDoctor> lst=new ArrayList<>();
		List<Patient> patientlist=patientrepository.findByPatientid(id);
		for(int i=0;i<patientlist.size();i++)
		{
			Doctor doc= resttemplate.getForObject("http://DOCTOR-SERVICE/doctor/"+patientlist.get(i).getDocvisited(),Doctor.class);
			lst.add(new VisitedDoctor(doc.getDoctorName() , patientlist.get(i).getDocvisited(),patientlist.get(i).getPrescription(),patientlist.get(i).getDate()));
		}
		PatientInformation o= new PatientInformation(patientlist.get(0).getPatientname(), patientlist.get(0).getAge(), lst);
		return o;
	}

	
	

}
