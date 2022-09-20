package com.PatientService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PatientService.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	public List<Patient> findByPatientid(Integer id);

	public void deleteByPatientid(Integer pid);
	
	
	
}
