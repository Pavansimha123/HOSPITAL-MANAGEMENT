package com.PatientService.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.PatientService.Service.PatientInterface;
import com.PatientService.model.PatientInformation;
import com.PatientService.model.Doctor;
import com.PatientService.model.Patient;

import com.PatientService.model.VisitedDoctor;
import com.PatientService.repo.PatientRepository;


@Service
public class PatientService implements PatientInterface {
	
	@Autowired
	private PatientRepository patientrepo;
	
	@Autowired
	private RestTemplate resttemplate;
	
	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return patientrepo.findAll();
	}

	@Override
	public Patient getPatient(Integer id) {
		// TODO Auto-generated method stub
		List<Patient> s = patientrepo.findByPatientid(id);
		return s.get(0);
	}

	@Override
	public PatientInformation getVisitDetails(Integer id)
	{
		List<VisitedDoctor> sts=new ArrayList<>();
		List<Patient> pat=patientrepo.findByPatientid(id);
		for(int i=0;i<pat.size();i++)
		{
			Doctor doc= resttemplate.getForObject("http://DOCTOR-SERVICE/doctor/"+pat.get(i).getDocvisited(),Doctor.class);
			sts.add(new VisitedDoctor(doc.getDoctorName() , pat.get(i).getDocvisited(),pat.get(i).getPrescription(),pat.get(i).getDate()));
		}
		PatientInformation o= new PatientInformation(pat.get(0).getPatientname(), pat.get(0).getAge(), sts);
		return o;
	}

	@Override
	public void addPatient(Patient patient) {
		// TODO Auto-generated method stub
		patientrepo.save(patient);
	}

	

}
