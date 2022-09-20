package com.DoctorService.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DoctorService.Service.DoctorInterface;
import com.DoctorService.model.Doctor;
import com.DoctorService.repo.DoctorRepository;

@Service
public class DoctorImplimentation implements DoctorInterface {
	
	
	@Autowired
	private DoctorRepository docrepo;
	
	
	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		
		return docrepo.findAll();
	}

	@Override
	public Doctor getDoctor(Integer id) {
		// TODO Auto-generated method stub
		return docrepo.findById(id).get();
	}

	@Override
	public Doctor addDoctor(Doctor doc) {
		// TODO Auto-generated method stub
		return docrepo.save(doc);
	}

	

}
