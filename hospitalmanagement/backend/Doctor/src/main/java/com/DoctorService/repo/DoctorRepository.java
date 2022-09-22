package com.DoctorService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DoctorService.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>
{
	
	
}
