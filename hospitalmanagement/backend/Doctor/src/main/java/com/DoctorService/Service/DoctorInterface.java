package com.DoctorService.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DoctorService.model.Doctor;

@Service
public interface DoctorInterface
{
	
	public List<Doctor> getAllDoctors();
	public Doctor getDoctor(Integer id);
	public Doctor addDoctor(Doctor doc);
	
}
